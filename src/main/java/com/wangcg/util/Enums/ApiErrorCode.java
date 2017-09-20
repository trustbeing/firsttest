package com.wangcg.util.Enums;

public enum ApiErrorCode {
	UnAuthorize(401),
	NoPermission(402),
	UnRealNameCertification(2002),
	AccountNoFunds(2003);

	private int value = 0;

	ApiErrorCode(int value) {
		this.value = value;
	}


	public Integer value() {
		return this.value;
	}
}
