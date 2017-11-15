package com.test.shopping.service;

import java.util.List;

import com.test.shopping.domain.Product;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;

/**
 * 这是一个service层：
 * 具体根据业务需求定义方法--中转作用
 * @author JUST-GO
 * 
 */
public interface IProductService {
	List<Product> queryBestProduct(Integer num,String ordername,String oredrType);
	/**
	 * 保存功能:需要参数obj
	 * @param obj
	 */
	void save(Product obj);
	/**
	 * 修改操作
	 * @param obj
	 */
	void update(Product obj);
	/**
	 * 删除功能
	 * @param id
	 */
	void delete(Long id );
	/**
	 * 
	 * @param id
	 * @return
	 */
	Product queryOne(Long id);
	/**
	 * 查询所有
	 * @param query
	 * @return
	 */
	List<Product> queryAll(IBaseQuery query);
	/**
	 * 分页和查询
	 * @param query
	 * @return
	 */
	PageList<Product> queryList(IBaseQuery query);
	/**
	 * 上架和下架
	 * @param id
	 */
	public void upAndDown(Long id);
	
	/**
	 * 是否是需要推荐
	 * @param id
	 */
	public void isRecommend(Long id);
}
