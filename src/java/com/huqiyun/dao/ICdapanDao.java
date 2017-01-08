package com.huqiyun.dao;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.CdapanDTO;
/**
 * cdapan  
 * 大盘数据 数据访问层接口
 * @author huqiyun	
 *
 */
public interface ICdapanDao extends IBaseDao<CdapanDTO, Integer> {

 	public int insert(CdapanDTO cdapan) throws SQLException;
    
    public void update(CdapanDTO cdapan) throws SQLException;
   
    public void updateForce(CdapanDTO cdapan) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<CdapanDTO> queryList(CdapanDTO cdapan)throws SQLException;
    
    public int queryListCount(CdapanDTO cdapan) throws SQLException;
   
    public CdapanDTO loadById(Integer id) throws SQLException;
}
