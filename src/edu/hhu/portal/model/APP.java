package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class APP extends Model<APP>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static APP dao = new APP();
	
	public List<APP> findAll(){
		String sql = "SELECT * FROM WP_APP";
		return find(sql);
	}
}
