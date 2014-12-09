package com.hexaware.iprofile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javaxt.utils.Base64;

import com.sun.jersey.api.client.Client;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.bouncycastle.util.encoders.Hex;

/**
 * This class defines common routines for generating authentication signatures
 * for AWS Platform requests.
 */
public class Signature {
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	public static void main(String[] args) throws Exception {
		
		//String epoch = new String(System.currentTimeMillis() / 1000 + "");
		String epoch = "1389949027";
		System.out.println("*********** epoch  ***********  "  +epoch);
		calculateRFC2104HMAC("GET\n" + epoch+ "\n/contacts/company_details.json", "5kLdxM2WUd7bmVSviJYo",
				epoch);

	}

	/**
	 * Computes RFC 2104-compliant HMAC signature. * @param data The data to be
	 * signed.
	 * 
	 * @param key
	 *            The signing key.
	 * @return The Base64-encoded RFC 2104-compliant HMAC signature.
	 * @throws java.security.SignatureException
	 *             when signature generation fails
	 */
	public static String calculateRFC2104HMAC(String data, String key,
			String epoch) throws ClientProtocolException, IOException,
			java.security.SignatureException {
		String result = "";
		try {
			// get an hmac_sha1 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),
					HMAC_SHA1_ALGORITHM);

			// get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);

			// compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(data.getBytes());

			System.out.println("rawHmac :" + new String(rawHmac, "UTF-8"));
			@SuppressWarnings("static-access")
			byte[] hexBytes = new Hex().encode(rawHmac);
			System.out.println("rawHmac: " + new String(hexBytes, "UTF-8"));
			// base64-encode the hmac
			result = EncodeBase64(rawHmac);
			System.out.println("Result : " + result);

			String urlEncoded = URLEncoder.encode(result, "UTF-8");
			System.out.println("URL encoded :" + urlEncoded);

			/*String finalUrl = "https://salesiq.iprofile.net/companies/company_search.json?name=AB&api_key=U8SjpzvwMyZ7b9rVWahF&signature="
			+ urlEncoded + "&epoch=" + epoch;*/
			
			String finalUrl = "https://salesiq.iprofile.net/companies/company_details.json?id=50db55e0b4a6de0e38006840&api_key=U8SjpzvwMyZ7b9rVWahF&signature="
					+ urlEncoded + "&epoch=" + epoch;
			
			/* String finalUrl = "https://salesiq.iprofile.net/contacts/company_contact.json?id=50db55e0b4a6de0e38006840&api_key=U8SjpzvwMyZ7b9rVWahF&signature="
			 	+ urlEncoded + "&epoch=" + epoch;*/
			
			System.out.println("Final URL :" + finalUrl);

			HttpHost proxy = new HttpHost("hexproxy.hexaware.local", 3128,
					"http");
			HttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
					proxy);
			

			HttpGet request = new HttpGet(finalUrl);
			HttpResponse response = client.execute(request);
			System.out.println("response = " + response);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String EncodeBase64(byte[] rawData) {
		return Base64.encodeBytes(rawData);
	}

}