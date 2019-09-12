package cn.wpin.mall.product.dto;


import cn.wpin.mall.product.entity.ProductAttribute;
import cn.wpin.mall.product.entity.ProductAttributeCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 包含有分类下属性的dto
 * @author wangpin
 * @date 2019-9-11 14:46:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductAttributeCategoryItem extends ProductAttributeCategory {
    private List<ProductAttribute> productAttributeList;

}
