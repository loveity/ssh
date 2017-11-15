package com.test.shopping.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.test.shopping.dao.IUserDao;
import com.test.shopping.dao.impl.UserDaoImpl;
import com.test.shopping.domain.User;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.service.IUserService;

public class UserServiceImpl implements IUserService {
	//中转参照
	IUserDao dao = new UserDaoImpl();

	@Override
	public void save(User obj) {
		
		dao.save(obj);
	}

	@Override
	public void update(User obj) {
		
		dao.update(obj);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public User queryOne(Long id) {
		return dao.queryOne(id);
	}

	@Override
	public List<User> queryAll(IBaseQuery query) {
		
		return dao.queryAll(query);
	}

	@Override
	public PageList<User> queryList(IBaseQuery query) {
		
		return dao.queryList(query);
	}

	@Override
	public void upAndDown(Long id) {
		
	}


	@Override
	public User login(String username) {
		User user = dao.Login(username);
		
		return user;
	}

	@Override
	public void isUpName(Long id) {
		
		if (id !=null) {
			User user = dao.queryOne(id);
			if (user.getStatus()) {
				user.setStatus(false);
			}else{
				user.setStatus(true);
			}
			dao.update(user);
		}
		
	}

	@Override
	public void updatePassword(String password, Long id) {
		/*
		 *根据id查询到对象后进行修改密码
		 */
		User user = dao.queryOne(id);
		user.setPassword(DigestUtils.md5Hex(password));
		//修改后进行修改数据库
		dao.update(user);
	}
}
