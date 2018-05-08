package com.mst.tika;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class PostJSON_Request {
	public static void main(String[] args) {
		PostJSON_Request.PostJSON_Request("");
	}
	public static void PostJSON_Request(String text) {
			// set URL to Post Request
           String post_url = "http://10.0.129.218:8080/mst-sentence-service-discovery/webapi/recommandation/save";
		  
           
		   try {
			   URL url = new URL(post_url);
			   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			   conn.setConnectTimeout(5000);
			   conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			   conn.setDoOutput(true);
			   conn.setDoInput(true);
			   conn.setRequestMethod("POST");
			   OutputStream os = conn.getOutputStream();
			   os.write(text.getBytes("UTF-8"));
			   os.close(); 
			   
			   // read the response
			   /*InputStream in = new BufferedInputStream(conn.getInputStream());
			   String result = IOUtils.toString(in, "UTF-8");
			   System.out.println(result);
			   System.out.println("result after Reading JSON Response");
			   JSONObject myResponse = new JSONObject(result);
			   System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
			   System.out.println("id- "+myResponse.getInt("id"));
			   System.out.println("result- "+myResponse.getString("result"));
			   in.close();*/
			   conn.disconnect();
           } 
		   catch (Exception e) {
				System.out.println(e);
			}
	}
}

