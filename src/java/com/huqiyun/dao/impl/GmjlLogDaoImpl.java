package com.huqiyun.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huqiyun.com.SqlName;
import com.huqiyun.dao.IGmjlLogDao;
import com.huqiyun.dto.GmjlLogDTO;
/**
 * gmjl_log  
 * 购买基金日志表 数据访问层实现类
 * @author huqiyun
 *
 */
 
@Repository("gmjlLogDao")
public class GmjlLogDaoImpl extends BaseDaoImpl<GmjlLogDTO, java.lang.Integer> implements IGmjlLogDao {


	@Override
	public int insert(GmjlLogDTO gmjlLog) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.insert(SqlName.GmjlLogSql.insert, gmjlLog);
	}

	@Override
	public void update(GmjlLogDTO gmjlLog) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.GmjlLogSql.update, gmjlLog);
	}

	@Override
	public void updateForce(GmjlLogDTO gmjlLog) throws SQLException {
		this.sqlMapClientTemplate.update(SqlName.GmjlLogSql.updateForce, gmjlLog);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		this.sqlMapClientTemplate.delete(SqlName.GmjlLogSql.delete,id);
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<GmjlLogDTO> queryList(GmjlLogDTO gmjlLog) throws SQLException {
		return this.sqlMapClientTemplate.queryForList(SqlName.GmjlLogSql.queryList, gmjlLog);
	}

	@Override
	public int queryListCount(GmjlLogDTO gmjlLog) throws SQLException {
		return (Integer) this.sqlMapClientTemplate.queryForObject(SqlName.GmjlLogSql.queryListCount, gmjlLog);
	}

	@Override
	public GmjlLogDTO loadById(Integer id) throws SQLException {
		return  (GmjlLogDTO)this.getSqlMapClientTemplate().queryForObject(SqlName.GmjlLogSql.loadById,id);
	}

	@Override
	public Class<GmjlLogDTO> getEntityClass() {
		return GmjlLogDTO.class;
	}
 	
}
