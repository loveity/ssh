<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 编辑商品 </title>
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
    <span class="action-span"><a href="group_goodsList">商品列表</a>
    </span>
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 编辑商品 </span>
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
       <s:form action="/system/product_edit" method="post" theme="simple" enctype="multipart/form-data">
            		<s:hidden  name="product.id" />
            		<s:hidden  name="product.inputTime" />
            		<s:hidden  name="product.viewTimes" />
            		<s:hidden  name="product.smallPic" />
            		<s:hidden  name="product.bigPic" />
            <table width="90%" id="general-table" align="center">
            	
                <tr>
                    <td class="label">商品名称：</td>
                    <td><s:textfield name="product.name" ></s:textfield >
                    <span class="require-field"><s:property value="fieldErrors.nameErroee[0]"/></span>
                    </td>
                    
                </tr>
                <tr>
                    <td class="label">商品编号： </td>
                    <td>
                       <s:textfield name="product.sn" ></s:textfield>
                    </td>
                </tr>
                
                 <tr>
                    <td class="label">商品分类编号：</td>
                    <td>
                    	<s:select name="product.dir.id" list="#dirs" listKey="id" listValue="name">
                    	</s:select>
                        <span class="require-field">*</span>
                    </td>
                </tr>
                
                  <tr>
                    <td class="label">成本价： </td>
                    <td>
                       <s:textfield name="product.costPrice" />
                       <span class="require-field"><s:property value='fieldErrors["product.costPrice"][0]'/></span>
                    </td>
                </tr>  <tr>
                    <td class="label">零售价： </td>
                    <td>
                       <s:textfield name="product.salePrice" />
                        <span class="require-field"><s:property value='fieldErrors["product.salePrice"][0]'/></span>
                    </td>
                </tr>  <tr>
                    <td class="label">市场价： </td>
                    <td>
                       <s:textfield name="product.marketPrice" />
                        <span class="require-field"><s:property value='fieldErrors["product.marketPrice"][0]'/></span>
                    </td>
                </tr>
                 </tr>  <tr>
                    <td class="label">产地： </td>
                    <td>
                       <s:textfield name="product.place" ></s:textfield>
                    </td>
                </tr>
                
                <tr>
                    <td class="label">库存:</td>
                    <td>
                       <s:textfield name="product.num" ></s:textfield>
                        <span class="require-field"><s:property value="fieldErrors['product.num'][0]"/></span>
                    </td>
                </tr>
                    <td class="label">是否上架：</td>
                    <td>
                    	<s:radio name="product.status" list="#{'0':'上架','1':'下架'}" ></s:radio>
                    </td>
                </tr>
                </tr>
                    <td class="label">是否推荐：</td>
                    <td>
                    	<s:radio name="product.recommended" list="#{'true':'推荐','false':'不推荐'}" ></s:radio>
                    </td>
                </tr>
                <!-- 来上传图片 -->
                	</tr>
                    <td class="label">上传图片：</td>
                    <td>
                    	<s:file name="productImage" accept="image/*"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">商品简单描述：</td>
                    <td><s:textarea name="product.intro"></s:textarea></td>
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