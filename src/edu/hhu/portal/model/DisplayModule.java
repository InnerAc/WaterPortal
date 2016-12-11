package edu.hhu.portal.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;

public class DisplayModule extends Model<DisplayModule>{
	public final static DisplayModule dao = new DisplayModule();
	
	public List<DisplayModule> findAll(){
		return find("SELECT * FROM WP_DISPLAYMODULE");
	}
	
	public List<DisplayModule> findManageModules(String user){
		String sql = "SELECT * FROM WP_DISPLAYMODULE WHERE DM_EDIT LIKE '%"+user+"%' or DM_SHOWALL=1";
		System.out.println(sql);
		return find(sql);
	}
	
	public List<DisplayModule> findIssuedModules(String user){
		String sql = "SELECT * FROM WP_DISPLAYMODULE WHERE DM_ISSUED LIKE '%"+user+"%' or DM_SHOWALL=1";
		System.out.println(sql);
		return find(sql);
	}
	
	public Map<String ,DisplayModule> findByIds(String dmides){
		String[] ids = dmides.split(",");
		String sql = "SELECT * FROM WP_DISPLAYMODULE WHERE DM_ID='"+ids[0]+"'";
		int n = ids.length;
		for(int i=1;i<n;i++){
			sql += "OR DM_ID='"+ids[i]+"'";
		}
		List<DisplayModule> dms = find(sql);
		//put the result in map for sort
		Map<String, DisplayModule> sortMap = new HashMap<String, DisplayModule>();
		for(DisplayModule dm: dms){
			sortMap.put(dm.getStr("DM_ID"), dm);
		}
		return sortMap;
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
