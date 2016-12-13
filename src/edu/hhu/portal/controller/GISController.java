package edu.hhu.portal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.ST;
import edu.hhu.portal.util.SSSYQUtil;

public class GISController extends Controller{
	
	boolean hhudev = false;
	
	public void index(){
		render("/view/gis.jsp");
	}
	
	public void sw(){
		String stid = getPara();
		if(hhudev){
			renderText("{\"z\":\""+stid+"\",\"tm\":\"null\"}");
			return;
		}
		String ztm = SSSYQUtil.getSWbySTID(stid);
		renderText(ztm);
	}
	
	public void sts(){
		List<ST> sts = ST.dao.findAll();
		renderJson(sts);
	}
}
