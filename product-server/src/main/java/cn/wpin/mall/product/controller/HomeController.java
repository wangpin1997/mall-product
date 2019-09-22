package cn.wpin.mall.product.controller;

import cn.wpin.mall.content.entity.Subject;
import cn.wpin.mall.product.dto.FlashPromotionProduct;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.entity.Product;
import cn.wpin.mall.product.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpin
 */
@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeService homeService;


    /**
     * 获取推荐品牌
     */
    @RequestMapping("getRecommendBrandList")
    public List<Brand> getRecommendBrandList(@RequestParam Integer offset, @RequestParam Integer limit) {
        return homeService.getRecommendBrandList(offset, limit);
    }

    /**
     * 获取秒杀商品
     */
    @RequestMapping("getFlashProductList")
    public List<FlashPromotionProduct> getFlashProductList(@RequestParam Long flashPromotionId,
                                                           @RequestParam Long sessionId) {
        return homeService.getFlashProductList(flashPromotionId, sessionId);
    }


    /**
     * 获取新品推荐
     */
    @RequestMapping("getNewProductList")
    public List<Product> getNewProductList(@RequestParam Integer offset, @RequestParam Integer limit) {
        return homeService.getNewProductList(offset, limit);
    }

    /**
     * 获取人气推荐
     */
    @RequestMapping("getHotProductList")
    public List<Product> getHotProductList(@RequestParam Integer offset, @RequestParam Integer limit) {
        return homeService.getHotProductList(offset, limit);
    }

    /**
     * 获取推荐专题
     */
    @RequestMapping("getRecommendSubjectList")
    public List<Subject> getRecommendSubjectList(@RequestParam Integer offset, @RequestParam Integer limit) {
        return homeService.getRecommendSubjectList(offset, limit);
    }
}
