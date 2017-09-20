package com.wangcg.util.weixin;

import com.alibaba.fastjson.JSONObject;
import com.wangcg.util.HttpHelper;

public class WxxcxHelper {
	private static  final String appId="wx8c08505b66cb1dde";
	private static  final String appSecret ="7aa476eac66112c25dd43a44f927e98f";
	public static WxxcxSession getAccessToken(String code){

		WxxcxSession result = null;

		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replaceAll("JSCODE", code);
		JSONObject jsonObject = HttpHelper.httpsRequest(requestUrl, "GET", null);
		try{
			String openid = jsonObject.getString("openid");
			if(openid!=null && openid.length()>0) {
				result = new WxxcxSession();
				result.setOpenid(openid);
				result.setErrmsg(jsonObject.getString("errmsg"));
				result.setSession_key(jsonObject.getString("session_key"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String a=org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
		}
		return result;
	}
}
