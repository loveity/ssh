package com.wangwei.ssh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wangwei.ssh.dao.IEmployeeDao;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;
import com.wangwei.ssh.service.IEmployeeService;

public class EmployeeServiceImpl  implements IEmployeeService{
	IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public void save(Employee emp) {
		employeeDao.save(emp);
	}

	@Override
	public void update(Employee emp) {
		employeeDao.update(emp);
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public Employee getOne(Long id) {
		return employeeDao.getOne(id);
		
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
		
	}
	/*
	 * 转账：
	 */
	@Override
	public void transMoney(Long inId, Long outId, BigDecimal money) {
		employeeDao.in(inId,money);
//		int x =1/0;
		employeeDao.out(outId, money);
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public PageList<Employee> queryList(Query query) {
		
		return employeeDao.queryList(query);
	}
}
