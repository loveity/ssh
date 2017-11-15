package com.test.shopping.dao;


import java.util.List;

import org.junit.Test;

import com.test.shopping.dao.impl.ProductDaoImpl;
import com.test.shopping.domain.Product;
import com.test.shopping.page.PageList;
import com.test.shopping.query.BaseQueryImpl;
import com.test.shopping.query.ProductQuery;

/**
 * @author JUST-GO
 * 一个测试类
 */
public class ProductDaoTest {
	IProductDao dao = new ProductDaoImpl();
	@Test
	public void testSave() {
//		Product queryOne = (Product) dao.queryOne(3L);
		BaseQueryImpl query = new ProductQuery();
//		query.setOrderByName("inputTime");
//		query.setOrderType("DESC");
//		query.setPageSize(8);
//		query.setStatus(1);
		query.setPageSize(null);
		List<Product> all = dao.queryAll(query);
		
		for (Product product : all) {
			String pic = product.getSmallPic();
			product.setBigPic(pic);
			System.out.println(product);
			dao.save(product);
		}
	}

	@Test
	public void testUpdate() {
		Product product = (Product) dao.queryOne(198L);
		product.setName("蓝宝石VS红宝石");
		product.setPlace("大中国");
		dao.update(product);
		
	}

	@Test
	public void testDelete() {
		dao.delete(100L);
	}

	@Test
	public void testQueryOne() {
		
		Product one = (Product) dao.queryOne(43L);
		System.out.println(one);
	}

	@Test
	public void testQueryAll() {
		BaseQueryImpl query = new ProductQuery();
//		query.setOrderByName("inputTime");
//		query.setOrderType("DESC");
//		query.setPageSize(8);
//		query.setStatus(1);
		query.setPageSize(null);
		List<Product> all = dao.queryAll(query);
		
		for (Product product : all) {
			String pic = product.getSmallPic();
			product.setBigPic(pic);
			System.out.println(product);
		}
	}
	@Test
	public void testQueryList() {
		PageList<Product> page=new PageList<Product>(); 
		
		ProductQuery query = new ProductQuery();
		page = dao.queryList(query);
		System.out.println(page);
	}
}
