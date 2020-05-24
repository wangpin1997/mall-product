package cn.wpin.mall.product.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wangpin 
 * 商品的促销信息，包括sku、打折优惠、满减优惠
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PromotionProduct extends Product {
    /**
     * 商品库存信息
     */
    private List<SkuStock> skuStockList;
    /**
     * 商品打折信息
     */
    private List<ProductLadder> productLadderList;
    /**
     * 商品满减信息
     */
    private List<ProductFullReduction> productFullReductionList;

}
