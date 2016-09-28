package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

public class PageController extends Controller{
	public void index(){
		render("/view/index.jsp");
	}
}
