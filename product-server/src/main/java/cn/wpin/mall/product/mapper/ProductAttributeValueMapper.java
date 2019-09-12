package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductAttributeValue;
import cn.wpin.mall.product.example.ProductAttributeValueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductAttributeValueMapper {

    long countByExample(ProductAttributeValueExample example);

    int deleteByExample(ProductAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductAttributeValue record);

    int insertSelective(ProductAttributeValue record);

    List<ProductAttributeValue> selectByExample(ProductAttributeValueExample example);

    ProductAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByExample(@Param("record") ProductAttributeValue record, @Param("example") ProductAttributeValueExample example);

    int updateByPrimaryKeySelective(ProductAttributeValue record);

    int updateByPrimaryKey(ProductAttributeValue record);
}