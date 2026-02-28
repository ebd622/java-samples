module com.myorg.theClientAPI {
    exports com.myorg.client;
    opens com.myorg.impl; // Let's Application to access it
}