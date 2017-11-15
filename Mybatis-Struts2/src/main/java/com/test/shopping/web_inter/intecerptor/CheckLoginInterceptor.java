package com.test.shopping.web_inter.intecerptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.test.shopping.domain.User;


/**
 * @author JUST-GO
 * 拦截器：当用户登录的时候，进行拦截
 */
public class CheckLoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 拿到session判断是否为空
		User user = (User) ActionContext.getContext().getSession().get("USER_IN_SESSION");
		if (user==null) {
			//为空时就返回登录界面
			return Action.LOGIN;
		}
		//就放行
		return invocation.invoke();
	}


}
