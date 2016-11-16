package edu.hhu.portal.controller;

import java.util.List;




import kjoms.udcs.bean.CAClient;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.APP;
import edu.hhu.portal.model.USER;

public class PageController extends Controller{
	public void index(){
		String userid = getSessionAttr("userid");
		List<APP> apps = APP.dao.findAll();
		if(userid != null){
			USER user = getSessionAttr(userid);
			setAttr("user", user);
		}
		setAttr("apps", apps);
		render("/view/indexNew.jsp");
	}
	public void manager(){
		USER user = getSessionAttr("user");
		setAttr("user", user);
		if(user == null){
			render("/view/indexNew.jsp");
		}else{
			render("/view/backend/backindex.jsp");
		}
	}
	public void login(){
		String userid = getPara("userid");	
		String pwd = getPara("pwd");
//		if(userid.equals("innerac"))
		if(CAClient.loginCA(userid, pwd)){
			setSessionAttr("userid", userid);
			USER user = USER.dao.findById(userid);
			setSessionAttr("user", user);
			redirect("/");
		}else{
			setAttr("info", "登陆失败，请检查用户名密码");
			setAttr("url", "/");
			render("/view/success.jsp");
		}
	}
	public void logout(){
		removeSessionAttr("userid");
		removeSessionAttr("user");
		render("/view/toindex.jsp");
	}
}
