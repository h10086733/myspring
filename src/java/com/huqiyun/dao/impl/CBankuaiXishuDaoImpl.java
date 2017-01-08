package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.ICBankuaiXishuDao;
import com.huqiyun.dto.CBankuaiXishuDTO;
/**
 * c_bankuai_xishu  
 * 板块系数 数据访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("cBankuaiXishuDao")
public class CBankuaiXishuDaoImpl extends BaseDaoImpl<CBankuaiXishuDTO, java.lang.Integer> implements ICBankuaiXishuDao {


	@Override
	public int insert(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.CBankuaiXishuSql.insert, cBankuaiXishu);
	}

	@Override
	public void update(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiXishuSql.update, cBankuaiXishu);
	}

	@Override
	public void updateForce(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiXishuSql.updateForce, cBankuaiXishu);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.CBankuaiXishuSql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<CBankuaiXishuDTO> queryList(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.CBankuaiXishuSql.queryList, cBankuaiXishu);
	}

	@Override
	public int queryListCount(CBankuaiXishuDTO cBankuaiXishu) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.CBankuaiXishuSql.queryListCount, cBankuaiXishu);
	}

	@Override
	public CBankuaiXishuDTO loadById(Integer id) throws SQLException {
		return  (CBankuaiXishuDTO)this.getSqlMapClientTemplate().queryForObject(SqlName.CBankuaiXishuSql.loadById,id);
	}

	@Override
	public Class<CBankuaiXishuDTO> getEntityClass() {
		return CBankuaiXishuDTO.class;
	}
 	
}
