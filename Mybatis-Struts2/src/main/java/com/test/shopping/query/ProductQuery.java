package com.test.shopping.query;


/**
 * @author JUST-GO
 *  这是一个查询对象的封装
 */
public class ProductQuery extends BaseQueryImpl implements IBaseQuery{
	
	private Long dir_id;//根据分类编号来查
	private Integer status;//根据是否上下架
	//根据零售的价格
	private Integer minSalePrice;
	private Integer maxSalePrice;//最大的价格
	//根据关键字查询
	private String keyWords;
	
	
	
	public Long getDir_id() {
		return dir_id;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getMinSalePrice() {
		return minSalePrice;
	}
	public Integer getMaxSalePrice() {
		return maxSalePrice;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setMinSalePrice(Integer minSalePrice) {
		this.minSalePrice = minSalePrice;
	}
	public void setMaxSalePrice(Integer maxSalePrice) {
		this.maxSalePrice = maxSalePrice;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	@Override
	public String toString() {
		return "ProductQuery [dir_id=" + dir_id + ", status=" + status
				+ ", minSalePrice=" + minSalePrice + ", maxSalePrice="
				+ maxSalePrice + ", keyWords=" + keyWords 
				 + "]";
	}
	
}
