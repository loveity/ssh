package com.test.shopping.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.shopping.dao.IBaseDao;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.util.MybatisUtil;

/**
 * @author JUST-GO
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
	
		private Class<?> clz;
		//需要定义是哪个文件解决硬编码
		public BaseDaoImpl(){
			//利用泛型拿到对象得到里面的类型遍历得到。再强转成calss
			Type type = this.getClass().getGenericSuperclass();//返回一个类型
			//进行强转：里面不只一个
			ParameterizedType paty = (ParameterizedType)type;
			//调用方法得到数组
			Type[] types = paty.getActualTypeArguments();
			//需要转成class对象
			clz=(Class<?>)types[0];
		}
	
	
	@Override
	public void save(T obj) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			session.insert(clz.getName()+"Mapper.save",obj);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void update(T obj) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			session.update(clz.getName()+"Mapper.update",obj);
			session.commit();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void delete(Serializable id) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			session.delete(clz.getName()+"Mapper.delete",id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public T queryOne(Serializable id) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			return session.selectOne(clz.getName()+"Mapper.queryOne",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	/**
	 * 这里是根据用户的名字进行查询到是否有这个用户
	 * @param name
	 * @param key
	 * @return
	 */
	public T queryOne(String mapper,Serializable key) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			return session.selectOne(mapper,key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public List<T> queryAll(IBaseQuery query) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			return session.selectList(clz.getName()+"Mapper.queryAll",query);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public PageList<T> queryList(IBaseQuery query) {
		SqlSession session = MybatisUtil.INSTANCE.getSqlSession();
		try {
			Integer totalCount = session.selectOne(clz.getName()+"Mapper.count",query);
			//这是分页查询到的所有对象
			List<T> list = session.selectList(clz.getName()+"Mapper.queryList",query);
			
			return new PageList<T>(list, query.getCurrentPage(), query.getPageSize(), totalCount);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
