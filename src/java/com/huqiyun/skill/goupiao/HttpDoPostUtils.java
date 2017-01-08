package com.huqiyun.skill.goupiao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * HttpDoPostUtils.java Create on 2012-9-7下午3:08:18
 * 
 * 
 * Copyright (c) 2012 by MTA.
 * 
 * @author lmeteor
 * @Email txin0814@sina.com
 * @description 模拟HTTP发送请求得到报文
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class HttpDoPostUtils
{

    
    private static HttpClient httpClient = null;
    static
    {
        //指定协议名称和默认的端口号
        Protocol myhttps = new Protocol("https", new MySecureProtocolSocketFactory(), 443);
        //注册刚才创建的https 协议对象
        Protocol.registerProtocol("https", myhttps); 
        httpClient = new HttpClient();
        httpClient.getParams().setParameter(HttpClientParams.USE_EXPECT_CONTINUE, Boolean.FALSE);
    }
    
    /**
     * 发送请求报文，得到响应报文
     * @param url
     *             登录请求URL
     * @param pList
     *             是否包含请求参数
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String doRequestToString(String url,List<NameValuePair> pList,String contentLength) throws UnsupportedEncodingException
    {
        //获得postMethod对象
        PostMethod pmethod = getPostMethod(url);
        if(!StringUtils.isBlank(contentLength)){
        	String[] content=contentLength.split(",");
        	for (int i = 0; i < content.length; i++) {
        		pmethod.addRequestHeader(content[i].split(":")[0],content[i].split(":")[1]);
			}
        }
        pmethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        //判断是否包含参数
        if(null != pList && pList.size() > 0)
        {
            pmethod.setRequestBody(pList.toArray(new NameValuePair[pList.size()]));
        }
        String value = "";
        try
        {
            httpClient.executeMethod(pmethod);
            try {
				decompress(pmethod.getResponseBodyAsStream(),new FileOutputStream(new File("D:/1.txt")));
			} catch (Exception e) {
				System.out.println("没有压缩!");
			}
            value = pmethod.getResponseBodyAsString();
        }
        catch ( HttpException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        
        return value;
    }
    
    /**
     * 获得12306网站的登录验证码
     * @param url
     *             请求URL
     * @param filePath
     *             验证码保存路径 如:e:\\login.jpg
     * @return
     */
    public static File doGetFile(String url,String filePath)
    {
        PostMethod pmethod = getPostMethod(url);
        pmethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        try
        {
            httpClient.executeMethod(pmethod);
            System.out.println(pmethod.getStatusCode());
            //得到响应中的流对象
            InputStream in = pmethod.getResponseBodyAsStream();
            //包装 并读出流信息
//            BufferedInputStream bis = new BufferedInputStream(in);
            File file = new File(filePath);
            FileOutputStream fs = new FileOutputStream(file);
            IOUtils.copy(in, fs);
            fs.flush();
            fs.close();
            return file;
        }
        catch (HttpException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
        
    }
    public static List<NameValuePair> createNameValuePair(String params) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (null != params && !params.trim().equals("")) {
        	System.out.println(params.toString());
            String[] _params = params.split("&");
            // userCookieList = new AttributeList();
            for (int i = 0; i < _params.length; i++) {
                int _i = _params[i].indexOf("=");
                if (_i != -1) {
                    String name = _params[i].substring(0, _i);
                    String value = _params[i].substring(_i + 1);
                    nvps.add(new NameValuePair(name, value));
                }
            }
        }
        return nvps;
    }
    
    
    public static PostMethod getPostMethod(String url)
    {
        PostMethod pmethod = new PostMethod(url);
        //设置响应头信息
        pmethod.addRequestHeader("Connection", "keep-alive");
        pmethod.addRequestHeader("Cache-Control", "max-age=0");
        pmethod.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        pmethod.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        pmethod.addRequestHeader("Referer","https://kyfw.12306.cn/otn/login/init");
		pmethod.addRequestHeader("X-Requested-With","XMLHttpRequest");
		pmethod.addRequestHeader("Host","kyfw.12306.cn");
		pmethod.addRequestHeader("Origin","https://kyfw.12306.cn");
		pmethod.addRequestHeader("Referer","https://kyfw.12306.cn/otn/leftTicket/init");
		pmethod.addRequestHeader("Accept-Encoding","gzip,deflate,sdch");
		pmethod.addRequestHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6");
		pmethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
		
		 StringBuffer sb=new StringBuffer();
			Cookie[] cookies=httpClient.getState().getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("JSESSIONID")){
					sb.append("; JSESSIONID="+cookies[i].getValue());
				}
				if(cookies[i].getName().equals("BIGipServerotn")){
					sb.append("; BIGipServerportal="+cookies[i].getValue());
				}
			}
			if(!StringUtils.isBlank(sb.toString())){
				String cookie=sb.substring(1)+"; _jc_save_fromStation=%u5317%u4EAC%2CBJP; _jc_save_toStation=%u4E0A%u6D77%2CSHH; _jc_save_fromDate=2014-10-06; _jc_save_toDate=2014-09-23; _jc_save_wfdc_flag=dc";
				System.out.println(cookie);
				pmethod.setRequestHeader("Cookie",cookie);
			}
			
		return pmethod;
    }
    public static GetMethod getGetMethod(String url)
    {
    	GetMethod getmethod = new GetMethod(url);
        //设置响应头信息
    	getmethod.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		getmethod.addRequestHeader("Referer","https://kyfw.12306.cn/otn/login/init");
		getmethod.addRequestHeader("Host","kyfw.12306.cn");
		getmethod.addRequestHeader("Accept-Encoding","gzip, deflate");
		getmethod.addRequestHeader("Accept-Language","zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
		getmethod.addRequestHeader("Cache-Control","max-age=0");
		getmethod.addRequestHeader("Connection","keep-alive");
		getmethod.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		getmethod.addRequestHeader("Origin", "https://kyfw.12306.cn");
		getmethod.addRequestHeader("Referer", "https://kyfw.12306.cn/otn/login/init");
		getmethod.addRequestHeader("X-Requested-With","XMLHttpRequest");
		 StringBuffer sb=new StringBuffer();
			Cookie[] cookies=httpClient.getState().getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("JSESSIONID")){
					sb.append("; JSESSIONID="+cookies[i].getValue());
				}
				if(cookies[i].getName().equals("BIGipServerotn")){
					sb.append("; BIGipServerportal="+cookies[i].getValue());
				}
			}
			if(!StringUtils.isBlank(sb.toString())){
				String cookie=sb.substring(1)+"; _jc_save_fromStation=%u5317%u4EAC%2CBJP; _jc_save_toStation=%u4E0A%u6D77%2CSHH; _jc_save_fromDate=2014-10-06; _jc_save_toDate=2014-09-23; _jc_save_wfdc_flag=dc";
				System.out.println(cookie);
				getmethod.setRequestHeader("Cookie",cookie);
			}
        return getmethod;
    }
 // url 请求地址 params 参数 返回String型 url content
 	public static String getMethod(String url, Map<String, String> params)
 			throws Exception {
 		BufferedReader reader = null;
 		String str = "";
 		if (StringUtils.isBlank(url)) {
				return "";
			}
 		GetMethod getmethod=getGetMethod(url);
 		try {
 			if (params != null && params.size() > 0) {
 				StringBuffer sb = new StringBuffer();
 				for (Entry<String, String> entry : params.entrySet()) {
 					sb.append("&" + entry.getKey() + "=" + entry.getValue());
 				}
// 				sb.deleteCharAt(0);
// 				getmethod.setQueryString(sb.toString());
 				if (url.indexOf("?") == -1) {
 					sb.deleteCharAt(0);
 					url = url + "?" + sb.toString();
 				} else {
 					url = url + sb.toString();
 				}
 			}
 			Cookie[] cookies=httpClient.getState().getCookies();
 			for (int i = 0; i < cookies.length; i++) {
 				System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
 				if(cookies[i].getName().equals("BIGipServerotn")){
 					getmethod.setRequestHeader("Cookie","BIGipServerportal="+cookies[i].getValue());
 					System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
 				}
			}
 			int stat = httpClient.executeMethod(getmethod);
 			//仅处理200访问正常
 			if (stat == 200) {
			  try {
					return decompress(getmethod.getResponseBodyAsStream(),new FileOutputStream(new File("D:/1.txt")));
				} catch (Exception e) {
					System.out.println("没有压缩!");
				}
 				reader = new BufferedReader(new InputStreamReader(
 						getmethod.getResponseBodyAsStream()));
 				StringBuffer sb = new StringBuffer();
 				while ((str = reader.readLine()) != null) {
 					sb.append(str);
 				}
 				str = sb.toString();
 			}else{
 				System.out.println(stat);
 			}
 		} catch (Exception e) {
 			throw e;
 		} finally {
 			if (reader != null) {
 				reader.close();
 			}
 			if(getmethod!=null){
 				getmethod.releaseConnection();
 			}
 		}
 		return str;
 	}
	/**
	 * 数据解压缩
	 * 
	 * @param is
	 * @param os
	 * @throws Exception
	 */
	public static String decompress(InputStream is, OutputStream os)
			throws Exception {

		GZIPInputStream gis = new GZIPInputStream(is);

		int count;
		byte data[] = new byte[1024*1024];
		while ((count = gis.read(data, 0, 1024*1024)) != -1) {
			os.write(data, 0, count);
		}
		gis.close();
		return IOUtils.toString(new FileInputStream(new  File("D:/1.txt")));
	}

}
