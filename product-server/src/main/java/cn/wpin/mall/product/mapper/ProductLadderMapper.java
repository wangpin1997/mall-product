package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductLadder;
import cn.wpin.mall.product.example.ProductLadderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductLadderMapper {
    long countByExample(ProductLadderExample example);

    int deleteByExample(ProductLadderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductLadder record);

    int insertSelective(ProductLadder record);

    List<ProductLadder> selectByExample(ProductLadderExample example);

    ProductLadder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductLadder record, @Param("example") ProductLadderExample example);

    int updateByExample(@Param("record") ProductLadder record, @Param("example") ProductLadderExample example);

    int updateByPrimaryKeySelective(ProductLadder record);

    int updateByPrimaryKey(ProductLadder record);
}