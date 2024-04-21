package com.ebd.demo.httpsclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;

@SpringBootApplication
public class ClientTLS implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(ClientTLS.class);


    public static void main(String[] args) {
        SpringApplication.run(ClientTLS.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
        //--- Check & get args
        log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        log.info("NonOptionArgs: {}", args.getNonOptionArgs());
        log.info("OptionNames: {}", args.getOptionNames());
        args.getOptionNames().forEach(name -> log.info("Arg: {}={}",name,args.getOptionValues(name)));

        //Get trustStore
        if(!args.containsOption("trustStore.name")){
            log.error("Arg [trustStore.name] is required");
            System.exit(0);
        }
        String trustStore = args.getOptionValues("trustStore.name").get(0);

        //--- 1. Get and check input parameters
        //Get password
        if(!args.containsOption("password")){
            log.error("Arg [password] is required");
            System.exit(0);
        }
        String pass = args.getOptionValues("password").get(0);

        //Get alias
        String alias = "1";
        if(args.containsOption("alias")){
            alias = args.getOptionValues("alias").get(0);
        } else {
            log.info("Arg [alias] is not provided. Using default value: {}", alias);
        }

        //Get tls-resource
        if(!args.containsOption("tls.resource")){
            log.error("Arg [tls.resource] is required");
            System.exit(0);
        }
        String resource = args.getOptionValues("tls.resource").get(0);

        //Get http-method
        String method = args.containsOption("http.method") ?
                args.getOptionValues("http.method").get(0) : "GET";

        //--- 2. Run TLS request
        // 2.1 Create KeyStore
        KeyStore identityKeyStore = KeyStore.getInstance("jks");
        FileInputStream identityKeyStoreFile = new FileInputStream(trustStore);
        identityKeyStore.load(identityKeyStoreFile, pass.toCharArray());

        // 2.2 Create TrustStore (not required)
        KeyStore trustKeyStore = KeyStore.getInstance("jks");
        FileInputStream trustKeyStoreFile = new FileInputStream(trustStore);
        trustKeyStore.load(trustKeyStoreFile, pass.toCharArray());

        // 2.3 Create SSLContext
        SSLContext sslContext = SSLContexts.custom()
                // load identity keystore
                .loadKeyMaterial(identityKeyStore, pass.toCharArray(), (aliases, socket) -> alias)
                // load trust keystore
                .loadTrustMaterial(trustKeyStore, null)
                .build();

        // 2.4 Create Factory
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                sslContext, new String[]{"TLSv1.2", "TLSv1.3"},
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        // 2.5 Creare a client
        CloseableHttpClient client = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();

        // Call a SSL-endpoint
        HttpResponse httpresponse = client.execute(new HttpGet(method));

        //printing the status line
        log.info("Result: {}", httpresponse.getStatusLine());
    }
}
