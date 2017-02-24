package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.ICBankuaiValueDao;
import com.huqiyun.dto.CBankuaiValueDTO;
/**
 * c_bankuai_value  
 * 板块每日收盘价格 数据访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiValueDao")
public class CBankuaiValueDaoImpl extends BaseDaoImpl<CBankuaiValueDTO, java.lang.Integer> implements ICBankuaiValueDao {


	@Override
	public int insert(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.CBankuaiValueSql.insert, cBankuaiValue);
	}

	@Override
	public void update(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiValueSql.update, cBankuaiValue);
	}

	@Override
	public void updateForce(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiValueSql.updateForce, cBankuaiValue);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.CBankuaiValueSql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<CBankuaiValueDTO> queryList(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.CBankuaiValueSql.queryList, cBankuaiValue);
	}

	@Override
	public int queryListCount(CBankuaiValueDTO cBankuaiValue) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.CBankuaiValueSql.queryListCount, cBankuaiValue);
	}

	@Override
	public CBankuaiValueDTO loadById(Integer id) throws SQLException {
		return  (CBankuaiValueDTO)this.getSqlMapClientTemplate().queryForObject(SqlName.CBankuaiValueSql.loadById,id);
	}

	@Override
	public Class<CBankuaiValueDTO> getEntityClass() {
		return CBankuaiValueDTO.class;
	}
 	
}
