package action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.struts2.ServletActionContext;

import bean.Message;

import com.opensymphony.xwork2.ModelDriven;

import dao.MessageDao;
import service.AdminsDAO;
import service.FinsuccessAdminDAO;
import service.MaintainService;
import service.QueryService;
import service.UsersDAO;
import service.impl.AdminsDAOImpl;
import service.impl.FinsuccessAdminDAOImpl;
import service.impl.UsersDAOImpl;
import entity.Admins;
import entity.Admins;
import entity.Finsuccess;
import entity.Users;

public class AdminsAction extends SuperAction implements ModelDriven<Users> {
	private static final long serialVersionUID = 1L;
	private Admins adm = new Admins();
	public String pdff() throws IOException, RowsExceededException, WriteException {
		 String fname = "Finance";
		 Admins a = (Admins) session.getAttribute("cur_user");
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
	        
	        FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
			String hql = "from Finsuccess";
			@SuppressWarnings("rawtypes")
			List list = (List) fdao.queryAllFinsuccess();
			 Label xuexiao = new Label(0,0,"学校");
		        sheet.addCell(xuexiao);
		        Label zhuanye = new Label(1,0,"专业");
		        sheet.addCell(zhuanye);
		        Label jingzhengli = new Label(2,0,"专业竞争力");
		        sheet.addCell(jingzhengli);
		        
		        Label qinghua = new Label(0,1,"清华大学");
		        sheet.addCell(qinghua);
		        Label jisuanji = new Label(1,1,"计算机专业");
		        sheet.addCell(jisuanji);
		        Label gao = new Label(2,1,"高");
		        sheet.addCell(gao);
		        
		        Label beida = new Label(0,2,"北京大学");
		        sheet.addCell(beida);
		        Label falv = new Label(1,2,"法律专业");
		        sheet.addCell(falv);
		        Label zhong = new Label(2,2,"中");
		        sheet.addCell(zhong);
		        
		        Label ligong = new Label(0,3,"北京理工大学");
		        sheet.addCell(ligong);
		        Label hangkong = new Label(1,3,"航空专业");
		        sheet.addCell(hangkong);
		        Label di = new Label(2,3,"低");
		        sheet.addCell(di);

				  //把创建的内容写入到输出流中，并关闭输出流
		        workbook.write();
		        workbook.close();
		        os.close();
				session.setAttribute("temp_list", list);
				hql = "from Financing";
				@SuppressWarnings("rawtypes")
				List lis = (List) fdao.queryAllFining();
				session.setAttribute("list_size", lis.size());
			
				return "ppp";
			}
			
	        
	        
	     
	        
	      
	        

	       
	
	public String auto() throws Exception {
		  HttpServletRequest req=ServletActionContext.getRequest(); 
		  HttpServletResponse resp=ServletActionContext.getResponse(); 
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		out.write(queryService.queryByCommand(req.getParameter("content")));
		out.flush();
		out.close();
		return "talk";
	}
	
	public String listmm() throws Exception {
		// 设置编码
				request.setCharacterEncoding("UTF-8");
				// 接受页面的�?
			
				
		
						
				QueryService listService = new QueryService();
				// 查询消息列表并传给页�?
				request.setAttribute("messageList", listService.queryMessageListByPage());
				// 向页面传�?
			
				return "listmm_success";
	}
	public String addMes() throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("add");
		MessageDao messageDao= new MessageDao();
		Message mm=new Message();
		mm.setCommand(request.getParameter("command"));
		mm.setContent(request.getParameter("content"));
		mm.setDescription(request.getParameter("description"));
		messageDao.addMess(mm);
		return listmm();
	}
	public String updatemess() throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("add");
		String id = request.getParameter("id");
		
		MessageDao messageDao= new MessageDao();
		Message mm=messageDao.queryone(Integer.valueOf(id));
		session.setAttribute("cur_message", mm);
		return "update_ss";
	}
	public String updatemm() throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("add");
	//	String id = request.getParameter("id");
		Message mm=(Message)session.getAttribute("cur_message");
		 String id =mm.getId();
		Map<String,Object> parameter = new HashMap<String, Object>();
	
		mm.setCommand(request.getParameter("command"));
		
		mm.setContent(request.getParameter("content"));
		
		mm.setDescription(request.getParameter("description"));
		parameter.put("message", mm);
		parameter.put("id", Integer.valueOf(id));
		MessageDao messageDao= new MessageDao();
	     messageDao.updatem(parameter);
		return listmm();
	}
	public String deone() throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("deleteone");
		String id = request.getParameter("id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteOne(id);
		return listmm();
	}
	public String debatch() throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("deleteone");
		String[] ids = request.getParameterValues("id");
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(ids);
		return listmm();
	}
	public String update() throws Exception {
		System.out.println("AdminsAction.update.");
		Admins u = (Admins) session.getAttribute("cur_user");
		adm.setUid(u.getUid());
		String str = request.getParameter("jnum") + request.getParameter("name") + request.getParameter("phone");
		adm.setJnum(request.getParameter("jnum"));
		adm.setGender(request.getParameter("gender"));
		adm.setName(request.getParameter("name"));
		adm.setDepartment(request.getParameter("department"));
		adm.setPhone(request.getParameter("phone"));
		adm.setEmail(request.getParameter("email"));
		adm.setUsername(u.getUsername());
		adm.setPassword(u.getPassword());
		adm.setStatus(u.getStatus());
		AdminsDAO udao = new AdminsDAOImpl();
		if (udao.updateAdmin(adm)) {
			session.removeAttribute("cur_user");
			session.setAttribute("cur_user", adm);
			return "update_success";
		} else {
			return "update_failed";
		}
	}
	
	
	public String changePassword() throws Exception {
		System.out.println("AdminsAction.update.");
		Admins u = (Admins) session.getAttribute("cur_user");
		/*adm.setUid(u.getUid());
		String str = request.getParameter("jnum") + request.getParameter("name") + request.getParameter("phone");
		adm.setJnum(u.getJnum());
		adm.setGender(u.getGender());
		adm.setName(u.getName());
		adm.setDepartment(u.getDepartment());
		adm.setPhone(u.getPhone());
		adm.setEmail(u.getEmail());
		adm.setUsername(u.getUsername());
		adm.setPassword(request.getParameter("password"));
		adm.setStatus(u.getStatus());*/
		String cur_p = (u).getPassword();
		String p0 = (String) request.getParameter("p0");
		String p1 = (String) request.getParameter("p1");
		String p2 = (String) request.getParameter("p2");
		if (p0 == null || p1 == null || p2 == null || p0.isEmpty() || p1.isEmpty() || p2.isEmpty()) {
			this.addFieldError("pswError", "请将信息填写完整");
			return "changePwd_failed";
		}
		if (!p0.equals(cur_p)) {
			this.addFieldError("pswError", "原密码错误");
			return "changePwd_failed";
		}
		if (!p1.equals(p2)) {
			this.addFieldError("inputError", "新密码输入不一致");
			return "changePwd_failed";
		}
		if (p1.equals(cur_p)) {
			this.addFieldError("pswError", "新密码和原密码相同");
			return "changePwd_failed";
		}
		u.setPassword(p1);
		AdminsDAO udao = new AdminsDAOImpl();
		if (udao.updateAdmin(u)) {
			session.removeAttribute("cur_user");
			session.setAttribute("cur_user", adm);
			return "changePwd_success";
		} else {
			return "changePwd_failed";
		}
	}
	public String toInfo() throws Exception {
		System.out.println("UsersAction.modify.");
		System.out.println("UsersAction.modify() return modify_success");
		return "toInfoadmins_success";
	}
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
