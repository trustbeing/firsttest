package com.wangcg.dao;

import com.wangcg.model.InfoUser;

public interface InfoUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InfoUser record);

    int insertSelective(InfoUser record);

    InfoUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InfoUser record);

    int updateByPrimaryKey(InfoUser record);

    int updateNickNameByPrimaryKey(InfoUser record);

    int updateRecentVisitByPrimaryKey(InfoUser record);
}