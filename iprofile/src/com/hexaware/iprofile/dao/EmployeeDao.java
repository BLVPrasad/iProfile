package com.hexaware.iprofile.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Employee;

public class EmployeeDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveEmployee(Employee e) {
		template.save(e);
	}
}
