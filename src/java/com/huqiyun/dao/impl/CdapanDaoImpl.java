package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.ICdapanDao;
import com.huqiyun.dto.CdapanDTO;
/**
 * cdapan  
 * 大盘数据 数据访问层实现类
 * @author lisu
 *
 */
 
@Repository("cdapanDao")
public class CdapanDaoImpl extends BaseDaoImpl<CdapanDTO, java.lang.Integer> implements ICdapanDao {


	@Override
	public int insert(CdapanDTO cdapan) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.CdapanSql.insert, cdapan);
	}

	@Override
	public void update(CdapanDTO cdapan) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CdapanSql.update, cdapan);
	}

	@Override
	public void updateForce(CdapanDTO cdapan) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.CdapanSql.updateForce, cdapan);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.CdapanSql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<CdapanDTO> queryList(CdapanDTO cdapan) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.CdapanSql.queryList, cdapan);
	}

	@Override
	public int queryListCount(CdapanDTO cdapan) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.CdapanSql.queryListCount, cdapan);
	}

	@Override
	public CdapanDTO loadById(Integer id) throws SQLException {
		return  (CdapanDTO)this.getSqlMapClientTemplate().queryForObject(SqlName.CdapanSql.loadById,id);
	}

	@Override
	public Class<CdapanDTO> getEntityClass() {
		return CdapanDTO.class;
	}
 	
}
