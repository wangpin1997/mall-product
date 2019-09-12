package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.dto.ProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * @author wangpin
 */
public interface ProductAttributeCategoryDao {
    List<ProductAttributeCategoryItem> getListWithAttr();
}
