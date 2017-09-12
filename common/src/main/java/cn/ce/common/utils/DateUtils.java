package cn.ce.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtils {
	public static DateFormat timeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static DateFormat timeKeyFormat = new SimpleDateFormat(
			"yyyy-MM-ddhhmmss");
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");

	//"yyyy-MM-dd'T'HH:mm:ssZ"  
	
	public static Date getDateTimeT(String time)throws Exception{
		 DateFormat timeFormat=new SimpleDateFormat ("YYYY-MM-DD'T'hh:mm:ssZ");
		 Date d = timeFormat.parse(time);
		 return d;
	}
	
	
	/**
	 * @param String time yyyy-MM-dd hh:mm:ss
	 * @return Date
	 * @throws Exception
	 */
	public static Date getDateTime(String time) throws Exception {
		 DateFormat timeFormat=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date d = timeFormat.parse(time);
		return d;
	}

	/**
	 * @param String time yyyy-MM-dd
	 * @return Date
	 * @throws Exception
	 */
	public static Date getDate(String time) throws Exception {
		 DateFormat dateFormat=new SimpleDateFormat ("yyyy-MM-dd");
		Date d = dateFormat.parse(time);
		return d;
	}

	/**
	 * @param Date date
	 * @return String yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getDateStr(Date date) throws Exception {
		if (date==null) {
			date=new Date();
		}
		 DateFormat dateFormat=new SimpleDateFormat ("yyyy-MM-dd");
		String d = dateFormat.format(date);
		return d;
	}

	/**
	 * @param Date date
	 * @return String yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getDateSimpleStr(Date date) throws Exception {
		if (date==null) {
			date=new Date();
		}
		 DateFormat dateFormat=new SimpleDateFormat ("yyyyMMdd");
		String d = dateFormat.format(date);
		return d;
	}
	
	/**
	 * @param Date date
	 * @return String yyyy-MM-dd hh:mm:ss
	 * @throws Exception
	 */
	public static String getTimeStr(Date date) throws Exception {
		 DateFormat timeFormat=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		String d = timeFormat.format(date);
		return d;
	}
	
	

	public static String getMilTimeStr(Date date) throws Exception {
		 DateFormat timeFormat=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS");
		String d = timeFormat.format(date);
		
		return d;
	}
	
	public static Date getMilTime(String date) throws Exception {
		 DateFormat timeFormat=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSS");
		Date d = timeFormat.parse(date);
		
		return d;
	} 
	/**
	 * @param Date date
	 * @return String yyyy-MM
	 * @throws Exception
	 */
	public static String getYearMonthStr(Date date) throws Exception {
		 DateFormat yearMonthFormat=new SimpleDateFormat ("yyyy-MM");
		String d = yearMonthFormat.format(date);
		return d;
	}

	/**
	 * @param Date date
	 * @return String yyyy-MM
	 * @throws Exception
	 */
	public static String getSimpleYear(Date date)  {
		DateFormat yearMonthFormat=new SimpleDateFormat ("yy");
		String d = yearMonthFormat.format(date);
		return d;
	}
	
	/**
	 * @param Date date
	 * @return String yyyy-MM-ddhhmmss
	 * @throws Exception
	 */
	public static String getTimeKeyStr(Date date) throws Exception {
		 DateFormat timeKeyFormat=new SimpleDateFormat ("yyyyMMddhhmmss");
		String d = timeKeyFormat.format(date);
		return d;
	}

	public enum Type {
		DAY(3), SECOND(6);
		private int day;

		private Type(int type) {
			this.day = type;
		}

		public int getValue() {
			return this.day;
		}
	}

	/**
	 * 
	 * @param String
	 *            strdate
	 * @param String
	 *            strformat
	 * @return Date
	 */
	public static Date string2Date(String strdate, String strformat) {
		DateFormat format1 = new SimpleDateFormat(strformat);
		Date date = null;
		// String转Date
		try {
		    date = format1.parse(strdate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return date;
	}

	/**
	 * @param Date
	 *            date
	 * @param String
	 *            strformat
	 * @return String
	 */
	public static String date2String(Date date, String strformat) {
		DateFormat format1 = new SimpleDateFormat(strformat);
		String strDate = "";
		// Date转String
		strDate = format1.format(date);
		return strDate;
	}
	public static Date addDays(Date date,int offset){
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, offset);
			return cal.getTime();
		}catch(Exception e){
			e.printStackTrace();
			return date;
		}
	}
	
	
	public static Date getLastDayOfMonth(Date date){
		try{
			
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			return cal.getTime();
		}catch(Exception e){
			e.printStackTrace();
			return date;
		}
	}
	
	
	/**
	 * @param Date date
	 * @param Integer offset
	 * @return String yyyy-MM-dd
	 */
	public static String addYears(Date date,int offset) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, offset);
			Date d = cal.getTime();
			return date2String(d,"yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
			return date2String(date,"yyyy-MM-dd");
		}
	}
	/**
	 * @param Date date
	 * @param Integer offset
	 * @return String yyyy-MM-dd
	 */
	public static Date addYearsForDate(Date date,int offset) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, offset);
			Date d = cal.getTime();
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			return date;
		}
	}
	
	

	public static int getDayOfWeek(Date date) {
		int dayofweek = 0;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			dayofweek=cal.get(Calendar.DAY_OF_WEEK)-1;
			dayofweek=(dayofweek==0)?7:dayofweek;
			return dayofweek;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	/*
	 * @param strFormat:any of (yyyy MM dd HH hh mm ss)
	 * */
	public static boolean isFirstTimeLarger(Date date1,Date date2,String strFormat){
		DateFormat format1 = new SimpleDateFormat(strFormat);
		String time1 =format1.format(date1);
		String time2 =format1.format(date2);
		try{
			if(format1.parse(time1).compareTo(format1.parse(time2))>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//        smdate=sdf.parse(sdf.format(smdate));  
//        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }  
	
	public static List<String> getDateStrList(Date beginDate,Date endDate){
		if (beginDate.after(endDate)) {
			return null;
		}
		List<String> list=new ArrayList<String>();
		Calendar c=Calendar.getInstance();
		c.setTime(beginDate);
		int i;
		try {
			i = Math.abs(daysBetween(beginDate, endDate));
			for (int j = 0; j < i; j++) {
				c.add(Calendar.DAY_OF_MONTH, 1);
				list.add(getDateStr(c.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * @param String time yyyy-MM-dd hh:mm:ss
	 * @return Date
	 * @throws Exception
	 */
	public static Date getEnglishDateTime(String time) throws Exception {
		DateFormat dateFormat=new SimpleDateFormat ("dd/MMM/yyyy:HH:mm:ss +S", Locale.ENGLISH);
	
		Date d = dateFormat.parse(time);
		return d;
	}
	/**
	 * 格式转换  04/May/2017:09:54:33 +0800 转成 2017-02-01 10：11：12 .11111
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String convertTimeStrFromEnglish(String time) throws Exception {
		Date d = DateUtils.getEnglishDateTime(time);
		return DateUtils.getMilTimeStr(d);
	}
	
	public static void main(String[] args) {
//		DateFormat dateFormat=new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		
//		String s="04/May/2017:11:19:52 +080011";
		String s="Sat Apr 19 09:52:39 CST 2014";
		
//		DateFormat dateFormat=new SimpleDateFormat ("dd/MMM/yyyy:hh:mm:ss +SSS", Locale.ENGLISH);
		DateFormat dateFormat=new SimpleDateFormat ("dd/MMM/yyyy:hh:mm:ss +SSS", Locale.ENGLISH);
		try {
			Date d = dateFormat.parse(s);
			System.out.println(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getEnglishDateTime(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//获取前N天的日期
	public static String getStatetime(int n){
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		       
		        Calendar c = Calendar.getInstance();  
		        c.add(Calendar.DATE, - n);  
		        Date monday = c.getTime();
		        String preMonday = sdf.format(monday);
		        return preMonday;
   }
	
	public static List<String> getMonthBetween(Date minDate, Date maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(minDate);
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(maxDate);
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}
		return result;
	}
}
