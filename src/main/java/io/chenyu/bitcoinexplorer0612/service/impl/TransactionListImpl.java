package io.chenyu.bitcoinexplorer0612.service.impl;

import com.github.pagehelper.Page;
import io.chenyu.bitcoinexplorer0612.dao.TransactionMapper;
import io.chenyu.bitcoinexplorer0612.dao.Transaction_detailMapper;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.TransactionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionListImpl implements TransactionListService {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private Transaction_detailMapper transaction_detailMapper;
    @Override
    public Page<Transaction> search(String txhash) {
        return transactionMapper.search(txhash);
    }

    @Override
    public List<Transaction_detail> searchbyaddress(String address) {
        return transaction_detailMapper.searchbyaddress(address);
    }

    @Override
    public List<Transaction> gettransactionbyhash(String txhash) {
        return transactionMapper.searchbyhash(txhash);
    }
}