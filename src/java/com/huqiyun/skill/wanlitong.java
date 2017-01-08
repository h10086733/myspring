package com.huqiyun.skill;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class wanlitong {
	 static DefaultHttpClient hc=new DefaultHttpClient();
	 static{
		 hc=(DefaultHttpClient) WebClientDevWrapper.wrapClient(hc);
//		 HttpHost proxy = new HttpHost("192.168.153.1", 80);
//		 hc.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
	 }
	 
	public static void main(String[] args) throws Exception {
		HashMap<String, String> params2 = new HashMap<String, String>();
		params2.put("j_username", "huqy123");
		params2.put("rt", new Date() + "");
		HttpGet httpget=new HttpGet("https://www.wanlitong.com/login.do?gURL=http://www.wanlitong.com/");
		hc.execute(httpget);
		httpget.abort();
		String str = httpPost("https://www.wanlitong.com/member/validateIp.do",
				params2);
		System.out.println(str);
		
		int randomNumber=0;
		for(int i=0;i<6;i++){
			randomNumber+=(int)(Math.random()*10);
		}
		String datetime=(System.currentTimeMillis()+randomNumber)+"";
		String cookieUrl="https://www.wanlitong.com/paic/common/vcode.do?timestamp="+datetime;
		HttpGet httpGet = new HttpGet(cookieUrl);
		System.out.println(cookieUrl);
		HttpResponse response = hc.execute(httpGet);
		FileOutputStream fos = new FileOutputStream(new File("D:\\wanlitong.jpg"));
		IOUtils.copy(response.getEntity().getContent(), fos);
		fos.flush();
		fos.close();
		httpGet.abort();
		
		
		Runtime.getRuntime().exec("mspaint D:\\wanlitong.jpg");
		System.out.println("-----------------send end-----------------");
		System.out.println("请输入验证码:");
		Scanner cin = new Scanner(System.in);
		String validCode = cin.next();
		cin.close();
		
		HashMap<String, String> params3 = new HashMap<String, String>();
		params3.put("gURL", "http://www.wanlitong.com/");
		params3.put("j_username", "huqy123");
		params3.put("j_password", "huqiyun690086");
		params3.put("validCode", validCode);
		params3.put("timestamp", datetime);
		
		str = httpPost("https://www.wanlitong.com/getLogin.do",params3);
		
//		System.out.println(str);
		List<Cookie> list = hc.getCookieStore().getCookies();
		System.out.println("-----------------send begin-----------------");
		String url2="";
		for (Cookie cookie : list) {
			System.out.println(cookie.getName() + "=" + cookie.getValue());
			if(cookie.getName().equals("jumpUrl")&&cookie.getValue().contains("loginSuccess")){
				url2=cookie.getValue();
			}
		}
		
		str = httpPost(url2,params3);
		
		String regex="<input type=\"hidden\" name=\"param\" id=\"param\" value=\"(.*?)\"/>";
		params3.put("param",fecth(str,regex,1));
		str = httpPost("https://www.wanlitong.com/newssologin",params3);
		System.out.println(str+"======");
		 httpget=new HttpGet("http://8.wanlitong.com/touzi");
		  response = hc.execute(httpget);
		   fos = new FileOutputStream(new File("D:\\wanlitong.html"));
			IOUtils.copy(response.getEntity().getContent(), fos);
			fos.flush();
			fos.close();
			httpGet.abort();
	}
	// 抓取首次匹配字符串
		public static String fecth(String xml, String regex, int group) {
			Pattern p = Pattern.compile(regex);
			String value = "";
			Matcher m = p.matcher(xml);
			if (m.find() && null != m.group(1)) {
				value = m.group(group);
			}
			return value.trim();
		}
	public static String httpPost(String url, HashMap<String, String> params2)
			throws Exception {
		String str = "";
		HttpPost hp = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params2 != null) {
			Iterator iter = params2.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String name = (String) entry.getKey();
				String value = (String) entry.getValue();
				nvps.add(new BasicNameValuePair(name, value));
			}
		}
		hp.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		
		hp.addHeader("content-type","application/json,*/*");
		HttpResponse response = hc.execute(hp);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			str = EntityUtils.toString(httpEntity);
		}
		hp.abort();
		return str;
	}
}
