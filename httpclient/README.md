


# Test TLS connection
This is a simple client app to test a mTLS/TLS connection. </br>
The client uses Apache HttpClient.

## Usage
#### Using default handshaking protocols for TLS clients:
```
java -jar tls-client-demo-1.0.0.jar \
--trustStore.name=ttsName.jks \
--password=pass \
--alias=aliasName \
--tls.resource=https://test.resource.com/ \
--http.method=GET
```

##### To enable specific (TLSv1.2) [SunJSSE](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html) protocols on the client:
```
java -Djdk.tls.client.protocols=TLSv1.2 \
-jar tls-client-demo-1.0.0.jar \
--trustStore.name=ttsName.jks \
--password=pass \
--alias=aliasName \
--tls.resource=https://test.resource.com/ \
--http.method=GET
```
Create and run jar:
```
mvn spring-boot:run -Dspring-boot.run.arguments=" \
--trustStore.name=ttsName.jks \
--password=pass \
--alias=aliasName \
--tls.resource=https://test.resource.com/ \
--http.method=GET"
```
