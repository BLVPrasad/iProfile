package com.hexaware.iprofile.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Company;
import com.hexaware.iprofile.Technology;

public class TechnologyDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
		
	}

	public void saveTechnology(Technology t) {
		template.save(t);
	}
	
	public void readAll(){
			
		String query = "FROM Technology";
		List technologies = template.find(query);
		System.out.println(technologies);
		 //for (int i = 0; i < companies.size(); i++){
		 for(Object o : technologies){  
			 Technology t = (Technology)o; 
			 System.out.println("Technology id :" + t.getTech_id());
			 System.out.println("Catagory :" + t.getCatagory());
			 System.out.println("Sub catagory  :" + t.getSub_catagory());
			 System.out.println("Product :" + t.getProduct());
			 System.out.println("Vendor :" + t.getVendor());
		 }
	}
	
}
