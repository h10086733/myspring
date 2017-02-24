package com.huqiyun.service;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.GmjlLogDTO;
/**
 * gmjl_log  
 * 购买基金日志表 业务访问层接口
 * @author huqiyun
 *
 */
public interface IGmjlLogService {

 	public int insert(GmjlLogDTO gmjlLog) throws SQLException;
    
    public void update(GmjlLogDTO gmjlLog) throws SQLException;
   
    public void updateForce(GmjlLogDTO gmjlLog) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<GmjlLogDTO> queryList(GmjlLogDTO gmjlLog)throws SQLException;
    
    public int queryListCount(GmjlLogDTO gmjlLog) throws SQLException;
   
    public GmjlLogDTO loadById(Integer id) throws SQLException;
    
    public GmjlLogDTO queryListGetFirst(GmjlLogDTO gmjlLog)throws SQLException;
}
