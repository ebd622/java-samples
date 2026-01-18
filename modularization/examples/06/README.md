# Hidden vs Exposed

* Module `theFirstAPI` exposes its package `com.myorg.first`, but does not expose `com.myorg.impl`
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
