package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.ICdapanDao;
import com.huqiyun.dto.CdapanDTO;
import com.huqiyun.service.ICdapanService;
/**
 * cdapan  
 * 大盘数据 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cdapanService")
public class CdapanServiceImpl implements ICdapanService{

	@Autowired
	private ICdapanDao cdapanDao;

	@Override
	public int insert(CdapanDTO cdapan) throws SQLException {
		return cdapanDao.insert(cdapan);
	}

	@Override
	public void update(CdapanDTO cdapan) throws SQLException {
		cdapanDao.update(cdapan);
	}

	@Override
	public void updateForce(CdapanDTO cdapan) throws SQLException {
		cdapanDao.updateForce(cdapan);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		cdapanDao.delete(id);
	}
	
	@Override
	public List<CdapanDTO> queryList(CdapanDTO cdapan) throws SQLException {
		return cdapanDao.queryList(cdapan);
	}

	@Override
	public int queryListCount(CdapanDTO cdapan) throws SQLException {
		return cdapanDao.queryListCount(cdapan);
	}

	@Override
	public CdapanDTO loadById(Integer id) throws SQLException {
		return cdapanDao.loadById(id);
	}

	@Override
	public CdapanDTO queryListGetFirst(CdapanDTO cdapan) throws SQLException {
		List<CdapanDTO> d = queryList(cdapan);
		if(d.size()>0){
			return d.get(0);
		}
		return new CdapanDTO();
	}
 	
}
