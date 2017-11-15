package com.wangwei.ssh.domain;

import java.math.BigDecimal;

public class Employee {
	private Long id;
	private String name;
	private Boolean sex;
	private BigDecimal  salary;
	/*
	 * 这是多对一的关系（一个员工有多个部门）
	 */
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", salary=" + salary + "]";
	}
	
}
