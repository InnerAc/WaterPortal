package edu.hhu.portal.util;

import java.util.Date;

public class DateUtil {

	public static String unixTime2Date(String unixTime){
		long time = Long.parseLong(unixTime);
		return unixTime2Date(time);
	}
	
	public static String unixTime2Date(long unixTime){
			Date date = new Date(unixTime);
			String res = "";
			String month = (date.getMonth()+1)<10?("0"+(date.getMonth()+1)):((date.getMonth()+1)+"");
			String day = (date.getDate())<10?("0"+(date.getDate())):((date.getDate())+"");
			res += (date.getYear()+1900)+"-"+month+"-"+day;
			return res;
		}
}
