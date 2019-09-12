package cn.wpin.mall.product.dto;

import lombok.Data;

/**
 * 查询单个产品进行修改时返回的结果
 * @author wangpin
 */
@Data
public class ProductResult extends ProductParam {
    /**
     * 商品所选分类的父id
     */
    private Long cateParentId;

}
