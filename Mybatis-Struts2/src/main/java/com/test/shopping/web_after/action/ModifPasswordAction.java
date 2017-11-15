package com.test.shopping.web_after.action;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.test.shopping.domain.User;
import com.test.shopping.service.IUserService;
import com.test.shopping.service.impl.UserServiceImpl;
import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 * 这是修改密码的action
 * 
 */
public class ModifPasswordAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	/**
	 * 需要定义：三个变量
	 * oldPassword -旧密码
	 * newPassword-新密码
	 * rePassword-确认新密码
	 */
	private String oldPassword;
	private String newPassword;
	private String rePassword;
	
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	/**
	 * 需要接收上传的参数：拿到session中的用户密码，进行比较和修改
	 * 
	 */
	
	@InputConfig(methodName="execute")
	public String modifPassword(){
		
		//修改前需要进行判断密码：
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("USER_IN_SESSION");
		Long id= user.getId();
		session.remove("USER_IN_SESSION");//删除session中的用户再进行跳转
		service.updatePassword(newPassword, id);
		
		return LOGIN;//登录修改成功之后需要调回登录界面
	}
	/**
	 * 
	 * 这是一个验证的方法。验证修改时需要的判断
	 */
	public void validateModifPassword() {
		//拿到对应的session,从里面取密码后进行判断
		User use = (User) ActionContext.getContext().getSession().get("USER_IN_SESSION");
		if (!use.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
			this.addFieldError("oldPasswordErro", "旧密码错误了，亲");
			return;
		}
		if (StringUtils.isBlank(newPassword)) {
			this.addFieldError("newPasswordErro", "新密码为空");
			return;
		}
		if (!newPassword.equals(rePassword)) {
			this.addFieldError("passwordErro", "新密码不一致了");
			return;
		}
		
	}
	
	public String getOldPassword() {
		return oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
}
