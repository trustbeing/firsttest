package com.wangcg.model;

import java.math.BigDecimal;
import java.util.Date;

public class InfoOrderSim {
    private Long id;

    private Long userId;

    private Date startTime;

    private Date endTime;

    private BigDecimal userBuyPrice;

    private Date userBuyTime;

    private Double sysBuyPrice;

    private Date sysBuyTime;

    private Date sysSellTime;

    private Double sysSellPrice;

    private BigDecimal userSellPrice;

    private Date userSellTime;

    private BigDecimal buyTotalMoney;

    private BigDecimal sellTotalMoney;

    private BigDecimal tradeFee;

    private BigDecimal transferFee;

    private BigDecimal stampFee;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getUserBuyPrice() {
        return userBuyPrice;
    }

    public void setUserBuyPrice(BigDecimal userBuyPrice) {
        this.userBuyPrice = userBuyPrice;
    }

    public Date getUserBuyTime() {
        return userBuyTime;
    }

    public void setUserBuyTime(Date userBuyTime) {
        this.userBuyTime = userBuyTime;
    }

    public Double getSysBuyPrice() {
        return sysBuyPrice;
    }

    public void setSysBuyPrice(Double sysBuyPrice) {
        this.sysBuyPrice = sysBuyPrice;
    }

    public Date getSysBuyTime() {
        return sysBuyTime;
    }

    public void setSysBuyTime(Date sysBuyTime) {
        this.sysBuyTime = sysBuyTime;
    }

    public Date getSysSellTime() {
        return sysSellTime;
    }

    public void setSysSellTime(Date sysSellTime) {
        this.sysSellTime = sysSellTime;
    }

    public Double getSysSellPrice() {
        return sysSellPrice;
    }

    public void setSysSellPrice(Double sysSellPrice) {
        this.sysSellPrice = sysSellPrice;
    }

    public BigDecimal getUserSellPrice() {
        return userSellPrice;
    }

    public void setUserSellPrice(BigDecimal userSellPrice) {
        this.userSellPrice = userSellPrice;
    }

    public Date getUserSellTime() {
        return userSellTime;
    }

    public void setUserSellTime(Date userSellTime) {
        this.userSellTime = userSellTime;
    }

    public BigDecimal getBuyTotalMoney() {
        return buyTotalMoney;
    }

    public void setBuyTotalMoney(BigDecimal buyTotalMoney) {
        this.buyTotalMoney = buyTotalMoney;
    }

    public BigDecimal getSellTotalMoney() {
        return sellTotalMoney;
    }

    public void setSellTotalMoney(BigDecimal sellTotalMoney) {
        this.sellTotalMoney = sellTotalMoney;
    }

    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }

    public BigDecimal getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(BigDecimal transferFee) {
        this.transferFee = transferFee;
    }

    public BigDecimal getStampFee() {
        return stampFee;
    }

    public void setStampFee(BigDecimal stampFee) {
        this.stampFee = stampFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}