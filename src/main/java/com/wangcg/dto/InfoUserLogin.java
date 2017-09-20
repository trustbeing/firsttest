package com.wangcg.dto;

public class InfoUserLogin {
	private Long id;

	private String loginIp;

	public InfoUserLogin(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
}
