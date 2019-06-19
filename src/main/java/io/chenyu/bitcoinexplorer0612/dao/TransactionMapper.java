package io.chenyu.bitcoinexplorer0612.dao;

import io.chenyu.bitcoinexplorer0612.po.Transaction;
import org.apache.ibatis.annotations.Param;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);


}