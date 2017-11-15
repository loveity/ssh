<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/fc.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<s:action name="index_top" namespace="/" executeResult="true"></s:action>
	
  <div class="main">
    <div class="mainunit01">
      <div class="mainunit01-l">
        <div class="ml-top">
          <h1>玉品类别</h1>
          <h2><a href="#">详细&gt;&gt;</a></h2>
        </div>
        	<s:iterator value="#dirs" var="dir" status="type">
        	<s:if test="#type.odd">
	        	<dt><a href="#"><s:property value="name"/>　   <s:property value="englishName"/></a></dt>
	        </s:if>
	        <s:else>
     			 <dd><a href="#"><s:property value="name"/>　<s:property value="englishName"/></a></dd>
	        </s:else>	
        	</s:iterator>
      </div>
      
      <div class="mainunit01-mid">
        <div class="uint01mid-top">
        	<img src='/upload/0a710.jpg' width="391" height="215" />
        </div>
        <div class="uint01mid-bottom">
          <div class="unit01b-top">
          <h1>新闻中心</h1>
          <h2><a href="#">更多&gt;&gt;</a></h2>
          </div>
          
          <div class="unit01-main">
          <dd>2009-02-24</dd>
          <dt><a href="#">2010年中国将有2.5亿消费者采购珠宝首选缅甸翡翠</a></dt>
          <dd>2009-02-24</dd>
          <dt><a href="#">2010年中国将有2.5亿消费者采购珠宝首选缅甸翡翠</a></dt>
          <dd>2009-02-24</dd>
          <dt><a href="#">2010年中国将有2.5亿消费者采购珠宝首选缅甸翡翠</a></dt>
          <dd>2009-02-24</dd>
          <dt><a href="#">2010年中国将有2.5亿消费者采购珠宝首选缅甸翡翠</a></dt>
          <dd>2009-02-24</dd>
          <dt><a href="#">2010年中国将有2.5亿消费者采购珠宝首选缅甸翡翠</a></dt>
          </div>
        </div>
      </div>
      
      <div class="mainunitright">
        <div class="unit01rtop">
          <div class="rrr-top">
          <h1>华氏公告</h1>
          <h2><a href="#">详细>></a></h2>
          </div>
          
          <div class="rrr-cont">　　华氏玉业采用先进电子商务平台，依靠瑞丽珠宝街和缅甸玉石生产厂家，联合打造中国翡翠市场网络第一品牌。华氏定位中高档翡翠饰品的网络营销，兼顾中低档翡翠饰品的批发零售业务。
本行所售玉石有全国联保证书。我们诚信经营，
全球配送，竭诚为玉友提供优质服务。<br />
          </div>
        </div>
        
        
        <div class="unit01rbottom">
          <div class="urbtop">
          <h1>我们的优势</h1>
          <h2><a href="#">详细>></a></h2>
          </div>
          <div class="urbcont">
            <div class="leftpic"><img src="/images/homehl_19.jpg" name="pic01" id="pic01" /><img src="/images/homehl_22.jpg" name="pic02" id="pic02" /></div>
            
            <div class="urrightcont">
              <dt><a href="#">品质：接受全球专业珠宝鉴定机构鉴定</a></dt>
              <dt><a href="#">价优：减少中间环节实行B-C和F-C</a></dt>
              <dt><a href="#">时尚：名家设计，与国际款式同步</a></dt>
              <dt><a href="#">专注：专营缅甸纯天然翡翠全球配送 </a></dt>
              <dt><a href="#">品牌：最佳网购珠宝翡翠机构</a></dt>
              <dt><a href="#">服务：十天内包退换</a></dt>
            
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="mainunit02">
      <div class="unit02-top"><h1>华氏新品</h1>
      <h2><a href="#">查看详细>></a></h2>
      </div>
      
      <div class="unit02cont">
        <div class="unit02left">
        	<s:iterator value="#newProduct" var="product">
		          <div class="picproducts">
		          <a href="/productDetil?id=<s:property value='id'/>"><img src='<s:property value='smallPic'/>' width="143" height="102" alt="">
		         	 <h1 style="white-space: nowrap; overflow: hidden; text-overflow:ellipsis;"><s:property value='name'/></h1>
		         	 <h2>市场报价:￥<s:property value='marketPrice'/></h2><h3>华氏实价:<font color="#FF4C00">￥<s:property value='salePrice'/></font></h3></a>
		         </div>
			</s:iterator>
		</div>
        
        <div class="unit02right">
        <s:iterator value="#newList" var="prod">
        <a href="/productDetil?id=<s:property value='id'/>">
        	<img src="<s:property value='bigPic'/>" width="234" height="173" alt=""></a>
        <dt>产品名称：<font class="green"><s:property value='name'/></font></dt>
        <dt><font class="del">市场价格：￥<s:property value='marketPrice'/></font> 　<font class="bold">华氏实价：</font><font class="orange">￥<s:property value='salePrice'/></font></dt>
        <dt>产地：<s:property value='place'/></dt>
		<dt>规格：<s:property value='model'/></dt>
	</s:iterator>
<label for="button4"></label>
<div class="botton01">
  <label for="button4"></label>
  <input type="submit" name="button3" id="button3" value=" " /><input name="button4" type="button" id="button4" value=" " />
</div>
<br />

</div>
      </div>
      
      <div class="unit02bottom"> </div>
    </div>
    <div class="mainunit02">
      <div class="unit02-top"><h1>华氏热门</h1>
      <h2><a href="#">查看详细>></a></h2>
      </div>
      
      <div class="unit02cont">
        <div class="unit02left">
          <s:iterator value="#hotProduct" var="produ">
		          <div class="picproducts"><a href="/productDetil?id=<s:property value='id'/>"><img src='<s:property value='smallPic'/>' width="143" height="102" alt="">
		         	 <h1 style="white-space: nowrap; overflow: hidden; text-overflow:ellipsis; "><s:property value='name' /></h1>
		         	 <h2>市场报价:￥<s:property value='marketPrice'/></h2><h3>华氏实价:<font color="#FF4C00">￥<s:property value='salePrice'/></font></h3></a>
		         </div>
			</s:iterator>

		</div>
        
        <div class="unit02right">
        <s:iterator value="#hotList" var="prodi">
        <a href="/productDetil?id=<s:property value='id'/>">
        	<img src="<s:property value='bigPic'/>" width="234" height="173" alt=""></a>
        <dt>产品名称：<font class="green"><s:property value='name'/></font></dt>
        <dt><font class="del">市场价格：￥<s:property value='marketPrice'/></font> 　<font class="bold">华氏实价：</font><font class="orange">￥<s:property value='salePrice'/></font></dt>
        <dt>产地：<s:property value='place'/></dt>
		<dt>规格：<s:property value='model'/></dt>
	</s:iterator>
<label for="button4"></label>
<div class="botton01">
  <label for="button4"></label>
  <input type="submit" name="button3" id="button3" value=" " /><input name="button4" type="button" id="button4" value=" " />
</div>
<br />

</div>
      </div>
      
      <div class="unit02bottom"> </div>
    </div>
   <s:action name="index_footer" namespace="/" executeResult="true"></s:action>
   
</div>
</body>
</html>
