# Running as automatic modules
* Use module path to run jars as automatic modules:
  ```shell
  java -p output/mlib -m client/com.myorg.client.ClientApp
  ```
* `-p output/mlib`: Sets the module path to the output/mlib directory, where modular JARs are located.
* `-m client/com.myorg.client.ClientApp`: Runs the main class com.myorg.client.ClientApp from the client module.
* 
TODO
