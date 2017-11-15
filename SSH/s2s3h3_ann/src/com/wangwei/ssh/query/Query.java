package com.wangwei.ssh.query;


/**
 * @author JUST-GO
 * 分页对象的操作
 */
public class Query {
	
	private Integer pageSize=4;
	private Integer currentPage=1;
	
	@SuppressWarnings("unused")
	private Integer indexbegin=0;
	
	public void setIndexbegin(Integer indexbegin) {
		this.indexbegin = indexbegin;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getCurrentPage() {
		
		return currentPage;
	}
	public Integer getIndexbegin() {
		
		return (currentPage-1)*pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setCurrentPage(Integer currentPage) {
		if (currentPage==null) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}
	
	

}
