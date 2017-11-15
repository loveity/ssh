package com.test.shopping.web_befor.action;

import com.test.shopping.domain.Product;
import com.test.shopping.service.IProductService;
import com.test.shopping.service.impl.ProductServiceImpl;
import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 * 这是一个显示详细信息的product action
 */
@SuppressWarnings("serial")
public class ProductDetilAction extends BaseAction {
	
	private Long id;//得到了id.进行查询物品
	IProductService service = new ProductServiceImpl();
	
	@Override
	public String execute() throws Exception {
		Product product = service.queryOne(id);
		System.out.println("--图片得到的"+product);
		putContext("product", product);
		
		return SUCCESS;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
