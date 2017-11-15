<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/fc.css" rel="stylesheet" type="text/css" />
<link href="/css/fc02.css" rel="stylesheet" type="text/css" />
</head>
<body>
  <s:action name="index_top" namespace="/" executeResult="true" />
  
  <div class="main">
    <div class="mainunit01">
      <div class="main02leftadd">
      <div class="mainunit01-l">
        <div class="ml-top">
          <h1>玉品类别</h1>
          <h2><a href="#">详细&gt;&gt;</a></h2>
        </div>
        <dt><a href="#">观音佛陀 　　Kwan-yin Buddha</a></dt>
        <dd><a href="#">翡翠手镯 　　Jade Bangle</a></dd>
        <dt><a href="#">指环戒指 　　Ring Finger Ring</a></dt>
        <dd><a href="#">手链项链 　　Bracelet Necklace</a></dd>
        <dt><a href="#">胸针耳饰 　　Brooch Eardrop</a></dt>
        <dd><a href="#">十二生肖　　 Chinese Zodiac</a></dd>
        <dt><a href="#">招财貔貅　　 Lucky PiXiu</a></dt>
        <dd><a href="#">翡翠金蟾 　　Jade Jinchan</a></dd>
        <dt><a href="#">如意挂件　　 Ruyi Pendant</a></dt>
        <dd><a href="#">裸石界面　　 Interface</a></dd>
        <dt><a href="#">翡翠原石　　 Jade Stone</a></dt>
        <dd><a href="#">摆件玩件　　 Decoration</a></dd>
        <dt><a href="#">指环戒指 　　Ring Finger Ring</a></dt>
      </div>
      
      <div class="woman"><img src="/images/woman_3.jpg"  onMouseOver="this.src='/images/woman_3over.jpg';" onMouseOut="this.src='/images/woman_3.jpg'" onClick="this.src='/images/woman_3.jpg'"></div>
     </div>
      
      <div class="main02right">
        <div class="m02r-top">首页 &gt; 玉品类别 &gt; 观音佛陀 &gt; <font class="orange03">最终产品展示</font></div>
        
        <div class="productshow"><img src="<s:property value='#product.bigPic'/>" width="698" height="510" alt="没有图片" /></div>
        
        <div class="subpicshow"><img src="<s:property value='#product.smallPic'/>" width="105" height="75" alt="没有图片"/></div>
        
        <div class="price"><h1>市场价格：￥<s:property value='#product.marketPrice'/>元　华氏价格：<span class="orange08">￥<s:property value='#product.salePrice'/>元</span></h1>
        <h2>
	        <a href="/cart_save?id=<s:property value='#product.id'/>" target="cart"><img src="/images/fc02_36.jpg"/></a>
	        <img src="/images/fc02_33.jpg" />
	    </h2>
          
        </div>
        
        <div class="productshowtitle01">商品信息</div>
        <table width="100%" border="0" cellspacing="2" cellpadding="0">
  <tr>
    <td width="145" class="tableleft">名　　称</td>
    <td class="tablefont"><s:property value='#product.name'/></td>
  </tr>
  <tr>
    <td class="tableleft">编　　号</td>
    <td class="tablefont02"><s:property value='#product.sn'/></td>
  </tr>
  <tr>
    <td class="tableleft">规　　格</td>
    <td class="tablefont"><s:property value='#product.model'/></td>
  </tr>
  <tr>
    <td class="tableleft">产　　地</td>
    <td class="tablefont02"><s:property value='#product.place'/></td>
  </tr>
  <tr>
    <td class="tableleft">数　　量</td>
    <td class="tablefont"><s:property value='#product.num'/></td>
  </tr>
  <tr>
    <td class="tableleft">重　　量</td>
    <td class="tablefont02">0.1235克&nbsp;</td>
  </tr>
  <tr>
    <td class="tableleft">鉴定结论</td>
    <td class="tablefont">鉴定结论Appraisal：天然翡翠A货；
            折光率Refractive Index :1.66；放大检查Magnificat:纤维交织结构</td>
  </tr>
  <tr>
    <td class="tableleft">介　　绍</td>
    <td class="tablefont02"><s:property value='#product.intro'/></td>
  </tr>
  <tr>
    <td class="tableleft">购物配送</td>
    <td class="tablefont">华氏美玉珍藏翠玉礼盒；<br />
      中国结艺设计手工编织挂绳；<br />
              国家权威翡翠鉴定A货证书；<br />
              国内EMS特快专递；<br />
              注：国际邮费由买家支付</td>
  </tr>
</table>
         <div class="productshowtitle01">购物流程</div>
         
         <div class="lc"><img src="/images/fc03_29_3.jpg" width="84" height="58" /><img src="/images/fc03_29_5.jpg" width="84" height="58" /><img src="/images/fc03_29_7.jpg" width="84" height="58" /><img src="/images/fc03_29_9.jpg" width="84" height="57" /><img src="/images/fc03_29_11.jpg" width="84" height="58" /><img src="/images/fc03_29_13.jpg" width="84" height="57" /></div>
         <div class="productshowtitle01">玉友评论</div>
         
         <div class="pl">
           <div class="pltitle">
             <h1>暂无评论</h1>
             <h2><a href="#">关闭评论</a></h2>
             
             <div class="plcont">昵称：
               <label for="textfield"></label>
               <input type="text" name="textfield" class="textfieldpl" />
             　密码：
             <input type="text" name="textfield2" class="textfieldpl" />
             　（如果您是华氏珠宝会员，请输入账号和密码）<br />
             <input type="checkbox" name="checkbox" id="checkbox" />
             <label for="checkbox"></label>
             <label for="radio"></label>
             匿名（如果不是华氏珠宝会员，请选择匿名留言，也可以先<span class="orange">注册</span>成为会员后留言）<br />
             内容：
             <label for="textarea"></label>
             <textarea name="textarea" id="textarea" class="textareapl" cols="45" rows="5"></textarea>
             
             <div class="ok">回复数据，清空内容<img src="/images/show_3.jpg" width="82" height="23" /></div>
             </div>
           </div>
         </div>
         
      </div>
      
    </div>
    <s:action name="index_footer" namespace="/" executeResult="true"></s:action>
    
</body>
</html>
