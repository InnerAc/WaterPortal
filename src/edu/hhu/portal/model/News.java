package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import edu.hhu.portal.util.DateUtil;

public class News extends Model<News>{
	public final static News dao = new News();
	
	public News findByNID(String nid){
		News news = findById(nid);
		String time = news.getStr("N_DATE");
		time = DateUtil.unixTime2Date(time);
		news.set("N_DATE", time);
		return news;
	}
	
	public List<News> findAll(){
		List<News> newss = find("SELECT * FROM NEWS");
		for(News news : newss){
			String time = news.getStr("N_DATE");
			time = DateUtil.unixTime2Date(time);
			news.set("N_DATE", time);
		}
		return newss;
	}
	
	public List<News> findByDMID(String dmid,String userid){
		List<News> newss = find("SELECT * From WP_NEWS where N_DMID='"+dmid+"' AND (N_SHOWALL='1' OR N_SHOWUSER LIKE'%"+userid+"%')");
		for(News news : newss){
			String time = news.getStr("N_DATE");
			time = DateUtil.unixTime2Date(time);
			news.set("N_DATE", time);
		}
		return newss;
	}
	
	public List<News> findByDMID(String dmid,String num,String userid){
		List<News> newss = find("SELECT * From WP_NEWS where N_DMID='"+dmid+"'AND (N_SHOWALL='1' OR N_SHOWUSER LIKE'%"+userid+"%') ORDER BY N_DATE DESC limit 0,"+num);
		for(News news : newss){
			String time = news.getStr("N_DATE");
			time = DateUtil.unixTime2Date(time);
			news.set("N_DATE", time);
		}
		return newss;
	}
	
	public List<News> findByDMID(String dmid, int num,String userid){
		List<News> newss = find("SELECT * From WP_NEWS where N_DMID='"+dmid+"'AND (N_SHOWALL='1' OR N_SHOWUSER LIKE'%"+userid+"%') ORDER BY N_DATE DESC limit 0,"+num);
		for(News news : newss){
			String time = news.getStr("N_DATE");
			System.out.println(time);
			time = DateUtil.unixTime2Date(time);
			System.out.println(time);
			news.set("N_DATE", time);
		}
		return newss;
	}
}
