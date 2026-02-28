# Unnamed modules
* Get and print module-info from the classes:
  ```
  Application.class.getModule()
  ClientApi.class.getModule()
  ```
* Output:
  ```
  --- All code running from the classpath belong to the one [unnamed module] ---
  This is ClientApp, it is a part of unnamed module @4fcb38dd
  This is FirstApi, it is a part of unnamed module @4fcb38dd
  ```
* JARs belongs to one (unnamed) module
* It is the same module - it has the same hash code:

## Summary
* When you run your code from the `classpath`, all jars belong to the single `unnamed module`