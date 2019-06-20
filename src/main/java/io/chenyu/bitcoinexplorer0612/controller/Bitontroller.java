package io.chenyu.bitcoinexplorer0612.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Bitcoin")
@EnableAutoConfiguration
@CrossOrigin
public class Bitontroller {

    @Autowired
    private BlockMapper blockMapper;

    @GetMapping("/blocklist")
    public PageInfo<Block> blockList(@RequestParam(required = false,defaultValue = "")Integer height,
                                    @RequestParam(required = false,defaultValue = "")String blockhash,
                                    @RequestParam(required = false,defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,100);
        Page<Block> blockPage = blockMapper.search(height,blockhash);
        PageInfo<Block> blockPageInfo = blockPage.toPageInfo();
        return  blockPageInfo;
    }


}
