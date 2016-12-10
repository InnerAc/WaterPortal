package edu.hhu.portal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSSYQUtil {
	public static String getSWbySTID(String stid){
		String s=HTTPRequest.sendGet("http://10.32.22.161:8080/maven_restful/rest/shuiweis/"+stid, "");
        String regex = "<z>(.*)</z>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			s = matcher.group(1);
		}
		return s;
	}
}
