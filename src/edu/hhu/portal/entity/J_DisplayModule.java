package edu.hhu.portal.entity;

import java.util.List;

public class J_DisplayModule {
	String id;
	String name;
	String service;
	String type;
	String size;
	String lvl;
	String disnum;
	String disid;
	String pictype;
	List<J_News> newss;
	
	public J_DisplayModule(String i_id, String i_name, String i_service, String i_type, String i_size, String i_lvl, String i_disnum, String i_disid, String i_pictype){
		this.id = i_id;
		this.name = i_name;
		this.service = i_service;
		this.type = i_type;
		this.size = i_size;
		this.lvl = i_lvl;
		this.disnum = i_disnum;
		this.disid = i_disid;
		this.pictype = i_pictype;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public String getDisnum() {
		return disnum;
	}
	public void setDisnum(String disnum) {
		this.disnum = disnum;
	}
	public String getDisid() {
		return disid;
	}
	public void setDisid(String disid) {
		this.disid = disid;
	}
	public String getPictype() {
		return pictype;
	}
	public void setPictype(String pictype) {
		this.pictype = pictype;
	}
	public List<J_News> getNewss() {
		return newss;
	}
	public void setNewss(List<J_News> newss) {
		this.newss = newss;
	}
}
