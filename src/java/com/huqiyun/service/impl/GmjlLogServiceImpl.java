package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.IGmjlLogDao;
import com.huqiyun.dto.GmjlLogDTO;
import com.huqiyun.service.IGmjlLogService;
/**
 * gmjl_log  
 * 购买基金日志表 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("gmjlLogService")
public class GmjlLogServiceImpl implements IGmjlLogService{

	@Autowired
	private IGmjlLogDao gmjlLogDao;

	@Override
	public int insert(GmjlLogDTO gmjlLog) throws SQLException {
		gmjlLog.setDeleteTag("1");
		return gmjlLogDao.insert(gmjlLog);
	}

	@Override
	public void update(GmjlLogDTO gmjlLog) throws SQLException {
		gmjlLogDao.update(gmjlLog);
	}

	@Override
	public void updateForce(GmjlLogDTO gmjlLog) throws SQLException {
		gmjlLogDao.updateForce(gmjlLog);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		gmjlLogDao.delete(id);
	}
	
	@Override
	public List<GmjlLogDTO> queryList(GmjlLogDTO gmjlLog) throws SQLException {
		return gmjlLogDao.queryList(gmjlLog);
	}

	@Override
	public int queryListCount(GmjlLogDTO gmjlLog) throws SQLException {
		return gmjlLogDao.queryListCount(gmjlLog);
	}

	@Override
	public GmjlLogDTO loadById(Integer id) throws SQLException {
		return gmjlLogDao.loadById(id);
	}
 	@Override
	public GmjlLogDTO queryListGetFirst(GmjlLogDTO gmjlLog)
			throws SQLException {
		 List<GmjlLogDTO> queryList = queryList(gmjlLog);
		 if(queryList==null||queryList.size()==0){
			 return new GmjlLogDTO();
		 }
		 return queryList.get(0);
	}
}
