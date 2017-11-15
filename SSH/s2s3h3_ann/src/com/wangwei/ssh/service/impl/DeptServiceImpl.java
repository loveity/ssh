package com.wangwei.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wangwei.ssh.dao.IDeptDao;
import com.wangwei.ssh.domain.Dept;
import com.wangwei.ssh.service.IDeptService;

@Service
@Transactional()//默认的就是对所有的有事务：特殊的就单独标记
public class DeptServiceImpl  implements IDeptService{
	
	@Autowired
	IDeptDao deptDao;
	
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
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Dept getOne(Long id) {
		return deptDao.getOne(id);
		
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Dept> getAll() {
		return deptDao.getAll();
		
	}

}
