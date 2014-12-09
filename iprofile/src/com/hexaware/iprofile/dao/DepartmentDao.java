package com.hexaware.iprofile.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Department;

public class DepartmentDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
		
	}

	public void saveDepartment(Department d) {
		template.save(d);
	}
}
