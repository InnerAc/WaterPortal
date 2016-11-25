package edu.hhu.portal.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.render.Render;
import com.jfinal.upload.UploadFile;

import edu.hhu.portal.model.APP;
import edu.hhu.portal.model.Service;
import edu.hhu.portal.model.USER;

public class APPController extends Controller{
	public void index(){
		String appid = getPara();
		APP app = APP.dao.findById(appid);
		renderJson(app);
	}
	
	/**
	 * 根据 id,id,id...获取应用的信息
	 */
	public void list(){
		String appides = getPara();
		
		String userid = getSessionAttr("userid");
		if(userid == null){
			userid = "NUL";
			appides = Service.dao.findById("tourist").getStr("S_APPS");
		}
		if(appides == null || appides.equals("")){
			USER user = getSessionAttr("user");
			String serviceName = user.getStr("U_SERVICE");
			appides = Service.dao.findById(serviceName).getStr("S_APPS");
		}
		
		
		String[] appids = appides.split(",");
		System.out.println(appids);
		List<APP> apps = new ArrayList<APP>();
		for(String appid : appids){
			APP app = APP.dao.findById(appid);
			apps.add(app);
		}
		renderJson(apps);
	}
	
	public void img(){
		if(getRequest().getMethod().equals("GET")){
			int aid = getParaToInt();
			APP app = APP.dao.findById(aid);
			setAttr("app", app);
			render("/view/backend/editappimg.jsp");
		} else{
			UploadFile files = getFile("file","../static/icon");
			String imgName = files.getFileName();
			int aid = getParaToInt("A_ID");
			APP app = APP.dao.findById(aid);
			app.set("A_ICON", imgName);
			app.update();
			setAttr("info", "修改成功");
			setAttr("url", "/app/manager");
			render("/view/success.jsp");
		}
	}
	public void add(){
		if(getRequest().getMethod().equals("GET")){
			render("/view/backend/addapp.jsp");
		}else{
			UploadFile files = getFile("file","../static/icon");
			String imgName = files.getFileName();
			Map<String, String>res = new HashMap<String, String>();
			APP app = new APP();
			app.init(APP.dao.findMaxId()+1, imgName, getPara("A_NAME"), getPara("A_URL"), getPara("A_SERVICE"));
			app.save();
			manager();
		}
	}
	
	public void edit(){
		if(getRequest().getMethod().equals("GET")){
			int aid = getParaToInt();
			APP app = APP.dao.findById(aid);
			setAttr("app", app);
			render("/view/backend/editapp.jsp");
		}else{
			APP app = getModel(APP.class,"");
			System.out.println(app);
			app.update();
			setAttr("info", "修改成功");
			setAttr("url", "/app/manager");
			render("/view/success.jsp");
		}
	}
	
	public void delete(){
		int aid = getParaToInt();
		APP app = APP.dao.findById(aid);
		app.delete();
		setAttr("info", "删除成功");
		setAttr("url", "/app/manager");
		render("/view/success.jsp");
	}
	
	public void manager(){
		List<APP> apps = APP.dao.findAll();
		setAttr("apps", apps);
		render("/view/backend/managerapp.jsp");
	}
}
