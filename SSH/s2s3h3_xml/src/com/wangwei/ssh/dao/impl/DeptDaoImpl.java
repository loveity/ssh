package com.wangwei.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wangwei.ssh.dao.IDeptDao;
import com.wangwei.ssh.domain.Dept;

public class DeptDaoImpl extends HibernateDaoSupport implements IDeptDao {
	
	@Override
	public void save(Dept emp) {
		getHibernateTemplate().save(emp);
	}

	@Override
	public void update(Dept emp) {
		getHibernateTemplate().update(emp);
	}

	@Override
	public void delete(Long id) {
		Dept Dept =getOne(id);
		if (Dept!=null) {
			getHibernateTemplate().delete(Dept);
		}
	}

	@Override
	public Dept getOne(Long id) {
		 
		return getHibernateTemplate().get(Dept.class, id);
	}

	@Override
	public List<Dept> getAll() {
		
		return getHibernateTemplate().loadAll(Dept.class);
	}

}
