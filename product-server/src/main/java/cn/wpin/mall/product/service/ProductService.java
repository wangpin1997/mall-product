package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dao.*;
import cn.wpin.mall.product.dto.ProductParam;
import cn.wpin.mall.product.dto.ProductQueryParam;
import cn.wpin.mall.product.dto.ProductResult;
import cn.wpin.mall.product.entity.*;
import cn.wpin.mall.product.example.*;
import cn.wpin.mall.product.mapper.*;
import com.github.pagehelper.PageHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品管理Service实现类
 * @author wangpin 
 */
@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MemberPriceDao memberPriceDao;

    @Autowired
    private MemberPriceMapper memberPriceMapper;

    @Autowired
    private ProductLadderDao productLadderDao;

    @Autowired
    private ProductLadderMapper productLadderMapper;

    @Autowired
    private ProductFullReductionDao productFullReductionDao;

    @Autowired
    private ProductFullReductionMapper productFullReductionMapper;

    @Autowired
    private SkuStockDao skuStockDao;

    @Autowired
    private SkuStockMapper skuStockMapper;

    @Autowired
    private ProductAttributeValueDao productAttributeValueDao;
    
    @Autowired
    private ProductAttributeValueMapper productAttributeValueMapper;
    
//    @Autowired
//    private CmsSubjectProductRelationDao subjectProductRelationDao;
//    @Autowired
//    private CmsSubjectProductRelationMapper subjectProductRelationMapper;
//    @Autowired
//    private CmsPrefrenceAreaProductRelationDao prefrenceAreaProductRelationDao;
//    @Autowired
//    private CmsPrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductVertifyRecordDao productVertifyRecordDao;

   
    public int create(ProductParam productParam) {
        int count;
        //创建商品
        Product product = productParam;
        product.setId(null);
        productMapper.insertSelective(product);
        //根据促销类型设置价格：、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        relateAndInsertList(memberPriceDao, productParam.getMemberPriceList(), productId);
        //阶梯价格
        relateAndInsertList(productLadderDao, productParam.getProductLadderList(), productId);
        //满减价格
        relateAndInsertList(productFullReductionDao, productParam.getProductFullReductionList(), productId);
        //处理sku的编码
        handleSkuStockCode(productParam.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(skuStockDao, productParam.getSkuStockList(), productId);
        //添加商品参数,添加自定义商品规格
        relateAndInsertList(productAttributeValueDao, productParam.getProductAttributeValueList(), productId);
//        //关联专题 todo:
//        relateAndInsertList(subjectProductRelationDao, productParam.getSubjectProductRelationList(), productId);
//        //关联优选
//        relateAndInsertList(prefrenceAreaProductRelationDao, productParam.getPrefrenceAreaProductRelationList(), productId);
        count = 1;
        return count;
    }

    private void handleSkuStockCode(List<SkuStock> skuStockList, Long productId) {
        if(CollectionUtils.isEmpty(skuStockList)) {
            return;
        }
        for(int i=0;i<skuStockList.size();i++){
            SkuStock skuStock = skuStockList.get(i);
            if(StringUtils.isEmpty(skuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d", productId));
                //三位索引id
                sb.append(String.format("%03d", i+1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }

   
    public ProductResult getUpdateInfo(Long id) {
        return productDao.getUpdateInfo(id);
    }

   
    public int update(Long id, ProductParam productParam) {
        int count;
        //更新商品信息
        Product product = productParam;
        product.setId(id);
        productMapper.updateByPrimaryKeySelective(product);
        //会员价格
        MemberPriceExample pmsMemberPriceExample = new MemberPriceExample();
        pmsMemberPriceExample.createCriteria().andProductIdEqualTo(id);
        memberPriceMapper.deleteByExample(pmsMemberPriceExample);
        relateAndInsertList(memberPriceDao, productParam.getMemberPriceList(), id);
        //阶梯价格
        ProductLadderExample ladderExample = new ProductLadderExample();
        ladderExample.createCriteria().andProductIdEqualTo(id);
        productLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(productLadderDao, productParam.getProductLadderList(), id);
        //满减价格
        ProductFullReductionExample fullReductionExample = new ProductFullReductionExample();
        fullReductionExample.createCriteria().andProductIdEqualTo(id);
        productFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(productFullReductionDao, productParam.getProductFullReductionList(), id);
        //修改sku库存信息
        SkuStockExample skuStockExample = new SkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo(id);
        skuStockMapper.deleteByExample(skuStockExample);
        handleSkuStockCode(productParam.getSkuStockList(),id);
        relateAndInsertList(skuStockDao, productParam.getSkuStockList(), id);
        //修改商品参数,添加自定义商品规格
        ProductAttributeValueExample productAttributeValueExample = new ProductAttributeValueExample();
        productAttributeValueExample.createCriteria().andProductIdEqualTo(id);
        productAttributeValueMapper.deleteByExample(productAttributeValueExample);
        relateAndInsertList(productAttributeValueDao, productParam.getProductAttributeValueList(), id);
        //关联专题
        //TODO:cms类的一些包整合好后引入
//        CmsSubjectProductRelationExample subjectProductRelationExample = new CmsSubjectProductRelationExample();
//        subjectProductRelationExample.createCriteria().andProductIdEqualTo(id);
//        subjectProductRelationMapper.deleteByExample(subjectProductRelationExample);
//        relateAndInsertList(subjectProductRelationDao, productParam.getSubjectProductRelationList(), id);
//        //关联优选
//        CmsPrefrenceAreaProductRelationExample prefrenceAreaExample = new CmsPrefrenceAreaProductRelationExample();
//        prefrenceAreaExample.createCriteria().andProductIdEqualTo(id);
//        prefrenceAreaProductRelationMapper.deleteByExample(prefrenceAreaExample);
//        relateAndInsertList(prefrenceAreaProductRelationDao, productParam.getPrefrenceAreaProductRelationList(), id);
        count = 1;
        return count;
    }

   
    public List<Product> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (productQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(productQueryParam.getPublishStatus());
        }
        if (productQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(productQueryParam.getProductSn());
        }
        if (productQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
        }
        if (productQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(productExample);
    }

   
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        Product product = new Product();
        product.setVerifyStatus(verifyStatus);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        List<ProductVertifyRecord> list = new ArrayList<>();
        int count = productMapper.updateByExampleSelective(product, example);
        //修改完审核状态后插入审核记录
        for (Long id : ids) {
            ProductVertifyRecord record = new ProductVertifyRecord();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setDetail(detail);
            record.setStatus(verifyStatus);
            record.setVertifyMan("test");
            list.add(record);
        }
        productVertifyRecordDao.insertList(list);
        return count;
    }

   
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        Product record = new Product();
        record.setPublishStatus(publishStatus);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

   
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        Product record = new Product();
        record.setRecommandStatus(recommendStatus);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

   
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        Product record = new Product();
        record.setNewStatus(newStatus);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

   
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        Product record = new Product();
        record.setDeleteStatus(deleteStatus);
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

   
    public List<Product> list(String keyword) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if(!StringUtils.isEmpty(keyword)){
            criteria.andNameLike("%" + keyword + "%");
            productExample.or().andDeleteStatusEqualTo(0).andProductSnLike("%" + keyword + "%");
        }
        return productMapper.selectByExample(productExample);
    }

    /**
     * @deprecated 旧版创建
     */
    public int createOld(ProductParam productParam) {
        int count;
        //创建商品
        Product product = productParam;
        product.setId(null);
        productMapper.insertSelective(product);
        //根据促销类型设置价格：、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        List<MemberPrice> memberPriceList = productParam.getMemberPriceList();
        if (!CollectionUtils.isEmpty(memberPriceList)) {
            for (MemberPrice pmsMemberPrice : memberPriceList) {
                pmsMemberPrice.setId(null);
                pmsMemberPrice.setProductId(productId);
            }
            memberPriceDao.insertList(memberPriceList);
        }
        //阶梯价格
        List<ProductLadder> productLadderList = productParam.getProductLadderList();
        if (!CollectionUtils.isEmpty(productLadderList)) {
            for (ProductLadder productLadder : productLadderList) {
                productLadder.setId(null);
                productLadder.setProductId(productId);
            }
            productLadderDao.insertList(productLadderList);
        }
        //满减价格
        List<ProductFullReduction> productFullReductionList = productParam.getProductFullReductionList();
        if (!CollectionUtils.isEmpty(productFullReductionList)) {
            for (ProductFullReduction productFullReduction : productFullReductionList) {
                productFullReduction.setId(null);
                productFullReduction.setProductId(productId);
            }
            productFullReductionDao.insertList(productFullReductionList);
        }
        //添加sku库存信息
        List<SkuStock> skuStockList = productParam.getSkuStockList();
        if (!CollectionUtils.isEmpty(skuStockList)) {
            for (SkuStock skuStock : skuStockList) {
                skuStock.setId(null);
                skuStock.setProductId(productId);
            }
            skuStockDao.insertList(skuStockList);
        }
        //添加商品参数,添加自定义商品规格
        List<ProductAttributeValue> productAttributeValueList = productParam.getProductAttributeValueList();
        if (!CollectionUtils.isEmpty(productAttributeValueList)) {
            for (ProductAttributeValue productAttributeValue : productAttributeValueList) {
                productAttributeValue.setId(null);
                productAttributeValue.setProductId(productId);
            }
            productAttributeValueDao.insertList(productAttributeValueList);
        }
        //关联专题 todo:
//        relateAndInsertList(subjectProductRelationDao, productParam.getSubjectProductRelationList(), productId);
//        //关联优选
//        relateAndInsertList(prefrenceAreaProductRelationDao, productParam.getPrefrenceAreaProductRelationList(), productId);
        count = 1;
        return count;
    }

    /**
     * 建立和插入关系表操作
     *
     * @param dao       可以操作的dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            LOGGER.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
