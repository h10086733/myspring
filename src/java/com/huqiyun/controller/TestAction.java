package com.huqiyun.controller;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huqiyun.com.CommonEnum;
import com.huqiyun.task.FetchJl;

@Controller
public class TestAction {
	private Logger logger=LoggerFactory.getLogger(TestAction.class);
	
	@Autowired
	FetchJl fetch;
	
	@RequestMapping(value="/test",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiGetPan(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		System.out.println(request.getParameter("id"));
		try {
			fetch.dingshitime();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	@RequestMapping(value="/dingshiFetchAllXs",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiFetchAllXs(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		try {
			fetch.dingshiFetchAllXs();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	@RequestMapping(value="/dingshiGetXs",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiGetXs(HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("type");
		logger.info("come in: {},{}",System.currentTimeMillis(),type);
		if(StringUtils.isBlank(type)){
			return "类型不能为空";
		}
		try {
			String current=fetch.fetchCurrentXs(type);
			return current;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "!!!!!!!!!!!!!!!!!!!!!!!";
		
	}
	
	@RequestMapping(value="/dingshiGetAllXs",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiGetAllXs(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		Map<String, String> hm = CommonEnum.hm;
		String result="";
		for (Entry<String, String> set : hm.entrySet()) {
			String key = set.getKey();
			try {
				result+=key+":"+fetch.fetchCurrentXs(key)+"\n";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
}
