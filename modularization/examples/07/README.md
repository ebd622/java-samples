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
    
      ```
    This is ClientApp, it is a part of module com.myorg.theClient
    This is FirstApi, it is a part of module com.myorg.theFirstAPI
    ---Accessing Helper class and its methods
    com.myorg.impl.HelperImpl@65b54208
    Hello from HelperImpl
    ---Accessing secret() method via reflection
    public java.lang.String com.myorg.impl.HelperImpl.secret()
    se...t
        0.30 real         0.07 user         0.02 sys
            47955968  maximum resident set size
                   0  average shared memory size
                   0  average unshared data size
                   0  average unshared stack size
                3827  page reclaims
                 238  page faults
                   0  swaps
                   0  block input operations
                   0  block output operations
                   0  messages sent
                   0  messages received
                   0  signals received
                   4  voluntary context switches
                 449  involuntary context switches
           476369128  instructions retired
           225790024  cycles elapsed
            27362096  peak memory footprint
      ```
  * Using Custom java image:
      ```
      /usr/bin/time -l custom-image/bin/java -p output/mlib -m com.myorg.theClient/com.myorg.client.ClientApp 
      ```
      ```
    This is ClientApp, it is a part of module com.myorg.theClient
    This is FirstApi, it is a part of module com.myorg.theFirstAPI
    ---Accessing Helper class and its methods
    com.myorg.impl.HelperImpl@65b54208
    Hello from HelperImpl
    ---Accessing secret() method via reflection
    public java.lang.String com.myorg.impl.HelperImpl.secret()
    se...t
        0.09 real         0.07 user         0.01 sys
            39714816  maximum resident set size
                   0  average shared memory size
                   0  average unshared data size
                   0  average unshared stack size
                2809  page reclaims
                   0  page faults
                   0  swaps
                   0  block input operations
                   0  block output operations
                   0  messages sent
                   0  messages received
                   0  signals received
                   0  voluntary context switches
                 348  involuntary context switches
           540865277  instructions retired
           237488481  cycles elapsed
            21725976  peak memory footprint
      ```
