package com.wangwei.ssh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wangwei.ssh.domain.Dept;
import com.wangwei.ssh.domain.Employee;
import com.wangwei.ssh.page.PageList;
import com.wangwei.ssh.query.Query;
import com.wangwei.ssh.service.IDeptService;
import com.wangwei.ssh.service.IEmployeeService;


@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport {
	@Autowired
	IEmployeeService employeeService;
	@Autowired
	IDeptService deptService;
	
	Employee employee = new Employee();

	private static final long serialVersionUID = 1L;
	
	Query query =new Query();

	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	PageList<Employee> queryList = new PageList();
	
	@Override
	public String execute() throws Exception {
		
		queryList = employeeService.queryList(query);
		System.out.println("----");
		ActionContext.getContext().put("queryList", employeeService.queryList(query));
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
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
