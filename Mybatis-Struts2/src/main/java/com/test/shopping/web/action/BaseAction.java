package com.test.shopping.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author JUST-GO
 * 这是一个继成ActionSupport的类
 * 可以抽取和设置一些常用属性
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	protected final static String RELOAD = "reload";
	
	public void putContext(String key,Object obj){
		//将一些信息放到值栈当中，同时也可以取出
		ActionContext.getContext().put(key, obj);
	}
}
