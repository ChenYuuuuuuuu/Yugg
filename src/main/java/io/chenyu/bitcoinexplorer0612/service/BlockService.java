package io.chenyu.bitcoinexplorer0612.service;

import io.chenyu.bitcoinexplorer0612.dto.BlockListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockService {
    List<BlockListDTO> getRecentblocks();

}
