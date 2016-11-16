package edu.hhu.portal.model;

import com.jfinal.plugin.activerecord.Model;

public class ServiceMap extends Model<ServiceMap>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static ServiceMap dao = new ServiceMap();
	public String serviceByService(String service){
		ServiceMap sm = findById(service);
		String resservice = sm.getStr("SM_TAR");
		if(service == null || service.equals("")){
			resservice = service;
		}
		return resservice;
	}
}
