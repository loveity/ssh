package com.test.shopping.dao;



import com.test.shopping.domain.User;

/**
 * @author JUST-GO
 * 一个范围数据库的dao
 * 可以对数据库进行增删改查
 */
public interface IUserDao extends IBaseDao<User>{
	/**
	 * 这里需要继承父接口：
	 */
	
	public User Login(String username) ;
}
