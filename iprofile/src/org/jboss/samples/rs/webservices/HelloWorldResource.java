package org.jboss.samples.rs.webservices;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/*@Path("/MyRESTApplication")
public class HelloWorldResource {

	@GET()
	@Produces("text/plain")
	public String sayHello() {
	    return "Hello World!";
	}
}

----------*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.client.ClientProtocolException;
import org.bouncycastle.util.encoders.Hex;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;




import org.infinispan.util.Base64;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hexaware.iprofile.Address;
import com.hexaware.iprofile.Company;
import com.hexaware.iprofile.Contact;
import com.hexaware.iprofile.Technology;
import com.hexaware.iprofile.dao.AddressDao;
import com.hexaware.iprofile.dao.CompanyDao;
import com.hexaware.iprofile.dao.ContactDao;
import com.hexaware.iprofile.dao.TechnologyDao;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Path("/MyRESTApplication")
public class HelloWorldResource {

	StringBuilder builder;
	String searchText, twitterReturnValue, alchemyReturnValue = "";
	ClientConfig config;
	Client client;
	WebResource iProfileSearchWebResource;
	WebResource iProfileComDetailsWebResource;
	WebResource iProfileContactsWebResource;
	JSONObject twitterJSONObject, alchemyJSONObject;
	String jsonOutput[];
	String epoch = "";
	//String signature = "";
	String apiKey = "";
	String secretKey = "";
	//String stringToSign = "";
	String output = "";
	String inputText ="";
	MultivaluedMap queryParams; 
	Resource r;
	BeanFactory factory;
	
	private final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	 HelloWorldResource() {
		builder = new StringBuilder();
		config = new DefaultClientConfig();
		client = Client.create(config);
		iProfileSearchWebResource = createIProfileSearchWebResource();
		iProfileComDetailsWebResource = createIProfileComDetailsWebResource();
		iProfileContactsWebResource = createIProfileContactsWebResource();
		//epoch = new String(System.currentTimeMillis() / 1000 + "");
		apiKey = "U8SjpzvwMyZ7b9rVWahF";
		secretKey = "5kLdxM2WUd7bmVSviJYo";
		//stringToSign = "GET\n" + epoch + "\n/companies/company_search.json";
		//stringToSign = "GET\n" + epoch + "\n/companies/company_details.json";
		r = new ClassPathResource("applicationContext.xml");
		factory = new XmlBeanFactory(r);
	}
	 
	@GET()
	@Path("/insert")
	@Produces(MediaType.TEXT_PLAIN)
	public String insert()
	{
	 	System.out.println("=========   H2DB  Connected    ==============");
		String strArray[] = null;
		try{
	        
	        AddressDao addressdao = (AddressDao) factory.getBean("addressBean");
			Address address = new Address();
			addressdao.saveAddress(address);
			System.out.println("===========  address inserted successfully   ===============");
		
			/*ContactDao contactDao = (ContactDao) factory.getBean("contactBean");
			Contact contact = new Contact();
			contact.setContact_id(new Long(0001));
			contact.setFirst_name("Vara");
			contact.setLast_name("Prasad");
			contactDao.saveContact(contact);
			System.out.println("Contact data successfully........");*/	
			
			CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
			Company c = new Company();
			//companydao.getCompany(1111);
			//companydao.readAll();
			
			c.setCompany_id("50db55e0b4a6de0e38006840");
			c.setName("Hexaware Technologies");
			c.setUrl("hexaware.com");
			c.setRevenue_range("123456789");
			c.setEmployee_range("9000+");
			c.setIndustry("ITServices");
			c.setIt_contacts_count("");
			c.setTwitter_url("");
			c.setLi_url("");
			c.setStock_ticker("");
			c.setOwnership_type("");
			c.setPhone("04447451724");
			c.setSic("");
			c.setDuns("");
			//c.setDescription("Innovation labs");
			c.setLast_updated("");
			
			//address.setAddress_id(new Long(11));
			address.setAddress1("SIPCOT IT PARK");
			address.setAddress2("Navallur post");
			address.setCity("Chennai");
			address.setState("AP");
			address.setZip("530026");
			address.setCountry("India");
			c.setAddress(address);
			
			companydao.saveCompany(c);
			//getCompany();
			companydao.readAll();
	  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data inserted succesfully";
	}
 
	@GET()
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public List getCompanies(){
		
		CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
		List list = companydao.readAll();
		return list;
	}
	
	
	@GET()
	@Path("/search/{name}")
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces("application/json")
	public String search(@PathParam("name") String inputText){
		CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
		epoch = new String(System.currentTimeMillis() / 1000 + "");
		List list = companydao.search(inputText);
		if(list.isEmpty()){
			HelloWorldResource iprofileFeed = new HelloWorldResource();
			//signature = iprofileFeed.signature;
			//epoch = iprofileFeed.epoch;
			String stringToSign = "GET\n" + epoch + "\n/companies/company_search.json";
			try {
				String signature = iprofileFeed.calculateRFC2104HMAC(
						stringToSign, "5kLdxM2WUd7bmVSviJYo");
				//System.out.println("signature :: "+signature);
				queryParams = new MultivaluedMapImpl();
				queryParams.add("name",inputText);
				queryParams.add("api_key", apiKey);
				queryParams.add("signature", signature);
				queryParams.add("epoch", epoch);
				//technologydao.readAll();
				output = iprofileFeed.readIProfile(queryParams, signature, epoch, inputText, iProfileSearchWebResource);
				//System.out.println("Final Output :: "+output);
				//getCompanySearch(output);
				//setCompanyDetails(output);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			output = "Record is already existed in local DB";
		}
		return output;
	}
	
	
    
  @GET()
  //@Produces("text/plain")
  @Path("/details/{id}")
  @Produces("application/json")
	public String companyDetails(@PathParam("id") String inputText) {
	  
	  	CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
		epoch = new String(System.currentTimeMillis() / 1000 + "");
		Company c = companydao.findCompany(inputText);
		if(c == null){
		  	epoch = new String(System.currentTimeMillis() / 1000 + "");
		    System.out.println("=============        Details Accept parameter ========= "+inputText);
			HelloWorldResource iprofileFeed = new HelloWorldResource();
			
			String stringToSign = "GET\n" + epoch + "\n/companies/company_details.json";
			try {
				String signature = iprofileFeed.calculateRFC2104HMAC(
						stringToSign, "5kLdxM2WUd7bmVSviJYo");
				queryParams = new MultivaluedMapImpl();
				
				queryParams.add("id",inputText);
				queryParams.add("api_key", apiKey);
				
				queryParams.add("signature", signature);
				queryParams.add("epoch", epoch);
				
				//technologydao.readAll();
	
				output = iprofileFeed.readIProfile(queryParams, signature, epoch, inputText, iProfileComDetailsWebResource);
				//getCompanySearch(output);
				setCompanyDetails(output);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return output;
	}
  
  @GET()
  //@Produces("text/plain")
  @Path("/contacts/{id}")
  @Produces("application/json")
	public String companyContact(@PathParam("id") String inputText) {

	  	System.out.println("=============     Contact Accept parameter ========= "+inputText);
		HelloWorldResource iprofileFeed = new HelloWorldResource();
		String stringToSign = "GET\n" + epoch + "\n/contacts/company_contact.json";
		
		try {
			String sign = iprofileFeed.calculateRFC2104HMAC(
					stringToSign, secretKey);
			
			queryParams = new MultivaluedMapImpl();
			
			queryParams.add("id",inputText);
			queryParams.add("api_key", apiKey);
			queryParams.add("signature", sign);
			queryParams.add("epoch", epoch);
			System.out.println("signature :: "+sign);
			
			//technologydao.readAll();

			output = iprofileFeed.readIProfile(queryParams, sign, epoch, inputText, iProfileContactsWebResource);
			System.out.println("Final Output :: "+output);
			
			//getCompanySearch(output);
			//getCompanyDetails(output);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	public WebResource createIProfileSearchWebResource() {
		iProfileSearchWebResource = client.resource("https://salesiq.iprofile.net/companies/company_search.json");		
		return iProfileSearchWebResource;
	}
	
	public WebResource createIProfileComDetailsWebResource() {
		iProfileComDetailsWebResource = client.resource("https://salesiq.iprofile.net/companies/company_details.json");
		return iProfileComDetailsWebResource;
	}
	
	public WebResource createIProfileContactsWebResource() {
		iProfileContactsWebResource = client.resource("https://salesiq.iprofile.net/contacts/company_contact.json");
		return iProfileContactsWebResource;
	}

	@SuppressWarnings({ "finally", "unchecked", "rawtypes" })
	public String readIProfile(MultivaluedMap queryParams,String signature, String epoch, String inputText, WebResource wr) {
		
		System.out.println("inputText"+inputText);
				
		try {
			System.out.println("queryParams Values :: " + queryParams.values());
					
			ClientResponse response = wr.queryParams(queryParams).accept("application/json")
					.get(ClientResponse.class);			

			int statusCode = response.getStatus();
			System.out.println("statusCode :: "+statusCode);
			String line = "";
			if (statusCode == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						response.getEntityInputStream()));
				
				while ((line = br.readLine()) != null) {
					output += line;
				}
			} else {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			return output;
		}
	}
	
	@SuppressWarnings("static-access")
	public String calculateRFC2104HMAC(String data, String key)
			throws ClientProtocolException, IOException,
			java.security.SignatureException {
		String result = "";
		String urlEncoded = "";
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),
					HMAC_SHA1_ALGORITHM);
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			
			byte[] hexBytes = new Hex().encode(rawHmac);
			result = EncodeBase64(rawHmac);
			
			urlEncoded = URLEncoder.encode(result, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return urlEncoded;
	}

	public String EncodeBase64(byte[] rawData) {
		return Base64.encodeBytes(rawData);
	}
	
	
	public String[] setCompanyDetails(String iprofile)
	{
		String strArray[] = null;
		try{
	        JSONObject req = new JSONObject(iprofile);
	        JSONObject reqId = new JSONObject(req.getString("id"));
	        JSONObject reqAddr = new JSONObject(req.getString("address"));
	        //strArray = new String[jsonArray.length()];
	       /* TechnologyDao technologydao = (TechnologyDao) factory.getBean("technologyBean");
			
			Technology technology = new Technology();
			technology.setTech_id(new Long(11));
			technology.setProduct(".net");
			technology.setVendor("Microsoft");
			technologydao.saveTechnology(technology);
			System.out.println("Technology data successfully........");*/
			
			AddressDao addressdao = (AddressDao) factory.getBean("addressBean");
			
			Address address = new Address();
			
			addressdao.saveAddress(address);
			
			/*ContactDao contactDao = (ContactDao) factory.getBean("contactBean");
			Contact contact = new Contact();
			contact.setContact_id(new Long(0001));
			contact.setFirst_name("Vara");
			contact.setLast_name("Prasad");
			contactDao.saveContact(contact);
			System.out.println("Contact data successfully........");*/	
			
			CompanyDao companydao = (CompanyDao) factory.getBean("companyBean");
			Company c = new Company();
		
			//companydao.getCompany(1111);
			//companydao.readAll();
			c.setCompany_id(reqId.getString("$oid"));
			c.setName(req.getString("name"));
			c.setUrl(req.getString("url"));
			c.setRevenue_range(req.getString("revenue"));
			c.setEmployee_range(req.getString("employees"));
			//c.setEmployee_range("5000");
			c.setIndustry(req.getString("industry"));
			c.setIt_contacts_count( req.getString("it_contacts_count"));
			c.setTwitter_url(req.getString("twitter_url"));
			c.setLi_url(req.getString("linkedin_url"));
			c.setStock_ticker(req.getString("stock_ticker"));
			c.setOwnership_type(req.getString("ownership_type"));
			c.setPhone(req.getString("phone"));
			c.setSic(req.getString("sic"));
			c.setDuns(req.getString("duns"));
			//c.setDescription(req.getString("description"));
			c.setLast_updated(req.getString("last_updated_at"));
			//address.setAddress_id(new Long(11));
			address.setAddress1(reqAddr.getString("address1"));
			//address.setAddress1("SIPCOT IT PARK");
			address.setAddress2(reqAddr.getString("address2"));
			//address.setAddress2("Gajuwaka junction");
			address.setCity(reqAddr.getString("city"));
			address.setState(reqAddr.getString("state"));
			address.setZip(reqAddr.getString("zip"));
			address.setCountry(reqAddr.getString("country"));
			c.setAddress(address);
			companydao.saveCompany(c);
			
			//getCompany();
	        
	    /* for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject jsonObject = jsonArray.getJSONObject(i);
	        String text = jsonObject.getString("name");
	        strArray[i]=text;
	        System.out.println("Company :" + text);
	      //  alchemyReturnValue+=readAlchemyAPI(text,alchemyWebResource);
	      }*/
	     //alchemyJSONObject = new JSONObject(alchemyReturnValue);
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		finally{
			return strArray;
		}
		
	}
	
	private String[] getCompanySearch(String iprofile)
	{
		//getCompany();
		String strArray[] = null;
		try{
	        JSONObject req = new JSONObject(iprofile);
	        JSONArray jsonArray =   req.getJSONArray("companies");
	        strArray = new String[jsonArray.length()];
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            String text = jsonObject.getString("id");
	            strArray[i] = text;
	            System.out.println("Company:" + text);
	       }
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return strArray;
		}
	}
}





/*System.out.println("=============reqId.getString("+ "$oid\") ================ "+reqId.getString("$oid"));

System.out.println("name  : "+ req.getString("name"));
System.out.println("url  : "+ req.getString("url"));
System.out.println("revenue  : "+ req.getString("revenue"));
System.out.println("employees  : "+ req.getString("employees"));

System.out.println("industry  : "+ req.getString("industry"));
System.out.println("it_contacts_count  : "+ req.getString("it_contacts_count"));
System.out.println("twitter_url  : "+ req.getString("twitter_url"));

System.out.println("stock_ticker  : "+ req.getString("stock_ticker"));
System.out.println("ownership_type  : "+ req.getString("ownership_type"));

System.out.println("address1  : "+ reqAddr.getString("address1"));
System.out.println("address2  : "+ reqAddr.getString("address2"));
System.out.println("city  : "+ reqAddr.getString("city"));
System.out.println("state  : "+ reqAddr.getString("state"));
System.out.println("zip  : "+ reqAddr.getString("zip"));
System.out.println("country  : "+ reqAddr.getString("country"));
System.out.println("country_code  : "+ reqAddr.getString("country_code"));*/