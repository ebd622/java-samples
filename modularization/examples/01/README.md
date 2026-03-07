# Old code
## Before we start
* How many modules do you have in your JRE (that are part of the JDK)?
  ```
  java --list-modules
  ```
* Get details on a specific module, for example the module java.base:
  ```
  java --describe-module java.base
  ```
* Mudules in javadoc:  
  ```
  https://docs.oracle.com/en/java/javase/25/docs/api/index.html
  ```
  * You can see the list of modules and their packages with `directives`
## Run code  
* Works fine with classpath
* JARs are included into classpath