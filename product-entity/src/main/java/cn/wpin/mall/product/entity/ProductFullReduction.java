package cn.wpin.mall.product.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductFullReduction extends IdEntity {

    private Long productId;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;

}