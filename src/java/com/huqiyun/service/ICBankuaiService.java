package com.huqiyun.service;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.CBankuaiDTO;
/**
 * c_bankuai  
 * 板块关联的股票 业务访问层接口
 * @author huqiyun
 *
 */
public interface ICBankuaiService {

 	public int insert(CBankuaiDTO cBankuai) throws SQLException;
    
    public void update(CBankuaiDTO cBankuai) throws SQLException;
   
    public void updateForce(CBankuaiDTO cBankuai) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<CBankuaiDTO> queryList(CBankuaiDTO cBankuai)throws SQLException;
    
    public int queryListCount(CBankuaiDTO cBankuai) throws SQLException;
   
    public CBankuaiDTO loadById(Integer id) throws SQLException;
    
    public CBankuaiDTO queryListGetFirst(CBankuaiDTO cBankuai)throws SQLException;

}
