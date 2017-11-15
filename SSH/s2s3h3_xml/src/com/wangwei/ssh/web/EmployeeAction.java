package com.wangwei.ssh.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wangwei.ssh.domain.Dept;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.query.Query;
import com.wangwei.ssh.service.IDeptService;
import com.wangwei.ssh.service.IEmployeeService;

public class EmployeeAction extends ActionSupport {
	
	
	IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	Employee employee = new Employee();
	Query query = new Query();

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
//		ActionContext.getContext().put("alldept", deptService.getAll());
		ActionContext.getContext().put("allEmp", employeeService.queryList(query));
		return SUCCESS;
	}
	public String input() throws Exception {
		
		if (employee.getId()!=null) {
			employee = employeeService.getOne(employee.getId());
		}
		ActionContext.getContext().put("alldept", deptService.getAll());
		return INPUT;
	}
	public String save() throws Exception {
		Dept dept = employee.getDept();
		if (dept.getId()== -1) {
			employee.setDept(null);
		}
		if (employee.getId()!=null) {
			employeeService.update(employee);
		}else{
			employeeService.save(employee);
		}
		return "reload";
	}
	public String delete() throws Exception{
		
		if (employee.getId()!=null) {
			employeeService.delete(employee.getId());
		}
		return "reload";
	}
	
	
	
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
