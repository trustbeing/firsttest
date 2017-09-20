package com.wangcg.dto;

public class InfoUserUpdate {
	private Long id;

	private String nickName;

	public InfoUserUpdate(Long id, String nickName) {
		this.id = id;
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
