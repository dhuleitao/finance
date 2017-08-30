package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Admins;
import entity.Financing;
import entity.Fincanceled;
import entity.Finfailed;
import entity.Finsuccess;
import entity.Users;
import service.FinanceDAO;
import service.FinsuccessAdminDAO;
import service.impl.FinanceDAOImpl;
import service.impl.FinsuccessAdminDAOImpl;

public class FinanceAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File file;

	private String fileFileName;
	
	public String readyfin(){
		Financing fin = readForm();
		if (fin == null)
			return "applyFinance_uninput";
		fin.setFid(getNextFid("Financing"));
		fin.setStatus("正在报销");
		session.setAttribute("sFin", fin);
		return "to_upload_img";
	}

	public String applyFinance() throws IOException {
		Financing fin =(Financing) session.getAttribute("sFin");
		String imgPath = uploadFile();
		if (imgPath == null) {
			session.setAttribute("apply_message", "请上传报销凭证！");
			return "applyFinance_noproof";
		}
		fin.setImgPath(imgPath);
		FinanceDAO fdao = new FinanceDAOImpl();
		if (fdao.addFinance(fin)) {
			session.setAttribute("apply_message", "success");
			session.setAttribute("update_flag", "update");
			session.removeAttribute("temp_data");
			return "applyFinance_success";
		} else {
			return "exception";
		}
	}

	private String uploadFile() {
		InputStream is;
		OutputStream os;
		try {
			String fileName = getFileName();
			is = new FileInputStream(file);
			String savePath = request.getServletContext().getRealPath("");
			session.setAttribute("debug_savePath", savePath);
			int index = Math.max(savePath.lastIndexOf('\\'), savePath.lastIndexOf('/'));
			String des = savePath.substring(0, index) + "/Finance_upload_pics/";
			session.setAttribute("debug_path", des);
			session.setAttribute("debug_filename", fileName);
			File pic = new File(des, fileName);
			File fileParent = pic.getParentFile();
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			os = new FileOutputStream(pic);

			byte[] buffer = new byte[500];
			while (-1 != is.read(buffer, 0, buffer.length)) {
				os.write(buffer);
			}
			os.close();
			is.close();
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

		}
	}

	private String getFileName() {
		int random1 = (int) (Math.random() * 10000);
		int random2 = (int) (Math.random() * 10000);
		String s = random1 + "" + new Date().hashCode() + "" + random2
				+ fileFileName.substring(fileFileName.lastIndexOf('.'));
		return s;
	}

	public String cancel() {
		String ss = (String) session.getAttribute("ff");
		System.out.println(ss);
		String fid = (String) request.getParameter("fid");
		FinanceDAO fdao = new FinanceDAOImpl();
		String hql = "from Financing where fid='" + fid + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		Object delF = list.get(0);
		Fincanceled addF = new Fincanceled((Financing) delF);
		addF.setFid(getNextFid("Fincanceled"));
		addF.setStatus("已撤销");
		if (fdao.move(delF, addF)) {
			viewFinancing();
			session.setAttribute("global_message", "cancel_success");
			session.setAttribute("update_flag", "update");
			return "cancel_success";
		} else {
			session.setAttribute("global_message", "撤销失败，请稍后再试！");
			return "cancel_failed";
		}
	}

	public String viewFinancing() {
		System.out.println("view fining");
		FinanceDAO fdao = new FinanceDAOImpl();
		String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
		String hql = "from Financing where jnum='" + jnum + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		if (list != null) {
			session.setAttribute("temp_list", list);
			session.setAttribute("financing_count", list.size());
			return "viewFinancing_success";
		} else {
			session.removeAttribute("financing_count");
			return "no_record";
		}
	}

	public String viewFinsuccess() {
		FinanceDAO fdao = new FinanceDAOImpl();
		String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
		String hql = "from Finsuccess where jnum='" + jnum + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		if (list != null) {
			session.setAttribute("temp_list", list);
			return "viewFinsuccess_success";
		} else
			return "no_record";
	}
	public String pFinsuccess2() throws IOException, RowsExceededException, WriteException {
		 String fname = "Finance";
		
		    OutputStream os = response.getOutputStream();//取得输出流
		    response.reset();//清空输出流
		    
		    //下面是对中文文件名的处理
		    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
		    fname = java.net.URLEncoder.encode(fname,"UTF-8");
		    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
		    response.setContentType("application/msexcel");//定义输出类型
		    WritableWorkbook workbook = Workbook.createWorkbook(os);
	        //创建新的一页
	        WritableSheet sheet = workbook.createSheet("First Sheet",0);
	        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
	        Label xuexiao = new Label(0,0,"单号");
	        sheet.addCell(xuexiao);
	        Label zhuanye = new Label(1,0,"类型");
	        sheet.addCell(zhuanye);
	        Label jingzhengli = new Label(2,0,"发票");
	        sheet.addCell(jingzhengli);
	        Label x = new Label(3,0,"申请");
	        sheet.addCell(x);
	        Label z = new Label(4,0,"工号");
	        sheet.addCell(z);
	        Label j = new Label(5,0,"项目");
	        sheet.addCell(j);
	        Label xu = new Label(6,0,"金额");
	        sheet.addCell(xu);
	        Label zh = new Label(7,0,"卡号");
	        sheet.addCell(zh);
	        Label ji = new Label(8,0,"户名");
	        sheet.addCell(ji);
	        Label dates = new Label(9,0,"日期");
	        sheet.addCell(dates);
	        Label zhuan = new Label(10,0,"备注");
	        sheet.addCell(zhuan);
	        Label jingzheng = new Label(11,0,"状态");
	        sheet.addCell(jingzheng);
	        Label ren = new Label(12,0,"办理人");
	        sheet.addCell(ren);
	        FinanceDAO fdao = new FinanceDAOImpl();
			String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
			String hql = "from Finsuccess where jnum='" + jnum + "'";
			@SuppressWarnings("rawtypes")
			List list = (List) fdao.query(hql);
			Finsuccess fin=new Finsuccess();
			if (list != null) {
				int ii=0,i;
				while(ii<list.size())
				{   i=ii+1;
					fin=(Finsuccess)list.get(ii);
					
					  xuexiao = new Label(0,i,fin.getFnum());
				        sheet.addCell(xuexiao);
				         zhuanye = new Label(1,i,fin.getType());
				        sheet.addCell(zhuanye);
				         jingzhengli = new Label(2,i,fin.getSerial());
				        sheet.addCell(jingzhengli);
				        x = new Label(3,i,fin.getApplyname());
				        sheet.addCell(x);
				         z = new Label(4,i,fin.getJnum());
				        sheet.addCell(z);
				         j = new Label(5,i,fin.getProjectname());
				        sheet.addCell(j);
				        xu = new Label(6,i,fin.getMoney().toString());
				        sheet.addCell(xu);
				         zh = new Label(7,i,fin.getCardnum());
				        sheet.addCell(zh);
				        ji = new Label(8,i,fin.getCardname());
				        sheet.addCell(ji);
				         dates = new Label(9,i,fin.getApplydate().toString());
				        sheet.addCell(dates);
				         zhuan = new Label(10,i,fin.getComment());
				        sheet.addCell(zhuan);
				        jingzheng = new Label(11,i,"报销完成");
				        sheet.addCell(jingzheng);
				        ren = new Label(12,i,"管理员一号");
				        sheet.addCell(ren);
					 ii++;
					
				}
				  //把创建的内容写入到输出流中，并关闭输出流
		        workbook.write();
		        workbook.close();
		        os.close();
				
				return "ppp";
			} else
				return "ppp";
	}
			
	public String viewFinfailed() {
		FinanceDAO fdao = new FinanceDAOImpl();
		String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
		String hql = "from Finfailed where jnum='" + jnum + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		if (list != null) {
			session.setAttribute("temp_list", list);
			return "viewFinfailed_success";
		} else
			return "no_record";
	}

	public String viewFincanceled() {
		FinanceDAO fdao = new FinanceDAOImpl();
		String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
		String hql = "from Fincanceled  where jnum='" + jnum + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		if (list != null) {
			session.setAttribute("temp_list", list);
			return "viewFincanceled_success";
		} else
			return "no_record";
	}

	public String canceledRefin() {
		String fid = (String) request.getParameter("fid");
		FinanceDAO fdao = new FinanceDAOImpl();
		String hql = "from Fincanceled where fid='" + fid + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		Object delF = list.get(0);
		Financing addF = readForm();
		if (addF == null)
			return "canceledRefin_uninput";
		addF.setFid(getNextFid("Financing"));
		addF.setStatus("正在报销");
		if (file == null) {
			addF.setImgPath(((Fincanceled) delF).getImgPath());
		} else {
			addF.setImgPath(uploadFile());
			if (addF.getImgPath() == null) {
				return "exception";
			}
		}
		if (fdao.move(delF, addF)) {
			viewFinancing();
			session.setAttribute("global_message", "refin_success");
			return "canceledRefin_success";
		} else {
			session.setAttribute("apply_message", "重新申请失败，请稍后再试！");
			return "canceledRefin_failed";
		}
	}

	public String failedRefin() {
		String fid = (String) request.getParameter("fid");
		FinanceDAO fdao = new FinanceDAOImpl();
		String hql = "from Finfailed where fid='" + fid + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		Finfailed delF = (Finfailed) list.get(0);
		Financing addF = readForm();
		if (addF == null)
			return "failedRefin_uninput";
		addF.setFid(getNextFid("Financing"));
		addF.setStatus("正在报销");
		if (file == null) {
			addF.setImgPath(((Finfailed) delF).getImgPath());
		} else {
			addF.setImgPath(uploadFile());
			if (addF.getImgPath() == null) {
				return "exception";
			}
		}
		if (fdao.move(delF, addF)) {
			viewFinancing();
			session.setAttribute("global_message", "refin_success");
			return "failedRefin_success";
		} else {
			session.setAttribute("apply_message", "重新申请失败，请稍后再试！");
			return "failedRefin_failed";
		}
	}

	public String detail() {
		Object fin = null;
		FinanceDAO fdao = new FinanceDAOImpl();
		String fid = request.getParameter("fid");
		String table = request.getParameter("type");
		String hql = "from " + table + " where fid='" + fid + "'";
		if (table.equals("Financing")) {
			session.setAttribute("toWhere", "toFinancing");
		} else if (table.equals("Finsuccess")) {
			session.setAttribute("toWhere", "toFinsuccess");
		}
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		if (list.size() > 0) {
			fin = list.get(0);
		}
		if (fin != null) {
			session.setAttribute("temp_fin", fin);
			session.setAttribute("asdfg", "aaaaaaaaa");
			return "get_detail";
		}
		return "unget_detail";
	}

	public String canceledDetail() {
		FinanceDAO fdao = new FinanceDAOImpl();
		String fid = request.getParameter("fid");
		String table = request.getParameter("type");
		String hql = "from " + table + " where fid='" + fid + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		Object fin = list.get(0);
		if (fin != null) {
			session.setAttribute("temp_fin", fin);
			return "get_canceled_detail";
		} else
			return "unget_detail";
	}

	public String failedDetail() {
		FinanceDAO fdao = new FinanceDAOImpl();
		String fid = request.getParameter("fid");
		String table = request.getParameter("type");
		String hql = "from " + table + " where fid='" + fid + "'";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.query(hql);
		Object fin = list.get(0);
		if (fin != null) {
			session.setAttribute("temp_fin", fin);
			return "get_failed_detail";
		} else
			return "unget_detail";
	}

	private Financing readForm() {
		try {
			String fnum = (String) request.getParameter("fnum");
			String type = (String) request.getParameter("type");
			String serial = (String) request.getParameter("serial");
			String applyname = (String) request.getParameter("applyname");
			String jnum = (String) request.getParameter("jnum");
			String projectname = (String) request.getParameter("projectname");

			String cardnum = (String) request.getParameter("cardnum");
			String cardname = (String) request.getParameter("cardname");
			String cardtype = (String) request.getParameter("cardtype");
			String comment = request.getParameter("comment");
			String temp = request.getParameter("money");

			FormInput cache = new FormInput(fnum, type, serial, applyname, jnum, projectname, cardnum, cardname,
					cardtype, comment, temp);
			session.setAttribute("temp_data", cache);

			if ("".equals(temp) || "".equals(fnum) || "".equals(type) || "".equals(serial) || "".equals(applyname)
					|| "".equals(jnum) || "".equals(projectname) || "".equals(cardnum) || "".equals(cardname)
					|| "".equals(cardtype)) {
				session.setAttribute("apply_message", "请将信息填写完整！");
				return null;
			}
			BigDecimal money;
			try {
				money = new BigDecimal(temp);
				if (money.compareTo(new BigDecimal(1000000)) == 1) {
					session.setAttribute("apply_message", "单次最高报销1,000,000元！");
					return null;
				} else if (money.compareTo(new BigDecimal(0)) == -1) {
					session.setAttribute("apply_message", "报销金额应大于0元！");
					return null;
				}
			} catch (Exception ex) {
				session.setAttribute("apply_message", "请填写正确的申报金额！");
				return null;
			} finally {

			}

			Financing fin = new Financing("-1", fnum, type, serial, applyname, jnum, projectname, "-1", money, cardnum,
					cardname, cardtype, new Date(System.currentTimeMillis()), comment);
			return fin;
		} catch (Exception ex) {
			session.setAttribute("apply_message", "系统异常！请稍后重试！");
			return null;
		} finally {

		}
	}

	public class FormInput {
		public String fnum;
		public String type;
		public String serial;
		public String applyname;
		public String jnum;
		public String projectname;
		public String cardnum;
		public String cardname;
		public String cardtype;
		public String comment;
		public String temp;

		FormInput() {

		}

		FormInput(String fnum, String type, String serial, String applyname, String jnum, String projectname,
				String cardnum, String cardname, String cardtype, String comment, String temp) {
			this.fnum = fnum;
			this.type = type;
			this.serial = serial;
			this.applyname = applyname;
			this.jnum = jnum;
			this.projectname = projectname;
			this.cardnum = cardnum;
			this.cardname = cardname;
			this.cardtype = cardtype;
			this.comment = comment;
			this.temp = temp;
		}

		@Override
		public String toString() {
			return "FormInput [fnum=" + fnum + ", type=" + type + ", serial=" + serial + ", applyname=" + applyname
					+ ", jnum=" + jnum + ", projectname=" + projectname + ", cardnum=" + cardnum + ", cardname="
					+ cardname + ", cardtype=" + cardtype + ", comment=" + comment + ", temp=" + temp + "]";
		}

	}

	private String getNextFid(String table) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(cast(fid as int)) from " + table;
			Query query = session.createQuery(hql);
			Object res = query.uniqueResult();
			res=res!=null?res:0;
			Integer nextFid = ((Integer) res) + 1;
			tx.commit();
			return nextFid.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			if (tx != null)
				tx = null;
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
