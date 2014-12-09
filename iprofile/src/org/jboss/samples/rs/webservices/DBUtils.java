package org.jboss.samples.rs.webservices;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hexaware.iprofile.Technology;
import com.hexaware.iprofile.dao.TechnologyDao;

public class DBUtils {
	
	public void DBCreate(){
		
		Resource r = new ClassPathResource("applicationContext.xml");
	
		BeanFactory factory = new XmlBeanFactory(r);
		
		System.out.println("=========   H2DB  Connected    ==============");
		
		TechnologyDao technologydao = (TechnologyDao) factory.getBean("technologyBean");
		
		Technology technology = new Technology();
		technology.setTech_id(new Long(11));
		technology.setProduct(".net");
		technology.setVendor("Microsoft");
		technologydao.saveTechnology(technology);
		System.out.println("Inserted data successfully........");
		
		technologydao.readAll();
	}
	
	public void search(){
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
