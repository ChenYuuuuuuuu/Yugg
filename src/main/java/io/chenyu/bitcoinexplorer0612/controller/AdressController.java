package io.chenyu.bitcoinexplorer0612.controller;

import io.chenyu.bitcoinexplorer0612.dao.Transaction_detailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AdressController {
    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @GetMapping("/getBalance")
    public Double getBalance(@RequestParam String address){
        Double blance = transaction_detailMapper.getBlance(address);
        return blance;
    }

}
