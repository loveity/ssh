package com.wangwei.ssh.query;


/**
 * @author JUST-GO
 * 分页对象的操作
 */
public class Query {
	
	private Integer pageSize=4;
	private Integer currentPage=1;
	
	private Integer indexbegin=0;
	
	
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getCurrentPage() {
		
		return currentPage;
	}
	public Integer getIndexbegin() {
		return (this.currentPage-1)*this.pageSize;
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
