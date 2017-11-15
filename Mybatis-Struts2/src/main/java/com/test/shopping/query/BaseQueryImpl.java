package com.test.shopping.query;

import org.apache.commons.lang3.StringUtils;

public class BaseQueryImpl  implements IBaseQuery{

	//需要设置三个参数将参数传给分页的对象
	private Integer pageSize =5;
	//默认为1前台传过来
	private Integer currentPage =1;
	@SuppressWarnings("unused")
	private Integer indexBegin=0;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	//这里需要计算索引,在分页的时候需要用
	public Integer getIndexBegin() {
		if (pageSize!=null&& currentPage!=null) {
			return (currentPage-1)*pageSize;
		}
		return null;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setCurrentPage(Integer currentPage) {
		if (currentPage==null) {
			currentPage=1;
		}
		this.currentPage = currentPage;
	}
	
	/**
	 * 根据产品的最新上架和浏览次数进行查询
	 */
	
	private String orderType;//升序和jiang
	private String orderByName;//按照申明类型进行排序
	private String getOrder;//这是浏览次数最多的
	
	//提供一个方法可以进行结果排序
	

	public String getGetOrder() {
		if (!StringUtils.isBlank(orderByName)) {
			
			return "order by"+" "+orderByName+" "+orderType;
		}
		return "";
	}
	public String getOrderType() {
		return orderType;
	}
	public String getOrderByName() {
		return orderByName;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}
	
	

}
