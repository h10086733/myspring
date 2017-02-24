package com.huqiyun.service;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.CBankuaiValueDTO;
/**
 * c_bankuai_value  
 * 板块每日收盘价格 业务访问层接口
 * @author huqiyun
 *
 */
public interface ICBankuaiValueService {

 	public int insert(CBankuaiValueDTO cBankuaiValue) throws SQLException;
    
    public void update(CBankuaiValueDTO cBankuaiValue) throws SQLException;
   
    public void updateForce(CBankuaiValueDTO cBankuaiValue) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<CBankuaiValueDTO> queryList(CBankuaiValueDTO cBankuaiValue)throws SQLException;
    
    public int queryListCount(CBankuaiValueDTO cBankuaiValue) throws SQLException;
   
    public CBankuaiValueDTO loadById(Integer id) throws SQLException;
    
    public CBankuaiValueDTO queryListGetFirst(CBankuaiValueDTO cBankuaiValue)throws SQLException;
}
