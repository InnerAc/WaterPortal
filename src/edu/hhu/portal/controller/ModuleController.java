package edu.hhu.portal.controller;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;

public class ModuleController extends Controller{
	/**
	 * 得到该用户可以订阅的所有模块<br>
	 * @JSON 模块list
	 */
	public void list(){
	}
	
	/**
	 * 获取该用户可以管理的模块列表<br>
	 */
	public void manager(){
		String userid = getSessionAttr("userid");
		List<DisplayModule> dms = DisplayModule.dao.findManageModules(userid);
		setAttr("dms", dms);
		render("/view/managerModule.jsp");
	}
	/**
	 * 获取该用户拥有信息发布权限的模块列表
	 */
	public void issued(){
		String userid = getSessionAttr("userid");
		List<DisplayModule> dms = DisplayModule.dao.findIssuedModules(userid);
		setAttr("dms", dms);
		render("/view/issuedModule.jsp");
	}
	/**
	 * 增加一个新的模块<br>
	 * 如果是get请求，则返回增加模块的页面<br>
	 * 如果是post请求，获取新的模块信息，写入数据库<br>
	 * 如果写入成功，则返回成功信息，并且重定向到模块管理界面<br>
	 * 如果写入失败，返回失败信息，将页面恢复到点击提交按钮前的状态
	 */
	public void add(){
		if(getRequest().getMethod().equals("GET")){
			String userid = getSessionAttr("userid");
			setAttr("userid", userid);
			render("/view/addModule.jsp");
		}
		if(getRequest().getMethod().equals("POST")){
			DisplayModule dm = getModel(DisplayModule.class,"");
			long id = new Date().getTime()%1000000000;
			String dmid = Long.toString(id);
			dm.set("DM_ID", dmid);
			if(dm.save()){
				setAttr("info", "创建模块成功");
				setAttr("url", "/");
				render("/view/success.jsp");
			}
		}
	}
	
	/**
	 * 修改模块信息<br>
	 * 如果是get请求，查询到模块的基本信息，然后将信息填充到jsp中<br>
	 * 如果是post请求，得到待更新的模块信息，更新到数据库<br>
	 * 如果更新成功，则返回成功信息，并且重定向到模块管理界面<br>
	 * 如果更新失败，返回失败信息，将页面恢复到点击提交按钮前的状态
	 */
	public void edit(){
		if(getRequest().getMethod().equals("GET")){
			String mdid = getPara();
			DisplayModule dm = DisplayModule.dao.findById(mdid);
			setAttr("dm", dm);
			render("/view/editModule.jsp");
		}
		if(getRequest().getMethod().equals("POST")){
			DisplayModule dm = getModel(DisplayModule.class,"");
			if(dm.update()){
				setAttr("info", "修改模块成功");
				setAttr("url", "/");
				render("/view/success.jsp");
			}
		}
	}
	
	/**
	 * 删除模块<br>
	 * 取到模块id，从数据库中删除模块信息<br>
	 * 返回成功信息，重定向到模块管理界面
	 */
	public void delete(){
		String dmid = getPara();
		DisplayModule dm = DisplayModule.dao.findById(dmid);
		if(dm.delete()){
			renderText("删除成功");
		}
	}
	/**
	 * 得到模块基本信息<br>
	 * 根据模块id返回模块的基本信息及所需要显示的新闻列表
	 */
	public void module(){
	}
}
