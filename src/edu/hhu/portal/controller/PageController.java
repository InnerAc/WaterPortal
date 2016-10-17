package edu.hhu.portal.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;

public class PageController extends Controller{
	public void index(){
		setSessionAttr("userid", "innerac");
		setSessionAttr("service", "水文局");
		setSessionAttr("username", "安纪存");
		render("/view/index.jsp");
	}
}
