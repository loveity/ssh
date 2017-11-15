package com.wangwei.ssh.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wangwei.ssh.dao.IEmployeeDao;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;

public class EmployeeDaoImpl extends HibernateDaoSupport implements IEmployeeDao {
	
	@Override
	public void save(Employee emp) {
		getHibernateTemplate().save(emp);
	}

	@Override
	public void update(Employee emp) {
		getHibernateTemplate().update(emp);
	}

	@Override
	public void delete(Long id) {
		Employee employee = getHibernateTemplate().get(Employee.class, id);
		if (employee!=null) {
			getHibernateTemplate().delete(employee);
		}
	}

	@Override
	public Employee getOne(Long id) {
		 
		return getHibernateTemplate().get(Employee.class, id);
	}

	@Override
	public List<Employee> getAll() {
		
		return getHibernateTemplate().loadAll(Employee.class);
	}

	@Override
	public void in(Long inId, BigDecimal money) {
		Employee inEmployee = getOne(inId);
		inEmployee.setSalary(inEmployee.getSalary().add(money));
		//最后再更新修改
		update(inEmployee);
	}

	@Override
	public void out(Long outId, BigDecimal money) {
		Employee outEmployee = getOne(outId);
		outEmployee.setSalary(outEmployee.getSalary().subtract(money));
		//最后再更新修改
		update(outEmployee);
	}
	@Override
	public PageList<Employee> queryList(Query query) {
		
		//获得所有的分页结果：
		Criteria criteria =  getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Employee.class);
		List countList = criteria.list();
		Integer size = countList.size();
		
		criteria.setFirstResult(query.getIndexbegin()).setMaxResults(query.getPageSize());
		List<Employee> list = criteria.list();//获得分页后的employee集合
		PageList page=new PageList(query.getPageSize(),query.getCurrentPage(),size);
		page.setDataList(list);
		return page;
	}
}
