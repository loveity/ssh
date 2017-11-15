package com.test.shopping.dao;


import java.util.List;

import org.junit.Test;

import com.test.shopping.dao.impl.ProductDirDaoImpl;
import com.test.shopping.domain.ProductDir;
import com.test.shopping.page.PageList;
import com.test.shopping.query.ProductDirQuery;

/**
 * @author JUST-GO
 * 一个测试类
 */
public class ProductDirDaoTest {
	IProductDirDao dao = new ProductDirDaoImpl();
	@Test
	public void testSave() {
		ProductDir queryOne = dao.queryOne(3L);
		queryOne.setName("蓝宝石闪亮亮");
		dao.save(queryOne);
	}

	@Test
	public void testUpdate() {
		ProductDir prd = dao.queryOne(14L);
		prd.setEnglishName("helloJava");
		prd.setName("你哈Java");
		dao.update(prd);
		
	}

	@Test
	public void testDelete() {
		dao.delete(16L);
	}

	@Test
	public void testQueryOne() {
		
		ProductDir one = dao.queryOne(2L);
		System.out.println(one);
	}

	@Test
	public void testQueryAll() {
		ProductDirQuery query =new ProductDirQuery();
		query.setPageSize(13);
//		query.setKeywords("石");
//		query.setName("翡翠原石");
		List<ProductDir> all = dao.queryAll(query);
		
//		PageList<ProductDir> list = dao.queryList(query);
//		System.out.println(list.getDataList());
		for (ProductDir prd : all) {
			System.out.println(prd);
		}
	}

}
