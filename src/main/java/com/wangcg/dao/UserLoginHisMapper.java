package com.wangcg.dao;

import com.wangcg.model.UserLoginHis;

public interface UserLoginHisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLoginHis record);

    int insertSelective(UserLoginHis record);

    UserLoginHis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLoginHis record);

    int updateByPrimaryKey(UserLoginHis record);
}