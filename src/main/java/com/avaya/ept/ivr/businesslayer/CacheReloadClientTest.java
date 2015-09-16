package com.avaya.ept.ivr.businesslayer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import java.io.InputStream;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;


public class CacheReloadClientTest {
	private static final String ACTION_PARAM = "action";
	private int requestTimeoutInSeconds = 3;
	
	public static void main(String args[]) throws Exception{
		CacheReloadClientTest client = new CacheReloadClientTest();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("dnis", "4443_44442");
		//String url = "http://135.122.6.204:9080/Butler/cacheInfoServlet";
		//String url = "http://135.122.6.204:9080/Butler/cacheInfoServlet?action=reload&dnis=4443_44442" + 
		//             "_44443_44444_44445_44446_44447_44448_44449_444412_444413_444414_444415_444417_444418_444419_444420" ;
		String DNISlist = "_44443_44444_44445_44446_44447_44448_44449_444412_444413_444414_444415_444417_444418_444419_444420";
		//String DNISlist = "_44443_44444";
		
		String repeatedDNISlist = "";
		for(int i =0;i<50;i++){
			repeatedDNISlist = repeatedDNISlist + DNISlist;
		}
		Thread job1 = new Thread(new CacheReloadRequest(DNISlist));
		Thread job2 = new Thread(new CacheReloadRequest(repeatedDNISlist));
		Thread job3 = new Thread(new CacheReloadRequest(repeatedDNISlist));
		job1.start();job2.start();job3.start();
	}
	
	public static class CacheReloadRequest implements Runnable{
		private String DNISlist;
		
		public CacheReloadRequest(String DNISlist){
			this.DNISlist = DNISlist;
		}

		@Override
		public void run(){
			// cache reload request
			String url = "http://135.122.6.204:9080/Butler/cacheInfoServlet?action=reload&dnis="+DNISlist;
			try{
			String response = sendGet(url);
			System.out.println("reponse value"+response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

		
		// HTTP GET request
		private static String sendGet(String url) throws Exception {
	 
			//String url = "http://www.google.com/search?q=mkyong";
	 
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
			// optional default is GET
			con.setRequestMethod("GET");
	 
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
	 
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());
			return response.toString();
	 
		}
}
