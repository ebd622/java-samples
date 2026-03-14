# Opening for runtime while closing for compile time dependencies

* Make change in the module `com.myorg.theClientAPI` to **open** the package `com.myorg.impl`: 
    ```
    module com.myorg.theClientAPI {
        exports com.myorg.client;
        opens com.myorg.impl; // Let's Client to access it
    }
    ```
    * Package `com.myorg.impl` is now open for reflection at runtime
    * But the package is still hidden at compile time.
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
  
## Summary
* By using `opens` directive, we can allow other modules to access non-exported packages at runtime via reflection, while keeping them hidden at compile time.
* This allows us to maintain strong encapsulation of our module's internal implementation, while still providing flexibility for runtime access when needed.
* This is particularly useful for frameworks and libraries that rely on reflection to access internal details of other modules, without exposing those details at compile time.