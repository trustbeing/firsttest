package com.wangcg.util.Auth;

import com.wangcg.util.redis.RedisCache;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RedisTokenManager implements TokenManager {

	public TokenModel createToken(long userId) {
		String token = UUID.randomUUID().toString().replace("-", "");
		TokenModel model = new TokenModel(userId, token);

		RedisCache.putObject(userId,token);

		return model;
	}

	public boolean checkToken(TokenModel model) {
		if (model == null) {
			return false;
		}
		Object token = RedisCache.getObject(model.getUserId());
		if (token == null || !(token instanceof String)||!((String)token).equals(model.getToken())) {
			return false;
		}
		//如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		//redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	public TokenModel getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		//使用userId和源token简单拼接成的token，可以增加加密措施
		long userId = Long.parseLong(param[0]);
		String token = param[1];
		return new TokenModel(userId, token);
	}

	public void deleteToken(long userId) {
		RedisCache.removeObject(userId);
	}
}
