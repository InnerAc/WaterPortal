package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

import edu.hhu.portal.util.SSSYQUtil;

public class GISController extends Controller{
	
	boolean hhudev = true;
	
	public void index(){
		render("/view/gis.jsp");
	}
	
	public void sw(){
		String stid = getPara();
		if(hhudev){
			renderText(stid);
			return;
		}
		String z = SSSYQUtil.getSWbySTID(stid);
		renderText(z);
	}
}
