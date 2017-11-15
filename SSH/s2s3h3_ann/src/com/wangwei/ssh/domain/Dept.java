package com.wangwei.ssh.domain;

/**
 * @author JUST-GO
 * 这是一个部门
 */
public class Dept {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}
	
}
