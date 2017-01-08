package com.huqiyun.skill.goupiao;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Qiangpiao {

	public static void main(String[] args) throws Exception {
		
		StringBuffer params=new StringBuffer();
		String xml="";
		//初始页面
//		params=new StringBuffer("_json_att=");
//		String initdc1="https://kyfw.12306.cn/otn/confirmPassenger/initDc";
//		HashMap<String, String> hm1=new HashMap<String, String>();
//		hm1.put("_json_att","");
//		xml=HttpDoPostUtils.getMethod(initdc1,hm1);
//		System.out.println(xml);
//		System.exit(0);
		
		//得到验证码
		String codeUrl = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand&"
				+ Math.random();
		HttpDoPostUtils.doGetFile(codeUrl, "D:/1.png");
		String code="";
		System.out.println("请输入验证码:");
		Scanner scanner = new Scanner(System.in);
		code = scanner.next();
		scanner.close();
		params.append("randCode="+code);
		params.append("&rand=sjrand");
		//异步验证验证码
		xml=HttpDoPostUtils.doRequestToString("https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn", HttpDoPostUtils.createNameValuePair(params.toString()),"");
		System.out.println("getCode="+xml);
		
		params=new StringBuffer();
		params.append("randCode="+code);
		params.append("&loginUserDTO.user_name=h10086733@163.com");
		params.append("&userDTO.password=huqiyun690086");
		//登陆12306
		xml=HttpDoPostUtils.doRequestToString("https://kyfw.12306.cn/otn/login/loginAysnSuggest", HttpDoPostUtils.createNameValuePair(params.toString()),"");
		System.out.println("getlogin:"+xml);

		//得到乘车信息
		String getT="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2014-10-06&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&purpose_codes=ADULT";
		xml=HttpDoPostUtils.getMethod(getT,null);
		System.out.println("getT:"+xml);
		JSONObject json=JSONObject.parseObject(xml);
		JSONArray jsonarray=JSONArray.parseArray(json.getString("data"));
		String secretStr="";
		//得到车次信息   
		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject result=jsonarray.getJSONObject(i);
			JSONObject queryLeftNewDTO=result.getJSONObject("queryLeftNewDTO");
			//得到车次
			String checi=queryLeftNewDTO.getString("station_train_code");
			//得到车次购买的加密码
			String jobj=result.getString("secretStr");
			if(!StringUtils.isBlank(jobj)){
				secretStr=jobj;
				System.out.println(queryLeftNewDTO);
				
				System.out.println(jobj);
				break;
			}
		}
		
		//提交订单前校验登陆
		String checkUser="https://kyfw.12306.cn/otn/login/checkUser";
		xml=HttpDoPostUtils.doRequestToString(checkUser,HttpDoPostUtils.createNameValuePair(params.toString()),"");
		System.out.println(xml);
		
		//预定车票
		String orderRequest="https://kyfw.12306.cn/otn/leftTicket/submitOrderRequest";
		//URLEncoder.encode(secretStr,"utf-8")
		params=new StringBuffer("secretStr="+URLDecoder.decode(secretStr,"utf-8")+"&train_date=2014-10-06&back_train_date=2014-09-22&tour_flag=dc&purpose_codes=ADULT&query_from_station_name=北京&query_to_station_name=上海&undefined");
		xml=HttpDoPostUtils.doRequestToString(orderRequest,HttpDoPostUtils.createNameValuePair(params.toString()),"Content-Length:424");
		System.out.println("orderRequest:"+xml);
		
		//初始页面
		params=new StringBuffer("_json_att=");
		String initdc="https://kyfw.12306.cn/otn/confirmPassenger/initDc";
//		xml=HttpDoPostUtils.doRequestToString(initdc, HttpDoPostUtils.createNameValuePair(params.toString()),"Content-Type:application/x-www-form-urlencoded,Content-Length:10,If-Modified-Since:0");
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("_json_att","");
		xml=HttpDoPostUtils.getMethod(initdc, hm);
		System.out.println(xml);
		
//		String randCodeUrl="https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=passenger&rand=randp";
//		HttpDoPostUtils.doGetFile(randCodeUrl, "D:/2.png");
//		System.out.println("请输入验证码:");
//		Scanner scanner1 = new Scanner(System.in);
//		code = scanner1.next();
//		scanner1.close();
//		
//		
//		String token="";
//		
//		String checkOrderInfo="https://kyfw.12306.cn/otn/confirmPassenger/checkOrderInfo";
//		params=new StringBuffer("cancel_flag=2&bed_level_order_num=000000000000000000000000000000&passengerTicketStr=&oldPassengerStr=&tour_flag=dc&randCode="+code+"&_json_att=&REPEAT_SUBMIT_TOKEN="+token);
//		xml=HttpDoPostUtils.doRequestToString(checkOrderInfo, HttpDoPostUtils.createNameValuePair(params.toString()), "Content-Length:313,Content-Type:application/x-www-form-urlencoded; charset=UTF-8");
//		System.out.println(xml);
		
	}

	/**
	 * 获取OldPassengerStr
	 * 
	 * @param userInfo
	 * @return
	 */
	public static String getOldPassengerStr(List<UserInfo> userInfo) {
		String oldStrs = "";
		for (int i = 0; i < userInfo.size(); i++) {
			String oldStr = userInfo.get(i).getName() + "," + userInfo.get(i).getCardType() + "," + userInfo.get(i).getCardID() + "," + userInfo.get(i).getType();
			oldStrs += oldStr + "_";
		}
		return oldStrs;
	}

	/**
	 * 获取PassengerTicketStr
	 * 
	 * @param userInfo
	 * @return
	 */
	public static String getPassengerTicketStr(List<UserInfo> userInfo) {
		String oldStrs = "";
		for (int i = 0; i < userInfo.size(); i++) {
			String oldStr = "";
			if ("WZ" == userInfo.get(i).getSeatType()) {
			} else {
				oldStr = userInfo.get(i).getSeatType();
			}
			String bR = oldStr + ",0," + userInfo.get(i).getTickType() + "," + userInfo.get(i).getName() + "," + userInfo.get(i).getCardType() + "," + userInfo.get(i).getCardID() + ","
					+ (userInfo.get(i).getPhone() == null ? "" : userInfo.get(i).getPhone()) + ",N";
			oldStrs += bR + "_";
		}
		return oldStrs.substring(0, oldStrs.length() - 1);
	}
	public static String fecthAll(String xml, String regex, int group) {
		Pattern p = Pattern.compile(regex);
		String value = "";
		Matcher m = p.matcher(xml);
		while (m.find() && null != m.group(1)) {
			value += ";" + m.group(group);
		}
		return value.trim();
	}

	public static String fecth(String xml, String regex, int group) {
		Pattern p = Pattern.compile(regex);
		String value = "";
		Matcher m = p.matcher(xml);
		if (m.find() && null != m.group(1)) {
			value = m.group(group);
		}
		return value.trim();
	}
}
