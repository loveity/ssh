package com.test.shopping.dao;




import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.test.shopping.dao.impl.UserDaoImpl;
import com.test.shopping.domain.User;
import com.test.shopping.page.PageList;
import com.test.shopping.query.UserQuery;
import com.test.shopping.service.impl.UserServiceImpl;

/**
 * @author JUST-GO
 * 一个测试类
 */
public class UserDaoTest {
	IUserDao dao = new UserDaoImpl();
	@Test
	public void testSave() {
		User queryOne = dao.queryOne(1L);
		queryOne.setUsername("ww001");
		queryOne.setPassword("000");
		dao.save(queryOne);
	}

	@Test
	public void testUpdate() {
		User user = dao.queryOne(18L);
		user.setPassword(DigestUtils.md5Hex("000"));
		dao.update(user);
		
	}

	@Test
	public void testDelete() {
		dao.delete(3L);
	}

	@Test
	public void testQueryOne() {
//		String password ="123";
//		System.out.println(DigestUtils.md5Hex(password));
		
		User one = dao.queryOne(19L);
		System.out.println(one);
	}

	@Test
	public void QueryAll() {
		UserQuery query=new UserQuery();
//		query.setKeyWords("小");
//		List<User> all = dao.queryAll(query);
//		System.out.println(all);
		PageList<User> list = dao.queryList(query);
		System.out.println(list.getDataList());
	}
	@Test
	public void testList() throws Exception {
//		PageList<User> list = dao.queryList(null);
//		System.out.println(list);
		
		UserServiceImpl userdao = new UserServiceImpl();
		userdao.login("小乔");
	}

}
