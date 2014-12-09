package com.hexaware.iprofile;

import java.util.Set;
	
public class Address {
	
		private Long address_id;
		private String address1;
		private String address2;
		private String city;
		private String state;
		private String country;
		private String zip;
		private String country_code;
		
		

		private Set<Company> companies;
	
		public Set<Company> getCompanies() {
			return companies;
		}

		public void setCompanies(Set<Company> companies) {
			this.companies = companies;
		}

		public Long getAddress_id() {
			return address_id;
		}
	
		public void setAddress_id(Long addressId) {
			this.address_id = addressId;
		}
	
		public String getAddress1() {
			return address1;
		}
	
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
	
		public String getAddress2() {
			return address2;
		}
	
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
	
		public String getCity() {
			return city;
		}
	
		public void setCity(String city) {
			this.city = city;
		}
	
		public String getState() {
			return state;
		}
	
		public void setState(String state) {
			this.state = state;
		}
	
		public String getCountry() {
			return country;
		}
	
		public void setCountry(String country) {
			this.country = country;
		}
	
		public String getZip() {
			return zip;
		}
	
		public void setZip(String zip) {
			this.zip = zip;
		}
		
		public String getCountry_code() {
			return country_code;
		}

		public void setCountry_code(String country_code) {
			this.country_code = country_code;
		}
	
}
