package com.test.shopping.dao;

import java.io.Serializable;
import java.util.List;

import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;

/**
 * @author JUST-GO
 * 父接口：具有增删改的功能
 */
public interface IBaseDao<T> {
	
	void save(T obj);
	void update(T obj);
	void delete(Serializable id );
	T queryOne(Serializable id);
	List<T> queryAll(IBaseQuery query);
	PageList<T> queryList(IBaseQuery query);

}
