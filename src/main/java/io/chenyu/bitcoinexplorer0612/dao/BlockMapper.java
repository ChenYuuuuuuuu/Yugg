package io.chenyu.bitcoinexplorer0612.dao;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecentBlocks();

    Page<Block> search(@Param("height") Integer height,@Param("blockhash") String blockhash);

    Block searchbyheight(@Param("height") Integer height);

    Page<Block> searchbyhash(@Param("blockhash") String blockhash);

    Page<Block> getblock_detail(@Param("height") Integer height);

    Page<Block> getblock_detailbyhash(@Param("hash") String hash);
}