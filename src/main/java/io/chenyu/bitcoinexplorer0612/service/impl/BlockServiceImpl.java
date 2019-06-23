package io.chenyu.bitcoinexplorer0612.service.impl;

import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.dto.BlockListDTO;
import io.chenyu.bitcoinexplorer0612.po.Block;
import io.chenyu.bitcoinexplorer0612.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;

    @Override
    public List<BlockListDTO> getRecentblocks() {
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();
        List<Block> blocks = blockMapper.selectRecentBlocks();
        for(Block block:blocks){
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            blockListDTOS.add(blockListDTO);
        }

        return blockListDTOS;
    }



}
