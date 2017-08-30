package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Fincanceled {

	private String fid;
	private String fnum;
	private String type;
	private String serial;
	private String applyname;
	private String jnum;
	private String projectname;
	private String status;
	private BigDecimal money;
	private String cardnum;
	private String cardname;
	private String cardtype;
	private Date applydate;
	private String comment;
	private String imgPath;

	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPaht) {
		this.imgPath = imgPaht;
	}
	public Fincanceled(){
		
	}
	public Fincanceled(Finance f) {
		this.fid = f.getFid();
		this.fnum = f.getFnum();
		this.type = f.getType();
		this.serial = f.getSerial();
		this.applyname = f.getApplyname();
		this.jnum = f.getJnum();
		this.projectname = f.getProjectname();
		this.status = f.getStatus();
		this.money = f.getMoney();
		this.cardnum = f.getCardnum();
		this.cardname = f.getCardname();
		this.cardtype = f.getCardtype();
		this.applydate = f.getApplydate();
		this.comment = f.getComment();
	}

	public Fincanceled(Financing f) {
		this.fnum = f.getFnum();
		this.type = f.getType();
		this.serial = f.getSerial();
		this.applyname = f.getApplyname();
		this.jnum = f.getJnum();
		this.projectname = f.getProjectname();
		this.status = f.getStatus();
		this.money = f.getMoney();
		this.cardnum = f.getCardnum();
		this.cardname = f.getCardname();
		this.cardtype = f.getCardtype();
		this.applydate = f.getApplydate();
		this.comment = f.getComment();
		this.imgPath = f.getImgPath();
	}
	public Fincanceled(String fid, String fnum, String type, String serial, String applyname, String jnum,
			String projectname, String status, BigDecimal money, String cardnum, String cardname, String cardtype,
			Date applydate, String comment) {
		//super();
		this.fid = fid;
		this.fnum = fnum;
		this.type = type;
		this.serial = serial;
		this.applyname = applyname;
		this.jnum = jnum;
		this.projectname = projectname;
		this.status = status;
		this.money = money;
		this.cardnum = cardnum;
		this.cardname = cardname;
		this.cardtype = cardtype;
		this.applydate = applydate;
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getApplyname() {
		return applyname;
	}

	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}

	public String getJnum() {
		return jnum;
	}

	public void setJnum(String jnum) {
		this.jnum = jnum;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Fincanceled(String fid, String fnum, BigDecimal money, Date applydate) {
		//super();
		this.fid = fid;
		this.fnum = fnum;
		this.money = money;
		this.applydate = applydate;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFnum() {
		return fnum;
	}

	public void setFnum(String fnum) {
		this.fnum = fnum;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

}