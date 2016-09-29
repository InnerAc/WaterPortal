package edu.hhu.portal.controller;

import java.util.Date;
import java.util.List;

import com.jfinal.core.Controller;

import edu.hhu.portal.model.News;

public class NewsController extends Controller{
	public void index(){
		String nid = getPara();
		try {
			News news = News.dao.findById(nid);
			setAttr("news", news);
			render("/view/news.jsp");
		} catch (Exception e) {
			renderText("Faile");
		}
	}
	
	public void list(){
		String superid = getPara();
		List<News> newss = News.dao.findBySuperId(superid);
		setAttr("newss", newss);
		render("/view/newss.jsp");
	}
	
	public void add(){
		News news = getModel(News.class,"");
		news.set("N_id", "n"+new Date().getTime()%100000000);
		news.set("N_date", new Date().getTime());
		try {
			news.save();
			renderText("Success");
		} catch (Exception e) {
			renderText("Fails");
		}
	}
}
