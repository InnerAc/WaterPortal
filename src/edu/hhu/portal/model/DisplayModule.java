package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class DisplayModule extends Model<DisplayModule>{
	public final static DisplayModule dao = new DisplayModule();
	
	public List<DisplayModule> findAll(){
		return find("SELECT * FROM DisplayModule");
	}
}
