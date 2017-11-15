package com.test.shopping.web_befor.action;

import org.apache.commons.lang3.StringUtils;

import com.test.shopping.service.IUserService;
import com.test.shopping.service.impl.UserServiceImpl;
import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 * 这是一隔注册的action
 */
@SuppressWarnings("serial")
public class SignAction extends BaseAction {
	
	IUserService userService = new UserServiceImpl();
	
	String repassword;
	String password;
	String username;
	String email;
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String  addUser(){
		if (StringUtils.isBlank(username)) {
			return SUCCESS;
		}
		if (!repassword.equals(password)) {
			return SUCCESS;
		}
		
		return "signsuccess";
	}
	
	/**
	 * 这里是接受参数数。
	 * @return
	 */

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
