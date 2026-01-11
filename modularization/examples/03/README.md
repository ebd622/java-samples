# Running as automatic modules
* Use module path to run jars as automatic modules:
  ```shell
  java -p mylib.jar -m my.module/com.example.Main
  ```
* `-p output/mlib`: Sets the module path to the output/mlib directory, where modular JARs are located.
* `-m client/com.myorg.client.ClientApp`: Runs the main class com.myorg.client.ClientApp from the client module.
* 
TODO
