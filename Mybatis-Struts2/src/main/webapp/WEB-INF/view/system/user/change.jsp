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
</head>
<body>
<h1>
    <span class="action-span"><a href="/system/user">用户列表</a>
    </span>
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 编辑用户 </span>
    <div style="clear:both"></div>
</h1>

<div class="tab-div">
    <div id="tabbar-div">
        <p>
            <span class="tab-front" id="general-tab">通用信息</span>
        </p>
    </div>
    <div id="tabbody-div">
       <s:form action="/system/user_edit" method="post" theme="simple" >
       	<s:hidden name="id"></s:hidden>
            <table width="90%" id="general-table" align="center">
            <s:iterator value="#session.USER_IN_SESSION" var="e">
                    <td class="label">用户名称：</td>
                    <td><s:textfield name="username" ></s:textfield >
                    </td>
                </tr>
                <tr>
                    <td class="label">用户密码：</td>
                    <td><s:textfield name="password" ></s:textfield >
                    </td>
                </tr>
                
                  <tr>
                    <td class="label">邮箱： </td>
                    <td>
                       <s:textfield name="email" />
                </tr>  
                <tr>
                    <td class="label">用户类型：</td>
                    <td>
                    	<s:radio name="type" list="#{'0':'管理员','2':'用户'}" ></s:radio>
                    </td>
                </tr>
                <tr>
                    <td class="label">账户状态：</td>
                    <td>
                    	<s:radio name="status" list="#{'true':'启用','false':'禁用'}" ></s:radio>
                    </td>
                </tr>
            </s:iterator>
            </table>
             <div class="button-div">
                <input type="submit" value=" 确定 " class="button"/>
            </div>
        </s:form>
    </div>
</div>

</body>
</html>