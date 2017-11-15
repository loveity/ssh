package com.test.shopping.service.impl;

import java.util.List;

import com.test.shopping.dao.IProductDirDao;
import com.test.shopping.dao.impl.ProductDirDaoImpl;
import com.test.shopping.domain.ProductDir;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.query.ProductDirQuery;
import com.test.shopping.service.IProductDirService;

public class ProductDirServiceImpl implements IProductDirService {
	//中转参照
	IProductDirDao dao = new ProductDirDaoImpl();

	@Override
	public void save(ProductDir obj) {
		
		dao.save(obj);
	}

	@Override
	public void update(ProductDir obj) {
		dao.update(obj);
	}

	@Override
	public void delete(Long id) {
		System.out.println(id);
		dao.delete(id);
	}

	@Override
	public ProductDir queryOne(Long id) {
		return dao.queryOne(id);
	}

	@Override
	public List<ProductDir> queryAll(IBaseQuery query) {
		return dao.queryAll(query);
	}

	@Override
	public PageList<ProductDir> queryList(IBaseQuery query) {
		PageList<ProductDir> list = dao.queryList(query);
		return list;
	}

	@Override
	public void upAndDown(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isRecommend(Long id) {
		
	}

	@Override
	public List<ProductDir> queryProductDirNum(Integer num) {
		ProductDirQuery query =new ProductDirQuery();
		query.setPageSize(num);//查询13条数据
		//查询总共13条数据
		return dao.queryAll(query);
		
	}

}
