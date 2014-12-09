package com.hexaware.iprofile.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Blv;

public class BlvDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveBlv(Blv b) {
		template.save(b);
	}
}
