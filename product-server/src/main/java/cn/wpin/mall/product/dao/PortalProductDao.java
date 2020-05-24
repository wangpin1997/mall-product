package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.CartProduct;
import cn.wpin.mall.product.entity.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 *
 * @author wangpin
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);

    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
}
