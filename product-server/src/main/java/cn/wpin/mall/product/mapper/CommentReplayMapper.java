package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.CommentReplay;
import cn.wpin.mall.product.example.CommentReplayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentReplayMapper {

    long countByExample(CommentReplayExample example);

    int deleteByExample(CommentReplayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentReplay record);

    int insertSelective(CommentReplay record);

    List<CommentReplay> selectByExample(CommentReplayExample example);

    CommentReplay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentReplay record, @Param("example") CommentReplayExample example);

    int updateByExample(@Param("record") CommentReplay record, @Param("example") CommentReplayExample example);

    int updateByPrimaryKeySelective(CommentReplay record);

    int updateByPrimaryKey(CommentReplay record);
}