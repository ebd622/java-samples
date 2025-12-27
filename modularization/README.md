# Modularization
### Benefits of Modularization
Modularization offers multiple benefits, by helping to do the following (1):
* clearly define the boundaries of subsystems
* thoroughly encapsulate the internals of modules or subsystems
* clarify dependencies at compile time and runtime
* make applications more secure
* easily validate architectural specifications related to dependencies
* provide stricter access control
* create smaller, targeted deployments

### Modularized Java
The JDK used to ship as one large **rt.jar** file that bundled almost the entire Java runtime, forcing applications to depend on everything even if they only needed a small portion. To better support modern, lightweight, cloud‑native needs, Java developers **modularized the JDK**, splitting it into many smaller modules and removing components unnecessary for most applications. This allows developers to depend only on the modules they need, reducing footprint and improving flexibility

List all modules in JRE java that are part of the JDK:

```
java --list-modules
```
### Java and Maven modules
Are these the same?
The answer is NO. Java modules and Maven modules are not the same thing. They solve different problems, operate at different layers, and have different purposes.



TODO

# Usefull references
* [Cruising Along with Java](https://pragprog.com/titles/vscajava/cruising-along-with-java/)
* [ Java Modules: Why and How](https://youtu.be/DItYExUOPeM?si=xaS_oVbrA-VK7fWK)
* https://youtu.be/X7ZB41Bj0lA?si=-IS9jgKLFmmwhoKL
