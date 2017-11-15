package com.test.shopping.page;

import java.util.ArrayList;
import java.util.List;


/**
 * @author JUST-GO
 *  这是一个分页的类：
 */
public class PageList<T> {
	//三个参数需要查询对象传来
	private Integer currentPage;
	private Integer totalCount;
	private Integer pageSize;
	
	private Integer lastPage;
	private Integer nextPage;
	private Integer totalPage;
	private Integer endPage;
	
	//增加2个属性（y用于记录每页的记录索引）（开始默认为0）
	private Integer beginIndexPage=0;
	private Integer endIndexPage;
	
	
	
	public Integer getBeginIndexPage() {
		return beginIndexPage;
	}

	public Integer getEndIndexPage() {
		return endIndexPage;
	}

	public void setBeginIndexPage(Integer beginIndexPage) {
		this.beginIndexPage = beginIndexPage;
	}

	public void setEndIndexPage(Integer endIndexPage) {
		this.endIndexPage = endIndexPage;
	}


	List<T> dataList = new ArrayList<T>();
	
	public PageList(List<T> dataList,Integer currentPage,Integer pageSize,Integer totalCount){
		this.dataList=dataList;
		this.currentPage=currentPage;
		this.pageSize=pageSize;
		this.totalCount=totalCount;;
		//下面的参数需要计算
		this.totalPage=this.totalCount%this.pageSize>0?this.totalCount/this.pageSize+1:
			this.totalCount/this.pageSize;
		this.endPage=this.totalPage;
		this.lastPage=this.currentPage-1<=0?1:this.currentPage-1;
		this.nextPage=this.currentPage+1>=this.endPage?this.endPage:this.currentPage+1;
		//将这2个索引进行赋值操作
		 PageIndex pageIndex = PageIndex.getPageIndex(4, currentPage, totalPage);//活动的一个对象
		this.beginIndexPage=pageIndex.getBeginIndex();//获得开始的索引号
		this.endIndexPage=pageIndex.getEndIndex();
	}
	
	public PageList(){}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setCurrentPage(Integer currentPage) {
		if (currentPage==null) {
			currentPage=1;
		}
		
		this.currentPage = currentPage;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	

	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", totalCount="
				+ totalCount + ", pageSize=" + pageSize + ", lastPage="
				+ lastPage + ", nextPage=" + nextPage + ", totalPage="
				+ totalPage + ", endPage=" + endPage 
				+ "]";
	}
	
}
