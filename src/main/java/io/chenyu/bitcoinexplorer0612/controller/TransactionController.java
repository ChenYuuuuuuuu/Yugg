package io.chenyu.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.chenyu.bitcoinexplorer0612.dao.TransactionMapper;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.TransactionListService;
import io.chenyu.bitcoinexplorer0612.service.Transaction_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
@EnableAutoConfiguration
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionListService transactionListService;
    @Autowired
    private Transaction_detailService transaction_detailService;
    @GetMapping("/transactionlist")
   public PageInfo<Transaction> search(@RequestParam(required = false,defaultValue = "")String txhash,
                                       @RequestParam(required = false,defaultValue = "1")Integer Pagenum ){
        PageHelper.startPage(Pagenum,5);
        Page<Transaction> transactions = transactionListService.search(txhash);
        PageInfo<Transaction> transactionPageInfo = transactions.toPageInfo();
        return transactionPageInfo;
    }
    @GetMapping("/transactionlist2")
    public PageInfo<Transaction> search2(@RequestParam(required = false,defaultValue = "")String txhash,
                                        @RequestParam(required = false,defaultValue = "1")Integer Pagenum ){
        PageHelper.startPage(Pagenum,3100);
        Page<Transaction> transactions = transactionListService.search(txhash);
        PageInfo<Transaction> transactionPageInfo = transactions.toPageInfo();
        return transactionPageInfo;
    }

    @GetMapping("/transaction_detailbyhash")
    public List<Transaction_detail> getdetailbyhash(@RequestParam(required = false,defaultValue = "")String  txhash){
        List<Transaction_detail> transaction_details = transaction_detailService.gettransaction_detailbyhash(txhash);
        return transaction_details;
    }


}
