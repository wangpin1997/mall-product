package cn.wpin.mall.client.product;


import cn.wpin.mall.product.entity.CartProduct;
import cn.wpin.mall.product.entity.PromotionProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product")
public interface PortalProductClient {

    @GetMapping("portalProduct/getCartProduct")
    CartProduct getCartProduct(@RequestParam Long id);

    @GetMapping("portalProduct/getPromotionProductList")
    List<PromotionProduct> getPromotionProductList(@RequestParam List<Long> ids);
}
