package com.hexaware.iprofile;

import java.util.Set;


public class Department {

	private Long department_id;
    
    private String departmentName;
     
    private Set<Employee> employees;

	public Long getDepartmentId() {
		return department_id;
	}

	public void setDepartmentId(Long department_id) {
		this.department_id = department_id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
    
    
    
    
}
