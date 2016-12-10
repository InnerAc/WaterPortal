package edu.hhu.portal.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class ST extends Model<ST>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static ST dao = new ST();
	
	public List<ST> findAll(){
		String sql = "select * from WP_ST";
		return find(sql);
	}
}
