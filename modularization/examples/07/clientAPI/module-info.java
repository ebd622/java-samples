module com.myorg.theFirstAPI {
    exports com.myorg.client;
    opens com.myorg.impl; // Let's Client to access it
}