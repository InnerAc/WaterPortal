package edu.hhu.portal.controller;

import java.util.Date;
import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.DisplayModule;
import edu.hhu.portal.model.News;

public class NewsController extends Controller{
	/**
	 * 新闻详情页面<br>
	 * 取得新闻id，校验该用户是否有查看权限<br>
	 * 如果没有查看权限，返回没有权限信息，重定向主页<br>
	 */
	public void index(){
	}
	
	/**
	 * 根据模块id获取所有的新闻list<br>
	 * 获取新闻时要保证只获取该用户有查看权限的新闻<br>
	 * 返回新闻列表
	 */
	public void list(){
	}
	
	/**
	 * 验证用户是否对该拥有信息发布权限<br>
	 * 根据模块id获取该模块下所属的所有新闻<br>
	 * 返回新闻列表
	 */
	public void manager(){
		
	}
	
	/**
	 * 首先验证用户是否对此模块拥有信息发布的权限<br>
	 * 添加新闻<br>
	 * 如果是get请求，则返回增加新闻的页面<br>
	 * 如果是post请求，获取新的新闻信息，写入数据库<br>
	 * 如果写入成功，则返回成功信息，并且重定向到新闻管理界面<br>
	 * 如果写入失败，返回失败信息，将页面恢复到点击提交按钮前的状态<br>
	 * <br>
	 * 验证首先应该先验证该用户对于这个模块是否拥有
	 */
	public void add(){
		if(getRequest().getMethod().equals("GET")){
			String dmid = getPara();
			String dmname = DisplayModule.dao.findNAMEbyID(dmid);
			String userid = getSessionAttr("userid");
			if(dmid == null || dmid.equals("")){
				return;
			}
			setAttr("userid", userid);
			setAttr("dmid", dmid);
			setAttr("dmname", dmname);
			render("/view/addNews.jsp");
		}
		if(getRequest().getMethod().equals("POST")){
			News news = getModel(News.class,"");
			long id = new Date().getTime()%1000000000;
			String nid = Long.toString(id);
			news.set("N_ID", nid);
			if(news.save()){
				setAttr("info", "新闻发布成功");
				setAttr("url", "/");
				render("/view/success.jsp");
			}
		}
	}
	
	/**
	 * 首先验证用户是否对此模块拥有信息发布的权限<br>
	 * 编辑新闻<br>
	 * 如果是get请求，查询到新闻的基本信息，然后将信息填充到jsp中<br>
	 * 如果是post请求，得到待更新的新闻信息，更新到数据库<br>
	 * 如果更新成功，则返回成功信息，并且重定向到新闻管理界面<br>
	 * 如果更新失败，返回失败信息，将页面恢复到点击提交按钮前的状态
	 */
	public void edit(){
		
	}
	/**
	 * 首先验证用户是否对此模块拥有信息发布的权限<br>
	 * 删除新闻<br>
	 * 获取新闻id然后从数据中删除<br>
	 * 返回成功信息，重定向到新闻管理界面
	 */
	public void delete(){
		
	}
}
