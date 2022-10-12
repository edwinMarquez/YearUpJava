#### Regular Expressions.


Regular expressions are a way to represent patterns that can be contained in a text. 

i.e. given a string we might be interested in finding any digits on it. 
one way to represent this would be: 

`[0-9]+`

We can add more complexity on it, for example saying that we are interested only if it is 
at least 3 digits long, 

`[0-9]{3,}`

we can add more complexity and say that we want to also capture decimal positions if it has some

`[0-9]{3,}\.?[0-9]*`

[reference](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)
