package com.wangwei.ssh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wangwei.ssh.dao.IDeptDao;
import com.wangwei.ssh.domain.Dept;


@Repository
public class DeptDaoImpl implements IDeptDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Dept emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(Dept emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public void delete(Long id) {
		Dept Dept =getOne(id);
		if (Dept!=null) {
			sessionFactory.getCurrentSession().delete(Dept);
		}
	}

	@Override
	public Dept getOne(Long id) {
		 
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getAll() {
		
		return sessionFactory.getCurrentSession().createCriteria(Dept.class).list();
	}

}
