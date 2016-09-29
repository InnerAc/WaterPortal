package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import edu.hhu.portal.entity.J_News;

public class News extends Model<News>{
	public final static News dao = new News();
	
	public List<News> findAll(){
		return find("SELECT * FROM News");
	}
	
	public List<News> findBySuperId(String superId){
		return find("SELECT * From News where N_superid='"+superId+"'");
	}
	
	public List<News> findBySuperId(String superId,String num){
		return find("SELECT * From News where N_superid='"+superId+"' and 1=1 limit "+num);
	}
	
	public List<News> findBySuperId(String superId, int num){
		return find("SELECT * From News where N_superid='"+superId+"' and 1=1 limit "+num);
	}
	
	public J_News getNews(String N_id){
		News news = findById(N_id);
		J_News jn = new J_News(news.getStr("N_id"), news.getStr("N_title"),news.getStr("N_author"),news.getStr("N_date"),news.getStr("N_content"));
		return jn;
	}
	
	public J_News turnNews(){
		J_News jn = new J_News(getStr("N_id"), getStr("N_title"),getStr("N_author"),getStr("N_date"),getStr("N_content"));
		return jn;
	}
}
