package com.test.shopping.web_befor.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.test.shopping.buycart.BuyCart;
import com.test.shopping.buycart.ProductItem;
import com.test.shopping.domain.Product;
import com.test.shopping.service.IProductService;
import com.test.shopping.service.impl.ProductServiceImpl;
import com.test.shopping.web.action.BaseAction;

@SuppressWarnings("serial")
public class BuyCartAction extends BaseAction {
	
	private Long id;
	IProductService service= new ProductServiceImpl();
	
	ProductItem  item  = new ProductItem();
	
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String save(){
		Product product = service.queryOne(id);
		System.out.println("购物车的对象"+product);//看看是否查到对象
		
		//拿到对应的购物车对象（封装到session中）
		Map<String, Object> session = ActionContext.getContext().getSession();
		BuyCart buyCart =(BuyCart)session.get("CART_IN_SESSION");
		if (buyCart==null) {
			buyCart= new BuyCart();
			session.put("CART_IN_SESSION", buyCart);//放置到session当中
		}
		item.setProduct(product);
		item.setNum(1);
		buyCart.save(item);
		
		return RELOAD;
	}
	public String delete(){
		/*
		 * 根据有id
		 */
		BuyCart buyCart = (BuyCart) ActionContext.getContext().getSession().get("CART_IN_SESSION");
		buyCart.delete(id);
		
		return RELOAD;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductItem getItem() {
		return item;
	}

	public void setItem(ProductItem item) {
		this.item = item;
	}


	
}
