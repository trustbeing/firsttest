package com.wangcg.util.Enums;

public enum UserLogType {
	Unknown(0),
	UserLogin(1),
	UserLogOut(2),
	UserStockBuy(3),
	UserStockSell(4),
	UserFutureBuy(5),
	UserFutureSell(6);

	private int value = 0;

	UserLogType(int value) {
		this.value = value;
	}


	public Integer value() {
		return this.value;
	}
}
