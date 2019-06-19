package io.chenyu.bitcoinexplorer0612.service;

import io.chenyu.bitcoinexplorer0612.dto.BlockListDTO;

import java.util.List;

public interface BlockService {
    List<BlockListDTO> getRecentblocks();
}
