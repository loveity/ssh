package com.wangwei.ssh.service;

import java.math.BigDecimal;
import java.util.List;

import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;

public interface IEmployeeService {
	void save(Employee emp);
	void update(Employee emp);
	void delete(Long id);
	Employee getOne(Long id);
	List<Employee> getAll();
	/*
	 * 实现转账的功能：
	 * 需要三个参数：
	 * 转入的id：转出的Id.以及转账的金额
	 */
	void transMoney(Long inId,Long outId, BigDecimal money);
	PageList<Employee> queryList(Query query);
}
