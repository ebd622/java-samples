# Java 17 features
Since Java 10 (March 2018), Java is on a 6 month release cycle. </br>
Java 17 is a LTS (Long Term Support) version, there are no major updates there. It includes 14 JEPs (JDK enhancement proposal).</br>
The next LTS version (Java 21) should be released in September of 2023.

## List of JEPS in Java 17
JEPs can be devided into 4 categories:
* Nice developer stuff
  * [JEP 406](https://openjdk.org/jeps/406): Pattern Matching for switch (Preview)
  * [JEP 409](https://openjdk.org/jeps/409): Sealed Classes
* Specific developer stuff
  * [JEP 306](https://openjdk.org/jeps/306): Restore Always-Strict Floating-Point Semantics
  * [JEP 356](https://openjdk.org/jeps/356): Enhanced Pseudo-Random Number Generators
  * [JEP 412](https://openjdk.org/jeps/412): Foreign Function & Memory API (Incubator)
  * [JEP 414](https://openjdk.org/jeps/414): Vector API (Second Incubator)
  * [JEP 415](https://openjdk.org/jeps/415): Context-Specific Deserialization Filters
* Keeping up with Apple stuff
  * [JEP 382](https://openjdk.org/jeps/382): New macOS Rendering Pipeline
  * [JEP 391](https://openjdk.org/jeps/391): macOS/AArch64 Port
* Cleaning up stuff
  * [JEP 398](https://openjdk.org/jeps/398): Deprecate the Applet API for Removal
  * [JEP 403](https://openjdk.org/jeps/403): Strongly Encapsulate JDK Internals
  * [JEP 407](https://openjdk.org/jeps/407): Remove RMI Activation
  * [JEP 410](https://openjdk.org/jeps/410): AOT and JIT Compiler
  * [JEP 411](https://openjdk.org/jeps/411): Deprecate the Security Manager for Removal

## Install JDK17 (macOS)
Use [sdkman](https://sdkman.io/) to manage development kits. [Here](https://sdkman.io/usage) are more usage examples.

Install SDK:
```
curl -s "https://get.sdkman.io" | bash
```
List all available java SDKs
```
sdk list java
```
List installed SDKs
```
sdk list java | grep installed
```
Install JDK17:
```
sdk install java 17.0.4-oracle
```
Check current version
```
sdk current java
```
```
java -version
```
Make use of a specific version:
```
sdk use java 17.0.4-oracle
```
```
sdk use java 11.0.2-open
```


## Resources
* [Java 17 is here](https://blogs.oracle.com/javamagazine/post/java-jdk-17-generally-available)
* [All new Java 17 in 5 minutes](https://youtu.be/m2ak1zI-M8g)
* [Java 17 API specification](https://cr.openjdk.java.net/~iris/se/17/latestSpec//api/index.html)
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [SdkMan](https://sdkman.io/usage)

