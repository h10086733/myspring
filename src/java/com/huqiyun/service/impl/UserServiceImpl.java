package com.huqiyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huqiyun.dao.IUserDao;
import com.huqiyun.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public int queryCountUser() {
		return userDao.queryCountUser();
	}
	
}
