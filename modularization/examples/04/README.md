# Explicitly named modules
* Remove classpath and only use module path to run the application (just to keep examples clean and simple).
* Add module's descriptor to the client and server projects to explicitly name the modules and declare dependencies.
* Check the module descriptor of the module:
  ```shell
  jar -f output/mlib/client.jar -d
  ```

TODO
