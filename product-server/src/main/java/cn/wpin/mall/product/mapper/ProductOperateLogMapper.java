package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductOperateLog;
import cn.wpin.mall.product.example.ProductOperateLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductOperateLogMapper {
    long countByExample(ProductOperateLogExample example);

    int deleteByExample(ProductOperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductOperateLog record);

    int insertSelective(ProductOperateLog record);

    List<ProductOperateLog> selectByExample(ProductOperateLogExample example);

    ProductOperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductOperateLog record, @Param("example") ProductOperateLogExample example);

    int updateByExample(@Param("record") ProductOperateLog record, @Param("example") ProductOperateLogExample example);

    int updateByPrimaryKeySelective(ProductOperateLog record);

    int updateByPrimaryKey(ProductOperateLog record);
}