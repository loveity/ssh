package com.test.shopping.web_after.action;


import com.test.shopping.domain.ProductDir;
import com.test.shopping.page.PageList;
import com.test.shopping.query.ProductDirQuery;
import com.test.shopping.service.IProductDirService;
import com.test.shopping.service.impl.ProductDirServiceImpl;
import com.test.shopping.web.action.BaseAction;

/** 
 * 这是一个productdir的action：里面有很多方法
 * @author JUST-GO
 *
 */
public class ProductDirAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private ProductDir productdir =new ProductDir();
	IProductDirService  service = new ProductDirServiceImpl();
	
	//查询分页：封装一个查询对象
	ProductDirQuery  query = new ProductDirQuery();
	
	@Override
	public String execute() throws Exception {
		
		
		putContext("dirs", service.queryAll(query));
		
		PageList<ProductDir> list  = service.queryList(query);
		
		putContext("page", list);
		
		return SUCCESS;
	}
	
	
	public String edit(){
		
		if (productdir.getId()!=null) {
			service.update(productdir);
		}else{
			service.save(productdir);
		}
		
		return RELOAD;
		
	}
	public String input(){
		System.out.println(productdir.getId());
		putContext("dirs", service.queryAll(query));
		if (productdir.getId()!=null) {
			
			productdir= service.queryOne(productdir.getId());
		}
		
		return INPUT;
		
	}
	public String delete(){
		System.out.println("------"+productdir.getId());
		
		if (productdir.getId()!=null) {
			System.out.println("-------执行？、");
			service.delete(productdir.getId());
		}
		return RELOAD;
		
	}
	
	public String isUp(){
		if (productdir.getId()!=null) {
			
//			service.isUpName(productdir.getId());
		}
		return RELOAD;
	}
	
	/**
	 *  提供get方法。productdir可以接受参数和传递参数
	 * @return
	 */

	public ProductDir getProductdir() {
		return productdir;
	}


	public void setProductdir(ProductDir productdir) {
		this.productdir = productdir;
	}


	public ProductDirQuery getQuery() {
		
		return  query;
	}

	public void setQuery(ProductDirQuery query) {
		this.query = query;
	}
	
	
}
