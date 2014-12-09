package com.hexaware.iprofile.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hexaware.iprofile.Company;

public class CompanyDao {
	org.springframework.orm.hibernate3.HibernateTemplate template;

	public void setSessionFactory(org.hibernate.SessionFactory factory) {
		template = new HibernateTemplate(factory);
	}

	public void saveCompany(Company c)  {
		try{
			template.saveOrUpdate(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Company findCompany(String idValue) {
		Company company = null;
		try{
			company = template.get(Company.class, idValue);
			System.out.println(company.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		return company;
	}
	
	public List readAll(){
		
		String query = "FROM Company";
		List companies = template.find(query);
		
		List compList = new ArrayList();
		for(Object o : companies){  
			 Company c = (Company)o; 
			 System.out.println("Company_id :  "+c.getCompany_id());
			 compList.add(c.getCompany_id());
		 }
		 return compList;
	}
	
	public List search(String str){
		
		String query = "from Company u where upper(u.name) like upper(:name)";
		List companies = template.findByNamedParam(query, "name", '%' + str + '%');
		System.out.println("Companies objects : "+companies);
		List compList = new ArrayList();
		for(Object o : companies){  
			 Company c = (Company)o; 
			 System.out.println("Company_id :  "+c.getCompany_id());
			 compList.add(c.getCompany_id());
		 }
		 return compList;
	}
	
	/*public Company getCompany(final Serializable id){
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session)
                throws HibernateException,SQLException {
                return session.load(Company.class, id);
            }
        };
        return (Company)template.execute(callback);
    }*/
	
}
