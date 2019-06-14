package io.chenyu.bitcoinexplorer0612.dao;

import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;

public interface Transaction_detailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(Transaction_detail record);

    int insertSelective(Transaction_detail record);

    Transaction_detail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(Transaction_detail record);

    int updateByPrimaryKey(Transaction_detail record);
}