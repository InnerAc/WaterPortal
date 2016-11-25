package edu.hhu.portal.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.APP;
import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.Service;
import edu.hhu.portal.model.USER;

public class ServiceController extends Controller{
	public void index(){
		
	}
	
	public void manager(){
		
	}
	
	public void addModule(){
		String userid = getSessionAttr("userid");
		List<DisplayModule> dms = DisplayModule.dao.findAll();
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		Service service = Service.dao.findById(serviceName);
		setAttr("dms", dms);
		setAttr("user", user);
		setAttr("service", service);
		render("/view/backend/serviceModule.jsp");
	}
	
	public void updateList(){
		String list = getPara("list");
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		Service service = Service.dao.findById(serviceName);
		service.set("S_LIST", list);
		service.update();
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
	
	public void updateListTourist(){
		String list = getPara("list");
		Service service = Service.dao.findById("tourist");
		service.set("S_LIST", list);
		service.update();
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
	
	public void addAPP(){
		List<APP> apps = APP.dao.findAll();
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		Service service = Service.dao.findById(serviceName);
		setAttr("service", service);
		setAttr("apps", apps);
		render("/view/backend/serviceAPP.jsp");
	}
	
	public void updateAPP(){
		String list = getPara("list");
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		Service service = Service.dao.findById(serviceName);
		service.set("S_APPS", list);
		service.update();
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
	
	public void updateAPPTourist(){
		String list = getPara("list");
		Service service = Service.dao.findById("tourist");
		service.set("S_APPS", list);
		service.update();
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
}
