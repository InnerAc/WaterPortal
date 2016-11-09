package edu.hhu.portal.controller;

import java.util.List;



import kjoms.udcs.bean.CAClient;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.APP;

public class PageController extends Controller{
	public void index(){
//		setSessionAttr("userid", "null");
//		setSessionAttr("service", "水文局");
//		setSessionAttr("username", "安纪存");
		String userid = getSessionAttr("userid");
		List<APP> apps = APP.dao.findAll();
		setAttr("apps", apps);
		setAttr("userid", userid);
		render("/view/indexUser.jsp");
	}
	public void manager(){
		setSessionAttr("userid", "innerac");
		setSessionAttr("service", "水文局");
		setSessionAttr("username", "安纪存");
		render("/view/index.jsp");
	}
	public void login(){
		String userid = getPara("userid");	
		String pwd = getPara("pwd");
		if(CAClient.loginCA(userid, pwd)){
			setSessionAttr("userid", userid);
			System.out.println(userid+" "+pwd);
			redirect("/");
		}else{
			setAttr("info", "登陆失败，请检查用户名密码");
			setAttr("url", "/");
			render("/view/success.jsp");
		}
	}
	public void logout(){
		removeSessionAttr("userid");
		redirect("/");
	}
}
