package action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import service.FinanceDAO;
import service.FinsuccessAdminDAO;
import service.impl.FinanceDAOImpl;
import service.impl.FinsuccessAdminDAOImpl;
import entity.Admins;
import entity.Financing;
import entity.Finsuccess;
import entity.Users;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FinanceAdminAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toPay() {
		try {
			@SuppressWarnings("rawtypes")
			List res = (List) new FinanceDAOImpl()
					.query("from Financing where fid='" + request.getParameter("fid") + "'");
			Financing financing = (Financing) res.get(0);
			session.setAttribute("temp_pay_project", financing.getProjectname());
			session.setAttribute("temp_pay_name", financing.getApplyname());
			session.setAttribute("temp_pay_money", financing.getMoney());
			return "alipay_page";
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		}
	}

	public String vFinsuccess() {
		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String hql = "from Finsuccess";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.queryAllFinsuccess();
		if (list != null) {
			session.setAttribute("temp_list", list);
			hql = "from Financing";
			@SuppressWarnings("rawtypes")
			List lis = (List) fdao.queryAllFining();
			session.setAttribute("list_size", lis.size());
			return "viewFinsuccess_success";
		} else
			return "no_record";
	}
	public String pFinsuccess() throws IOException, RowsExceededException, WriteException {
		 String fname = "Finance";
		 Admins a = (Admins) session.getAttribute("cur_user");
		    OutputStream os = response.getOutputStream();//ȡ?????
		    response.reset();//??????
		    
		    //???????ļ???Ĵ???
		    response.setCharacterEncoding("UTF-8");//???Ӧ???ı??ʽ
		    fname = java.net.URLEncoder.encode(fname,"UTF-8");
		    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
		    response.setContentType("application/msexcel");//?????????
		    WritableWorkbook workbook = Workbook.createWorkbook(os);
	        //????????ҳ
	        WritableSheet sheet = workbook.createSheet("First Sheet",0);
	        //????Ҫ?ʾ????????һ????Ԫ?񣬵???????Ϊ????꣬?ڶ??????Ϊ???꣬????????Ϊ??
	        Label xuexiao = new Label(0,0,"????);
	        sheet.addCell(xuexiao);
	        Label zhuanye = new Label(1,0,"???);
	        sheet.addCell(zhuanye);
	        Label jingzhengli = new Label(2,0,"??Ʊ");
	        sheet.addCell(jingzhengli);
	        Label x = new Label(3,0,"??");
	        sheet.addCell(x);
	        Label z = new Label(4,0,"????);
	        sheet.addCell(z);
	        Label j = new Label(5,0,"?Ŀ");
	        sheet.addCell(j);
	        Label xu = new Label(6,0,"??");
	        sheet.addCell(xu);
	        Label zh = new Label(7,0,"????);
	        sheet.addCell(zh);
	        Label ji = new Label(8,0,"???");
	        sheet.addCell(ji);
	        Label dates = new Label(9,0,"??");
	        sheet.addCell(dates);
	        Label zhuan = new Label(10,0,"??ע");
	        sheet.addCell(zhuan);
	        Label jingzheng = new Label(11,0,"״̬");
	        sheet.addCell(jingzheng);
	        Label ren = new Label(12,0,"????);
	        sheet.addCell(ren);
	        FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
			String hql = "from Finsuccess";
			@SuppressWarnings("rawtypes")
			List list = (List) fdao.queryAllFinsuccess();
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
				        jingzheng = new Label(11,i,"??????);
				        sheet.addCell(jingzheng);
				        ren = new Label(12,i,a.getName());
				        sheet.addCell(ren);
					 ii++;
					
				}
				  //?Ѵ??????????????????????ر????
		        workbook.write();
		        workbook.close();
		        os.close();
				session.setAttribute("temp_list", list);
				hql = "from Financing";
				@SuppressWarnings("rawtypes")
				List lis = (List) fdao.queryAllFining();
				session.setAttribute("list_size", lis.size());
			
				return "ppp";
			} else
				return "ppp";
			
	        
	        
	     
	        
	      
	        
	      
		/*FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String hql = "from Finsuccess";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.queryAllFinsuccess();
		if (list != null) {
			session.setAttribute("temp_list", list);
			hql = "from Financing";
			@SuppressWarnings("rawtypes")
			List lis = (List) fdao.queryAllFining();
			session.setAttribute("list_size", lis.size());
			return "viewFinsuccess_success";
		} else
			return "no_record";*/
	       
	}
	public String vFinfail() {

		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String hql = "from Finfailed";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.queryAllFinfail();
		if (list != null) {
			session.setAttribute("temp_list", list);
			hql = "from Financing";
			@SuppressWarnings("rawtypes")
			List lis = (List) fdao.queryAllFining();
			session.setAttribute("list_size", lis.size());
			return "viewFinfail_success";
		} else
			return "no_record";
	}

	public String vFining() {

		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String hql = "from Financing";
		@SuppressWarnings("rawtypes")
		List list = (List) fdao.queryAllFining();
		if (list != null) {
			session.setAttribute("temp_list", list);
			session.setAttribute("list_size", list.size());
			return "viewFining_success";
		} else
			return "no_record";
	}

	public String Fin() {
		String pass = request.getParameter("pass");
		Admins a = (Admins) session.getAttribute("cur_user");
		if(pass==null){
			session.setAttribute("fin_message", "???֧??????");
			return "alipay_page";
		}
		if (!pass.equals(a.getPassword())) {
			session.setAttribute("fin_message", "֧???????);
			return "alipay_page";
		}
		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String fid = request.getParameter("fid");
		if (fdao.finIt("Financing", fid, "Finsuccess")) {
			session.setAttribute("fin_message", "success");
			return vFining();
		} else
			return "success_failed";
	}

	public String Finfail() {
		System.out.print("zzz11111zzzz");
		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String fid = session.getAttribute("bohui").toString();
		String comment = request.getParameter("comment");
		@SuppressWarnings("rawtypes")
		List lis = (List) fdao.queryAllFining();
		session.setAttribute("list_size", lis.size());
		System.out.print(comment);
		try {
			if (fdao.movee("Financing", fid, comment, "Finfailed"))
				return vFining();
			else
				return "success_failed";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "exception";
		} finally {

		}
	}

	public String Finfail2() {
		System.out.print("zzz11111zzzz");
		FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
		String hql = "from Financing";
		@SuppressWarnings("rawtypes")
		List lis = (List) fdao.queryAllFining();
		session.setAttribute("list_size", lis.size());
		String fid = request.getParameter("fid");
		session.setAttribute("bohui", fid);
		return "tiaozhuan";
	}
}
