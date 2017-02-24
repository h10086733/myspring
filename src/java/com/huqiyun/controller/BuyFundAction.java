package com.huqiyun.controller;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.huqiyun.dto.GmjlLogDTO;
import com.huqiyun.service.IGmjlLogService;
import com.huqiyun.task.Fetch;
import com.huqiyun.util.StringUtil;

@Controller
public class BuyFundAction {
	private Logger logger=LoggerFactory.getLogger(BuyFundAction.class);
	
	@Autowired
	IGmjlLogService gmjjLogService;
	
	@RequestMapping(value="/queryBuyFund",method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String dingshiGetPan(HttpServletRequest request,HttpServletResponse response){
		logger.info("come in: {}",System.currentTimeMillis());
		try {
			GmjlLogDTO gmjlLog=new GmjlLogDTO();
			gmjlLog.setDeleteTag("1");
			List<GmjlLogDTO> queryList = gmjjLogService.queryList(gmjlLog);
			for (GmjlLogDTO gmjlLogDTO : queryList) {
				//获取当前价格
				String s = Fetch.getJavaScriptPage("http://hq.sinajs.cn/list=sz"+gmjlLogDTO.getJjdm());
				if(s.split(",").length<3){
					continue;
				}
				double current=Double.parseDouble(s.split(",")[3]);
				gmjlLogDTO.setCurrentPrice(current+"");
			}
			return JSON.toJSONString(queryList);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	
	@RequestMapping(value="/insertBuy",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public ModelAndView insertBuy(HttpServletRequest request,HttpServletResponse response,GmjlLogDTO gmjlLog){
		logger.info("come in: {}",System.currentTimeMillis());
		try {
			gmjlLog.setDeleteTag("1");
			gmjlLog.setGmStatus("1");
			String bugDate = gmjlLog.getBugDate();
			String gmcb = gmjlLog.getGmcb();
			String jjdm = gmjlLog.getJjdm();
			String jjmc = gmjlLog.getJjmc();
			if(StringUtil.isNullOrEmptyStr(bugDate,gmcb,jjdm,jjmc)){
				return new ModelAndView("/success");
			}
			gmjjLogService.insert(gmjlLog);
			return new ModelAndView("/success");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new ModelAndView("/");
	}
	@RequestMapping(value="/updateBuy",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateBuy(HttpServletRequest request,HttpServletResponse response,GmjlLogDTO gmjlLog){
		logger.info("come in: {}",System.currentTimeMillis());
		try {
			Integer id = gmjlLog.getId();
			if(id==null){
				return "id不存在";
			}
			GmjlLogDTO o = gmjjLogService.loadById(id);
			if(StringUtils.isNotBlank(gmjlLog.getGmStatus())){
				o.setGmStatus(gmjlLog.getGmStatus());
			}
			if(StringUtils.isNotBlank(gmjlLog.getYldw())){
				o.setYldw(gmjlLog.getYldw());
			}
			if(StringUtils.isNotBlank(gmjlLog.getSaleDate())){
				o.setSaleDate(gmjlLog.getSaleDate());
			}
			gmjjLogService.update(o);
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
}
