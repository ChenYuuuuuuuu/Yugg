package io.chenyu.bitcoinexplorer0612.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import io.chenyu.bitcoinexplorer0612.api.BitcoinJsonRpcApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class BitcoiJsonRpcApiImpl implements BitcoinJsonRpcApi {
    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitcoiJsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                                @Value("${bitcoin.jsonrpc.password}") String password,
                                @Value("${bitcoin.jsonrpc.url}") String url) throws MalformedURLException {
        HashMap<String, String> headers = new HashMap<>();
        String authStrOrig = String.format("%s:%s",username,password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authStrResult = String.format("Basic %s",authStr);
        headers.put("Authorization",authStrResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url),headers);
    }

    @Override
    public JSONObject getBlockchainInfo() throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
        return jsonObject;
    }

    @Override
    public JSONObject getBlockbyHash(String blockhash) throws Throwable {
        JSONObject getblock = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);
        return getblock;
    }

    @Override
    public JSONObject getTransactionbyTxid(String txid) throws Throwable {
        JSONObject getrawtransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return getrawtransaction;
    }

    @Override
    public JSONObject getBlockhashByHeight(Integer height) throws Throwable {
        JSONObject result = jsonRpcHttpClient.invoke("getblockhash", new Object[]{height}, JSONObject.class);
        return result;
    }

    @Override
    public JSONObject getMemPool() throws Throwable {
        JSONObject getmempoolinfo = jsonRpcHttpClient.invoke("getmempoolinfo", new Object[]{}, JSONObject.class);
        return getmempoolinfo;
    }

    @Override
    public JSONObject getRecentBlocks() throws Throwable {
        String getbestblockhash = jsonRpcHttpClient.invoke("getbestblockhash", new Object[]{}, String.class);
        JSONObject getblock = jsonRpcHttpClient.invoke("getblock", new Object[]{getbestblockhash}, JSONObject.class);
        return getblock;
    }
}
