package com.wangcg.dao;

import com.wangcg.model.InfoOrderSim;

public interface InfoOrderSimMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InfoOrderSim record);

    int insertSelective(InfoOrderSim record);

    InfoOrderSim selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InfoOrderSim record);

    int updateByPrimaryKey(InfoOrderSim record);
}