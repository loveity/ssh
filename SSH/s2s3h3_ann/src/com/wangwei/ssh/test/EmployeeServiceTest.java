package com.wangwei.ssh.test;



import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangwei.ssh.domain.Dept;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;
import com.wangwei.ssh.service.IDeptService;
import com.wangwei.ssh.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {
	@Autowired
	IEmployeeService employeeService;
	@Autowired
	IDeptService deptService;
	
	@Test
	public void testSave() {
		Dept dept1= new Dept();
		dept1.setName("人事部");
		Dept dept2= new Dept();
		dept2.setName("财务部");
		deptService.save(dept1);
		deptService.save(dept2);
		for (int i = 1; i < 13; i++) {
			Employee emp = new Employee();
			emp.setName("employee"+i);
			if (i%2==0) {
				emp.setSex(true);
				emp.setDept(dept1);
			}else{
				emp.setSex(false);
				
				emp.setDept(dept2);
			}
			emp.setSalary(new BigDecimal(6000));
			employeeService.save(emp);
		}
	}

	@Test
	public void testUpdate() {
		Employee emp = new Employee();
		employeeService.update(emp);
	}

	@Test
	public void testDelete() {
		employeeService.delete(11L);
	}

	@Test
	public void testGetOne() {
		Employee one = employeeService.getOne(6L);
		System.out.println(one);
	}

	@Test
	public void testGetAll() {
		List<Employee> all = employeeService.getAll();
		for (Employee employee : all) {
			System.out.println(employee);
		}
	}
    @Test
	public void testTran() throws Exception {
    	employeeService.transMoney(1L, 2L, new BigDecimal(2000));
	}
    
    @Test
	public void page()throws Exception {
    	
    	Query query = new Query();
    	query.setCurrentPage(1);
    	PageList<Employee> queryList = employeeService.queryList(query);
    	List<Employee> list2 = queryList.getDataList();
    	System.out.println(queryList);
    	for (Employee employee : list2) {
			System.out.println(employee);
		}
    }
}
