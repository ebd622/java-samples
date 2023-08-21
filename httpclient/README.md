


# Mutual TLS test
This is a simple client app to test a mTLS connection, it uses Apache HttpClient.
Usage: </br>
`
java -Djdk.tls.client.protocols=TLSv1.2 \ \n

-jar tls-client-demo-1.0.0.jar \
<store.jks> \
<password> \
<alias> \
<https://example.com/...> \
<GET | POST>
`
