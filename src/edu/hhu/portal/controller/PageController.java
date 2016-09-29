package edu.hhu.portal.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;

public class PageController extends Controller{
	public void index(){
		render("/view/index.jsp");
	}
	
	public void addModule(){
		render("/view/addModule.jsp");
	}
	
	public void addNews(){
		List<DisplayModule> dms = DisplayModule.dao.findAll();
		setAttr("modules", dms);
		render("/view/addNews.jsp");
	}
}
