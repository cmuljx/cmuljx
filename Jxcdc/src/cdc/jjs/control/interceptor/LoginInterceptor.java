package cdc.jjs.control.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cdc.jjs.control.action.LoginState;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 48L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�level����
		String loginState = (String)ctx.getSession().get(LoginState.LOGINSTATE);
		// ���level��Ϊnull
		if (loginState.equals("true"))
		{
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
	
}
