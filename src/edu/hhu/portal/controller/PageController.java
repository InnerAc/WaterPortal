package edu.hhu.portal.controller;

import java.util.List;





import org.springframework.web.util.CookieGenerator;

import kjoms.udcs.bean.CAClient;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.APP;
import edu.hhu.portal.model.USER;

public class PageController extends Controller{
	public void index(){
		String userid = getSessionAttr("userid");
		if(userid != null){
			USER user = getSessionAttr(userid);
			setAttr("user", user);
		}
		render("/view/indexNew.jsp");
	}
	public void tourise(){
		String userid = getSessionAttr("userid");
		if(userid != null){
			USER user = getSessionAttr(userid);
			setAttr("user", user);
		}
		render("/view/indexTourise.jsp");
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
	public void sso(){
		String url = getPara("rurl");
		System.out.println(url);
		String userid = getSessionAttr("userid");
		if(userid != null){
			USER user = getSessionAttr("user");
			CookieGenerator generator = new CookieGenerator();
			String token = user.getStr("U_TOKEN");
			generator.setCookieName("hp_t");
	        generator.addCookie(getResponse(), token);
	        generator.setCookieName("currentLoginName");
	        generator.addCookie(getResponse(), userid);
	        getResponse().addHeader("Access-Control-Allow-Origin", "*");
			redirect(url);
		}
	}
}
