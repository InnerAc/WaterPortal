package edu.hhu.portal.controller;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.USER;

public class UserController extends Controller{
	public void updateList(){
		String list = getPara("list");
		String userId = getSessionAttr("userid");
		USER user = USER.dao.findById(userId);
		user.set("U_LIST", list);
		user.update();
		setAttr("info", "修改成功");
		setAttr("url", "/");
		render("/view/success.jsp");
	}
}
