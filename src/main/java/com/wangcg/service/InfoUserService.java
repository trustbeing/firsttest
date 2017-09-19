package com.wangcg.service;

import com.wangcg.dto.InfoUser.InfoUserLogin;
import com.wangcg.dto.InfoUser.InfoUserUpdate;
import com.wangcg.model.InfoUser;


public interface InfoUserService {
    InfoUser selectByPrimaryKey(Long id);

    int updateNickNameByPrimaryKey(InfoUserUpdate model);

	InfoUser userLogin(InfoUserLogin user);

	String updateUserLogin(Long id,String loginIp) throws Exception;
}
