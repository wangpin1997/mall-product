package cn.wpin.mall.product.dao;

import cn.wpin.mall.product.entity.MemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格Dao
 * @author wangpin
 */
public interface MemberPriceDao {
    int insertList(@Param("list") List<MemberPrice> memberPriceList);
}
