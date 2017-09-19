package com.wangcg.dao;

import com.wangcg.model.UserDaily;

public interface UserDailyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDaily record);

    int insertSelective(UserDaily record);

    UserDaily selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDaily record);

    int updateByPrimaryKey(UserDaily record);
}