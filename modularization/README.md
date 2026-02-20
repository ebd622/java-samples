# Modularization
### History
* Java Modules came out of project [Jigsaw](https://openjdk.org/projects/jigsaw/) which has four big overaching goals.
* These goals were primarily implemented througt [JEP 200](https://openjdk.org/jeps/200) and [JEP 261](https://openjdk.org/jeps/261)

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
Get details on a specific module, for example the module `java.base`:
```
java --describe-module java.base
```

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
| --- | --- | --- |
| Level | Language/JVM | Build tool |
| Purpose | Encapsulation + dependency control at runtime | Project organization + build structure |
| Affects | Compilation, runtime, exports | Only structure of the build |
| File | module-info.java | pom.xml |
| Enforced by | Java compiler & JVM | Maven build lifecycle |

### The module descriptor
File **module-info.java** is called module descriptor or module declaration. 
It may have different **directives**, here are the full list.
#### Module declaration
* module – defines a named module
* open module – defines an open module (all packages are open for deep reflection)

#### Dependencies
* requires – declares a dependency on another module
* requires transitive – re-exports the dependency to downstream modules
* requires static – dependency needed at compile‑time but optional at run‑time

#### Exports and Opens
* **exports** – makes a package accessible to other modules
* **exports … to** – exports a package only to specific modules (qualified export)
* opens – opens a package for deep reflection (e.g., to frameworks like Jackson / Hibernate)
* open – opens all packages for reflection
* **opens … to** – opens a package only to specific modules (qualified opens)

#### Service Use and Implementation
* uses – declares dependence on a service (consumer)
* provides … with – registers a service implementation (provider)

#### Internal Access
permits (rare in modules; normally for sealed classes, but allowed if module-info declares sealed constructs inside)

#### Full list module directives
```
module
open module
requires
requires transitive
requires static
exports
exports ... to
opens
opens ... to
uses
provides ... with
```

# Usefull references
* [Cruising Along with Java](https://pragprog.com/titles/vscajava/cruising-along-with-java/)
* [ Java Modules: Why and How](https://youtu.be/DItYExUOPeM?si=xaS_oVbrA-VK7fWK)
* [Java 9 Modules: Why and How](https://youtu.be/X7ZB41Bj0lA?si=-IS9jgKLFmmwhoKL)
* [Java's Custom Runtime Builder - jlink](https://youtu.be/3UCBmdbeYm4?si=_8xeMwPgDZPoen5k)
