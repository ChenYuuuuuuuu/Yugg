package io.chenyu.bitcoinexplorer0612.dto;

import java.util.Date;

public class BlockListDTO {
    private String blockhash;

    private Integer height;

    private Date time;

    private Short txsize;

    private Integer size;

    private Double difficulty;

    private Double weight;

    private String nextBlock;

    private String prevBlock;

    private Date timestamp;

    private Date received;

    private Integer bits;

    private String version;

    private Integer noce;

    private Double blockReward;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Short getTxsize() {
        return txsize;
    }

    public void setTxsize(Short txsize) {
        this.txsize = txsize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(String prevBlock) {
        this.prevBlock = prevBlock;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNoce() {
        return noce;
    }

    public void setNoce(Integer noce) {
        this.noce = noce;
    }

    public Double getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(Double blockReward) {
        this.blockReward = blockReward;
    }
}
