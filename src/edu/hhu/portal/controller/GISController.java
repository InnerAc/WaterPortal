package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

import edu.hhu.portal.util.SSSYQUtil;

public class GISController extends Controller{
	public void index(){
		render("/view/gis.jsp");
	}
	
	public void sw(){
		String stid = getPara();
		String z = SSSYQUtil.getSWbySTID(stid);
//		renderJson("sw", z);
		renderText(z);
	}
}
