package com.huqiyun.dao;


import java.sql.SQLException;
import java.util.List;

import com.huqiyun.dto.CBankuaiXishu15DTO;
/**
 * c_bankuai_xishu_15  
 * 15分钟系数 数据访问层接口
 * @author huqiyun
 *
 */
public interface ICBankuaiXishu15Dao extends IBaseDao<CBankuaiXishu15DTO, Integer> {

 	public int insert(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException;
    
    public void update(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException;
   
    public void updateForce(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException;
   
    public void delete(Integer id) throws SQLException;
	
    public List<CBankuaiXishu15DTO> queryList(CBankuaiXishu15DTO cBankuaiXishu15)throws SQLException;
    
    public int queryListCount(CBankuaiXishu15DTO cBankuaiXishu15) throws SQLException;
   
    public CBankuaiXishu15DTO loadById(Integer id) throws SQLException;
}
