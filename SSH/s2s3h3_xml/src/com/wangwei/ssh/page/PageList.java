package com.wangwei.ssh.page;

import java.util.ArrayList;
import java.util.List;


/**
 * @author JUST-GO
 *  分页
 */
public class PageList<T> {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalPage;
	private Integer totalCount;
	private Integer endPage;
	private Integer firstPage;
	private Integer nextPage;
	private Integer lastPage;
	public PageList(){}
	
	List<T> dataList= new ArrayList<T>();
	
	public PageList(Integer pageSize,Integer currentPage,Integer totalCount){
		this.pageSize=pageSize;
		this.currentPage=currentPage;
		this.totalCount=totalCount;
		this.totalPage=this.totalCount%this.pageSize>0?this.totalCount/this.pageSize+1:this.totalCount/this.pageSize;
		this.endPage=this.totalPage;
		this.firstPage=1;
		this.nextPage=this.currentPage+1>this.endPage?this.endPage:this.currentPage+1;
		this.lastPage=this.currentPage-1<1?this.firstPage:this.currentPage-1;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public Integer getFirstPage() {
		return firstPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public List<T> getDataList() {
		return dataList;
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

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "PageList [pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", endPage=" + endPage + ", firstPage=" + firstPage + ", nextPage="
				+ nextPage + ", lastPage=" + lastPage + "]";
	}
	

}
