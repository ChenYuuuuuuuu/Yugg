package io.chenyu.bitcoinexplorer0612.dto;

import java.math.BigInteger;
import java.util.Date;

public class BlockGetDTObyHeight {
    private Integer Height;
    private Integer number_of_transactions;
    private Double output_total;
    private Double emstimated_transaction_volume;
    private Date timestamp;
    private Date RECEIVED_time;
    private String relayed_by;
    private Double difficulty;
    private int bits;
    private Double size;
    private Double weight;
    private String version;
    private Integer nonce;
    private Double block_reward;


    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public Integer getNumber_of_transactions() {
        return number_of_transactions;
    }

    public void setNumber_of_transactions(Integer number_of_transactions) {
        this.number_of_transactions = number_of_transactions;
    }

    public Double getOutput_total() {
        return output_total;
    }

    public void setOutput_total(Double output_total) {
        this.output_total = output_total;
    }

    public Double getEmstimated_transaction_volume() {
        return emstimated_transaction_volume;
    }

    public void setEmstimated_transaction_volume(Double emstimated_transaction_volume) {
        this.emstimated_transaction_volume = emstimated_transaction_volume;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getRECEIVED_time() {
        return RECEIVED_time;
    }

    public void setRECEIVED_time(Date RECEIVED_time) {
        this.RECEIVED_time = RECEIVED_time;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Double getBlock_reward() {
        return block_reward;
    }

    public void setBlock_reward(Double block_reward) {
        this.block_reward = block_reward;
    }
}
