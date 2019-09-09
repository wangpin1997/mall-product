package cn.wpin.mall.product.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Album extends IdEntity {

    private String name;

    private String coverPic;

    private Integer picCount;

    private Integer sort;

    private String description;

}