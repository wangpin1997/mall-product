package cn.wpin.mall.product.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CartProduct extends Product {

    private List<ProductAttribute> productAttributeList;
    private List<SkuStock> skuStockList;

}
