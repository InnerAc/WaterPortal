package edu.hhu.portal.model;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class DisplayModule extends Model<DisplayModule>{
	public final static DisplayModule dao = new DisplayModule();
	
	public List<DisplayModule> findAll(){
		return find("SELECT * FROM WP_DISPLAYMODULE");
	}
	
	public List<DisplayModule> findManageModules(String user){
		String sql = "SELECT * FROM WP_DISPLAYMODULE WHERE DM_EDIT LIKE '%"+user+"%'";
		System.out.println(sql);
		return find(sql);
	}
	
	public List<DisplayModule> findIssuedModules(String user){
		String sql = "SELECT * FROM WP_DISPLAYMODULE WHERE DM_ISSUED LIKE '%"+user+"%'";
		System.out.println(sql);
		return find(sql);
	}
	
	public String findNAMEbyID(String dmid){
		String name = null;
		try{
			name = findById(dmid).getStr("DM_NAME");
		}catch (Exception e){
			
		}
		return name;
	}
}
