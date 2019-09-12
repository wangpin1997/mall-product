package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.MemberPrice;
import cn.wpin.mall.product.example.MemberPriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberPriceMapper {

    long countByExample(MemberPriceExample example);

    int deleteByExample(MemberPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberPrice record);

    int insertSelective(MemberPrice record);

    List<MemberPrice> selectByExample(MemberPriceExample example);

    MemberPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByExample(@Param("record") MemberPrice record, @Param("example") MemberPriceExample example);

    int updateByPrimaryKeySelective(MemberPrice record);

    int updateByPrimaryKey(MemberPrice record);
}