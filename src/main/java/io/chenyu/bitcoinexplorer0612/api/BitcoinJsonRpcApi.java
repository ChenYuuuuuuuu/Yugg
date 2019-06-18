package io.chenyu.bitcoinexplorer0612.api;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    JSONObject getRecentBlocks() throws Throwable;

    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockbyHash(String blockhash) throws Throwable;

    JSONObject getTransactionbyTxid(String txid) throws Throwable;

    JSONObject getBlockhashByHeight(Integer height) throws Throwable;

    JSONObject getMemPool() throws Throwable;
}
