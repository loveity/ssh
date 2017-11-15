package com.wangwei.ssh.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;

public interface IEmployeeDao {
	void save(Employee emp);
	void update(Employee emp);
	void delete(Long id);
	Employee getOne(Long id);
	List<Employee> getAll();
	void in(Long inId, BigDecimal money);
	void out(Long outId, BigDecimal money);
	
	//分页操作：
	PageList<Employee> queryList(Query query);

}
