package io.chenyu.bitcoinexplorer0612.service;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionListService {
    Page<Transaction> search(@Param("txhash") String txhash);

    List<Transaction_detail> searchbyaddress(@Param("address") String address);

    List<Transaction> gettransactionbyhash(@Param("txhash") String txhash);
}
