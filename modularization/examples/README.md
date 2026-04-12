# Examples
## 01. Old code
### Before we start
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
  https://docs.oracle.com/en/java/javase/21/docs/api/index.html
  ```
    * You can see the list of modules and their packages with `directives`
### Run code
* Check jar structure:
  ```
  jar tf output/mlib/app.jar
  ```
* Works fine with classpath
* JARs are included into classpath

## 02. Unnamed modules
* Get and print module-info from the classes:
  ```
  Application.class.getModule()
  ClientApi.class.getModule()
  ```
  `getModule()` returns the module that this class or interface is a member of
* Output:
  ```
  --- All code running from the classpath belong to the one [unnamed module] ---
  This is ClientApp, it is a part of unnamed module @4fcb38dd
  This is FirstApi, it is a part of unnamed module @4fcb38dd
  ```
* JARs belongs to one (unnamed) module
* It is the same module - it has the same hash code:

### Summary
* When you run your code from the `classpath`, all jars belong to the single `unnamed module`

## 03. Running as automatic modules
### Run jars using module path
* Use module path to run jars as automatic modules:
  ```shell
  java -p output/mlib -m app/com.myorg.app.Application
  ```
* `-p output/mlib`: Sets the module path to the output/mlib directory, where modular JARs are located.
* `-m app/com.myorg.app.Application`: Runs the main class com.myorg.client.ClientApp from the client module.

### Get details about the modules
* To see details about the modules in the module path, use:
  ```shell
  jar -f output/mlib/app.jar -d
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
    * `client` is the name of the module, automatically derived from the JAR file name (client.jar).
    * It requires the java.base module, which is mandatory for all modules.
    * The keyword `mandated` `indicates that this requirement is added by the system **automatically**, even if you don’t declare it.

* So, with java modules we can get metadata about the modules and their dependencies, using native feature of java.

### Summary
* `Unnamed module` is not the same as `automatic module`.
* `Automatic modules` happen when you put a non-modular JAR on the module path. The module system derives the module name from the JAR filename.
* On the classpath, there is no derived name. It’s just part of the unnamed module.

## 04. Explicitly named modules
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
