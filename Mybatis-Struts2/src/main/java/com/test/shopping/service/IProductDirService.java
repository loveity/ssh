package com.test.shopping.service;

import java.util.List;

import com.test.shopping.domain.ProductDir;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;

/**
 * 这是一个service层：
 * 具体根据业务需求定义方法--中转作用
 * @author JUST-GO
 * 
 */
public interface IProductDirService {
	/**
	 * 查询分类中的13条数据
	 * @param num
	 */
	List<ProductDir> queryProductDirNum(Integer num);

	/**
	 * 保存功能:需要参数obj
	 * @param obj
	 */
	void save(ProductDir obj);
	/**
	 * 修改操作
	 * @param obj
	 */
	void update(ProductDir obj);
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
	ProductDir queryOne(Long id);
	/**
	 * 查询所有
	 * @param query
	 * @return
	 */
	List<ProductDir> queryAll(IBaseQuery query);
	/**
	 * 分页和查询
	 * @param query
	 * @return
	 */
	PageList<ProductDir> queryList(IBaseQuery query);
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
