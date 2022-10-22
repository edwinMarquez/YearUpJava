#### Modules

Java 9 introduces a new modular system. (JPMS)
Intended to help developers construct and maintaining large applications, 
Improve security and maintainability.
Improve performance, 
Scale down into smaller devices.


##### application

modules are declared in a file named `module-info.java` placed on the root directory: 

```java
module modulename{
    
}
```

modules can `require` other modules,
modules can `export` packages to other modules;

