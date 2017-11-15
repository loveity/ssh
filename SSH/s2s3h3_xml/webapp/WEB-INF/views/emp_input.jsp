<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<s:form  action="employee_save"  method="post">
		<s:hidden name="employee.id"/>
		<s:textfield  name="employee.name" label="姓名"/>
		<s:textfield   name="employee.salary" label="工资"/>
		<s:radio  name="employee.sex" list="%{#{true:'男',false:'女'}}" label="性别"/>
		<s:select list="#alldept" name="employee.dept.id" listKey="id" listValue="name" headerKey="-1" headerValue="---请选择---"/>
		<s:submit value="提交"/>
	</s:form>

</body>
</html>