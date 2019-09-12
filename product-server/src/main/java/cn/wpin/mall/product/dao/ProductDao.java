package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.dto.ProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * 商品自定义Dao
 * @author wangpin
 */
public interface ProductDao {
    /**
     * 获取商品编辑信息
     */
    ProductResult getUpdateInfo(@Param("id") Long id);
}
