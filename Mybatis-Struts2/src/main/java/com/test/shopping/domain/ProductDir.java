package com.test.shopping.domain;


/**
 * @author JUST-GO
 *　这是产品分类表：包括名称，和分类介绍
 */
public class ProductDir {
	private Long id;  		//主键
	private String name; 		//分类名称
	private String englishName; //英文名称
	private String intro; 		//分类介绍
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public String getIntro() {
		return intro;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "ProductDir [id=" + id + ", name=" + name + ", englishName="
				+ englishName + ", intro=" + intro + "]";
	}
	
	
}
