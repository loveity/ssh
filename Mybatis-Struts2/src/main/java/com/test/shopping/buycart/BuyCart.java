package com.test.shopping.buycart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author JUST-GO
 *  这是一个购物车类
 *  里面会封装很多的商品
 */
public class BuyCart {
	
	List<ProductItem> datdaList =new ArrayList<ProductItem>();
	/**
	 *  这是保存方法。需要将物品保存到购物车当中
	 * @param newItem 代表需要保存的心物品
	 */
	public void save(ProductItem newItem){
		/*
		 * 遍历结合id相同的就相加数量
		 */
		for (ProductItem item : datdaList) {
			if (item.getProduct().getId().equals(newItem.getProduct().getId())) {
				item.setNum(item.getNum()+newItem.getNum());
				return;
			}
		}
		datdaList.add(newItem);
	}
	
	
	/**
	 * 进行删除操作
	 * @param id 传入物品的id
	 */
	public void delete(Long id){
		//获得迭代器
		Iterator<ProductItem> iterator = datdaList.iterator();
		while (iterator.hasNext()) {
			
			ProductItem item =  iterator.next();
			if (item.getProduct().getId().equals(id)) {
				iterator.remove();
				return;
			}
		}
	}
	
	/**
	 * 获得总的市场价
	 * @return
	 */
	
	public Double getTotalPrice(){
		Double sum =0D;
		for (ProductItem item : datdaList) {
			sum +=item.getNum() * item.getProduct().getSalePrice().doubleValue();
		}
		
		return sum;
	}
	
	/**
	 * 获得总的市场价
	 * @return
	 */
	
	public Double getTotalMarketPrice(){
		Double sum1 =0D;
		for (ProductItem item : datdaList) {
			sum1 +=item.getNum() * item.getProduct().getMarketPrice().doubleValue();
		}
		
		return sum1;
	}


	public List<ProductItem> getDatdaList() {
		return datdaList;
	}


	public void setDatdaList(List<ProductItem> datdaList) {
		this.datdaList = datdaList;
	}
	
	
	
}
