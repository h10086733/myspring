package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.ICBankuaiXishu15Dao;
import com.huqiyun.dto.CBankuaiXishu15DTO;
/**
 * c_bankuai_xishu_15  
 * 15分钟系数 数据访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiXishu15Dao")
public class CBankuaiXishu15DaoImpl extends BaseDaoImpl<CBankuaiXishu15DTO, java.lang.Integer> implements ICBankuaiXishu15Dao {


	@Override
	public int insert(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.CBankuaiXishu15Sql.insert, cBankuaiXishu15);
	}

	@Override
	public void update(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiXishu15Sql.update, cBankuaiXishu15);
	}

	@Override
	public void updateForce(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiXishu15Sql.updateForce, cBankuaiXishu15);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.CBankuaiXishu15Sql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<CBankuaiXishu15DTO> queryList(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.CBankuaiXishu15Sql.queryList, cBankuaiXishu15);
	}

	@Override
	public int queryListCount(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.CBankuaiXishu15Sql.queryListCount, cBankuaiXishu15);
	}

	@Override
	public CBankuaiXishu15DTO loadById(Integer id) throws SQLException {
		return  (CBankuaiXishu15DTO)this.getSqlMapClientTemplate().queryForObject(SqlName.CBankuaiXishu15Sql.loadById,id);
	}

	@Override
	public Class<CBankuaiXishu15DTO> getEntityClass() {
		return CBankuaiXishu15DTO.class;
	}
 	
}
