package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.ICBankuaiDao;
import com.huqiyun.dto.CBankuaiDTO;
import com.huqiyun.service.ICBankuaiService;
/**
 * c_bankuai  
 * 板块关联的股票 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiService")
public class CBankuaiServiceImpl implements ICBankuaiService{

	@Autowired
	private ICBankuaiDao cBankuaiDao;

	@Override
	public int insert(CBankuaiDTO cBankuai) throws SQLException {
		return cBankuaiDao.insert(cBankuai);
	}

	@Override
	public void update(CBankuaiDTO cBankuai) throws SQLException {
		cBankuaiDao.update(cBankuai);
	}

	@Override
	public void updateForce(CBankuaiDTO cBankuai) throws SQLException {
		cBankuaiDao.updateForce(cBankuai);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		cBankuaiDao.delete(id);
	}
	
	@Override
	public List<CBankuaiDTO> queryList(CBankuaiDTO cBankuai) throws SQLException {
		return cBankuaiDao.queryList(cBankuai);
	}

	@Override
	public int queryListCount(CBankuaiDTO cBankuai) throws SQLException {
		return cBankuaiDao.queryListCount(cBankuai);
	}

	@Override
	public CBankuaiDTO loadById(Integer id) throws SQLException {
		return cBankuaiDao.loadById(id);
	}

	@Override
	public CBankuaiDTO queryListGetFirst(CBankuaiDTO cBankuai) throws SQLException {
		List<CBankuaiDTO> d=cBankuaiDao.queryList(cBankuai);
		if(d.size()>0){
			return d.get(0);
		}
		return new CBankuaiDTO();
	}
 	
}
