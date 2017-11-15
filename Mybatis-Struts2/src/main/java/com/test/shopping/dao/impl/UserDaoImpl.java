package com.test.shopping.dao.impl;





import com.test.shopping.dao.IUserDao;
import com.test.shopping.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	/**
	 * 这里就是直接继承那个抽象类(需要定义泛型)：实现User接口：
	 * 有一个登录的方法
	 */
	@Override
	public User Login(String username) {
		
		return super.queryOne("com.test.shopping.domain.UserMapper.login", username);
		
	}
}
