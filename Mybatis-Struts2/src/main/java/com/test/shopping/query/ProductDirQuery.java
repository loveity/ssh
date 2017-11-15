package com.test.shopping.query;


/**
 * @author JUST-GO
 *  这是一个查询对象的封装
 */
public class ProductDirQuery extends BaseQueryImpl implements IBaseQuery{
	
	private String name;//根据名字进行查询
	private String englishName;//根据名字进行查询
	private String keywords;//根据关键字.
	
	public String getName() {
		return name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@Override
	public String toString() {
		return "ProductDirQuery [name=" + name + ", englishName=" + englishName
				+ ", keywords=" + keywords + "]";
	}
	
}
