package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;

public class ModuleController extends Controller{
	public void all(){
		renderJson(DisplayModule.dao.findAll());
	}
}
