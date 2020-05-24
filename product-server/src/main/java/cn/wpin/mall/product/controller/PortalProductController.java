package cn.wpin.mall.product.controller;

import cn.wpin.mall.product.entity.CartProduct;
import cn.wpin.mall.product.entity.PromotionProduct;
import cn.wpin.mall.product.service.PortalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangpin
 */
@RestController
@RequestMapping("portalProduct")
public class PortalProductController {

    @Autowired
    private PortalProductService portalProductService;

    @GetMapping("getCartProduct")
    public CartProduct getCartProduct(@RequestParam Long id) {
        return portalProductService.getCartProduct(id);
    }

    @GetMapping("getPromotionProductList")
    public List<PromotionProduct> getPromotionProductList(@RequestParam List<Long> ids) {
        return portalProductService.getPromotionProductList(ids);
    }

}
