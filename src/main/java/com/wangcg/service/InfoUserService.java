package com.wangcg.service;

import com.wangcg.model.InfoUser;


public interface InfoUserService {
    InfoUser selectByPrimaryKey(Long id);

    int updateNickNameByPrimaryKey(Long id,String nickName);

	InfoUser userLogin(Long id);

	String updateUserLogin(Long id,String loginIp) throws Exception;

	InfoUser queryOrCreateByOpenid(String openid) throws Exception;
}
