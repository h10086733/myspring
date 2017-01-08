package com.huqiyun.util;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * isNullOrEmptyStr:判断字符串是否为空. <br/>
	 * 
	 * @author qiye
	 * @param str
	 * @return
	 * @since JDK 1.7
	 */
	public static boolean isNullOrEmptyStr(String str) {

		if (null == str) {
			return true;
		}

		return str.trim().isEmpty();
	}

	/**
	 * 
	 * grenerateRandomNmuber:获取随机length位字母和数字字符串. <br/>
	 * 
	 * @author qiye
	 * @param length
	 * @return
	 * @since JDK 1.7
	 */
	public static String grenerateRandomNmuber(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	/**
	 * 
	 * 随机N位数字
	 * 
	 */
	public static String getrandom(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(new Random().nextInt(10));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getrandom(6));
	}

	/**
	 * 
	 * @Title: isNullOrEmptyStr @Description: 判断字符串是否为空 多个 @param @param str @param @return @return
	 *         boolean @throws
	 */
	public static boolean isNullOrEmptyStr(String... str) {
		if (str != null) {
			for (String s : str) {
				if (StringUtils.isBlank(s)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Title: isEmail @Description: 判断字符串是否为邮箱 @param @param str @param @return @return
	 *         boolean @throws
	 */
	public static boolean isEmail(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		String emailRegex = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		return str.matches(emailRegex);
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
	/**
	 * 
	 * wxRequestXMLCreate:生成微信支付接口xml报文. <br/>
	 * 
	 * @author qiye
	 * @param param
	 * @return
	 * @since JDK 1.7
	 */
	public static String wxRequestXMLCreate(SortedMap<Object, Object> param) {

		StringBuffer xml = new StringBuffer();
		xml.append("<xml>");
		Set<Entry<Object, Object>> set = param.entrySet();
		Iterator<Entry<Object, Object>> it = set.iterator();
		while (it.hasNext()) {
			Entry<Object, Object> ent = it.next();
			xml.append("<").append(ent.getKey()).append(">").append(ent.getValue()).append("</").append(ent.getKey())
					.append(">");
		}
		xml.append("</xml>");
		return xml.toString();
	}
}
