package cn.wpin.mall.product.mapper;

import cn.wpin.mall.product.entity.AlbumPic;
import cn.wpin.mall.product.example.AlbumPicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumPicMapper {

    long countByExample(AlbumPicExample example);

    int deleteByExample(AlbumPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlbumPic record);

    int insertSelective(AlbumPic record);

    List<AlbumPic> selectByExample(AlbumPicExample example);

    AlbumPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlbumPic record, @Param("example") AlbumPicExample example);

    int updateByExample(@Param("record") AlbumPic record, @Param("example") AlbumPicExample example);

    int updateByPrimaryKeySelective(AlbumPic record);

    int updateByPrimaryKey(AlbumPic record);
}