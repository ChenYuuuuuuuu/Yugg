package io.chenyu.bitcoinexplorer0612.service;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BitcoinListService {
    Page<Block> search(@Param("height") Integer height, @Param("blockhash") String blockhash);

    Block searchbyHeight(@Param("height") Integer height);


    List<Block> searchbyhash(@Param("blockhash") String blockhash);

    List<Block> getblock_detail(@Param("height") Integer height);

    List<Block> getblock_detailbyhash(@Param("hash") String hash);
}