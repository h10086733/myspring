package com.huqiyun.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.alibaba.fastjson.JSON;
import com.huqiyun.com.CommonEnum;
import com.huqiyun.task.FetchJl;

@Controller
public class TestAction {
	private Logger logger=LoggerFactory.getLogger(TestAction.class);
	
	@Autowired
	FetchJl fetch;
	//定时更新20日数据   暂时放弃
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
	//定时更新20日数据  代替上方法
//	@RequestMapping(value="/getFirstDpan",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getFirstDpan(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		System.out.println(request.getParameter("id"));
		try {
			fetch.getFirstDpan();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	//获取所有行业系数  保存入数据库
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
	//获取单行业当前系数
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
	//获取全部行业当前系数   展示  不入库    15分钟
	@RequestMapping(value="/dingshiGetAllXs",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiGetAllXs(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		Map<String, String> hm = CommonEnum.hm;
		String result="";
		for (Entry<String, String> set : hm.entrySet()) {
			String key = set.getKey();
			try {
				result+=CommonEnum.hmName.get(key)+":"+fetch.fetchCurrentXs(key)+"\n";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	//保存行业指数的收盘价
	@RequestMapping(value="/hangyeshoupanjiaRestful",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String hangyeshoupanjiaRestful(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		fetch.hangyeshoupanjia();
		return "Ok";
		
	}
	//查询行业所有的个股  涨跌幅
	@RequestMapping(value="/hyggzdf",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String hyggzdf(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		String hy=request.getParameter("type");
		if(StringUtils.isBlank(hy)){
			return "type数据为空";
		}
		Map<String, String> hm = CommonEnum.hm;
		String[] st = hm.get(hy).split(",");
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < st.length; i++) {
			String g=st[i];
			g = FetchJl.getHead(g);
			//判断是否停牌了!!!!!!!
			String s = FetchJl.getJavaScriptPage("http://hq.sinajs.cn/list="+g);
			if(s.split(",").length<3){
				System.out.println(g+"没有获取到数据.股票:"+s);
			}else{
				Map<String,Object> m=new HashMap<String, Object>();
				m.put("gpname", s.split(",")[0].substring(s.indexOf("\"")+1));
				//昨日价格
				m.put("oldPrice", s.split(",")[2]);
				//当前价格
				m.put("c", s.split(",")[3]);
				if(s.split(",")[3].equals("0.000")){//停牌
					continue;
				}
				list.add(m);
			}
		}
		return JSON.toJSONString(list);
	}
}
