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
* SDK image vs custom image:
  * JDK java image: 
    ```
    java -version
    ```
    ```
    du -sk ~/.sdkman/candidates/java/21.0.2-open  
    ```
  * Custom java image:
    ```
    ./custom-image/bin/java -version
    ```
    ```
    du -sk custom-image
    ```
* Run application (functionally there is no differences between JDK java image and custom java image):
  * Using JDK java image: 
      ```
      java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application 
      ```
  * Using Custom java image:
      ```
      custom-image/bin/java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application 
      ```
* Run application to get some details of runtime performance:
  * Using JDK java image:
      ```
      /usr/bin/time -l java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application
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
           0.13 real         0.05 user         0.03 sys
            47611904  maximum resident set size
                   0  average shared memory size
                   0  average unshared data size
                   0  average unshared stack size
                2356  page reclaims
                1695  page faults
                   0  swaps
                   0  block input operations
                   0  block output operations
                   0  messages sent
                   0  messages received
                   0  signals received
                  15  voluntary context switches
                 796  involuntary context switches
           516126489  instructions retired
           254151493  cycles elapsed
            27067280  peak memory footprint    
      ```
  * Using Custom java image:
      ```
      /usr/bin/time -l custom-image/bin/java -p output/mlib -m com.myorg.theApp/com.myorg.app.Application 
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
            0.08 real         0.06 user         0.01 sys
            39796736  maximum resident set size
                   0  average shared memory size
                   0  average unshared data size
                   0  average unshared stack size
                2815  page reclaims
                   0  page faults
                   0  swaps
                   0  block input operations
                   0  block output operations
                   0  messages sent
                   0  messages received
                   0  signals received
                   0  voluntary context switches
                 323  involuntary context switches
           536785409  instructions retired
           227064807  cycles elapsed
            21824304  peak memory footprint

      ```
