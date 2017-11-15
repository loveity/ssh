<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心 - 用户列表 </title>
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
    <span class="action-span1"><a href="__GROUP__">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 用户列表 </span>
    <div style="clear:both"></div>
</h1>
<div id="title">
	<h2>欢迎你,尊敬的：${USER_IN_SESSION.username}</h2>
</div>
<!-- 这里是设置查询的条件的 -->
<div class="form-div">
    <form action="/system/user" name="searchForm" id="searchForm">
    	<input type="hidden" name="query.currentPage" id="query.currentPage"/>
        <img src="/images/icon_search.gif" width="26" height="22" border="0" alt="search" />
        
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
                <th>用户名称 </th>
                <th>密码</th>
                <th>email</th>
                <th>用户的类别</th>
                <th>账号状态</th>
                <th>上一次的登陆时间</th>
                <th>上一次的登陆IP</th>
                <th>登陆的时间</th>
                 <th>操作</th>
            </tr>
            <s:iterator value="#page.dataList" var="u">
            <tr>
                <td align="center"><s:property value="username"/></td>
                <td align="center"><s:property value="password"/></td>
                <td align="center"><s:property value="email"/></td>
                <td align="center">
                	<s:if test="type==0">
               			 超级管理员 
                	</s:if>
                	<s:elseif test="type==1">
                		管理员 
                	</s:elseif>
                	<s:else>
                		用户
                	</s:else>
                </td>
                <td align="center">
	                <a href="/system/user_isUp?user.id=<s:property value='#u.id'/>">
	                	<s:if test="status">
	                		启用<img src="/images/yes.gif "/>
	                	</s:if>
	                	<s:else>
	            			    禁用<img src="/images/no.gif "/>
	                	</s:else>
	                </a>
                </td>
                <td align="center"><s:date name="lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/></td>
                <td align="center"><s:property value="lastLoginIp"/></td>
                <td align="center"><s:date name="loginTime" format="yyyy-MM-dd HH:mm:ss"/></td>
                <td align="center">
                <a href="/system/user_showOne?user.id=<s:property value='#u.id'/>" target="_blank" title="查看"><img src="/images/icon_view.gif" width="16" height="16" border="0" /></a>
                <a href="/system/user_input?user.id=<s:property value='#u.id'/>" title="编辑"><img src="/images/icon_edit.gif" width="16" height="16" border="0" /></a>
                <a href="/system/user_delete?user.id=<s:property value='#u.id'/>" onclick="javascript:return confirm('亲，你那么愿意删除我？')" title="回收站"><img src="/images/icon_trash.gif" width="16" height="16" border="0" /></a></td>
            </tr>
            </s:iterator>
        </table>
        
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

    </div>
</form>

</body>
</html>