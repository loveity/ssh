package com.wangwei.ssh.dao.impl;

import java.math.BigDecimal;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wangwei.ssh.dao.IEmployeeDao;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;
@Repository
public class EmployeeDaoImpl  implements IEmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void delete(Long id) {
		Employee employee = getOne(id);
		if (employee!=null) {
			sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@Override
	public Employee getOne(Long id) {
		 
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		
		return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageList<Employee> queryList(Query query) {
		
		Session session = sessionFactory.getCurrentSession();
		//获得所有的分页结果：
		Criteria criteria = session.createCriteria(Employee.class);
		List countList = criteria.list();
		Integer size = countList.size();
		
		criteria.setFirstResult((query.getCurrentPage()-1)*query.getPageSize()).setMaxResults(query.getPageSize());
		List<Employee> list = criteria.list();//获得分页后的employee集合
		PageList page=new PageList(query.getPageSize(),query.getCurrentPage(),size);
		page.setDataList(list);
		return page;
	}

}
