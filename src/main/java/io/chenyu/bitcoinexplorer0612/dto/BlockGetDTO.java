package io.chenyu.bitcoinexplorer0612.dto;

public class BlockGetDTO {
    private String blockhash;
    private Integer height;
    private String prevBlcok;
    private String nextBlock;
    private String merkleRoot;
    private Short txSize;
    private Double outputTotal;
    private Double fees;
    private Long time;
    private Double difficulty;
    private Integer size;
    private Double total_input;
    private Double total_output;
    private Double fee_per_byte;
    private Double fee_per_weight_unit;
    private Double estimated;
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

    public String getPrevBlcok() {
        return prevBlcok;
    }

    public void setPrevBlcok(String prevBlcok) {
        this.prevBlcok = prevBlcok;
    }

    public String getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(String nextBlock) {
        this.nextBlock = nextBlock;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public Short getTxSize() {
        return txSize;
    }

    public void setTxSize(Short txSize) {
        this.txSize = txSize;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getTotal_input() {
        return total_input;
    }

    public void setTotal_input(Double total_input) {
        this.total_input = total_input;
    }

    public Double getTotal_output() {
        return total_output;
    }

    public void setTotal_output(Double total_output) {
        this.total_output = total_output;
    }

    public Double getFee_per_byte() {
        return fee_per_byte;
    }

    public void setFee_per_byte(Double fee_per_byte) {
        this.fee_per_byte = fee_per_byte;
    }

    public Double getFee_per_weight_unit() {
        return fee_per_weight_unit;
    }

    public void setFee_per_weight_unit(Double fee_per_weight_unit) {
        this.fee_per_weight_unit = fee_per_weight_unit;
    }

    public Double getEstimated() {
        return estimated;
    }

    public void setEstimated(Double estimated) {
        this.estimated = estimated;
    }
}
