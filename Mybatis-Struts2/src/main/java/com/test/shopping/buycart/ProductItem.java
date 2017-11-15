package com.test.shopping.buycart;

import com.test.shopping.domain.Product;

/**
 * @author JUST-GO
 * 这是一个物品类：里面封装了很多的物品的信息
 */
public class ProductItem {
	/**
	 * product就是一个商品
	 * 封装了名字，价格，生产地等所有的信息
	 */
	private Product product;
	/**
	 * number 就是商品的数量
	 */
	private Integer num;
	public Product getProduct() {
		return product;
	}
	public Integer getNum() {
		return num;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setNum(Integer number) {
		this.num = number;
	}
	

}
