package io.chenyu.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.chenyu.bitcoinexplorer0612.dao.TransactionMapper;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.service.TransactionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
@EnableAutoConfiguration
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionListService transactionListService;
    @GetMapping("/transactionlist")
   public PageInfo<Transaction> search(@RequestParam(required = false,defaultValue = "")String txhash){
        Page<Transaction> transactions = transactionListService.search(txhash);
        PageInfo<Transaction> transactionPageInfo = transactions.toPageInfo();
        return transactionPageInfo;
    }
}
