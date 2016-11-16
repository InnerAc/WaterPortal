package edu.hhu.portal.model;

import com.jfinal.plugin.activerecord.Model;

public class USER extends Model<USER>{

	private static final long serialVersionUID = 1L;
	public final static USER dao = new USER();
	
	public USER selectById(String uid){
		try {
			return findById(uid);
		} catch (Exception e) {
			return null;
		}
	}
}
