<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 编辑商品分类分类 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="#">商品分类列表</a>
    </span>
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 编辑商品分类 </span>
    <div style="clear:both"></div>
</h1>

<div class="tab-div">
    <div id="tabbar-div">
        <p>
            <span class="tab-front" id="general-tab">通用信息</span>
        </p>
    </div>
    <div id="tabbody-div">
       <s:form action="/system/productdir_edit" method="post" theme="simple" enctype="multipart/form-data">
            <table width="90%" id="general-table" align="center">
            	<tr>
            		<td><s:hidden  name="productdir.id" /></td>
            	</tr>
                <tr>
                    <td class="label">商品分类名称：</td>
                    <td><s:textfield name="productdir.name" ></s:textfield >
                    </td>
                </tr>
                <tr>
                    <td class="label">商品分类英文名称：</td>
                    <td><s:textfield name="productdir.englishName" ></s:textfield >
                    </td>
                </tr>
                <tr>
                    <td class="label">商品分类简单描述：</td>
                    <td><s:textarea name="productdir.intro"></s:textarea></td>
                </tr>
            </table>
            <div class="button-div">
                <input type="submit" value=" 确定 " class="button"/>
                <input type="reset" value=" 重置 " class="button" />
            </div>
        </s:form>
    </div>
</div>

</body>
</html>