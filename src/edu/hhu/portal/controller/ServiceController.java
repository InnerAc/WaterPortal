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
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		List<DisplayModule> dms = DisplayModule.dao.findServiceShowModules(serviceName);
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
	
	public void update(){
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		List<USER> users = USER.dao.findByService(serviceName);
		setAttr("user", user);
		setAttr("users", users);
//		render("/view/backend/manageruser.jsp");
		render("/view/backend/manageruserb.jsp");
	}
	public void updates(){
		USER user = getSessionAttr("user");
		String bumen = getPara("bumen");
		List<USER> users = USER.dao.findByService(bumen);
		setAttr("user", user);
		setAttr("users", users);
		setAttr("bumen", bumen);
		render("/view/backend/managerusers.jsp");
	}
	
	public void updateUSER(){
		String list = getPara("list");
		USER user = getSessionAttr("user");
		String[] uids = list.split(",");
		for(String uid : uids){
			USER use = USER.dao.findById(uid);
			use.set("U_LVL", "1");
			use.update();
		}
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
	
	public void updown(){
		String uid = getPara(0);
		String lvl = getPara(1);
		USER user = USER.dao.findById(uid);
		user.set("U_LVL", lvl);
		user.update();
		renderText("yes");
	}
}
