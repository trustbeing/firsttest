package com.wangcg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserDaily implements Serializable {
    private Long id;

    private Long userId;

    private Date dateTime;

    private BigDecimal accountMoney;

    private BigDecimal holdMoney;

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }

    public BigDecimal getHoldMoney() {
        return holdMoney;
    }

    public void setHoldMoney(BigDecimal holdMoney) {
        this.holdMoney = holdMoney;
    }
}