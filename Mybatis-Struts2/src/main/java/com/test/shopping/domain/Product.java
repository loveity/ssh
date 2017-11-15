package com.test.shopping.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JUST-GO
 *  产品表
 */
public class Product {
	private Long id;                // 唯一标识:对应着表中的主键
	private String name ;               // 商品名称
	private String sn;                 // 商品编号: 唯一的
	private BigDecimal costPrice;           // 商品成本价
	private BigDecimal salePrice;           // 商品零售价
	private BigDecimal marketPrice;         // 市场价格
	
	private String place ;              // 商品生产地
	private String model;               //  商品规格信息,如:长25.8厘米/宽18.56厘米/高1.25毫米
	private Integer num;               // 库存量,仅此一件 
	private String intro;              // 商品的描述信息
	//这里需要在网页中显示具体的名字,需要在对象中取出name ---
	private ProductDir dir;              // 商品分类编号
	private String bigPic;              // 商品大图存储路径
	private String smallPic;            // 商品小图存储路径,通过大图压缩而来.

	private Integer status;              // 上架==0/下架/==1
	private Integer viewTimes;           // 浏览次数--->
	private Boolean recommended;         // 是否推荐

	private Date inputTime;           // 上架时间

	
	public ProductDir getDir() {
		return dir;
	}

	public void setDir(ProductDir dir) {
		this.dir = dir;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSn() {
		return sn;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public String getPlace() {
		return place;
	}

	public String getModel() {
		return model;
	}

	public Integer getNum() {
		return num;
	}

	public String getIntro() {
		return intro;
	}


	public String getBigPic() {
		if (bigPic==null) {
			bigPic="/upload/default_small.jpg";
		}
		return bigPic;
	}

	public String getSmallPic() {
		return smallPic;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getViewTimes() {
		return viewTimes;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}


	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", sn=" + sn
				+ ", costPrice=" + costPrice + ", salePrice=" + salePrice
				+ ", marketPrice=" + marketPrice + ", place=" + place
				+ ", model=" + model + ", num=" + num + ", intro=" + intro
				+ ", dir=" + dir+ ", bigPic=" + bigPic + ", smallPic="
				+ smallPic + ", status=" + status + ", viewTimes=" + viewTimes
				+ ", recommended=" + recommended + ", inputTime=" + inputTime
				+ "]";
	}
	

}
