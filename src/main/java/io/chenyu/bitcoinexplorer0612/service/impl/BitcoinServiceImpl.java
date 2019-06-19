package io.chenyu.bitcoinexplorer0612.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.chenyu.bitcoinexplorer0612.api.BitcoinRestApi;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import io.chenyu.bitcoinexplorer0612.dao.TransactionMapper;
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
    private TransactionMapper transactionMapper;

    @Override
    @Async
    @Transactional
    public void syncBlockhash(String blockhash) {
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
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        Transaction tx = new Transaction();
        tx.setTxhash(txJson.getString("txid"));
        tx.setBlockhash(blockhash);
        tx.setTime(time);
        tx.setSize(txJson.getInteger("size"));
        tx.setWeight(txJson.getFloat("weight"));
        tx.setConfirmations(confirmations);
        transactionMapper.insert(tx);
        //todo set tx detail
        syncTxDetail(txJson);
        //todo set tx amount
    }

    @Override
    public void syncTxDetail(JSONObject txJson) {
        JSONArray vouts = txJson.getJSONArray("vout");
        syncTxDetailVout(vouts);
        JSONArray vins = txJson.getJSONArray("vin");
        syncTxDetailVin(vins);
    }

    @Override
    public void syncTxDetailVout(JSONArray vouts) {
            for(Object voutObj :vouts){
                JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
            }



    }

    @Override
    public void syncTxDetailVin(JSONArray vins) {

    }


}