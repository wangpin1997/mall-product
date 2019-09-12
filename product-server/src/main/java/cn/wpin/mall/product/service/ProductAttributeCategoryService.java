package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dao.ProductAttributeCategoryDao;
import cn.wpin.mall.product.dto.ProductAttributeCategoryItem;
import cn.wpin.mall.product.entity.ProductAttributeCategory;
import cn.wpin.mall.product.example.ProductAttributeCategoryExample;
import cn.wpin.mall.product.mapper.ProductAttributeCategoryMapper;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductAttributeCategoryService实现类
 * @author wangpin
 */
@Service
public class ProductAttributeCategoryService  {
    @Autowired
    private ProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private ProductAttributeCategoryDao productAttributeCategoryDao;

    public int create(String name) {
        ProductAttributeCategory productAttributeCategory = new ProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    
    public int update(Long id, String name) {
        ProductAttributeCategory productAttributeCategory = new ProductAttributeCategory();
        productAttributeCategory.setName(name);
        productAttributeCategory.setId(id);
        return productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
    }

    
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    
    public ProductAttributeCategory getItem(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    
    public List<ProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return productAttributeCategoryMapper.selectByExample(new ProductAttributeCategoryExample());
    }

    
    public List<ProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryDao.getListWithAttr();
    }
}
