package io.chenyu.bitcoinexplorer0612.service;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Transaction_detailService {
    Page<Transaction_detail> search(@Param("tx_id") Integer tx_id);

    List<Transaction_detail> gettransaction_detailbyhash(@Param("txhash") String txhash);
}
