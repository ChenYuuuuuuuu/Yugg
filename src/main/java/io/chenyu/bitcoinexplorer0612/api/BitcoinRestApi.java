package io.chenyu.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BitcoinRestApi", url = "http://localhost:18332")
public interface BitcoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();

    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockNoTxDetail(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getblockbyhash(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/headers/{num}/{blockhash}.json")
   List<Object> getblockbyheaders(@PathVariable(value = "num")Integer num, @PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/tx/{blockhash}.json")
    JSONObject gettx(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONObject getblockbyheight(@PathVariable(value = "height") Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getmemPool();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getmempoolcontents();

}
