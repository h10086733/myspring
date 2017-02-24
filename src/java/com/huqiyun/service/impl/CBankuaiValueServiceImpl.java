package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.ICBankuaiValueDao;
import com.huqiyun.dto.CBankuaiValueDTO;
import com.huqiyun.service.ICBankuaiValueService;
/**
 * c_bankuai_value  
 * 板块每日收盘价格 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiValueService")
public class CBankuaiValueServiceImpl implements ICBankuaiValueService{

	@Autowired
	private ICBankuaiValueDao cBankuaiValueDao;

	@Override
	public int insert(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		cBankuaiValue.setDeleteTag("1");
		return cBankuaiValueDao.insert(cBankuaiValue);
	}

	@Override
	public void update(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		cBankuaiValueDao.update(cBankuaiValue);
	}

	@Override
	public void updateForce(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		cBankuaiValueDao.updateForce(cBankuaiValue);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		cBankuaiValueDao.delete(id);
	}
	
	@Override
	public List<CBankuaiValueDTO> queryList(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		return cBankuaiValueDao.queryList(cBankuaiValue);
	}

	@Override
	public int queryListCount(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		return cBankuaiValueDao.queryListCount(cBankuaiValue);
	}

	@Override
	public CBankuaiValueDTO loadById(Integer id) throws SQLException {
		return cBankuaiValueDao.loadById(id);
	}
 	@Override
	public CBankuaiValueDTO queryListGetFirst(CBankuaiValueDTO cBankuaiValue)
			throws SQLException {
		 List<CBankuaiValueDTO> queryList = queryList(cBankuaiValue);
		 if(queryList==null||queryList.size()==0){
			 return new CBankuaiValueDTO();
		 }
		 return queryList.get(0);
	}
}
