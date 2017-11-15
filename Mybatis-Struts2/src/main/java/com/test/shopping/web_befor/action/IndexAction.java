package com.test.shopping.web_befor.action;


import java.util.List;

import com.test.shopping.domain.Product;
import com.test.shopping.service.IProductDirService;
import com.test.shopping.service.IProductService;
import com.test.shopping.service.impl.ProductDirServiceImpl;
import com.test.shopping.service.impl.ProductServiceImpl;
import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 * 这是前台页面的索引文件
 */
@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
	//这里需要定义变量
	IProductDirService proService = new ProductDirServiceImpl();
	IProductService service =new ProductServiceImpl();
	
	@Override
	public String execute() throws Exception {
		
		putContext("dirs", proService.queryProductDirNum(13)); //放到值栈当中
		
		putContext("newProduct", service.queryBestProduct(8, "inputTime", "DESC")); //放到值栈当中
		putContext("hotProduct", service.queryBestProduct(8, "viewTimes", "DESC")); //放到值栈当中
		
		putContext("newList", service.queryBestProduct(1, "inputTime", "DESC"));
		putContext("hotList",service.queryBestProduct(1, "viewTimes", "DESC"));
		return SUCCESS;
	}
	
	public String getBestHot(){
		
		
		return SUCCESS;
	}
	
	public  String top() {
		
		
		return "top";
	}
	public  String footer() {
		
		return "footer";
	}
	
	
	

}
