package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.FeightTemplate;
import cn.wpin.mall.product.example.FeightTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeightTemplateMapper {
    long countByExample(FeightTemplateExample example);

    int deleteByExample(FeightTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FeightTemplate record);

    int insertSelective(FeightTemplate record);

    List<FeightTemplate> selectByExample(FeightTemplateExample example);

    FeightTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FeightTemplate record, @Param("example") FeightTemplateExample example);

    int updateByExample(@Param("record") FeightTemplate record, @Param("example") FeightTemplateExample example);

    int updateByPrimaryKeySelective(FeightTemplate record);

    int updateByPrimaryKey(FeightTemplate record);
}