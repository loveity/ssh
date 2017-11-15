package com.wangwei.ssh.service;

import java.util.List;

import com.wangwei.ssh.domain.Dept;

public interface IDeptService {
	void save(Dept emp);
	void update(Dept emp);
	void delete(Long id);
	Dept getOne(Long id);
	List<Dept> getAll();
}
