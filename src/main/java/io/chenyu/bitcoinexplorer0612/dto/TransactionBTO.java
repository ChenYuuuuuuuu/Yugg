package io.chenyu.bitcoinexplorer0612.dto;

import java.math.BigInteger;

public class TransactionBTO {
    private String address;
    private String Hass_160;
    private Integer no_Transactions;
    private Double total_received;
    private Double final_balance;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHass_160() {
        return Hass_160;
    }

    public void setHass_160(String hass_160) {
        Hass_160 = hass_160;
    }

    public Integer getNo_Transactions() {
        return no_Transactions;
    }

    public void setNo_Transactions(Integer no_Transactions) {
        this.no_Transactions = no_Transactions;
    }

    public Double getTotal_received() {
        return total_received;
    }

    public void setTotal_received(Double total_received) {
        this.total_received = total_received;
    }

    public Double getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(Double final_balance) {
        this.final_balance = final_balance;
    }
}
