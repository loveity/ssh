<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/styles/general.css" rel="stylesheet" type="text/css" />
<link href="/styles/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function shows(ele){
		ele.src="/Security/SecurityCodeImageAction?num="+Math.random();
	}
	
	if (window.top!=window) {
		window.top.location.href=window.location.href;
	}
	
	
</script>

</head>
<body style="background: #278296;color:white">

<s:form action="login_execute"  method="post"  theme="simple">
    <table cellspacing="0" cellpadding="0" style="margin-top:100px" align="center">
        <tr>
            <td>
                <img src="/images/login.png" width="178" height="256" border="0" alt="ECSHOP" />
            </td>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>管理员姓名：</td>
                        <td>
                        <s:textfield name="username"></s:textfield>
                        <s:property value="#userNameError"/>
                        </td>
                    </tr>
                    <tr>
                        <td>管理员密码：</td>
                        <td>
                        	<s:password  name="password"></s:password>
                        	<span class="require-field"><s:property value="#passwordError"/></span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>验证码</td>
                        <td>
                        <s:textfield name="code"></s:textfield> </td>
                       <td> 
                       <img alt="没有图片" src="/Security/SecurityCodeImageAction" style="cursor: pointer;" onclick="shows(this)">
                        <s:property value="#codeError"/>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="进入管理中心" class="button" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    
</s:form>
</body>