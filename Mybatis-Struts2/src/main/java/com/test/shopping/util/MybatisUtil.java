package com.test.shopping.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author JUST-GO
 *  这是活动SqlSession的一个工具类
 */
public enum MybatisUtil {
	INSTANCE;
	private static SqlSessionFactory factory;
	static{
		try {
			factory = new SqlSessionFactoryBuilder().
			build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  SqlSession getSqlSession(){
		return factory.openSession();
	}
	
}
