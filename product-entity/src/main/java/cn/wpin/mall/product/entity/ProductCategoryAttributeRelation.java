package cn.wpin.mall.product.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductCategoryAttributeRelation extends IdEntity {

    private Long productCategoryId;

    private Long productAttributeId;

}