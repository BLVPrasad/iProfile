package com.hexaware.iprofile;

public class Company {
	
		private String company_id;
		private String name;
		private String url;
		private String employee_range;
		private String revenue_range;
		private String duns;
		private String industry;
		private String ownership_type;
		private String twitter_url;
		private String li_url;
		private String it_budget;
		private String software_budget;
		private String hardware_budget;
		private String service_budget;
		private String communication_budget;
		private String storage_budget;
		private String miscellaneous_budget;
		private Address address;
		private String it_contacts_count;
		private String stock_ticker;
		private String phone;
		private String sic;
		//private String description;
		private String last_updated;
		
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public String getCompany_id() {
			return company_id;
		}
		public void setCompany_id(String company_id) {
			this.company_id = company_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getEmployee_range() {
			return employee_range;
		}
		public void setEmployee_range(String employeeRange) {
			this.employee_range = employeeRange;
		}
		public String getRevenue_range() {
			return revenue_range;
		}
		public void setRevenue_range(String revenueRange) {
			this.revenue_range = revenueRange;
		}
		public String getDuns() {
			return duns;
		}
		public void setDuns(String duns) {
			this.duns = duns;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public String getOwnership_type() {
			return ownership_type;
		}
		public void setOwnership_type(String ownership_type) {
			this.ownership_type = ownership_type;
		}
		public String getTwitter_url() {
			return twitter_url;
		}
		public void setTwitter_url(String twitterUrl) {
			this.twitter_url = twitterUrl;
		}
		public String getLi_url() {
			return li_url;
		}
		public void setLi_url(String liUrl) {
			this.li_url = liUrl;
		}
		public String getIt_budget() {
			return it_budget;
		}
		public void setIt_budget(String itBudget) {
			it_budget = itBudget;
		}
		public String getSoftware_budget() {
			return software_budget;
		}
		public void setSoftware_budget(String softwareBudget) {
			this.software_budget = softwareBudget;
		}
		public String getHardware_budget() {
			return hardware_budget;
		}
		public void setHardware_budget(String hardwareBudget) {
			this.hardware_budget = hardwareBudget;
		}
		public String getService_budget() {
			return service_budget;
		}
		public void setService_budget(String serviceBudget) {
			this.service_budget = serviceBudget;
		}
		public String getCommunication_budget() {
			return communication_budget;
		}
		public void setCommunication_budget(String communicationBudget) {
			this.communication_budget = communicationBudget;
		}
		public String getStorage_budget() {
			return storage_budget;
		}
		public void setStorage_budget(String storageBudget) {
			this.storage_budget = storageBudget;
		}
		public String getMiscellaneous_budget() {
			return miscellaneous_budget;
		}
		public void setMiscellaneous_budget(String miscellaneousBudget) {
			this.miscellaneous_budget = miscellaneousBudget;
		}
		public String getIt_contacts_count() {
			return it_contacts_count;
		}
		public void setIt_contacts_count(String it_contacts_count) {
			this.it_contacts_count = it_contacts_count;
		}
		public String getStock_ticker() {
			return stock_ticker;
		}
		public void setStock_ticker(String stock_ticker) {
			this.stock_ticker = stock_ticker;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getSic() {
			return sic;
		}
		public void setSic(String sic) {
			this.sic = sic;
		}
		/*public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}*/
		public String getLast_updated() {
			return last_updated;
		}
		public void setLast_updated(String last_updated) {
			this.last_updated = last_updated;
		}
}
