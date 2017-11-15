<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/fc.css" rel="stylesheet" type="text/css" />
<link href="css/fc02.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

</script>
</head>

<body onload="MM_preloadImages('images/hs_03hover.jpg','images/hs_05over.jpg')">

<s:action name="index_top" namespace="/" executeResult="true" />

  <div class="main">
    <div class="mainunit01">
      <div class="main02leftadd">
      <h3>帮助中心</h3>
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>个人资料</h1>
          </div>
        <dt><a href="#">个人信息</a></dt>
        <dt><a href="#">修改密码</a></dt>
      </div>
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>消费明细</h1>
          </div>
        <dt>我的购物车</dt>
        <dt>账目明细</dt>
      </div>
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>互动社区</h1>
          </div>
        <dt><a href="#">玉友沙龙</a></dt>
        <dt><a href="#">我的留言</a></dt>
        <dt><a href="#">我的帖子</a></dt>
		<dt><a href="#">在线咨询</a></dt>
      </div>
      
      
      </div>
      <div class="main02right"><div class="m02r-top">首页 &gt; 玉品类别 &gt; 玉品类别 &gt; <font class="orange03">挂件吊坠</font></div>
      
        
        <div class="hyzc">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="60"><div align="right">用户名：</div></td>
              <td><label>
                <input name="user.username" type="text" class="fkklsj" />
              </label></td>
            </tr>
            <tr>
              <td> <div align="right">emai：</div></td>
              <td><input name="user.email" type="text" class="fkklsj" /></td>
            </tr>
            <tr>
              <td><div align="right">密码：</div></td>
              <td><input name="user.password type="text" class="fkklsj" /></td>
            </tr>
            <tr>
              <td><div align="right">确认密码：</div></td>
              <td><input name="repassword " type="text" class="fkklsj" /></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>	
             	 <a href="/sign_addUser"><img src="images/hs_03.jpg" name="Image13" width="80" height="23" border="0" id="Image13" />
              			
              	</a>
              		<a href="/sign" ><img src="images/hs_05.jpg" name="Image14" width="80" height="23" border="0" id="Image14" /></a>
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td class="zcdbc">我已经有了账号，我要<span class="lvse"><a href="/login.jsp">登录</a></span><br />
              忘记密码了吗？<span class="lvse"><a href="#">点击</a></span>找回密码</td>
            </tr>
          </table>
        </div>
        <br />
      </div>
    </div>
    
      <s:action name="index_footer" namespace="/" executeResult="true"/>
</div>
</body>
</html>
