package cn.wpin.mall.product.dto;


import lombok.Data;

/**
 * 商品分类对应属性信息
 * @author wangpin
 * @date 2019-9-11 14:45:44
 */
@Data
public class ProductAttrInfo {
    private Long attributeId;
    private Long attributeCategoryId;

}
