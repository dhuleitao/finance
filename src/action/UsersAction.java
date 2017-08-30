package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Admins;
import entity.Financing;
import entity.Fincanceled;
import entity.Finfailed;
import entity.Users;
import service.FinanceDAO;
import service.FinsuccessAdminDAO;
import service.QueryService;
import service.UsersDAO;
import service.impl.FinanceDAOImpl;
import service.impl.FinsuccessAdminDAOImpl;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	public String auto() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		QueryService queryService = new QueryService();
		out.write(queryService.queryByCommand(request.getParameter("content")));
		out.flush();
		out.close();
		return "toApply_success";
	}
	public String talk() throws IOException {
		
		return "talk_success";
	}
	public String login() {
		System.out.println("UsersAction.login;");

		if (myValidate() == false)
			return "login_failed";
		UsersDAO udao = new UsersDAOImpl();
		if (session.getAttribute("cur_user") != null) {
			return "login_repeat";
		}
		if (udao.usersLogin(user)) {
			session.setAttribute("cur_user", (Users) udao.queryUserInfo(user));
			session.setAttribute("today", new Date(System.currentTimeMillis()));

			FinanceDAO fdao = new FinanceDAOImpl();
			String jnum = ((Users) session.getAttribute("cur_user")).getJnum();
			String hql = "from Financing where jnum='" + jnum + "'";
			@SuppressWarnings("rawtypes")
			List list = (List) fdao.query(hql);
			if (list != null) {
				session.setAttribute("financing_count", list.size());
			}
			return "login_success";
		} else if (udao.adminsLogin(user)) {
			System.out.println("UsersAction.admin;");
			session.setAttribute("cur_user", (Admins) udao.queryAdminsInfo(user));
			session.setAttribute("today", new Date(System.currentTimeMillis()));
			FinsuccessAdminDAO fdao = new FinsuccessAdminDAOImpl();
			String hql = "from Financing";
			@SuppressWarnings("rawtypes")
			List list = (List) fdao.queryAllFining();
			session.setAttribute("list_size", list.size());
			return "login_admin_success";
		} else {
			this.addFieldError("loginError", "用户名密码错误！");
			return "login_failed";
		}
	}

	@SkipValidation
	public String logout() {
		System.out.println("UsersAction.logout");
		if (session.getAttribute("cur_user") != null) {
			session.removeAttribute("cur_user");
		}
		return "logout_success";
	}

	public String gohome() {

		System.out.println("UsersAction.gohome().");
		System.out.println("url changed.");
		return "gohome_success";
	}

	public String toApply() {
		System.out.println("UsersAction.toPWD().");
		return "toApply_success";
	}

	@SuppressWarnings("rawtypes")
	public String toInfo() throws Exception {
		System.out.println("UsersAction.modify.");
		System.out.println("UsersAction.modify() return modify_success");
		try {
			user = (Users)((List) new FinanceDAOImpl()
					.query("from Users where jnum='" + ((Users) session.getAttribute("cur_user")).getJnum() + "'")).get(0);
			session.setAttribute("cur_user",user);
		} catch (Exception e) {
			return "exception";
		}
		return "toInfo_success";
	}

	public String toPwd() {
		System.out.println("UsersAction.toPWD().");
		return "toPwd_success";
	}

	public String update() throws Exception {
		System.out.println("UsersAction.update.");
		Users u = (Users) session.getAttribute("cur_user");

		u.setPhone(request.getParameter("phone"));
		u.setEmail(request.getParameter("email"));
		UsersDAO udao = new UsersDAOImpl();
		if (udao.updateUsers(u)) {
			session.setAttribute("update_message", "success");
			session.removeAttribute("cur_user");
			session.setAttribute("cur_user", u);
			return "update_success";
		} else {
			session.setAttribute("update_message", "修改失败！");
			return "update_failed";
		}
	}

	public String changePwd() {
		Users u = (Users) session.getAttribute("cur_user");
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
		UsersDAO udao = new UsersDAOImpl();
		if (udao.updateUsers(u)) {
			session.setAttribute("changePWD_message", "success");
			session.removeAttribute("cur_user");
			return "changePwd_success";
		} else {
			session.setAttribute("changePWD_message", "修改失败！");
			return "changePwd_failed";
		}

	}

	private boolean myValidate() {
		System.out.println("UsersAction.validate");
		String key = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String input = request.getParameter("r");
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("loginError", "请输入用户名！");
			return false;
		}
		if (user.getPassword().length() < 1) {
			this.addFieldError("loginError", "请输入密码！");
			return false;
		}
		if (input != null && input.isEmpty()) {
			this.addFieldError("loginError", "请输入验证码！");
			return false;
		}
		if (input != null && !input.equals(key)) {
			this.addFieldError("loginError", "验证码错误！");
			return false;
		}
		return true;
	}

	@Override
	public Users getModel() {

		return this.user;
	}

}
