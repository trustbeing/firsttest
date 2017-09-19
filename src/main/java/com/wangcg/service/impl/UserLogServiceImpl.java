package com.wangcg.service.impl;

import com.wangcg.dao.UserLogMapper;
import com.wangcg.model.UserLog;
import com.wangcg.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserLogServiceImpl implements UserLogService {

	@Autowired
	private UserLogMapper userLogMapper;

	@Transactional(propagation= Propagation.SUPPORTS)
	public String Insert(Long userId, String content, Integer type, Long refId, String refTable) {

		UserLog userLog = new UserLog();
		userLog.setRefId(refId);
		userLog.setUserId(userId);
		userLog.setContent(content);
		userLog.setType(type);
		userLog.setRefTable(refTable);
		int count = userLogMapper.insert(userLog);
		if(count<=0){
			return "添加用户访问记录失败";
		}
		return "";

	}
}
