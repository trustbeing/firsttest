package com.wangcg.util.filter;

import com.wangcg.util.Auth.TokenManager;
import com.wangcg.util.Auth.TokenModel;
import com.wangcg.util.Constants;
import com.wangcg.util.annotation.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenManager manager;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		//如果验证token失败，并且方法注明了Authorization，返回401错误
		if (method.getAnnotation(Authorization.class) != null) {

			//从header中得到token
			String authorization = request.getHeader(Constants.AUTHORIZATION);
			//验证token
			TokenModel model = manager.getToken(authorization);
			if (manager.checkToken(model)) {
				//如果token验证成功，将token对应的用户id存在request中，便于之后注入
				request.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
				return true;
			}

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}




		return true;
	}
}
