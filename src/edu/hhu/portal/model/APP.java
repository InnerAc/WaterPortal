package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class APP extends Model<APP>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static APP dao = new APP();
	
	public void init(int id,String icon,String name,String url,String service){
		set("A_ID", id);
		set("A_ICON", icon);
		set("A_NAME", name);
		set("A_URL", url);
		set("A_SERVICE", service);
	}
	public List<APP> findAll(){
		String sql = "SELECT * FROM WP_APP";
		return find(sql);
	}
	
	public int findMaxId(){
		String sql = "SELECT MAX(A_ID) FROM WP_APP";
		int maxId = findFirst(sql).getInt("MAX(A_ID)");
		return maxId;
	}
	public List<APP> findByService(String service){
		String sql = "SELECT * FROM WP_APP WHERE A_SERVICE LIKE '%"+service+"%'";
		return find(sql);
	}
}
