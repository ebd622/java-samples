# Hidden vs Exposed

* Module `theFirstAPI` **exposes** its package `com.myorg.first`, but does not expose `com.myorg.impl`
    ```
    module com.myorg.theFirstAPI {
        exports com.myorg.first;
    }
    ```
  Package `com.myorg.impl` is hidden from other modules.
* Module `theClient` requires Module `theFirstAPI`
    ```
    module com.myorg.theClient {
        requires com.myorg.theFirstAPI;
    }
    ```
  * Class `ClientApp` in Module `theClient` can access public types in package `com.myorg.first`, but cannot access types in package `com.myorg.impl`
  * We cannot use `com.myorg.impl.HelperImpl` in `ClientApp`, because it is in a non-exported package:
    ```java
    // This will cause a compile-time error
    import com.myorg.impl.HelperImpl; 
    HelperImpl helperImpl = new HelperImpl(); // Error: HelperImpl is not accessible
    ```
    * So, implementation details are hidden from other modules, enforcing strong encapsulation.
    * This encapsulation helps maintain a clear separation between the public API (interface) and internal implementation, improving modular
* Check metadata of `theFirstAPI` module:
    ```
    jar -f output/mlib/first.jar -d
    ```
    * Output:
    ```
    com.myorg.theFirstAPI jar:file:.../java-samples/modularization/examples/07/output/mlib/first.jar!/module-info.class
    exports com.myorg.first
    requires java.base mandated
    contains com.myorg.impl
    ```
