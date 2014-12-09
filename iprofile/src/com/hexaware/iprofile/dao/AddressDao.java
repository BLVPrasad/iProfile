package com.hexaware.iprofile.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Address;

public class AddressDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveAddress(Address a) {
		template.saveOrUpdate(a);
	}
}
