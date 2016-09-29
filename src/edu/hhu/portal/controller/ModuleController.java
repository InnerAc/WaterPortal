package edu.hhu.portal.controller;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import edu.hhu.portal.entity.J_DisplayModule;
import edu.hhu.portal.model.DisplayModule;

public class ModuleController extends Controller{
	public void all(){
		renderJson(DisplayModule.dao.findAll());
	}
	
	public void add(){
//		String mData = getPara("module");
//		DisplayModule module = JSON.parseObject(mData,DisplayModule.class);
		DisplayModule module = getModel(DisplayModule.class,"");
		module.set("DM_id", new Date().getTime()%1000000000);
		try {
			module.save();
			renderText("Success");
		} catch (Exception e) {
			renderText("Faile");
		}
	}
	
	public void module(){
		String DM_id = getPara();
		J_DisplayModule jdm = DisplayModule.dao.getDM(DM_id);
		renderJson(jdm);
	}
}
