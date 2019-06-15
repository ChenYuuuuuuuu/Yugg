package io.chenyu.bitcoinexplorer0612.dto;

import java.util.Date;

public class BlockbyRelayedDTO {
    private Integer height;
    private Date time;
    private String hash;
    private Double size;


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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
