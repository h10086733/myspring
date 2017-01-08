package com.huqiyun.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.IUserDao;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Integer, Integer> implements IUserDao{
	
	public int queryCountUser(){
		return (int) this.getSqlMapClientTemplate().queryForObject("TB_USER.queryCountUser");
	}

	@Override
	public Class getEntityClass() {
		return UserDaoImpl.class;
	}
}
