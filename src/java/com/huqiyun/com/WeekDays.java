package com.huqiyun.com;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeekDays {
	
	//用来保存所有法定假日
	public static String[] statutoryHoliday = {"0402","0403","0404"
		,"0501","0528","0529","0530","1001"
		,"1002","1003","1004","1005","1006","1007","1008"};
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws ParseException {

		boolean f=validate("20170319");
		System.out.println(f);
	}

	private static List<String> getHolidaysAndWeekends(int year) {
		List<String> weekenDays = getWeekends(year);//拿到年度所有周末
		addStatutoryHolidays(weekenDays);//增加法定假日
		return weekenDays;
	}
	//判定日期 是否节假日
	public static boolean validate(String rq) {
		String mmdd = rq.substring(4);
		String yyyy = rq.substring(0,4);
		List<String> holidays = getHolidaysAndWeekends(Integer.parseInt(yyyy));
		for(String holiday: holidays){
			if(mmdd.equals(holiday)){
				return true;
			}
		}
		
		return false;
	}

	private static void addStatutoryHolidays(List<String> weekenDays) {
		for(String holiday: statutoryHoliday){
			weekenDays.add(holiday);
		}
	}

	public static List<String> getWeekends(int year){
		List<String> list = new ArrayList<String>();
		final SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(year, 0, 1);
		for(int day = 1; day <= cal.getActualMaximum(Calendar.DAY_OF_YEAR); day++){
			cal.set(Calendar.DAY_OF_YEAR, day);
			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
			if(weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY){
				list.add(sdf.format(cal.getTime()));
			}
		}
		return list;
	}
	
	public static String getCurrentDate(){
		return sdf.format(new Date());
	}
}
