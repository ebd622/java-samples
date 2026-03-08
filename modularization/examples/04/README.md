# Explicitly named modules
### Add module's descriptors
* Add module's descriptors to the app.jar and client.jar to explicitly name the modules and declare dependencies:
  ```shell
  04/app/module-info.java
  04/clientAPI/module-info.java
  ```
### Run jars using module path
* Remove classpath and only use module path to run the application (just to keep examples clean and simple).
* Run the application using module path and check that it works fine.
  ```shell
  This is Application, it is a part of module com.myorg.theApp
  This is ClientApi, it is a part of module com.myorg.theClientAPI
  ```
* Check the module descriptor of the module:
  ```shell
  jar -f output/mlib/client.jar -d
  ```
### Summary
* With explicit module descriptors, we can define the module name and its dependencies.
