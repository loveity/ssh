package com.test.shopping.web_after.action;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.test.shopping.dao.IProductDirDao;
import com.test.shopping.dao.impl.ProductDirDaoImpl;
import com.test.shopping.domain.Product;
import com.test.shopping.domain.ProductDir;
import com.test.shopping.page.PageList;
import com.test.shopping.query.IBaseQuery;
import com.test.shopping.query.ProductQuery;
import com.test.shopping.service.IProductService;
import com.test.shopping.service.impl.ProductServiceImpl;
import com.test.shopping.web.action.BaseAction;

import net.coobird.thumbnailator.Thumbnails;


@SuppressWarnings("serial")
public class ProductAction extends BaseAction {
	
	IProductService dao = new ProductServiceImpl();
	Product product = new Product();
	
	public void setProduct(Product product) {
		this.product = product;
	}
	//将对象放到值栈当中：
	public Product getProduct() {
		return product;
	}
	
	IBaseQuery query = new ProductQuery();
	
	PageList<Product> page = new PageList<Product>();
	
	public PageList<Product> getPage() {
		return page;
	}
	ProductDir dir = new ProductDir();
	//需要查询对象
	//拿到对应的分类集合。放到map当中。需要的是在当进行添加和修改跳转的时候就添加
	IProductDirDao pirDao= new ProductDirDaoImpl();

	
	@Override
	public String execute() throws Exception {
		putContext("dirs", pirDao.queryAll(null));
		 page = dao.queryList(query);
		 
		 System.out.println(page.getDataList());
		putContext("page", page);
		//默认会跳转到登录页面（就是显示页面）
		return SUCCESS;
	}
	
	
	@Override
	public String input(){
		putContext("dirs", pirDao.queryAll(null));
		if (product.getId()!=null) {
			//查找到id
			product = dao.queryOne(product.getId());
		}
		return INPUT;
	}
	public String delete(){
		if (product.getId()!=null) {
			dao.delete(product.getId());
		}
		return RELOAD;
	}
	
	/**上传图片。进行修改和添加
	 * 贴一个标签：防止页面乱输入参数
	 * @return
	 * @throws Exception
	 */
	private File productImage;
	private String productImageFileName;//是图片的后缀名
	private String productImageContentType;//图片的类型
	
	@InputConfig(methodName="input")
	public String edit() throws Exception{
		//接收到参数：就进行设置：
		//得到了图片进行设置：
		System.out.println("怎么回事--"+product);
		if (productImage!=null) {
			String uuidName = UUID.randomUUID().toString().substring(1, 6);
			System.out.println(uuidName);
			//获得后缀名
			String later = FilenameUtils.getExtension(productImageFileName);
			System.out.println(later);
			//进行拼接：
			String bigImage=uuidName+"."+later;
			String smallImage=uuidName+"_small."+later;
			
			//需要将图片放到指定的位置;首先获得路径
			String path;
			path = ServletActionContext.getServletContext().getRealPath("/upload");
			//需要将图片读取到指定的路径和文件的名字
			File bigFile = new File(path,bigImage);//获取大图片
			
			//利用工具读取到上传的路径读取的指定的路径(项目中去)
			FileUtils.copyFile(productImage, bigFile);
			product.setBigPic("/upload/"+bigImage);
			File smallFile = new File(path,smallImage);//获取指定文件
			//小图标的操作压缩
			Thumbnails.of(bigFile).size(120, 70).toFile(smallFile);
			product.setSmallPic("/upload/"+smallImage);
		}
		if (product.getId()!=null) {
			
			dao.update(product);
		}else{
			dao.save(product);
		}
		return RELOAD;
	}
	/**
	 * 这是一个验证操作；
	 * @SkipValidation
	 * 验证名称是否为空或者其他
	 */
	public void validateEdit() {
		//判断是如果为空的话就写出一个异常放到值栈当中
		if (StringUtils.isBlank(product.getName())) {
			this.addFieldError("nameErroee", "用户名空了");
		}
	}
	
	
	//需要提供一个方法： 修改上下架
	public String upAndDown(){
		
		if (product.getId()!=null) {
			dao.upAndDown(product.getId());
		}
		return RELOAD;
	}
	
	public String isRecommend(){
		if (product.getId()!=null) {
			dao.isRecommend(product.getId());
		}
		
		return RELOAD;
	}
	public String getProductImageContentType() {
		return productImageContentType;
	}
	public void setProductImageContentType(String productImageContentType) {
		this.productImageContentType = productImageContentType;
	}
	public File getProductImage() {
		return productImage;
	}
	public String getProductImageFileName() {
		return productImageFileName;
	}
	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}
	public void setProductImageFileName(String productImageFileName) {
		this.productImageFileName = productImageFileName;
	}
	
	
	public IBaseQuery getQuery() {
		return query;
	}
	public ProductDir getDir() {
		return dir;
	}
	
	
}
