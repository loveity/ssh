<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 商品列表 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/styles/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function pagechange(page){
		document.getElementById("query.currentPage").value=page;
		//再进行提交
		document.getElementById("searchForm").submit();
	}
</script>
<style type="text/css">
	<!--设置页面标签的颜色属性等 -->
	
	#page-table a{
		/*去掉下划线*/
		text-decoration: none; 
		border: 2px solid #CCFF33;
		padding:3px;
		background-color: #9966CC;
	}
	#page-table a:HOVER {
		background-color: #FF3300;
	}
	#page-table a#no{
		background-color: white;
		color: threedshadow;
		border: none;
	}
		div#title{
		text-align: center;
		color: red;
	}
</style>

</head>

<body>
<h1>
    <span class="action-span"><a href="/system/product_input">添加新商品</a></span>
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 商品列表 </span>
    <div style="clear:both"></div>
</h1>
	<div id="title">
		<h2>欢迎你,尊敬的：${USER_IN_SESSION.username}</h2>
 </div>
	
<!-- 这里是设置查询的条件的 -->
<div class="form-div">

    <form action="/system/product" name="searchForm" id="searchForm">
    	<input type="hidden" name="query.currentPage" id="query.currentPage"/>
        <img src="/images/icon_search.gif" width="26" height="22" border="0" alt="search" />
    <!-- 根据商品类型进行 -->
        <s:select name="query.dir_id" list="#dirs" listKey="id" listValue="name"
        headerKey="-1"  headerValue="---请选择---" >
        </s:select>
        
     <!-- 根据商品的价格进行筛-->
     从<s:textfield name="query.minSalePrice" />到<s:textfield  name="query.maxSalePrice"/>
     <!-- 上下架是否 -->
     <s:select name="query.status" list='#{"0":"上架","1":"下架"}' 
     	headerKey="-1"	headerValue="---请选择---" ></s:select>
     
    <!-- 关键字 -->
    关键字 <s:textfield  name="query.keyWords" size="15"  ></s:textfield>
      <input type="submit" value=" 搜索 " class="button" />
    </form>
</div>

<!-- 商品列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>商品图片</th>
                <th>编号</th>
                <th>商品名称</th>
                <th>零售价</th>
                <th>产地</th>
                <th>商品分类名称</th>
                <th>是否上架</th>
                <th>是否推荐</th>
                <th>库存</th>
                <th>上架日期</th>
                <th>操作</th>
            </tr>
            <s:iterator value="#page.dataList" var="p">
            <tr>
                <td align="center">
                	<img alt="没有图片哦" src="<s:property value='smallPic'/>" width="50px"/>
                </td>
                <td align="center" class="first-cell"><s:property value="sn"/></td>
                <td align="center"><s:property value="name"/></td>
                <td align="center"><s:property value="salePrice"/></td>
                <td align="center"><s:property value="place"/></td>
                <td align="center"><s:property value="dir.name"/></td>
                <td align="center">
               		 <a href="/system/product_upAndDown?product.id=<s:property value='id'/>">
	                	<s:if test="status==0">
	               			 <img src="/images/yes.gif "/>
	                	</s:if>
	                	<s:else>
	                		<img src="/images/no.gif "/>
	                	</s:else>
                	</a>
                </td>
                
                <td align="center">
                	<a href="/system/product_isRecommend?product.id=<s:property value='id'/>">
	                	<s:if test="recommended">
	               			 <img src=" /images/yes.gif "/>
	                	</s:if>
	                	<s:else>
	                		<img src=" /images/no.gif "/>
	                	</s:else>
                	</a>
                </td>
                <td align="center"><s:property value="num"/></td>
                <td align="center"><s:property value="inputTime"/></td>
                <td align="center">
                <a href="" target="_blank" title="查看"><img src="/images/icon_view.gif" width="16" height="16" border="0" /></a>
                <a href="product_input?product.id=<s:property value='id'/>" title="编辑"><img src="/images/icon_edit.gif" width="16" height="16" border="0" /></a>
                <a href="product_delete?product.id=<s:property value='id'/>" onclick="javascript:return confirm('亲，你那么愿意删除我？')" title="回收站"><img src="/images/icon_trash.gif" width="16" height="16" border="0" /></a></td>
            </tr>
            </s:iterator>
        </table>

    <!-- 分页开始 -->
        <table id="page-table" cellspacing="0">
            <tr>
                <td width="80%">&nbsp;</td>
                <td align="center" nowrap="true">
                <s:if test="#page.currentPage>1">
                <a href="javascript:pagechange(1)" style="text-decoration:none">首页</a>
                	<a href="javascript:pagechange(<s:property value='#page.lastPage'/>)" style="text-decoration:none">上一页</a>
                </s:if>
                <s:else>
                	<a id="no" >首页</a>
                	<a id="no">上一页</a>
                </s:else>
                <!-- 这里需要遍历索引对象得到里面的具体数值 -->
                <s:iterator begin="#page.beginIndexPage" end="#page.endIndexPage" var="index">
                	<s:if test="#index==#page.currentPage">
                		<a id="no"><s:property value='#page.currentPage'/></a>
                	</s:if>
                	<s:else>
                		<a href="javascript:pagechange(<s:property value='#index'/>)"></a>
                		<!-- 需要让结果显示出来--><s:property value="#index" />
                	</s:else>
                </s:iterator>
                
                <s:if test="#page.currentPage <#page.endPage">
                	<a href="javascript:pagechange(<s:property value='#page.nextPage'/>)" style="text-decoration:none" >下一页</a>
                	<a href="javascript:pagechange(<s:property value='#page.endPage'/>)" style="text-decoration:none">尾页</a>
                </s:if>
                <s:else>
               		<a id="no">下一页</a>
                	<a id="no">尾页</a>
                	
                </s:else>
                	总共<s:property value='#page.totalCount'/>条记录
                	当前第<s:property value='#page.currentPage'/>页|总共<s:property value='#page.totalPage'/>页
                </td>
            </tr>
        </table>
    <!-- 分页结束 -->
    </div>
</form>

</body>
</html>