package io.chenyu.bitcoinexplorer0612.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.BitcoinListService;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.po.Block;
import io.chenyu.bitcoinexplorer0612.service.TransactionListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bitcoin")
@EnableAutoConfiguration
@CrossOrigin
public class Bitontroller {

    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BitcoinListService bitcoinListService;
    @Autowired
    private TransactionListService transactionListService;
    @GetMapping("/blocklist")
    public PageInfo<Block> blockList(@RequestParam(required = false,defaultValue = "")Integer height,
                                    @RequestParam(required = false,defaultValue = "")String blockhash,
                                    @RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,100);
        Page<Block> blocks = bitcoinListService.search(height, blockhash);
        PageInfo<Block> blockPageInfo = blocks.toPageInfo();
        return  blockPageInfo;
    }
    @GetMapping("/searchall")
    public Object search(@RequestParam(required = false)String searchname){
        if(searchname!=null){
            if(searchname.length()<8){
                Block byheight = bitcoinListService.searchbyHeight(Integer.parseInt(searchname));
                if(byheight!=null){
                     return byheight;
                }
                return byheight;
            }else if(searchname.length()>10 && searchname.length()<50){
                List<Transaction_detail> searchbyaddress = transactionListService.searchbyaddress(searchname);
                return searchbyaddress;
            }else if(searchname.length()==64){
                List<Block> searchbyhash = bitcoinListService.searchbyhash(searchname);
                if(searchbyhash!=null){
                    return  searchbyhash;
                }
                List<Transaction> gettransactionbyhash = transactionListService.gettransactionbyhash(searchname);
                if(gettransactionbyhash!=null){
                    return  gettransactionbyhash;
                }
            }
        }

        return null;
    }



}
