package com.wangcg.controller;

import com.wangcg.dto.LoginCode;
import com.wangcg.model.InfoUser;
import com.wangcg.service.InfoUserService;
import com.wangcg.util.Auth.RedisTokenManager;
import com.wangcg.util.Auth.TokenModel;
import com.wangcg.util.JsonResultModel;
import com.wangcg.util.weixin.WxxcxHelper;
import com.wangcg.util.weixin.WxxcxSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxxcx")
public class WxxcxController {

	@Autowired
	private InfoUserService infoUserService;

	@Autowired
	private RedisTokenManager redisTokenManager;

	@RequestMapping(value={"/loginbywxcode"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public JsonResultModel<String> loginByWxCode(LoginCode code){

		WxxcxSession session = WxxcxHelper.getAccessToken(code.getCode());
		if(session==null){
			return JsonResultModel.returnNoPermission("");
		}

		String openid = session.getOpenid();
		try {
			InfoUser user =infoUserService.queryOrCreateByOpenid(openid);
			if(user!=null &&user.getId()>0){
				TokenModel token = redisTokenManager.createToken(user.getId());
				if(token!=null){
					return JsonResultModel.returnSuccess(token.getAuthToken());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonResultModel.returnAuthorizeFailure("");

	}
}
