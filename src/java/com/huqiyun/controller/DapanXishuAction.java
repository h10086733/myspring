package com.huqiyun.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.huqiyun.com.CommonEnum;
import com.huqiyun.dto.CBankuaiXishuDTO;
import com.huqiyun.service.ICBankuaiXishuService;

@Controller
public class DapanXishuAction {
	@Autowired
	private ICBankuaiXishuService cBankuaiXishuService;
	
	//查询最新系数的三日均值
	@RequestMapping(value="/getBkXs",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getBkXs(HttpServletRequest request,HttpServletResponse response){
		try {
			Map<String, String> hmName = CommonEnum.hmName;
			Map<String,String> hm=new HashMap<String, String>();
			for(Entry<String, String> entry:hmName.entrySet()){
				CBankuaiXishuDTO cBankuaiXishu=new CBankuaiXishuDTO();
				cBankuaiXishu.setPageNo(1);
				cBankuaiXishu.setPageSize(3);
				cBankuaiXishu.setBankuaiDaima(entry.getKey());
				List<CBankuaiXishuDTO> queryList = cBankuaiXishuService.queryList(cBankuaiXishu);
				int xs=0;
				for (CBankuaiXishuDTO cBankuaiXishuDTO : queryList) {
					xs+=cBankuaiXishuDTO.getCValue();
				}
				int sumXs=xs/queryList.size();
				hm.put(entry.getValue(),sumXs+"");
			}
			return JSON.toJSONString(hm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
