module com.myorg.theFirstAPI {
    exports com.myorg.first;
    opens com.myorg.impl; // Let's Client to access it
}