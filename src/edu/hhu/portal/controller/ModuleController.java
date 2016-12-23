package edu.hhu.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.News;
import edu.hhu.portal.model.Service;
import edu.hhu.portal.model.USER;

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
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		List<DisplayModule> dms = DisplayModule.dao.findManageModules(userid,serviceName);
		setAttr("dms", dms);
		setAttr("user", user);
		render("/view/backend/managerModule.jsp");
	}
	/**
	 * 获取该用户拥有信息发布权限的模块列表
	 */
	public void issued(){
		String userid = getSessionAttr("userid");
		USER user = getSessionAttr("user");
		String serviceName = user.getStr("U_SERVICE");
		List<DisplayModule> dms = DisplayModule.dao.findServiceIssuedModules(serviceName);
		setAttr("dms", dms);
		render("/view/backend/issuedModule.jsp");
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
			USER user = getSessionAttr("user");
			setAttr("userid", userid);
			setAttr("user", user);
			render("/view/backend/addModule.jsp");
		}
		if(getRequest().getMethod().equals("POST")){
			DisplayModule dm = getModel(DisplayModule.class,"");
			long id = new Date().getTime()%1000000000;
			String dmid = Long.toString(id);
			dm.set("DM_ID", dmid);
			if(dm.save()){
				setAttr("info", "创建模块成功");
				setAttr("url", "/module/manager");
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
		USER user = getAttr("user");
		setAttr("user", user);
		if(getRequest().getMethod().equals("GET")){
			String mdid = getPara();
			DisplayModule dm = DisplayModule.dao.findById(mdid);
			setAttr("dm", dm);
			render("/view/backend/editModule.jsp");
		}
		if(getRequest().getMethod().equals("POST")){
			DisplayModule dm = getModel(DisplayModule.class,"");
			if(dm.update()){
				setAttr("info", "修改模块成功");
				setAttr("url", "/module/manager");
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
		String dmid = getPara();
		String userid = getSessionAttr("userid");
		String service = "null";
		if(userid == null){
			userid = "NUL";
		}else {
			service = USER.dao.findById(userid).getStr("U_SERVICE");
		}
		DisplayModule dm = DisplayModule.dao.findById(dmid);
		List<News> newss = News.dao.findByDMID(dmid, 7,userid,service);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("dm", dm);
		res.put("newss", newss);
//		String jsonString = JSON.toJSONString(res);
//		renderJson(jsonString);
		renderJson(res);
	}
	
	/**
	 * 得到模块列表的所有信息<br>
	 * 根据id,id,id...获取所有模块的信息
	 */
	public void modules(){
		String dmids = getPara();
		String userid = getSessionAttr("userid");
		String service = "null";
		if(userid != null){
			service = USER.dao.findById(userid).getStr("U_SERVICE");
		}
		if(userid == null || "youke".equals(dmids)){
			userid = "NUL";
			dmids = Service.dao.findById("tourist").getStr("S_LIST");
		}
		if(dmids == null || dmids.equals("")){
			USER user = getSessionAttr("user");
			String serviceName = user.getStr("U_SERVICE");
			dmids = Service.dao.findById(serviceName).getStr("S_LIST");
		}
		String[] dmidlist = dmids.split(",");
		Map<String, DisplayModule> sortMap = DisplayModule.dao.findByIds(dmids);
		List<Object> list = new ArrayList<Object>();
		for(String dmid : dmidlist){
			System.out.println(dmid);
//			DisplayModule dm = DisplayModule.dao.findById(dmid);
			DisplayModule dm = sortMap.getOrDefault(dmid,null);
			if(dm == null){
				System.out.println(dmid+" is null");
				continue;
			}
			Map<String, Object> res = new HashMap<String, Object>();
			if(dm.getStr("DM_TYPE").equals("4")){//内容聚合
				String dmlistes = dm.getStr("DM_LIST");
				if(dmlistes != null){
					List<Object> idms = new ArrayList<Object>();
					String[] dmlists = dmlistes.split(",");
					for(String dmli : dmlists){
						Map<String, Object> ires = new HashMap<String, Object>();
						DisplayModule idm = DisplayModule.dao.findById(dmli);
						if(idm == null){
							continue;
						}
						List<News> inewss = News.dao.findByDMID(dmli, 5,userid,service);
						ires.put("dm", idm);
						ires.put("newss", inewss);
						idms.add(ires);
					}
					res.put("dm", dm);
					res.put("dms", idms);
				}
			}else{
				List<News> newss = News.dao.findByDMID(dmid, 7,userid,service);
				res.put("dm", dm);
				res.put("newss", newss);
			}
			list.add(res);
		}
		renderJson(list);
	}
	
	public void updateList(){
		String dmid = getPara("dmid");
		String list = getPara("list");
		DisplayModule dm = DisplayModule.dao.findById(dmid);
		dm.set("DM_LIST", list);
		if(dm.update()){
			setAttr("info", "修改模块成功");
			setAttr("url", "/module/manager");
			render("/view/success.jsp");
		}
	}
}
