package com.test.shopping.web_after.action;

import com.test.shopping.web.action.BaseAction;

/**
 * @author JUST-GO
 *  这里是主界面的action
 */
@SuppressWarnings("serial")
public class IndexAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String top(){
		return "top";
	}
	public String menu(){
		return "menu";
	}
	public String main(){
		return "main";
	}
	public String footer(){
		return "footer";
	}
	
}
