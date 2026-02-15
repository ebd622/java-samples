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
## Build custom java image with jlink
* List modules
  * JDK java image: 
    ```
    java --list-modules
    ```
  * Custom java image:
    ```
    ./custom-image/bin/java --list-modules
    ```
* Run application (functionally there is no differences between JDK java image and custom java image):
  * Using JDK java image: 
      ```
      java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp
      ```
  * Using Custom java image:
      ```
      custom-image/bin/java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp 
      ```
* Run application to get some details of runtime performance:
  * Using JDK java image:
      ```
      /usr/bin/time -l java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp
      ```
  * Using Custom java image:
      ```
      /usr/bin/time -l custom-image/bin/java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp 
      ```
