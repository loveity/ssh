<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 编辑用户 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/styles/main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
		div#title{
		text-align: center;
		color: red;
	}
</style>
</head>
<body>
<h1>
    <span class="action-span"><a href="group_goodsList">用户列表</a>
    </span>
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 编辑用户 </span>
    <div style="clear:both"></div>
</h1>

<div id="title">
	<h2>欢迎你,尊敬的：${USER_IN_SESSION.username}</h2>
</div>

<div class="tab-div">
    <div id="tabbar-div">
        <p>
            <span class="tab-front" id="general-tab">通用信息</span>
        </p>
    </div>
    <div id="tabbody-div">
       <s:form action="/system/modif_modifPassword" method="post" theme="simple" >
            <table width="90%" id="general-table" align="center">
            	 <tr>
                    <td class="label">原始密码： </td>
                    <td>
                    	<s:password  name="oldPassword" />
                    	<span class="require-field"><s:property value="#oldPasswordErro"/></span>
                    </td>
                </tr>
                <tr>
                    <td class="label">新密码： </td>
                    <td>
                    	<s:password  name="newPassword" />
                    	
                    	<span class="require-field"><s:property value="#passwordErro"/></span>
                    	<span class="require-field"><s:property value="#newPasswordErro"/></span>
                    	
                    </td>
                </tr>
                <tr>
                    <td class="label">确认新密码： </td>
                    <td>
                    	<s:password  name="rePassword" />
                    	<span class="require-field"><s:fielderror name="passwordErro"/></span>
                    </td>
                </tr>
               
                
            </table>
            <div class="button-div">
                <input type="submit" value=" 确定 " class="button" onclick="javascript:return confirm('是否确认修改')"/>
                <input type="reset" value=" 重置 " class="button" />
            </div>
        </s:form>
    </div>
</div>

</body>
</html>