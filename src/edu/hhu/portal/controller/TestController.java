package edu.hhu.portal.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.News;

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
