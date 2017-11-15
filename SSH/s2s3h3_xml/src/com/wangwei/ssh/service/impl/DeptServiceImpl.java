package com.wangwei.ssh.service.impl;

import java.util.List;

import com.wangwei.ssh.dao.IDeptDao;
import com.wangwei.ssh.domain.Dept;
import com.wangwei.ssh.service.IDeptService;

public class DeptServiceImpl  implements IDeptService{
	IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	@Override
	public void save(Dept emp) {
		deptDao.save(emp);
	}

	@Override
	public void update(Dept emp) {
		deptDao.update(emp);
	}

	@Override
	public void delete(Long id) {
		deptDao.delete(id);
	}

	@Override
	public Dept getOne(Long id) {
		return deptDao.getOne(id);
		
	}

	@Override
	public List<Dept> getAll() {
		return deptDao.getAll();
		
	}

}
