# Opening for runtime while closing for compile time dependencies

* Module `com.myorg.theClientAPI` **exports** its package `com.myorg.client`, and **opens** `com.myorg.impl`
    ```
    module com.myorg.theClientAPI {
        exports com.myorg.client;
        opens com.myorg.impl; // Let's Client to access it
    }
    ```
    * Package `com.myorg.impl` is now open for reflection at runtime.
    * But still hidden at compile time.
* Check metadata of `com.myorg.theClientAPI` module:
    ```
    jar -f output/mlib/client.jar -d
    ```
    * Output:
    ```
    com.myorg.theClientAPI jar:file:.../java-samples/modularization/examples/07/output/mlib/client.jar!/module-info.class
    exports com.myorg.client
    requires java.base mandated
    opens com.myorg.impl
    ```