package com.wangcg.service;

public interface UserLogService {

	String Insert(Long userId,String content,Integer type,Long refId,String refTable);
}
