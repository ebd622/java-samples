# Fail fast

* When running the application with the `classpath` Java tries to load 
classes directly from the JARs listed in the classpath. 
  
  If a required class is missing, you get a ClassNotFoundException or NoClassDefFoundError `at runtime after the application starts`.
* When running the application with the `module path`, Java’s module system checks for all required modules `before starting`.
  
  If a required module is missing, we get a fast fail: java.lang.module.FindException during boot layer initialization, and the application does not start.

## Summary:
* Classpath: Error occurs later, when the missing class is actually used (ClassNotFoundException).
* Module path: Error occurs immediately, `before the application starts` (FindException), because the module system enforces dependencies strictly at startup.
* With Module path:
  * The application fails fast if a required module is missing, preventing runtime errors and unpredictable behavior.
  * The module path provides stronger dependency management and early error detection, making your application safer and easier to troubleshoot.