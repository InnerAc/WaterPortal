package edu.hhu.portal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSSYQUtil {
	public static String getSWbySTID(String stid){
		String s=HTTPRequest.sendGet("http://10.32.22.161:8080/maven_restful/rest/shuiweis/"+stid, "");
        String regexz = "<z>(.*)</z>";
        String regext = "<tm>(.*)</tm>";
		Pattern pattern = Pattern.compile(regexz);
		Matcher matcher = pattern.matcher(s);
		String z = "";
		while (matcher.find()) {
			z = matcher.group(1);
		}
		String tm = "null";
		pattern = Pattern.compile(regext);
		matcher = pattern.matcher(s);
		while (matcher.find()) {
			tm = matcher.group(1);
		}
		return "{\"z\":\""+z+"\",\"tm\":\""+tm+"\"}";
	}
}
