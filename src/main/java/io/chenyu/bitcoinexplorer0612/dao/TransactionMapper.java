package io.chenyu.bitcoinexplorer0612.dao;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);


    Page<Transaction> search(@Param("txhash") String txhash);

    List<Transaction> searchbyhash(@Param("txhash") String txhash);
}