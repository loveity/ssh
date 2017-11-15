package com.test.shopping.query;

/**
 * @author JUST-GO
 * 查询的公用接口：规范
 * 可以抽取分页和查询
 */
public interface IBaseQuery {
	/**
	 * 需要抽取对应的方法
	 * @return
	 */
	Integer getCurrentPage();
	/**
	 * 需要在impl进行获得
	 */
	Integer getPageSize();
	
	
	
}
