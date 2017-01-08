package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.ICBankuaiDao;
import com.huqiyun.dto.CBankuaiDTO;
/**
 * c_bankuai  
 * 板块关联的股票 数据访问层实现类
 * @author lisu
 *
 */
 
@Repository("cBankuaiDao")
public class CBankuaiDaoImpl extends BaseDaoImpl<CBankuaiDTO, java.lang.Integer> implements ICBankuaiDao {


	@Override
	public int insert(CBankuaiDTO cBankuai) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.CBankuaiSql.insert, cBankuai);
	}

	@Override
	public void update(CBankuaiDTO cBankuai) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiSql.update, cBankuai);
	}

	@Override
	public void updateForce(CBankuaiDTO cBankuai) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CBankuaiSql.updateForce, cBankuai);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.CBankuaiSql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<CBankuaiDTO> queryList(CBankuaiDTO cBankuai) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.CBankuaiSql.queryList, cBankuai);
	}

	@Override
	public int queryListCount(CBankuaiDTO cBankuai) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.CBankuaiSql.queryListCount, cBankuai);
	}

	@Override
	public CBankuaiDTO loadById(Integer id) throws SQLException {
		return  (CBankuaiDTO)this.getSqlMapClientTemplate().queryForObject(SqlName.CBankuaiSql.loadById,id);
	}

	@Override
	public Class<CBankuaiDTO> getEntityClass() {
		return CBankuaiDTO.class;
	}
 	
}
