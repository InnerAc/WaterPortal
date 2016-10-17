package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

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
}
