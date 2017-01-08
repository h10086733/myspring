package com.huqiyun.service;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.CBankuaiXishuDTO;
/**
 * c_bankuai_xishu  
 * 板块系数 业务访问层接口
 * @author huqiyun
 *
 */
public interface ICBankuaiXishuService {

 	public int insert(CBankuaiXishuDTO cBankuaiXishu) throws SQLException;
    
    public void update(CBankuaiXishuDTO cBankuaiXishu) throws SQLException;
   
    public void updateForce(CBankuaiXishuDTO cBankuaiXishu) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<CBankuaiXishuDTO> queryList(CBankuaiXishuDTO cBankuaiXishu)throws SQLException;
    
    public int queryListCount(CBankuaiXishuDTO cBankuaiXishu) throws SQLException;
   
    public CBankuaiXishuDTO loadById(Integer id) throws SQLException;
}
