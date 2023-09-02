package com.ebd.demo.httpsclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.PrivateKeyDetails;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class ClientTLS implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(ClientTLS.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientTLS.class, args);
        System.exit(0);

        if(args.length < 3){
            System.out.println("No args provided");
            System.out.println("Usage: java -jar tls-client-demo-1.0.0.jar <truststore.jks> <password> <alias> <https://example.com/path/api> <GET|POST> ");
            System.exit(0);
        }
        System.out.println("---> TrustStore: " + args[0]);
        System.out.println("---> pass: " + args[1]);
        System.out.println("---> alias: " + args[2]);
        System.out.println("---> URL: " + args[3]);
        System.out.println("---> HTTP Method: " + args[4]);

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
                        return args[2];
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
        HttpUriRequest httpRequest;
        switch (args[4]) {
            case "GET":
                httpRequest = new HttpGet(args[3]);
                break;
            case "POST":
                httpRequest = new HttpPost(args[3]);
                break;
            default:
                httpRequest = new HttpGet(args[3]);
                break;
        }
        HttpResponse httpresponse = client.execute(httpRequest);

        //printing the status line
        System.out.println(httpresponse.getStatusLine());
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        log.info("NonOptionArgs: {}", args.getNonOptionArgs());
        log.info("OptionNames: {}", args.getOptionNames());
        args.getOptionNames().forEach(n -> log.info("Arg: {}={}",n,args.getOptionValues(n)));

//        for (String name : args.getOptionNames()){
//            log.info("arg-" + name + "=" + args.getOptionValues(name));
//        }
        boolean containsOption = args.containsOption("person.name");
        log.info("Contains person.name: " + containsOption);    }
}
