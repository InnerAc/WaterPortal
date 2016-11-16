package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

public class TestController extends Controller{
	public void index(){
		renderText("Test Success!");
	}
	public void test(){
		String jsp = getPara();
		render("/view/"+jsp+".jsp");
	}
	public void test2(){
		String jsp = getPara();
		render("/view/backend/"+jsp+".jsp");
	}
}
