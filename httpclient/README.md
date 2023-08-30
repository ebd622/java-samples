


# Test TLS connection
This is a simple client app to test a mTLS/TLS connection. it uses Apache HttpClient.

Usage: </br>
Using default handshaking protocols for TLS clients:
```
java -jar tls-client-demo-1.0.0.jar \
<store.jks> \
<password> \
<alias> \
<https://example.com/...> \
<GET | POST>
```
To enable specific (TLSv1.2) [SunJSSE](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html) protocols on the client:
```
java -Djdk.tls.client.protocols=TLSv1.2 \
-jar tls-client-demo-1.0.0.jar \
<store.jks> \
<password> \
<alias> \
<https://example.com/...> \
<GET | POST>
```

