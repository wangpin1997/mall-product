package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductCategoryAttributeRelation;
import cn.wpin.mall.product.example.ProductCategoryAttributeRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryAttributeRelationMapper {
    long countByExample(ProductCategoryAttributeRelationExample example);

    int deleteByExample(ProductCategoryAttributeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductCategoryAttributeRelation record);

    int insertSelective(ProductCategoryAttributeRelation record);

    List<ProductCategoryAttributeRelation> selectByExample(ProductCategoryAttributeRelationExample example);

    ProductCategoryAttributeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductCategoryAttributeRelation record, @Param("example") ProductCategoryAttributeRelationExample example);

    int updateByExample(@Param("record") ProductCategoryAttributeRelation record, @Param("example") ProductCategoryAttributeRelationExample example);

    int updateByPrimaryKeySelective(ProductCategoryAttributeRelation record);

    int updateByPrimaryKey(ProductCategoryAttributeRelation record);
}