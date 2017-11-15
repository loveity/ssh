package com.wangwei.ssh.service.impl;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wangwei.ssh.dao.IEmployeeDao;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;
import com.wangwei.ssh.service.IEmployeeService;

@Service
@Transactional()//默认的就是对所有的有事务：特殊的就单独标记
public class EmployeeServiceImpl  implements IEmployeeService{
	
	@Autowired
	IEmployeeDao employeeDao;
	
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
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Employee getOne(Long id) {
		return employeeDao.getOne(id);
		
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
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
