package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.SkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品sku库存Dao
 * @author wangpin
 */
public interface SkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list") List<SkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list") List<SkuStock> skuStockList);
}
