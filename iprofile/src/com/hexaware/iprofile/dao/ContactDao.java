package com.hexaware.iprofile.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Contact;

public class ContactDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveContact(Contact c) {
		template.save(c);
	}
}
