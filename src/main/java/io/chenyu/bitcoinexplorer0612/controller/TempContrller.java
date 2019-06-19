package io.chenyu.bitcoinexplorer0612.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import io.chenyu.bitcoinexplorer0612.api.BitcoinJsonRpcApi;
import io.chenyu.bitcoinexplorer0612.api.BitcoinRestApi;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.po.Block;
import io.chenyu.bitcoinexplorer0612.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/temp")
@EnableAutoConfiguration
public class TempContrller  {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/test")
    public String test() throws Throwable {

//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
//        return  blockChainInfo.toJSONString();

//    JSONObject blockNoTxDetail = bitcoinRestApi.getBlockNoTxDetail("000000000a2cf56ac5fbff35107995388d367143194ec1dce68cf07b9da36e8a");
//    return blockNoTxDetail.toJSONString();
//
//   JSONObject getblockbyhash = bitcoinRestApi.getblockbyhash("000000000a2cf56ac5fbff35107995388d367143194ec1dce68cf07b9da36e8a");
//     return getblockbyhash.toJSONString();
//
//        List<Object> getblockbyheaders = bitcoinRestApi.getblockbyheaders(5, "0000000000002ec8c8320ce46bbac25c2caab6b3bf6b265aea39fce6c1e82541");
//        return getblockbyheaders.toArray();

//       JSONObject gettx = bitcoinRestApi.gettx("2290d5ee07e350e4a445776bd068164e3b9632bf0c2e3b15b70e7ec91d3735a5");
//       return gettx.toJSONString();
//
//        JSONObject getblockbyheight = bitcoinRestApi.getblockbyheight(442997);
//       return getblockbyheight.toJSONString();
//
//        JSONObject jsonpObject = bitcoinRestApi.getmemPool();
//       return jsonpObject.toJSONString();
//
//        JSONObject getmempoolcontents = bitcoinRestApi.getmempoolcontents();
//        return getmempoolcontents.toJSONString();

//        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
//        return null;

//        JSONObject blockbyHash = bitcoinJsonRpcApi.getBlockbyHash("0000000000000487fe95dd1e0bb61aba58561c2dd3a81f384ae555af2f732eca");
//        JSONObject transactionbyTxid = bitcoinJsonRpcApi.getTransactionbyTxid("8805caef3720c4589973a3544c391a1e307e4ad7ecba484c6e56d617bf2b00a1");
//        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
//        JSONObject blockhashByHeight = bitcoinJsonRpcApi.getBlockhashByHeight(1543827);
//        JSONObject memPool = bitcoinJsonRpcApi.getMemPool();
//        JSONObject recentBlocks = bitcoinJsonRpcApi.getRecentBlocks();
        String tempBlockhash="000000000000001e2e7243a50b448c877eb98e64fa7615154631d7ade7f1b256";
        bitcoinService.syncBlockhash(tempBlockhash);

        return null;
    }




}
