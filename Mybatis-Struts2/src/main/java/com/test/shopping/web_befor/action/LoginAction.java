package com.test.shopping.web_befor.action;

import java.util.Date;
import java.util.Map;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.test.shopping.domain.User;
import com.test.shopping.service.IUserService;
import com.test.shopping.service.impl.UserServiceImpl;
import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 *  这是前台的登录界面
 */
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	//当用户登录的时候会上传用户名和密码。我们接受后进行判断
	private String username;
	private String password;
	//需要new一个userservice的对象
	IUserService service  = new UserServiceImpl();
	private String code;//验证码
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	private Map<String, Object> session;
	

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		
		//这里是将接收到的参数进行传递到服务层再调用数据层进行查询出结果返回
		User user = service.login(username);
		System.out.println(user);
		if (user==null) {
			//说明没有这个用户就需要返回到登录界面，并给出提示(错误信息保存到值栈当中)
			putContext("userNameError", "用户名错误");
			return LOGIN;
		}else{
			String code2 = (String)ActionContext.getContext().getSession().get("SESSION_SECURITY_CODE");
			//判断密码：是否相等
			System.out.println(code2);
			if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
				putContext("passwordError", "密码错误了");
				return LOGIN;
			}else if(!code2.equals(code)){//判断验证码是否相等
				putContext("codeError", "验证码错误了");
				return LOGIN;
			}else {
				ActionContext.getContext().getSession().put("USER_IN_SESSION", user);
				//下面就是判断登录成功了：就可以设置一些值
				user.setLastLoginTime(user.getLoginTime());
				user.setLoginTime(new Date());//登录时间就是一个当前时间
				
				user.setLastLoginIp(user.getLoginIp());
				//当前登录的ip是：
				user.setLoginIp(ServletActionContext.getRequest().getLocalAddr());
				
				//最后需要更新user。再进行登录成功跳转
				service.update(user);
				return SUCCESS;
			}
		}
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	
}
