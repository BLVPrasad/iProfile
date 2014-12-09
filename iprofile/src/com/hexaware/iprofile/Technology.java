package com.hexaware.iprofile;
	
import java.util.Set;
	
public class Technology {
	
		private Long tech_id;
		private String catagory;
		private String sub_catagory;
		private String vendor;
		private String product;
	
		private Set<Company> companies;
	
		public Set<Company> getCompanies() {
			return companies;
		}
	
		public void setCompanies(Set<Company> companies) {
			this.companies = companies;
		}
	
		public Long getTech_id() {
			return tech_id;
		}
	
		public void setTech_id(Long techId) {
			this.tech_id = techId;
		}
	
		public String getCatagory() {
			return catagory;
		}
	
		public void setCatagory(String catagory) {
			this.catagory = catagory;
		}
	
		public String getSub_catagory() {
			return sub_catagory;
		}
	
		public void setSub_catagory(String subCatagory) {
			this.sub_catagory = subCatagory;
		}
	
		public String getVendor() {
			return vendor;
		}
	
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
	
		public String getProduct() {
			return product;
		}
	
		public void setProduct(String product) {
			this.product = product;
		}
	
}
