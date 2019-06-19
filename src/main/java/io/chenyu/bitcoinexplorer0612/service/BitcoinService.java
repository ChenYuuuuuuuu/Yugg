package io.chenyu.bitcoinexplorer0612.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.chenyu.bitcoinexplorer0612.dao.BlockMapper;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public interface BitcoinService {
        void syncBlockhash(String blockhash);

    void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations);

    void syncTxDetail(JSONObject txJson);

    void syncTxDetailVout(JSONArray vouts);

    void syncTxDetailVin(JSONArray vins);



}
