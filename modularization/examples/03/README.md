# Running as automatic modules
### Run jars using module path
* Use module path to run jars as automatic modules:
  ```shell
  java -p output/mlib -m client/com.myorg.client.ClientApp
  ```
* `-p output/mlib`: Sets the module path to the output/mlib directory, where modular JARs are located.
* `-m client/com.myorg.client.ClientApp`: Runs the main class com.myorg.client.ClientApp from the client module.

### Get details about the modules
* To see details about the modules in the module path, use:
  ```shell
  jar -f output/mlib/client.jar -d
  ```
* `-d` option displays the module descriptor information from the specified JAR file.
* This will show the module name, dependencies, and other module-related information for the client module
* This is an output example:
  
  ```
  No module descriptor found. Derived automatic module.
  
  client automatic
  requires java.base mandated
  contains com.myorg.client
  ```
  
* So, with java modules we can get metadata about the modules and their dependencies, using native feature of java.