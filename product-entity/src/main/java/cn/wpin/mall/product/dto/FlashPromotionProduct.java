package cn.wpin.mall.product.dto;

import cn.wpin.mall.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 * @author wangpin
 */
@Getter
@Setter
public class FlashPromotionProduct extends Product {
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
