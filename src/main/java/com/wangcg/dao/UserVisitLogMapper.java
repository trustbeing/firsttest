package com.wangcg.dao;

import com.wangcg.model.UserVisitLog;

public interface UserVisitLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserVisitLog record);

    int insertSelective(UserVisitLog record);

    UserVisitLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserVisitLog record);

    int updateByPrimaryKey(UserVisitLog record);
}