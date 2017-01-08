package com.huqiyun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 辅助日期处理的一些通用的方法
 * 
 */

public class DateUtil {

	static Logger logger = Logger.getLogger(DateUtil.class);

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 格式化日期
	 * 
	 * @param value
	 *            value
	 * @param pattern
	 *            pattern
	 * @return String
	 */
	public static String getString(Date value, String pattern) {
		if (value == null) {
			return "";
		}
		SimpleDateFormat vFormat = new SimpleDateFormat(pattern);
		return vFormat.format(value);
	}

	public static Date getNextDay(Date value) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(value);
		cl.add(Calendar.DAY_OF_MONTH, 1);
		return cl.getTime();
	}

	/**
	 * 将日期字符串或时间转换成时间类型 日期字符串中的日期分隔符可是是"/",".","-"，返回时间具体到秒
	 * 
	 * @param str
	 * @return Date
	 */
	public static Date parseString(String dateString) {
		// return stringToCalendar(str, fmt).getTime();
		if (dateString == null || "".equals(dateString) || "null".equals(dateString.toLowerCase())) {
			throw new IllegalArgumentException("The date string is null!");
		}

		try {
			if (dateString.indexOf("-") != -1) {
				dateString = dateString.replaceAll("-", "/");
			} else if (dateString.indexOf(".") != -1) {
				dateString = dateString.replace('.', '/');
			}

			String fmt = "yyyy/MM/dd";

			if (dateString.indexOf(":") != -1) {
				fmt = "yyyy/MM/dd HH:mm:ss";
			}

			DateFormat df = new SimpleDateFormat(fmt);
			return df.parse(dateString);

		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * 将日期类型转换成字符串 其格式包括:通过DateFormat转换的标准格式，如yyyy/MM/dd HH:mm:ss或者yyyy-MM-dd
	 * HH:mm:ss 非标准的格式，如YYYY/MM/DD
	 * 
	 * @param dt
	 * @param fmt
	 * @return String
	 */
	public static String formatDate(Date dt, String fmt) {
		if (dt == null) {
			throw new IllegalArgumentException("The date is null !");
		}

		try {
			DateFormat df = new SimpleDateFormat(fmt);
			return df.format(dt);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * 获取当前操作系统的日期
	 * 
	 * @return Date
	 */
	public static java.sql.Date getSqlDate() {
		try {
			return new java.sql.Date((new java.util.Date()).getTime());
		} catch (Exception e) {
			return null;
		}
	}

	public static java.sql.Date getSqlDate(Date date) {
		try {
			return new java.sql.Date(date.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	public static java.sql.Date getSqlDate(String dateString) {
		try {
			return new java.sql.Date(parseString(dateString).getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取当前操作系统的时间
	 * 
	 * @return 当前操作系统的时间
	 */
	public static String getTime() {
		String timePattern = "HHmmss";
		return new SimpleDateFormat(timePattern).format(Calendar.getInstance().getTime());
	}

	/**
	 * 获取当前操作系统的时间, 格式示例 kk:mm:ss
	 * 
	 * @return 当前操作系统的时间
	 */
	public static String getTime(String timePattern) {
		return new SimpleDateFormat(timePattern).format(Calendar.getInstance().getTime());
	}

	/**
	 * 获得当前日期的字符串，格式示例 YYYYMMDD
	 * 
	 * @return
	 */
	public static String getDate() {
		String datePattern = "yyyyMMdd";
		return new SimpleDateFormat(datePattern).format(Calendar.getInstance().getTime());
	}

	/**
	 * 获得当前日期的字符串，格式参数 YYYY年MM月DD日
	 * 
	 * @return
	 */
	public static String getDate(String datePattern) {
		return new SimpleDateFormat(datePattern).format(Calendar.getInstance().getTime());
	}

	// Add millisecond
	public static Date addMillisecond(Date dt, int millisecond) {
		return addSecond(dt, (long) millisecond);
	}

	public static Date addMillisecond(Date dt, long millisecond) {
		Date newDate = new Date();
		newDate.setTime(dt.getTime() + millisecond);
		return newDate;
	}

	// add second
	public static Date addSecond(Date dt, int second) {
		return addSecond(dt, (long) second);
	}

	public static Date addSecond(Date dt, float second) {
		return addSecond(dt, (double) second);
	}

	public static Date addSecond(Date dt, long second) {
		return addMillisecond(dt, 1000L * second);
	}

	public static Date addSecond(Date dt, double second) {
		Double millisecond = new Double(1000.0 * second);
		return addMillisecond(dt, millisecond.longValue());
	}

	// add minute
	public static Date addMinute(Date dt, int minute) {
		return addMinute(dt, (long) minute);
	}

	public static Date addMinute(Date dt, float minute) {
		return addMinute(dt, (double) minute);
	}

	public static Date addMinute(Date dt, long minute) {
		return addMillisecond(dt, 1000L * 60L * minute);
	}

	public static Date addMinute(Date dt, double minute) {
		Double millisecond = new Double(1000.0 * 60.0 * minute);
		return addMillisecond(dt, millisecond.longValue());
	}

	// add hour
	public static Date addHour(Date dt, int hour) {
		return addHour(dt, (long) hour);
	}

	public static Date addHour(Date dt, float hour) {
		return addHour(dt, (double) hour);
	}

	public static Date addHour(Date dt, long hour) {
		return addMillisecond(dt, 1000L * 60L * 60L * hour);
	}

	public static Date addHour(Date dt, double hour) {
		Double millisecond = new Double(1000.0 * 60.0 * 60.0 * hour);
		return addMillisecond(dt, millisecond.longValue());
	}

	// add day
	public static Date addDay(Date dt, int day) {
		return addDay(dt, (long) day);
	}

	public static Date addDay(Date dt, float day) {
		return addDay(dt, (double) day);
	}

	public static Date addDay(Date dt, long day) {
		return addMillisecond(dt, 1000L * 60L * 60L * 24L * day);
	}

	public static Date addDay(Date dt, double day) {
		Double millisecond = new Double(1000.0 * 60.0 * 60.0 * 24.0 * day);
		return addMillisecond(dt, millisecond.longValue());
	}

	// add month
	public static Date addMonth(Date dt, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
		return cal.getTime();
	}

	public static Date addMonth(Date dt, float month) {
		return addMonth(dt, (double) month);
	}

	public static Date addMonth(Date dt, long month) {
		return addMonth(dt, (new Long(month)).intValue());
	}

	public static Date addMonth(Date dt, double month) {
		double floorMonth = Math.floor(month);
		double decimalMonth = month - floorMonth;
		dt = addMonth(dt, (new Double(floorMonth)).intValue());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		Date nextdt = cal.getTime();
		long monthMillisecond = nextdt.getTime() - dt.getTime();
		double millisecond = monthMillisecond * decimalMonth;
		return addMillisecond(dt, (long) millisecond);
	}

	// add month by lancy
	public static Date addMonth(String dt, int month) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(parseString(dt));

		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);

		return cal.getTime();
	}

	// add year
	public static Date addYear(Date dt, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + year);
		return cal.getTime();
	}

	public static Date addYear(Date dt, float year) {
		return addYear(dt, (double) year);
	}

	public static Date addYear(Date dt, long year) {
		return addYear(dt, (new Long(year)).intValue());
	}

	public static Date addYear(Date dt, double year) {
		double floorYear = Math.floor(year);
		double decimalYear = year - floorYear;
		dt = addYear(dt, (new Double(floorYear)).intValue());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
		Date nextdt = cal.getTime();
		long yearMillisecond = nextdt.getTime() - dt.getTime();
		double millisecond = yearMillisecond * decimalYear;
		return addSecond(dt, (long) millisecond);
	}

	/**
	 * 获得上月的月份，譬如本月四月，传入参数1，返回03，表示三月份
	 * 
	 * @return
	 */
	// update by zhuhong 20070323
	public static String getBeforeMonth(String currentMonth, int beforeMonth) {
		// String currentMonth = getDate("MM");
		int cal = beforeMonth % 12;
		// System.out.println("cal = " + cal);
		int month = Integer.parseInt(currentMonth) - cal;
		String returnMonth;
		if (month < 1) {
			returnMonth = String.valueOf(12 + month);
		} else {
			returnMonth = String.valueOf(Integer.parseInt(currentMonth) - cal);
		}
		if (returnMonth.length() < 2)
			return "0" + returnMonth;
		return returnMonth;

	}

	public static String getBeforeMonth(int beforeMonth) {
		String currentMonth = getDate("MM");
		int cal = beforeMonth % 12;
		// System.out.println("cal = " + cal);
		int month = Integer.parseInt(currentMonth) - cal;
		String returnMonth;
		if (month < 1) {
			returnMonth = String.valueOf(12 + month);
		} else {
			returnMonth = String.valueOf(Integer.parseInt(currentMonth) - cal);
		}
		if (returnMonth.length() < 2)
			return "0" + returnMonth;
		return returnMonth;

	}

	// add by lancy
	/**
	 * java.util.Date 转换为java.sql.Date
	 * 
	 * @return Date
	 */
	public static java.sql.Date toSqlDate(java.util.Date d) {
		try {
			return new java.sql.Date(d.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据输入的日期转换成julian格式的日期 julian格式：YYYYDDD，其中DDD是从1/1开始计数的整数值
	 * 例如20050101->2005001,20050131->2005031
	 * 
	 * @param inputDate
	 *            输入日期，格式YYYYMMDD
	 * @return julian格式日期，格式YYYYDDD,其中DDD是从1/1开始计数的整数值
	 * @throws ParseException
	 */
	public static String getJulianDate(String inputDate) throws ParseException {
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyyMMdd");
		inputFormatter.setLenient(false); // strict check the date string
		return new SimpleDateFormat("yyyyDDD").format(inputFormatter.parse(inputDate));
	}

	public static java.sql.Timestamp stringToTimestamp(String str, String format) {

		if (str == null || format == null) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		java.util.Date date = null;
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
		return new java.sql.Timestamp(date.getTime());
	}

	/**
	 * 以指定的格式解析日期字符串
	 * 
	 * @author Kevin
	 * @param dateString
	 * @param format
	 * @return Date null代表解析失败
	 * 
	 */
	public static Date parseDateString(String dateString, String format) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(true);
			Date temp = formatter.parse(dateString);
			return temp;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Description:计算两个日期间的天数
	 * 
	 * @author MIAOJIYONG001
	 * @param fromDate
	 *            起始日期
	 * @param toDate
	 *            结束日期
	 * @return Create Time:20081107
	 * @throws ParseException
	 */
	public static long dateDiff(String fromDate, String toDate) throws ParseException {
		long days = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date from = df.parse(fromDate);
		Date to = df.parse(toDate);
		days = ((to.getTime() - from.getTime()) / (24 * 60 * 60 * 1000));
		return days;
	}

	/**
	 * Description:是否是context-creditcard中设置的天之后
	 * 
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean turnOnDate(String onDate) {
		// 取当前时间
		String currentDate = DateUtil.getDate();
		// 取配置信息，比较日期。
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");

		String toDate = ms.getString(onDate).trim();
		long on = 0;
		try {
			on = DateUtil.dateDiff(toDate, currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (on >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Description:账单日是否是context-creditcard中设置的天之前
	 * 
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean turnByBillDate(String onDate, String billDate) {
		// 取配置信息，比较日期。
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");

		String fromDate = ms.getString(onDate).trim();
		long on = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date billDateFormat = sdf.parse(billDate);
			on = DateUtil.dateDiff(fromDate, formatDate(billDateFormat, "yyyyMMdd"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (on >= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Description:控制代码的开关
	 * 
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean getTurnOnOrOff(String key) {
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");
		String value = ms.getString(key).trim();
		return Boolean.valueOf(value).booleanValue();
	}

	/**
	 * 检查JCB主卡申请人是否是在18-40岁
	 * 
	 * @param year
	 * @return
	 */
	public static boolean checkAgeForJCBByYeay(String year) {
		int yearInt = Integer.parseInt(year);
		int nowYearInt = Calendar.getInstance().get(Calendar.YEAR);
		int age = nowYearInt - yearInt + 1;
		if (age < 18 || age > 40) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 根据出生日期计算年龄
	 * 
	 * @param strBirthDay
	 *            字符串型日期
	 * @param format
	 *            日期格式
	 * @return 未来日期返回0
	 * @throws ParseException
	 * @throws Exception
	 */
	public static int getAge(String strBirthDay, String format) throws ParseException {

		DateFormat df = new SimpleDateFormat(format);
		Date birthDay = df.parse(strBirthDay);

		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			return 0;
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}

		return age;
	}

	/**
	 * Description:计算两个日期间相差的分钟数
	 * 
	 * @author MIAOJIYONG001
	 * @param fromDate
	 *            起始日期
	 * @param toDate
	 *            结束日期
	 * @return Create Time:20081107
	 * @throws ParseException
	 */
	public static long dateDiffToMinute(String fromDate, String toDate) throws ParseException {
		long minutes = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date from = df.parse(fromDate);
		Date to = df.parse(toDate);
		minutes = ((to.getTime() - from.getTime()) / (60 * 1000));
		return minutes;
	}

	/**
	 * 解析字符串为日期对象
	 * 
	 * @param value
	 *            日期字符串
	 * @param format
	 *            日期格式,缺省为"yyyy-MM-dd HH:mm:ss"
	 * @return Date 转化后的日期值
	 */
	public static Date format(String value, String format) {
		if (value == null || value.length() == 0)
			return null;
		if (format == null || format.length() == 0)
			format = DEFAULT_DATE_FORMAT;

		if (format.length() > value.length()) {
			format = format.substring(0, value.length());
		}

		Date result = null;
		SimpleDateFormat df = null;
		if (format != null && format.length() > 0) {
			df = new SimpleDateFormat(format);
			try {
				result = df.parse(value);
			} catch (ParseException pe) {
				logger.debug(value + " parse fail with date format " + format);
				result = null;
			}
			if (result != null)
				return result;
		}

		return result;
	}

	/**
	 * 获取时间离当前时间的天数和小时 格式 xx天xx小时
	 * 
	 * @param date
	 *            日期
	 * @return String 计算后的结果
	 */
	public static String dateNowDiff(Date date) {
		if (null == date) {
			return "-";
		}

		long diffSec = date.getTime() - System.currentTimeMillis();

		return diffSec / (3600 * 24 * 1000) + "天" + (diffSec % (3600 * 24 * 1000)) / (3600 * 1000) + "小时";
	}

	/**
	 * 获得日期起始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateStarting(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 1);
		return cal.getTime();
	}

	/**
	 * 获得日期结束时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateEnding(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * date 加上分钟 time 跟当前时间比较
	 * 
	 * @param date
	 * @return true 小于:超时，false 大于:未超时
	 */
	public static boolean timePlusMinutesComparedNow(Date date, Integer time) {
		Calendar calendar = Calendar.getInstance();
		// date 加上分钟 time 时间
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, time);
		Calendar ca = Calendar.getInstance();
		// 当前比较时间
		ca.setTime(new Date());
		return calendar.before(ca);
	}

	/**
	 * 判断当前时间是否在 startTime 和 endTime 之间
	 * 
	 * @param Date
	 *            startTime
	 * @param Date
	 *            endTime
	 * @return true 在，false 不在
	 */
	public static boolean nowBetweenstartTimeAndendTime(Date startTime, Date endTime) {
		if (startTime == null || endTime == null) {
			return false;
		}
		Date now = new Date();
		return startTime.before(now) && now.before(endTime);
	}

	/**
	 * 判断当前时间是否在 startTime 之前
	 * 
	 * @param Date
	 *            startTime
	 * @return true 在，false 不在
	 */
	public static boolean nowBeforeStartTime(Date startTime) {
		if (startTime == null) {
			return false;
		}
		Date now = new Date();
		return now.before(startTime);
	}

	/**
	 * 将字符串转换为日期
	 * 
	 * @param date
	 * @param pattern
	 *            　yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date fullStringToDate(String date) {
		try {
			return new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将date + month，是否 在系统时间之后 true : 在系统时间之后（未过期） fasel : 在系统时间之前（过期）
	 * 
	 * @param date
	 * @param pattern
	 *            　yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static boolean dateAddmonthForSystem(Date startTime, int month) {
		if (startTime == null) {
			return false;
		}
		Date now = new Date();
		// 得到 + month 的时间
		Date retDate = addMonth(startTime, month);
		System.out.println(formatDate(now, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatDate(retDate, "yyyy-MM-dd HH:mm:ss"));

		return retDate.after(now);
	}

	/**
	 * 注册送88红包计算失效时间 如果获取红包的时间+3个月 在 ActivitiesEndTime 之前 返回 获取红包的时间+3个月 否则返回
	 * ActivitiesEndTime
	 * 
	 * @param date
	 * @param pattern
	 *            　yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date getZCSHB88ActivitiesEndTime(Date startTime, int month, Date activitiesEndTime) {
		if (startTime == null || activitiesEndTime == null) {
			return activitiesEndTime;
		}
		// 得到 + month 的时间
		Date retDate = addMonth(startTime, month);

		return retDate.before(activitiesEndTime) ? retDate : activitiesEndTime;
	}

	public static void main(String[] args) {
		Date a = fullStringToDate("2014-10-04 00:03:50");
		Date b = fullStringToDate("2015-11-04 00:03:50");
		System.out.println(formatDate(getZCSHB88ActivitiesEndTime(a, 3, b), "yyyy-MM-dd HH:mm:ss"));
	}
}
