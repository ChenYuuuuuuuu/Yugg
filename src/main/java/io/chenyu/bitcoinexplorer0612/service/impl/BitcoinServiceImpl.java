package io.chenyu.bitcoinexplorer0612.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.chenyu.bitcoinexplorer0612.api.BitcoinJsonRpcApi;
import io.chenyu.bitcoinexplorer0612.api.BitcoinRestApi;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.dao.TransactionMapper;
import io.chenyu.bitcoinexplorer0612.dao.Transaction_detailMapper;
import io.chenyu.bitcoinexplorer0612.enumeration.TxDetailType;
import io.chenyu.bitcoinexplorer0612.po.Block;
import io.chenyu.bitcoinexplorer0612.po.Transaction;
import io.chenyu.bitcoinexplorer0612.po.Transaction_detail;
import io.chenyu.bitcoinexplorer0612.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Component
public class BitcoinServiceImpl implements BitcoinService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @Override
    @Async
    @Transactional
    public void syncBlockhash(String blockhash) throws Throwable {
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()) {
            JSONObject blockJson = bitcoinRestApi.getblockbyhash(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockJson.getString("hash"));
            block.setHeight(blockJson.getInteger("height"));
            Long timestamp = blockJson.getLong("time");
            Date time = new Date(timestamp * 1000);
            block.setTime(time);
            block.setTxsize(blockJson.getShort("nTx"));
            block.setSize(blockJson.getInteger("size"));
            block.setWeight(blockJson.getFloat("weight"));
            block.setDifficulty(blockJson.getDouble("difficulty"));
            block.setPrevBlock(blockJson.getString("previousblockhash"));
            block.setNextBlock(blockJson.getString("nextblockhash"));
            Integer confirmations = blockJson.getInteger("confirmations");
            blockMapper.insert(block);
            JSONArray txesArray = blockJson.getJSONArray("tx");

            for (Object txObj : txesArray) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) txObj);
                syncTx(jsonObject, tempBlockhash, time, confirmations);
            }
            tempBlockhash = block.getNextBlock();
        }
        logger.info("end sync block");
    }

    @Override
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) throws Throwable {
        Transaction tx = new Transaction();
       String txid = txJson.getString("txid");
        tx.setTxhash(txid);
        tx.setBlockhash(blockhash);
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        transactionMapper.insert(tx);
        //todo set tx detail
        syncTxDetail(txJson, txid);
        //todo set tx amount
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txJson,String txid) throws Throwable {
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts, txid);
        JSONArray vins = txJson.getJSONArray("vin");
        syncTxDetailVin(vins,txid);
    }

    @Override
    @Transactional
    public void syncTxDetailVout(JSONArray vouts,String txid) {
            for(Object voutObj :vouts){
                JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
                Transaction_detail txDetail = new Transaction_detail();
                txDetail.setAmount(jsonObject.getDouble("value"));
                txDetail.setTxhash(txid);
                txDetail.setType((byte) TxDetailType.Receive.ordinal());
                JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if(addresses!=null){
                    String address = addresses.getString(0);
                    txDetail.setAddress(address);
                }
                transaction_detailMapper.insert(txDetail);
            }



    }

    @Override
    @Transactional
    public void syncTxDetailVin(JSONArray vins,String txid) throws Throwable {
        for(Object vinobj :vins){
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinobj);
            String vinTxid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");
            if(vinTxid !=null){
                JSONObject vinTxJson = bitcoinJsonRpcApi.getTransactionbyTxid(vinTxid);
                JSONArray vouts = vinTxJson.getJSONArray("vout");
                JSONObject utxoJson = vouts.getJSONObject(n);

                Transaction_detail txDetail = new Transaction_detail();
                txDetail.setAmount(-utxoJson.getDouble("value"));
                txDetail.setTxhash(txid);
                txDetail.setType((byte) TxDetailType.Send.ordinal());
                JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if(addresses !=null){
                    String address = addresses.getString(0);
                    txDetail.setAddress(address);
                }
                transaction_detailMapper.insert(txDetail);

            }
        }
    }


}
