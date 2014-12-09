package com.hexaware.iprofile;
	
import java.sql.Date;
	
public class Employee {
		private int employee_id;
	
		private String firstname;
		private String lastname;
		private Date birthDate;
		private String cellphone;
		private Department department;
	
		/*public Employee() {
		}
	
		public Employee(String firstname, String lastname, Date birthdate,
				String phone) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.birthDate = birthdate;
			this.cellphone = phone;
		}*/
	
		public int getEmployee_id() {
			return employee_id;
		}
	
		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}
	
		public String getFirstname() {
			return firstname;
		}
	
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
	
		public String getLastname() {
			return lastname;
		}
	
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	
		public Date getBirthDate() {
			return birthDate;
		}
	
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
	
		public String getCellphone() {
			return cellphone;
		}
	
		public void setCellphone(String cellphone) {
			this.cellphone = cellphone;
		}
	
		public Department getDepartment() {
			return department;
		}
	
		public void setDepartment(Department department) {
			this.department = department;
		}
	
}
