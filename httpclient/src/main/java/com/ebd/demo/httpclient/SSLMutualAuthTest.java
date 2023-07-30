package com.ebd.demo.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.PrivateKeyDetails;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Map;

public class SSLMutualAuthTest {

    public static void main(String[] args) throws Exception {
        if(args.length < 3){
            System.out.println("No args provided");
            System.out.println("Usage: java -jar SSLMutualAuthTest <truststore.jks> <password> <alias> <https://example.com/path/api> ");
            System.exit(0);
        }

        System.out.println("---> Run SSLMutualAuthTest");
        String CERT_ALIAS = "onboarding-organisations";
        KeyStore identityKeyStore = KeyStore.getInstance("jks");
        FileInputStream identityKeyStoreFile = new FileInputStream(args[0]);

        identityKeyStore.load(identityKeyStoreFile, args[1].toCharArray());
        KeyStore trustKeyStore = KeyStore.getInstance("jks");

        FileInputStream trustKeyStoreFile = new FileInputStream(args[0]);
        trustKeyStore.load(trustKeyStoreFile, args[1].toCharArray());

        SSLContext sslContext = SSLContexts.custom()

                // load identity keystore
                .loadKeyMaterial(identityKeyStore, args[1].toCharArray(), new PrivateKeyStrategy() {

                    @Override
                    public String chooseAlias(Map<String, PrivateKeyDetails> aliases, Socket socket) {
                        return CERT_ALIAS;
                    }
                })

                // load trust keystore
                .loadTrustMaterial(trustKeyStore, null)
                .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                sslContext, new String[]{"TLSv1.2", "TLSv1.3"},
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        CloseableHttpClient client = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();

        // Call a SSL-endpoint
        HttpUriRequest httpPost = new HttpPost("https://distributie.services.rabobank.nl/klant/GetRelation/7/");

        HttpResponse httpresponse = client.execute(httpPost);

        //printing the status line
        System.out.println(httpresponse.getStatusLine());
    }
}
