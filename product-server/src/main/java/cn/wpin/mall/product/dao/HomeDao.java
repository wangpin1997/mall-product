package cn.wpin.mall.product.dao;


import cn.wpin.mall.content.entity.Subject;
import cn.wpin.mall.product.dto.FlashPromotionProduct;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * @author wangpin
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<Brand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<Product> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<Product> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<Subject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
