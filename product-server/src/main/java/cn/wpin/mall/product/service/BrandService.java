package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dto.BrandParam;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.entity.Product;
import cn.wpin.mall.product.example.BrandExample;
import cn.wpin.mall.product.example.ProductExample;
import cn.wpin.mall.product.mapper.BrandMapper;
import cn.wpin.mall.product.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品品牌Service实现类
 * @author wangpin 
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ProductMapper productMapper;

    
    public List<Brand> listAllBrand() {
        return brandMapper.selectByExample(new BrandExample());
    }

    
    public int createBrand(BrandParam pmsBrandParam) {
        Brand pmsBrand = new Brand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(pmsBrand);
    }

    
    public int updateBrand(Long id, BrandParam pmsBrandParam) {
        Brand pmsBrand = new Brand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        //如果创建时首字母为空，取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        //更新品牌时要更新商品中的品牌名称
        Product product = new Product();
        product.setBrandName(pmsBrand.getName());
        ProductExample example = new ProductExample();
        example.createCriteria().andBrandIdEqualTo(id);
        productMapper.updateByExampleSelective(product,example);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    
    public int deleteBrand(List<Long> ids) {
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(pmsBrandExample);
    }

    
    public List<Brand> listBrand(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.setOrderByClause("sort desc");
        BrandExample.Criteria criteria = pmsBrandExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return brandMapper.selectByExample(pmsBrandExample);
    }

    
    public Brand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        Brand pmsBrand = new Brand();
        pmsBrand.setShowStatus(showStatus);
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }

    
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        Brand pmsBrand = new Brand();
        pmsBrand.setFactoryStatus(factoryStatus);
        BrandExample pmsBrandExample = new BrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }
}
