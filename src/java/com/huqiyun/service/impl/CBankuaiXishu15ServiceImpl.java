package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.ICBankuaiXishu15Dao;
import com.huqiyun.dto.CBankuaiXishu15DTO;
import com.huqiyun.service.ICBankuaiXishu15Service;
/**
 * c_bankuai_xishu_15  
 * 15分钟系数 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiXishu15Service")
public class CBankuaiXishu15ServiceImpl implements ICBankuaiXishu15Service{

	@Autowired
	private ICBankuaiXishu15Dao cBankuaiXishu15Dao;

	@Override
	public int insert(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		cBankuaiXishu15.setDeleteTag("1");
		return cBankuaiXishu15Dao.insert(cBankuaiXishu15);
	}

	@Override
	public void update(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		cBankuaiXishu15Dao.update(cBankuaiXishu15);
	}

	@Override
	public void updateForce(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		cBankuaiXishu15Dao.updateForce(cBankuaiXishu15);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		cBankuaiXishu15Dao.delete(id);
	}
	
	@Override
	public List<CBankuaiXishu15DTO> queryList(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		return cBankuaiXishu15Dao.queryList(cBankuaiXishu15);
	}

	@Override
	public int queryListCount(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		return cBankuaiXishu15Dao.queryListCount(cBankuaiXishu15);
	}

	@Override
	public CBankuaiXishu15DTO loadById(Integer id) throws SQLException {
		return cBankuaiXishu15Dao.loadById(id);
	}
 	@Override
	public CBankuaiXishu15DTO queryListGetFirst(CBankuaiXishu15DTO cBankuaiXishu15)
			throws SQLException {
		 List<CBankuaiXishu15DTO> queryList = queryList(cBankuaiXishu15);
		 if(queryList==null||queryList.size()==0){
			 return new CBankuaiXishu15DTO();
		 }
		 return queryList.get(0);
	}
}
