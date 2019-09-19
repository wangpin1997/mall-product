package cn.wpin.mall.client.product;

import cn.wpin.mall.content.entity.Subject;
import cn.wpin.mall.product.dto.FlashPromotionProduct;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product")
public interface HomeClient {

    /**
     * 获取推荐品牌
     */
    List<Brand> getRecommendBrandList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@RequestParam("flashPromotionId") Long flashPromotionId, @RequestParam("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<Product> getNewProductList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);
    /**
     * 获取人气推荐
     */
    List<Product> getHotProductList(@RequestParam("offset") Integer offset,@RequestParam("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<Subject> getRecommendSubjectList(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit);

}
