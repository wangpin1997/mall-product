package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.ProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 * @author wangpin
 */
public interface ProductAttributeValueDao {
    int insertList(@Param("list") List<ProductAttributeValue> productAttributeValueList);
}
