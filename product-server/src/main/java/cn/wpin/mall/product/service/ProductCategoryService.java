package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dao.ProductCategoryAttributeRelationDao;
import cn.wpin.mall.product.dao.ProductCategoryDao;
import cn.wpin.mall.product.dto.ProductCategoryParam;
import cn.wpin.mall.product.dto.ProductCategoryWithChildrenItem;
import cn.wpin.mall.product.entity.Product;
import cn.wpin.mall.product.entity.ProductCategory;
import cn.wpin.mall.product.entity.ProductCategoryAttributeRelation;
import cn.wpin.mall.product.example.ProductCategoryAttributeRelationExample;
import cn.wpin.mall.product.example.ProductCategoryExample;
import cn.wpin.mall.product.example.ProductExample;
import cn.wpin.mall.product.mapper.ProductCategoryAttributeRelationMapper;
import cn.wpin.mall.product.mapper.ProductCategoryMapper;
import cn.wpin.mall.product.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductCategoryService实现类
 * @author wangpin 
 */
@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCategoryAttributeRelationDao productCategoryAttributeRelationDao;
    @Autowired
    private ProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;
    @Autowired
    private ProductCategoryDao productCategoryDao;
   
    public int create(ProductCategoryParam pmsProductCategoryParam) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        //没有父分类时为一级分类
        setCategoryLevel(productCategory);
        int count = productCategoryMapper.insertSelective(productCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = pmsProductCategoryParam.getProductAttributeIdList();
        if(!CollectionUtils.isEmpty(productAttributeIdList)){
            insertRelationList(productCategory.getId(), productAttributeIdList);
        }
        return count;
    }

    /**
     * 批量插入商品分类与筛选属性关系表
     * @param productCategoryId 商品分类id
     * @param productAttributeIdList 相关商品筛选属性id集合
     */
    private void insertRelationList(Long productCategoryId, List<Long> productAttributeIdList) {
        List<ProductCategoryAttributeRelation> relationList = new ArrayList<>();
        for (Long productAttrId : productAttributeIdList) {
            ProductCategoryAttributeRelation relation = new ProductCategoryAttributeRelation();
            relation.setProductAttributeId(productAttrId);
            relation.setProductCategoryId(productCategoryId);
            relationList.add(relation);
        }
        productCategoryAttributeRelationDao.insertList(relationList);
    }

   
    public int update(Long id, ProductCategoryParam pmsProductCategoryParam) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        BeanUtils.copyProperties(pmsProductCategoryParam, productCategory);
        setCategoryLevel(productCategory);
        //更新商品分类时要更新商品中的名称
        Product product = new Product();
        product.setProductCategoryName(productCategory.getName());
        ProductExample example = new ProductExample();
        example.createCriteria().andProductCategoryIdEqualTo(id);
        productMapper.updateByExampleSelective(product,example);
        //同时更新筛选属性的信息
        if(!CollectionUtils.isEmpty(pmsProductCategoryParam.getProductAttributeIdList())){
            ProductCategoryAttributeRelationExample relationExample = new ProductCategoryAttributeRelationExample();
            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
            insertRelationList(id,pmsProductCategoryParam.getProductAttributeIdList());
        }else{
            ProductCategoryAttributeRelationExample relationExample = new ProductCategoryAttributeRelationExample();
            relationExample.createCriteria().andProductCategoryIdEqualTo(id);
            productCategoryAttributeRelationMapper.deleteByExample(relationExample);
        }
        return productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

   
    public List<ProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ProductCategoryExample example = new ProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(example);
    }

   
    public int delete(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

   
    public ProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }

   
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setNavStatus(navStatus);
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

   
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setShowStatus(showStatus);
        ProductCategoryExample example = new ProductCategoryExample();
        example.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory, example);
    }

   
    public List<ProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(ProductCategory productCategory) {
        //没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            ProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }
}
