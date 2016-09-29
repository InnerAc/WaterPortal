package edu.hhu.portal.entity;

public class J_News {
	String id;
	String title;
	String author;
	String date;
	String content;
	
	public J_News(String i_id,String i_title,String i_author,String i_date,String i_content){
		this.id = i_id;
		this.title = i_title;
		this.author = i_author;
		this.date = i_date;
		this.content = i_content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
