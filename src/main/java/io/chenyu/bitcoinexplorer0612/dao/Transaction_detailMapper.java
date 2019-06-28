package io.chenyu.bitcoinexplorer0612.dao;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Transaction_detailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(Transaction_detail record);

    int insertSelective(Transaction_detail record);

    Transaction_detail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(Transaction_detail record);

    int updateByPrimaryKey(Transaction_detail record);

    Double getBlance(@Param("address") String address);

    Page<Transaction_detail> search(@Param("tx_id") Integer tx_id);

    Page<Transaction_detail> searchbyaddress(@Param("address") String address);

    List<Transaction_detail> gettransaction_detailbyhash(@Param("txhash") String txhash);
}