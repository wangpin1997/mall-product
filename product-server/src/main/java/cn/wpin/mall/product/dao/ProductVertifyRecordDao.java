package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.ProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品审核日志自定义dao
 * @author wangpin
 */
public interface ProductVertifyRecordDao {
    int insertList(@Param("list") List<ProductVertifyRecord> list);
}
