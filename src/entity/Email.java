package entity;

import java.util.Date;

public class Email {
	private String eid;
	private String uid;
	private String title;
	private String content;
	private Date date;
	
	
	
	public Email(String eid, String uid, String title, String content, Date date) {
		//super();
		this.eid = eid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public final String getEid() {
		return eid;
	}
	public final void setEid(String eid) {
		this.eid = eid;
	}
	public final String getUid() {
		return uid;
	}
	public final void setUid(String uid) {
		this.uid = uid;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final Date getDate() {
		return date;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	
	
}
