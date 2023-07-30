package com.ebd.demo.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@SpringBootApplication
public class HttpclientApplication /*implements CommandLineRunner*/ {

	private static Logger LOG = LoggerFactory.getLogger(HttpclientApplication.class);
//	public static void main(String[] args) {
//		SpringApplication.run(HttpclientApplication.class, args);
//	}

	//@Override
	public void run(String... args) throws Exception {
		if (args.length < 2) {
			System.out.println("No args provided...");
			System.exit(0);
		}

		System.out.println("--->Trust store: " + args[0]);
		System.out.println("--->Pass: " + args[1]);
		System.out.println("--->URL: " + args[2]);


		//Creating SSLContextBuilder object
		SSLContextBuilder SSLBuilder = SSLContexts.custom();

		//Loading the Keystore file
		File file = new File(args[0]);
		SSLBuilder = SSLBuilder.loadTrustMaterial(file,
				args[1].toCharArray());

		//Building the SSLContext usiong the build() method
		//SSLContext sslcontext = SSLBuilder.build();
		SSLContext sslcontext = createContext(file, args[1], "onboarding-organisations");

		//Creating SSLConnectionSocketFactory object
		//SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());
		SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sslcontext, null, null, NoopHostnameVerifier.INSTANCE);

		//Creating HttpClientBuilder
		HttpClientBuilder clientbuilder = HttpClients.custom();

		//Setting the SSLConnectionSocketFactory
		clientbuilder = clientbuilder.setSSLSocketFactory(sslConSocFactory);

		//Building the CloseableHttpClient
		CloseableHttpClient httpclient = clientbuilder.build();

		//Creating the HttpGet request
		//HttpUriRequest httpget = new HttpGet("https://distributie.services.rabobank.nl/klant/CreateActivities/3");
		HttpUriRequest httpPost = new HttpPost(args[2]);

		//Executing the request
		HttpResponse httpresponse = httpclient.execute(httpPost);

		//printing the status line
		System.out.println(httpresponse.getStatusLine());

		//Retrieving the HttpEntity and displaying the no.of bytes read
		HttpEntity entity = httpresponse.getEntity();
		if (entity != null) {
			System.out.println(EntityUtils.toByteArray(entity).length);
		}

	}
	private SSLContext createContext(File file, String keyStorePassword, String privateKeyAlias) throws Exception {
		final char[] password = keyStorePassword.toCharArray();
		// This keyStore could also come from `file.toURI().toURL();`
		final URL keyStore = file.toURI().toURL();
		//final URL keyStore = Application.class.getClassLoader().getResource(keyStorePath);

		return SSLContextBuilder.create()
				.loadKeyMaterial(keyStore, password, password, (aliases, socket) -> privateKeyAlias)
				.loadTrustMaterial(keyStore, password)
				.build();
	}
}
