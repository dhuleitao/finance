package interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import action.UsersAction;


public class MyInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object user = ActionContext.getContext().getSession().get("cur_user");
		if (user != null ) {
			return invocation.invoke();
		} else {
			System.out.println("unloin:illegal access."); 
			return "unlogin";
		}
	}

}