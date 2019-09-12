package cn.wpin.mall.product.dto;


import cn.wpin.mall.product.entity.ProductCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author wangpin
 * @date 2019年9月11日14:43:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductCategoryWithChildrenItem extends ProductCategory {
    private List<ProductCategory> children;

}
