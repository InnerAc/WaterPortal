package edu.hhu.portal.controller;

import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.APP;
import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.USER;

public class UserController extends Controller{
	public void updateList(){
		String list = getPara("list");
		String userId = getSessionAttr("userid");
		USER user = USER.dao.findById(userId);
		user.set("U_LIST", list);
		user.update();
		setSessionAttr("user", user);
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
	
	public void addModule(){
		String userid = getSessionAttr("userid");
		List<DisplayModule> dms = DisplayModule.dao.findManageModules(userid);
		USER user = getSessionAttr(userid);
		setAttr("dms", dms);
		setAttr("user", user);
		render("/view/backend/subscribeModule.jsp");
	}
	
	public void addAPP(){
		String userid = getSessionAttr("userid");
		List<APP> apps = APP.dao.findAll();
		setAttr("apps", apps);
		render("/view/backend/subscribeAPP.jsp");
	}
	
	public void updateAPP(){
		String list = getPara("list");
		String userId = getSessionAttr("userid");
		USER user = USER.dao.findById(userId);
		user.set("U_APPS", list);
		user.update();
		setSessionAttr("user", user);
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
}
