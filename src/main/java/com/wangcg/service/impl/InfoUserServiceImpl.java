package com.wangcg.service.impl;

import com.wangcg.dao.InfoUserMapper;
import com.wangcg.dto.InfoUser.InfoUserLogin;
import com.wangcg.dto.InfoUser.InfoUserUpdate;
import com.wangcg.model.InfoUser;
import com.wangcg.service.InfoUserService;
import com.wangcg.service.UserLogService;
import com.wangcg.util.Enums.UserLogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class InfoUserServiceImpl implements InfoUserService{

    @Autowired
    private InfoUserMapper infoUserMapper;

    @Autowired
    private UserLogService userLogService;

    public InfoUser selectByPrimaryKey(Long id) {
        return infoUserMapper.selectByPrimaryKey(id);
    }

    public int updateNickNameByPrimaryKey(InfoUserUpdate userUpdate) {
        InfoUser user = new InfoUser();
        user.setId(userUpdate.getId());
        user.setNickName(userUpdate.getNickName());
        return infoUserMapper.updateNickNameByPrimaryKey(user);
    }

    public InfoUser userLogin(InfoUserLogin user) {
        InfoUser model = infoUserMapper.selectByPrimaryKey(user.getId());

        return model;
    }

    @Transactional(propagation= Propagation.REQUIRED ,isolation= Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public String updateUserLogin(Long id, String loginIp) throws Exception  {
        InfoUser user = new InfoUser();
        user.setId(id);
        user.setRecentVisit(new Date());
        int count =  infoUserMapper.updateRecentVisitByPrimaryKey(user);
        if(count<=0) {
            throw new Exception("更新最近访问失败!");
        }

        String result = userLogService.Insert(id,"用户登录，ip："+loginIp, UserLogType.UserLogin.value(),id,"info_user");
        if(result.length()> 0) {
            throw new Exception(result);
        }

        return "";
    }
}
