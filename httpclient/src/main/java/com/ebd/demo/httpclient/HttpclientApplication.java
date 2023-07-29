package com.ebd.demo.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.File;

@SpringBootApplication
public class HttpclientApplication {

	public static void main(String[] args) throws Exception {

		//SpringApplication.run(HttpclientApplication.class, args);
		//Creating SSLContextBuilder object
		SSLContextBuilder SSLBuilder = SSLContexts.custom();

		//Loading the Keystore file
		File file = new File("mykeystore.jks");
		SSLBuilder = SSLBuilder.loadTrustMaterial(file,
				"changeit".toCharArray());

		//Building the SSLContext usiong the build() method
		SSLContext sslcontext = SSLBuilder.build();

		//Creating SSLConnectionSocketFactory object
		SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());

		//Creating HttpClientBuilder
		HttpClientBuilder clientbuilder = HttpClients.custom();

		//Setting the SSLConnectionSocketFactory
		clientbuilder = clientbuilder.setSSLSocketFactory(sslConSocFactory);

		//Building the CloseableHttpClient
		CloseableHttpClient httpclient = clientbuilder.build();

		//Creating the HttpGet request
		HttpGet httpget = new HttpGet("https://example.com/");

		//Executing the request
		HttpResponse httpresponse = httpclient.execute(httpget);

		//printing the status line
		System.out.println(httpresponse.getStatusLine());

		//Retrieving the HttpEntity and displaying the no.of bytes read
		HttpEntity entity = httpresponse.getEntity();
		if (entity != null) {
			System.out.println(EntityUtils.toByteArray(entity).length);
		}
	}
}
