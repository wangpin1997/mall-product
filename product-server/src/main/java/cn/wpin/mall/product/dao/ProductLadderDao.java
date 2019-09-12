package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.ProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员阶梯价格Dao
 * @author wangpin
 */
public interface ProductLadderDao {

    int insertList(@Param("list") List<ProductLadder> productLadderList);
}
