package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.dto.ProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * @author wangpin
 */
public interface ProductCategoryDao {
    List<ProductCategoryWithChildrenItem> listWithChildren();
}
