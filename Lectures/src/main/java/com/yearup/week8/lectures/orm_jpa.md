### Object Relational Mapping (ORM)

Do notice on our Database Diagram, how data is presented in a table,however in our 
traditional java applications we use Objects to manipulate information.

### Java Persistence API. 

JPA is a standard, that libraries and frameworks can make use of, 
this standard provides the flexibility to define the data in our database to objects 
in our application.

It achieves this by defining some elements, 


#### - Entities
`Entities` : Entities are persistent objects, we can think of them as the tables of 
our database.

Requirements for entities are:
1. Class must be annotated as Entity.
2. Have a public or protected, no-argument constructor, (might have others)
3. Class must not be declared final, no methods or persist instance variables must be declared final
4. If an entity instance is passed by value as a detached object, such as through a session bean’s remote business interface, the class must implement the Serializable interface.
5. Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.
6. Persistent instance variables must be declared private, protected, or package-private and can be accessed directly only by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.





#### references:
[Java 6 EE JPA](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html)