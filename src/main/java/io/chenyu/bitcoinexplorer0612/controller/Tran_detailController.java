package io.chenyu.bitcoinexplorer0612.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.chenyu.bitcoinexplorer0612.dao.Transaction_detailMapper;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.Transaction_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tran_detail")
@EnableAutoConfiguration
@CrossOrigin
public class Tran_detailController {
    @Autowired
    private Transaction_detailMapper transaction_detailMapper;
    @Autowired
    private Transaction_detailService transaction_detailService;

    @GetMapping("/tran_detail_list")
    public PageInfo<Transaction_detail> tran_dratil_list(@RequestParam(required = false,defaultValue = "")Integer tx_id ){
        Page<Transaction_detail> transaction_details = transaction_detailService.search(tx_id);
        PageInfo<Transaction_detail> transaction_detailPageInfo = transaction_details.toPageInfo();
        return transaction_detailPageInfo;
    }
    @GetMapping("/tran_detailbyaddress")
    public PageInfo<Transaction_detail> tran_detailbyaddress(@RequestParam(required = false,defaultValue = "")String address ){
        Page<Transaction_detail> searchbyaddress = transaction_detailService.searchbyaddress(address);
        PageInfo<Transaction_detail> transaction_detailPageInfo = searchbyaddress.toPageInfo();
        return transaction_detailPageInfo;
    }
}
