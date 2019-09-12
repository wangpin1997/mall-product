package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductFullReduction;
import cn.wpin.mall.product.example.ProductFullReductionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductFullReductionMapper {
    long countByExample(ProductFullReductionExample example);

    int deleteByExample(ProductFullReductionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductFullReduction record);

    int insertSelective(ProductFullReduction record);

    List<ProductFullReduction> selectByExample(ProductFullReductionExample example);

    ProductFullReduction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByExample(@Param("record") ProductFullReduction record, @Param("example") ProductFullReductionExample example);

    int updateByPrimaryKeySelective(ProductFullReduction record);

    int updateByPrimaryKey(ProductFullReduction record);
}