# Java 21 features
Since Java 10 (March 2018), Java is on a 6 month release cycle. </br>
Java 21 is a LTS (Long Term Support) version, released on 19 Sepember 2023. There are no major updates there.</br>
The next LTS version (Java 25) will be released in ...

## JDK 21 features
### Language and tooling
* [JEP 430](https://openjdk.org/jeps/430): String Templates (Preview)
* [JEP 440](https://openjdk.org/jeps/440): Record Patterns
* [JEP 441](https://openjdk.org/jeps/441): Pattern Matching for switch
* [JEP 443](https://openjdk.org/jeps/443): Unnamed Patterns and Variables (Preview)
* [JEP 445](https://openjdk.org/jeps/445): Unnamed Classes and Instance Main Methods (Preview)
 
### Performance and Runtime
* [JEP 439](https://openjdk.org/jeps/439): Generational ZGC ("Z" garbage collector)
  * Was introduced in JDK15
  * Improved in JDK21 - generation capability has been added
* [JEP 444](https://openjdk.org/jeps/444): Virtual Threads
  * Light threads which don't drag around huge thread stack
  * Pay-as-you-go staacks (minimum size 200-300 bytes), stored in the heap
  * Scales to 1M+ concurrent connections on simple hardware (your loaptop)
  * Cheap enough to have a thread for every user request and async task
  * No need to pool them becasue they are cheap (pooling them in counterproductive)
  * Virtual threads transparently souspended/resumed when they block
  
### Libraries
* [JEP 431](https://openjdk.org/jeps/431): Sequenced Collections
* [JEP 442](https://openjdk.org/jeps/442): Foreign Function & Memory API (Third Preview)
* [JEP 446](https://openjdk.org/jeps/446): Scoped Values (Preview)
* [JEP 448](https://openjdk.org/jeps/448): Vector API (Sixth Incubator)
* [JEP 452](https://openjdk.org/jeps/452): Key Encapsulation Mechanism API
* [JEP 453](https://openjdk.org/jeps/453): Structured Concurrency (Preview)

### Housekeeping
* [JEP 449](https://openjdk.org/jeps/449): Deprecate the Windows 32-bit x86 Port for Removal
* [JEP 451](https://openjdk.org/jeps/451): Prepare to Disallow the Dynamic Loading of Agents

## Resources
* [JDK 21](https://openjdk.org/projects/jdk/21/)
* [Java21 Oracle](https://www.oracle.com/nl/java/technologies/downloads/#java21)
* [What's new for developers in JDK 21 ](https://developers.redhat.com/articles/2023/09/21/whats-new-developers-jdk-21#)
* [Java21 (from Devox BE 2023)](https://www.youtube.com/watch?v=eXCx2hW_xNI&t=29s)


