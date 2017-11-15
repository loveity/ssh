package com.test.shopping.web_after.action;



import com.opensymphony.xwork2.ActionContext;
import com.test.shopping.domain.User;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.query.UserQuery;
import com.test.shopping.service.IUserService;
import com.test.shopping.service.impl.UserServiceImpl;
import com.test.shopping.web.action.BaseAction;

/** 
 * 这是一个user的action：里面有很多方法
 * @author JUST-GO
 *
 */
public class UserAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	User user =new User();
	IUserService  service = new UserServiceImpl();
	
	//查询分页：封装一个查询对象
	IBaseQuery  query = new UserQuery();
	
	@Override
	public String execute() throws Exception {
		
		putContext("page", service.queryList(query));
		return SUCCESS;
	}
	
	public String edit(){
		if (user.getId()!=null) {
			service.update(user);
		}else{
			service.save(user);
		}
		return RELOAD;
	}
	/**
	 * 进行判断。当用户名为空的时候，不允许提交。会自动拦截，返回一个错误提示
	 * 也可以用标签	@SkipValidation
	 */

	public String input(){
		if (user.getId()!=null) {
			user= service.queryOne(user.getId());
		}
		return INPUT;
	}
	public String delete(){
		if (user.getId()!=null) {
			service.delete(user.getId());
		}
		return RELOAD;
	}
	public String change(){
		/**
		 * 从session中拿到数据
		 */
		return "change";
	}
	
	
	/**
	 * 修改密码的方法
	 * 定义几个变量
	 * 是修改当前登录的用户的密码
	 * @return
	 */
	private String password;
	private String newpassword;
	private String newpassword1;
	
	public String getPassword() {
		return password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public String getNewpassword1() {
		return newpassword1;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
	
	
	/*public String  modif() {
		//从获得当前的session对象中的用户进行判断是否为空。不为空进行修改
		User user1 = (User) ActionContext.getContext().getSession().get("USER_IN_SESSION");
		
		if (user1!=null) {//session中user
			//判断三个变量都不为空
			if (password ==null || newpassword ==null || newpassword1==null) {
				//判断初始密码和数据库密码不等时就提示
				putContext("ApasswordError", "密码不能为空");
				return "modif";
				
			}else if(password !=null && newpassword !=null && newpassword1!=null){
				if (!user1.getPassword().equals(DigestUtils.md5Hex(password))) {
					putContext("passwordError", "初始密码不正确");
					return "modif";
				}
				if (!newpassword.equals(newpassword1)) {
					putContext("newpasswordError", "新密码不一致");
					return "modif";
				}
				//否则就进行修改
				user1.setPassword(DigestUtils.md5Hex(newpassword));
				//再修改数据库里面的
				service.update(user1);
			}
		}
		return RELOAD;
	}*/
	/**
	 * 退出操作：需要消除session中的用户
	 * 或者直接clear清楚所有
	 * @return
	 */
	public String loginOut(){
		Object object = ActionContext.getContext().getSession().get("USER_IN_SESSION");
		if (object!=null) {
			ActionContext.getContext().getSession().remove("USER_IN_SESSION");
		}
		return LOGIN;
	}
	public String isUp(){
		if (user.getId()!=null) {
			service.isUpName(user.getId());
		}
		return RELOAD;
	}
	
	/**
	 *  提供get方法。user可以接受参数和传递参数
	 * @return
	 */
	public User getUser() {
		return user;
	}

	public IBaseQuery getQuery() {
		return query;
	}

	public void setQuery(IBaseQuery query) {
		this.query = query;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
