package com.app.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	private static final String TYPE = "application/json";

	public static String get(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpGet get = new HttpGet(uri);
			response = client.execute(get);
			return EntityUtils.toString(response.getEntity());
		} finally {
			if (client != null) {
				client.close();
			}

			if (response != null) {
				response.close();
			}
		}
	}

	public static String postJson(String uri, String json) throws IOException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(uri);
			post.setHeader(HTTP.CONTENT_TYPE, TYPE);
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			response = client.execute(post);
			return EntityUtils.toString(response.getEntity());
		} finally {
			if (client != null) {
				client.close();
			}

			if (response != null) {
				response.close();
			}
		}
	}
	
	public static String post(String uri, Map<String, String> params, String encoding) throws IOException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(uri);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        if(params == null){
	            throw new IOException();
	        }
	        
	        for (Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
	        
	        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, encoding);
	        post.setEntity(entity);
			response = client.execute(post);
			return EntityUtils.toString(response.getEntity());
		} finally {
			if (client != null) {
				client.close();
			}

			if (response != null) {
				response.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(get("http://www.baidu.com"));
	}
}
