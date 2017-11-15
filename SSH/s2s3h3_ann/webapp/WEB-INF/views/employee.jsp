<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的员工</title>
<script type="text/javascript">
	function pageChange(page){
		document.getElementById("currentPage").value=page;
		document.getElementById("myform").submit();
	}
</script>
</head>
<body>
<s:form  id="myform" action="employee">
<s:hidden  name="query.currentPage" id="currentPage"/>
	<table border="1px" width="400px">
	  <tr align="center">
	    <th>Id</th> 
	    <th>姓名</th>
	    <th>性别</th>
	    <th>工资</th>
	    <th>部门</th>
	    <th>操作</th>
	  </tr>
	  <s:iterator value="#queryList.dataList" >
		  <tr align="center">
		    <td>${id}</td>
		    <td>${name}</td>
		    <td>${sex?"男":"女"}</td>
<%-- 		    <td>${sex}</td> --%>
		    <td>${salary}</td>
		    <td>${dept.name}</td>
		    <td>
		    	<a href="employee_input?employee.id=${id}">修改</a>|
		    	<a href="employee_delete?employee.id=${id}">删除</a>
		    </td>
		  </tr>
	  </s:iterator>
	  <tr>
	  	<td colspan="6">
	  		 <a href="javascript:pageChange(1)">首页</a>
	  		 <a href="javascript:pageChange(${queryList.endPage})"> 尾页</a>
	  		 <a href="javascript:pageChange(${queryList.lastPage})"> 上一页</a>
	  		 <a href="javascript:pageChange(${queryList.nextPage})">下一页</a>
	  		
	  		当前第<s:property value="#queryList.currentPage"/>页|总共<s:property value="#queryList.totalPage"/>页 
	  	</td>
	  </tr>
	</table>
</s:form>
	<a href="employee_input">添加</a>

</body>
</html>