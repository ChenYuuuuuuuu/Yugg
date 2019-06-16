package io.chenyu.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONPObject;
import io.chenyu.bitcoinexplorer0612.api.BitcoinRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempContrller  {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @GetMapping("/test")
    public String test(){
         JSONPObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
          return  blockChainInfo.toJSONString();

//     JSONPObject blockNoTxDetail = bitcoinRestApi.getBlockNoTxDetail("000000000a2cf56ac5fbff35107995388d367143194ec1dce68cf07b9da36e8a");
//     return blockNoTxDetail.toJSONString();
//
//   JSONPObject getblockbyhash = bitcoinRestApi.getblockbyhash("000000000a2cf56ac5fbff35107995388d367143194ec1dce68cf07b9da36e8a");
//     return getblockbyhash.toJSONString();
//
//       JSONPObject getblockbyheaders = bitcoinRestApi.getblockbyheaders(5, "0000000000002ec8c8320ce46bbac25c2caab6b3bf6b265aea39fce6c1e82541");
//       return getblockbyheaders.toJSONString();
//
//       JSONPObject gettx = bitcoinRestApi.gettx("2290d5ee07e350e4a445776bd068164e3b9632bf0c2e3b15b70e7ec91d3735a5");
//       return gettx.toJSONString();
//
//        JSONPObject getblockbyheight = bitcoinRestApi.getblockbyheight(442997);
//       return getblockbyheight.toJSONString();
//
//        JSONPObject jsonpObject = bitcoinRestApi.getmemPool();
//       return jsonpObject.toJSONString();
//
//        JSONPObject getmempoolcontents = bitcoinRestApi.getmempoolcontents();
//        return getmempoolcontents.toJSONString();
    }



}
