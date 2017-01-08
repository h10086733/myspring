package com.huqiyun.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huqiyun.dao.ICBankuaiXishuDao;
import com.huqiyun.dto.CBankuaiXishuDTO;
import com.huqiyun.service.ICBankuaiXishuService;
/**
 * c_bankuai_xishu  
 * 板块系数 业务访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiXishuService")
public class CBankuaiXishuServiceImpl implements ICBankuaiXishuService{

	@Autowired
	private ICBankuaiXishuDao cBankuaiXishuDao;

	@Override
	public int insert(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return cBankuaiXishuDao.insert(cBankuaiXishu);
	}

	@Override
	public void update(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		cBankuaiXishuDao.update(cBankuaiXishu);
	}

	@Override
	public void updateForce(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		cBankuaiXishuDao.updateForce(cBankuaiXishu);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		cBankuaiXishuDao.delete(id);
	}
	
	@Override
	public List<CBankuaiXishuDTO> queryList(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return cBankuaiXishuDao.queryList(cBankuaiXishu);
	}

	@Override
	public int queryListCount(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return cBankuaiXishuDao.queryListCount(cBankuaiXishu);
	}

	@Override
	public CBankuaiXishuDTO loadById(Integer id) throws SQLException {
		return cBankuaiXishuDao.loadById(id);
	}
 	
}
