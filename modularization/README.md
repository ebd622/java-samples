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
TODO

### Java and Maven modules
Are these the same?
The answer is NO. Java modules and Maven modules are not the same thing. They solve different problems, operate at different layers, and have different purposes.

#### Java Modules
Java modules are a language-level and runtime-level construct.

Their purpose:
* Define strong encapsulation of packages
* Control what packages are exported
* Declare dependencies on other Java modules
* Help build modular JARs
* Improve security and maintainability

Think of Java modules as:</br>
✔ part of the Java language and JVM </br>
✔ affecting compilation and runtime behavior</br>
✔ enabling jlink, jmod, strongly encapsulated JARs</br>

#### Maven Modules
Maven modules are a **build-organization concept**, not a language feature.</br>
Their purpose:
* Organize a project into multiple subprojects
* Share parent configuration (dependencies, plugins, versions)
* Build multiple artifacts with one command
* Improve maintainability of large codebases

Think of Maven modules as:</br>
✔ part of the build tool</br>
✔ just folders and POMs</br>
✔ do not affect the JVM, encapsulation, or runtime behavior</br>

#### How they differ
| Area | Java Module | Maven module |
| ---- | ----------- | -------------|
| Area | Java Module | Maven module |

# Usefull references
* [Cruising Along with Java](https://pragprog.com/titles/vscajava/cruising-along-with-java/)
* [ Java Modules: Why and How](https://youtu.be/DItYExUOPeM?si=xaS_oVbrA-VK7fWK)
* https://youtu.be/X7ZB41Bj0lA?si=-IS9jgKLFmmwhoKL
