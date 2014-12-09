package com.hexaware.iprofile;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hexaware.iprofile.dao.AddressDao;
import com.hexaware.iprofile.dao.CompanyDao;

public class InsertTest {
	public static void main(String[] args) {

		Resource r = new ClassPathResource("applicationContext.xml");
		System.out.println("Resource is created;;;;;;;;;;;;;;;;;;;");
		BeanFactory factory = new XmlBeanFactory(r);
		
		
		
		/*DepartmentDao deptdao = (DepartmentDao) factory.getBean("deptBean");
		
		Department dept = new Department();
		dept.setDepartmentId(new Long(99));
		dept.setDepartmentName("Innovation");
			
		EmployeeDao empdao = (EmployeeDao) factory.getBean("empBean");

		Employee e = new Employee();
		e.setEmployee_id(5555);
		e.setFirstname("Vara");
		e.setLastname("Prasad");
		e.setDepartment(dept);
		deptdao.saveDepartment(dept);
		empdao.saveEmployee(e);*/
		
		AddressDao addressdao = (AddressDao) factory.getBean("addressBean");
		
		Address address = new Address();
		address.setAddress_id(new Long(77));
		address.setAddress1("kandanchavadi");
		address.setAddress2("Chennai");
		
		CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
		
		Company c = new Company();
		
		//companydao.getCompany(1111);
		
		//companydao.readAll();
		
		c.setCompany_id("7777");
		c.setName("Tata consultancy Services");
		c.setUrl("www.tcs.com");
		c.setAddress(address);
		addressdao.saveAddress(address);
		companydao.saveCompany(c);
		
		System.out.println("Inserted data successfully........");

	}
}
