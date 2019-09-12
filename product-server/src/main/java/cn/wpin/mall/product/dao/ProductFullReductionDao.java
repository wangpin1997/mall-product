package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.ProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品满减Dao
 * @author wangpin
 */
public interface ProductFullReductionDao {
    int insertList(@Param("list") List<ProductFullReduction> productFullReductionList);
}
