package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.ProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 * @author wangpin
 */
public interface ProductCategoryAttributeRelationDao {
    int insertList(@Param("list") List<ProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
