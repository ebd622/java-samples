# Hidden vs Exposed

* Module `theClientAPI` **exposes** its package `com.myorg.client`, but does not **expose** `com.myorg.impl`
    ```
    module com.myorg.theClientAPI {
        exports com.myorg.client;
    }
    ```
  Package `com.myorg.impl` is **hidden** from other modules.
* Module `theApp` requires Module `theClientAPI`
    ```
    module com.myorg.theApp {
        requires com.myorg.theClientAPI;
    }
    ```
  * Class `Application` in Module `theApp` can access public types in package `com.myorg.client`, but cannot access types in package `com.myorg.impl`
  * We cannot use `com.myorg.impl.HelperImpl` in `ClientApp`, because it is in a non-exported package:
    ```java
    // This will cause a compile-time error
    import com.myorg.impl.HelperImpl; 
    HelperImpl helperImpl = new HelperImpl(); // Error: HelperImpl is not accessible
    ```
    * So, implementation details are hidden from other modules, enforcing strong encapsulation.
    * This encapsulation helps maintain a clear separation between the public API (interface) and internal implementation, improving modular
* Check metadata of `theClientAPI` module:
    ```
    jar -f output/mlib/client.jar -d
    ```
    * Output:
    ```
    com.myorg.theClientAPI jar:file:.../java-samples/modularization/examples/07/output/mlib/client.jar!/module-info.class
    exports com.myorg.client
    requires java.base mandated
    contains com.myorg.impl
    ```
