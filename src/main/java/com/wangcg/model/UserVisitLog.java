package com.wangcg.model;

import java.io.Serializable;
import java.util.Date;

public class UserVisitLog implements Serializable {
    private Long id;

    private Long userId;

    private String clientUserAgent;

    private String clientRefer;

    private String apiUrl;

    private String clientIp;

    private Date createTime;

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

    public String getClientUserAgent() {
        return clientUserAgent;
    }

    public void setClientUserAgent(String clientUserAgent) {
        this.clientUserAgent = clientUserAgent == null ? null : clientUserAgent.trim();
    }

    public String getClientRefer() {
        return clientRefer;
    }

    public void setClientRefer(String clientRefer) {
        this.clientRefer = clientRefer == null ? null : clientRefer.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}