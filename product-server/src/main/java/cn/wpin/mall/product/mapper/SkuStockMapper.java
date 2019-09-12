package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.SkuStock;
import cn.wpin.mall.product.example.SkuStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuStockMapper {

    long countByExample(SkuStockExample example);

    int deleteByExample(SkuStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuStock record);

    int insertSelective(SkuStock record);

    List<SkuStock> selectByExample(SkuStockExample example);

    SkuStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByExample(@Param("record") SkuStock record, @Param("example") SkuStockExample example);

    int updateByPrimaryKeySelective(SkuStock record);

    int updateByPrimaryKey(SkuStock record);
}