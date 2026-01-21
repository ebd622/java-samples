# Opening for runtime while closing for compile time dependencies

* Module `theFirstAPI` **exports** its package `com.myorg.first`, and **opens** `com.myorg.impl`
    ```
    module com.myorg.theFirstAPI {
        exports com.myorg.first;
        opens com.myorg.impl; // Let's Client to access it
    }
    ```
    * Package `com.myorg.impl` is now open for reflection at runtime.
    * But still hidden at compile time.
* Check metadata of `theFirstAPI` module:
    ```
    jar -f output/mlib/first.jar -d
    ```
    * Output:
    ```
    com.myorg.theFirstAPI jar:file:.../java-samples/modularization/examples/07/output/mlib/first.jar!/module-info.class
    exports com.myorg.first
    requires java.base mandated
    opens com.myorg.impl
    ```
