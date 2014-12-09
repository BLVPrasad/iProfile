package com.hexaware.iprofile;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hexaware.iprofile.dao.AddressDao;
import com.hexaware.iprofile.dao.CompanyDao;
import com.hexaware.iprofile.dao.ContactDao;
import com.hexaware.iprofile.dao.TechnologyDao;
public class TestH2DBConnection {
		public static void main(String[] args) throws Exception {
	    	    
	    Resource r = new ClassPathResource("myapplicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(r);
		
		System.out.println("=========   H2DB  Connected    ==============");
		
		/*TechnologyDao technologydao = (TechnologyDao) factory.getBean("technologyBean");
		
		Technology technology = new Technology();
		technology.setTech_id(new Long(11));
		technology.setProduct(".net");
		technology.setVendor("Microsoft");
		technologydao.saveTechnology(technology);
		System.out.println("Technology data successfully........");*/
		
		AddressDao addressdao = (AddressDao) factory.getBean("addressBean");
		
		Address address = new Address();
		//address.setAddress_id(new Long(11));
		address.setAddress1("CCC");
		address.setAddress2("ZZZZZ");
		address.setCity("chennai");
		address.setCountry("India");
		address.setAddress2("ZZZZZ");
		address.setCity("chennai");
		addressdao.saveAddress(address);
		
		ContactDao contactDao = (ContactDao) factory.getBean("contactBean");
		
		Contact contact = new Contact();
		contact.setContact_id(new Long(0001));
		contact.setFirst_name("Vara");
		contact.setLast_name("Prasad");
		contactDao.saveContact(contact);
		System.out.println("Contact data successfully........");	
		CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
		
		Company c = new Company();
		
		//companydao.getCompany(1111);
		
		//companydao.readAll();
		
		c.setCompany_id("50db55e0b4a6de0e38006840");
		c.setName("Hexaware");
		c.setUrl("hexaware.com");
		c.setAddress(address);
		
		companydao.saveCompany(c);
		
		companydao.search("Hexa");
	    
	  }
}


