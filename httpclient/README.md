


# Test TLS connection
This is a simple client app to test a mTLS connection, it uses Apache HttpClient.

Usage: </br>
Using highest TLS version available:
```
java -jar tls-client-demo-1.0.0.jar \
<store.jks> \
<password> \
<alias> \
<https://example.com/...> \
<GET | POST>
```

```
java -Djdk.tls.client.protocols=TLSv1.2 \
-jar tls-client-demo-1.0.0.jar \
<store.jks> \
<password> \
<alias> \
<https://example.com/...> \
<GET | POST>
```

