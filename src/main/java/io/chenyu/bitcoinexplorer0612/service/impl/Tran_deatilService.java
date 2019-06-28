package io.chenyu.bitcoinexplorer0612.service.impl;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.dao.Transaction_detailMapper;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.Transaction_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tran_deatilService implements Transaction_detailService {
    @Autowired
    private Transaction_detailMapper transaction_detailMapper;
    @Override
    public Page<Transaction_detail> search(Integer tx_id) {
        return transaction_detailMapper.search(tx_id);
    }

    @Override
    public List<Transaction_detail> gettransaction_detailbyhash(String txhash) {
        return transaction_detailMapper.gettransaction_detailbyhash(txhash);
    }

    @Override
    public Page<Transaction_detail> searchbyaddress(String address) {
        return transaction_detailMapper.searchbyaddress(address);
    }
}
