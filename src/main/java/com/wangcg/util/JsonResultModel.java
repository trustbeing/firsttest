package com.wangcg.util;

import com.wangcg.util.Enums.ApiErrorCode;

public class JsonResultModel<T> {

	private boolean success;
	private int errcode;
	private T data;
	private String msg;

	public JsonResultModel(){

	}

	public JsonResultModel(T data){
		this.data = data;
	}

	public static <T> JsonResultModel returnSuccess(T data) {
		JsonResultModel result = new JsonResultModel();
		result.data = data;
		result.setSuccess(true);
		return result;
	}


	public static <String> JsonResultModel returnStringResult(String data) {
		JsonResultModel result = new JsonResultModel(data);
		if(data==null ||data.equals("")){
			result.setSuccess(true);
		}else{
			result.setMsg((java.lang.String) data);
		}
		return result;
	}

	public static <T> JsonResultModel returnNoPermission(T data) {
		JsonResultModel result = new JsonResultModel();
		result.setErrcode(ApiErrorCode.NoPermission.value());
		return result;
	}

	public static <T> JsonResultModel returnAuthorizeFailure(T data) {
		JsonResultModel result = new JsonResultModel();
		result.setErrcode(ApiErrorCode.UnAuthorize.value());
		return result;
	}

	public static <T> JsonResultModel returnFailure(String msg,T data) {
		JsonResultModel result = new JsonResultModel();
		result.setMsg(msg);
		return result;
	}

	public static <T> JsonResultModel returnFailure(String msg,int errorcode,T data) {
		JsonResultModel result = new JsonResultModel();
		result.setErrcode(errorcode);
		result.setMsg(msg);
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
