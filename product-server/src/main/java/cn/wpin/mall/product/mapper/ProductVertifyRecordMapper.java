package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.ProductVertifyRecord;
import cn.wpin.mall.product.example.ProductVertifyRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductVertifyRecordMapper {

    long countByExample(ProductVertifyRecordExample example);

    int deleteByExample(ProductVertifyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductVertifyRecord record);

    int insertSelective(ProductVertifyRecord record);

    List<ProductVertifyRecord> selectByExample(ProductVertifyRecordExample example);

    ProductVertifyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductVertifyRecord record, @Param("example") ProductVertifyRecordExample example);

    int updateByExample(@Param("record") ProductVertifyRecord record, @Param("example") ProductVertifyRecordExample example);

    int updateByPrimaryKeySelective(ProductVertifyRecord record);

    int updateByPrimaryKey(ProductVertifyRecord record);
}