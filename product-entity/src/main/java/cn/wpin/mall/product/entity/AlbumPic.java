package cn.wpin.mall.product.entity;

import cn.wpin.mall.common.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangpin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AlbumPic extends IdEntity {

    private Long albumId;

    private String pic;

}