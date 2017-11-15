package com.test.shopping.query;


/**
 * @author JUST-GO
 *  这是一个查询对象的封装
 */
public class UserQuery extends BaseQueryImpl implements IBaseQuery{
	//只需要根据关键字进行查询
	
	private String keyWords;

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		
		this.keyWords = keyWords;
	}
	
	
}
