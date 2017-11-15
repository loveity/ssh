<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/fc.css" rel="stylesheet" type="text/css" />
<link href="css/fc02.css" rel="stylesheet" type="text/css" />

<style type="text/css">
.listunit a.goa:hover {
	background-image: url(/images/fc02_4500.jpg);
	background-repeat: repeat-x;
	background-position: left bottom;
	background-color: #F9F9F9;
	display: inline;
	height: 150px;
	width: 708px;
}

</style>
</head>

<body>
<div id="box">

<s:action name="index_top" namespace="/" executeResult="true" />
  
  <div class="main">
    <div class="mainunit01">
      <div class="main02leftadd">
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
        <dt><a href="#">我的购物车</a></dt>
        <dt><a href="#">账目明细</a></dt>
        <dt><a href="#">收货地址</a></dt>
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
      <div class="main02right">
        <div class="listtitle04">　<a href="#">购物清单</a>　&gt;　<font class="ganlan">订单确认</font>　&gt;　<a href="#">支付贷款</a></div>   
        <div class="gwqdtitle05">
          <div class="gl">购物清单</div>
          
          <div class="gr"><a href="#">更新购物清单</a></div>
        </div>
        <div class="kuang">
          <div class="ddqrtitle">
          订单确认　　　　　　　　　　　　　　　　　　　　　　　　   　　　　　　　　　　　　　　　<a href="#">修改</a></div>
          
          <s:iterator  value="#session.CART_IN_SESSION.datdaList" var="item">
          
          <div class="listunit"><img src="<s:property value='#item.product.smallPic'/>" alt="" width="170" height="120" class="listunitpic" />
        <dl>
	        <div class="bottonunit02">
	        <a  class="go" href="/cart_delete?id=<s:property value='product.id'/>">
	       	 	<img src="images/qrdd_7.jpg"/>  
	       	</a>
       	 </div>
	        <h1>产品名称：<s:property value='product.name'/></h1>
	        
	        <dt>市场价格<font class="black">：￥<s:property value='#item.product.salePrice'/></font>　　华氏实价：<font class="orange08">￥<s:property value='product.marketPrice'/></font></dt>
	        <dt> 产　　地：<s:property value='#item.product.place'/></dt>       
	        <dt> 规　　格：<s:property value='#item.product.model'/></dt>
	        
	        <dt>数量：<s:property value='#item.num'/></dt>
	        <dt>编　　号：<s:property value='#item.product.sn'/></dt>
	        </dl>
	        </a>
		</div>

        </s:iterator>
        </div>
        <div class="gwje">购物金额小计：<span class="orange03">￥<s:property value='#session.CART_IN_SESSION.totalPrice'/></span>，比市场价<span class="green02">￥<s:property value='#session.CART_IN_SESSION.totalMarketPrice'/></span>节省了<span class="orange03">￥<s:property value='#session.CART_IN_SESSION.totalMarketPrice-#session.CART_IN_SESSION.totalPrice'/></span></div>
        <div class="tjan">
        <a  href="/index">
        	<img src="images/gwc_15.jpg"   />
        </a>
        
        <img src="images/gwc_17.jpg"  /></div>
        
      </div>
      
    </div>
       <s:action name="index_footer" namespace="/" executeResult="true"></s:action>
    
</div>
</body>
</html>
