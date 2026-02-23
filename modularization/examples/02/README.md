# Unnamed modules
* JARs belongs to one (unnamed) module
* It is the same module - it has the same hash code:
* Output:
  ```
  --- All code running from the classpath belong to the one [unnamed module] ---
  This is ClientApp, it is a part of unnamed module @4fcb38dd
  This is FirstApi, it is a part of unnamed module @4fcb38dd
  ```
## Summary
* When you run your code from the `classpath`, all jars belong to the single `unnamed module`