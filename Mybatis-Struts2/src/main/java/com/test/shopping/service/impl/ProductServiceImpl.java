package com.test.shopping.service.impl;

import java.util.Date;
import java.util.List;

import com.test.shopping.dao.IProductDao;
import com.test.shopping.dao.impl.ProductDaoImpl;
import com.test.shopping.domain.Product;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.query.ProductQuery;
import com.test.shopping.service.IProductService;

public class ProductServiceImpl implements IProductService {
	//中转参照
	IProductDao dao = new ProductDaoImpl();
	@Override
	public void save(Product obj) {
		obj.setInputTime(new Date());
		//设置浏览次数
		obj.setViewTimes(0);
		dao.save(obj);

	}

	@Override
	public void update(Product obj) {
		if (obj!=null) {
			
			dao.update(obj);
		}
		

	}

	@Override
	public void delete(Long id) {
		dao.delete(id);

	}

	@Override
	public Product queryOne(Long id) {
		
		return dao.queryOne(id);
	}

	@Override
	public List<Product> queryAll(IBaseQuery query) {
		return dao.queryAll(query);
	}

	@Override
	public PageList<Product> queryList(IBaseQuery query) {
		return dao.queryList(query);
	}

	/**
	 * 设置一个方法进行修改上下架
	 * 根据Id进行修改：
	 */
	@Override
	public void upAndDown(Long id){
		//根据id查询到对象
		if (id!=null) {
			Product product = dao.queryOne(id);//查询到对象给对象进行修改状态
			product.setStatus(1-product.getStatus());//修改状态
			//再将对象修改到数据库
			dao.update(product);
		}
	}

	@Override
	public void isRecommend(Long id) {
		if (id!=null) {
			Product product = dao.queryOne(id);
			System.out.println("对象"+product);
			if (product.getRecommended()) {
				product.setRecommended(false);
			}else{
				product.setRecommended(true);
			}
			//再将对象进行更改
			dao.update(product);
		}
		
	}

	@Override
	public List<Product> queryBestProduct(Integer num, String ordername ,String oredrType) {
		ProductQuery query= new ProductQuery();
		query.setPageSize(num);
		query.setOrderByName(ordername);//根据申明名字进行排序
		query.setOrderType(oredrType);
		return dao.queryAll(query);
	}
}
