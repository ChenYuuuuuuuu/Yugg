package io.chenyu.bitcoinexplorer0612.service.impl;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.dto.BlockListDTO;
import io.chenyu.bitcoinexplorer0612.po.Block;
import io.chenyu.bitcoinexplorer0612.service.BitcoinListService;
import io.chenyu.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockListImpl implements BitcoinListService {
    @Autowired
    private BlockMapper blockMapper;
    @Override
    public Page<Block> search(Integer height, String blockhash) {
        return blockMapper.search(height,blockhash);
    }

    @Override
    public Block searchbyHeight(Integer height) {
        return blockMapper.searchbyheight(height);
    }

    @Override
    public List<Block> searchbyhash(String blockhash) {
        return blockMapper.searchbyhash(blockhash);
    }

    @Override
    public List<Block> getblock_detail(Integer height) {
        return blockMapper.getblock_detail(height);
    }

    @Override
    public List<Block> getblock_detailbyhash(String hash) {
        return blockMapper.getblock_detailbyhash(hash);
    }

}
