package com.hexaware.iprofile;

import java.util.Set;

public class Contact {
	
		private Long contact_id;
		private String first_name;
		private String last_name;
		private String middle_name;
		private String title;
		private String rank;
		private String department;
		private String phone;
		private String email;
		private String reports_contactid;
		
		private Set<Company> companies;
		
		public Set<Company> getCompanies() {
			return companies;
		}
	
		public void setCompanies(Set<Company> companies) {
			this.companies = companies;
		}

		public Long getContact_id() {
			return contact_id;
		}

		public void setContact_id(Long contact_id) {
			this.contact_id = contact_id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String firstName) {
			this.first_name = firstName;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String lastName) {
			this.last_name = lastName;
		}

		public String getMiddle_name() {
			return middle_name;
		}

		public void setMiddle_name(String middleName) {
			this.middle_name = middleName;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getRank() {
			return rank;
		}

		public void setRank(String rank) {
			this.rank = rank;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getReports_contactid() {
			return reports_contactid;
		}

		public void setReports_contactid(String reportsContactid) {
			this.reports_contactid = reportsContactid;
		}
		
}
