package io.chenyu.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONPObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BitcoinRestApi", url = "http://localhost:18332")
public interface BitcoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONPObject getBlockChainInfo();

    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONPObject getBlockNoTxDetail(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONPObject getblockbyhash(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/headers/{num}/{blockhash}.json")
    JSONPObject getblockbyheaders(@PathVariable(value = "num")Integer num,@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/tx/{blockhash}.json")
    JSONPObject gettx(@PathVariable(value = "blockhash") String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    JSONPObject getblockbyheight(@PathVariable(value = "height") Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONPObject getmemPool();

    @GetMapping("/rest/mempool/contents.json")
    JSONPObject getmempoolcontents();

}
