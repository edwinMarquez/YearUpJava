### Database Constraints

A constraint is a rule, or some enforcement we put on the values for a field on a table

i.e. In the database we are using for our yearupSpring, for our table creation we can find the
`NOT NULL` constraint, this enforces that field on the table to verify that a null value is 
not inserted.

for the h2 database that we are using, `NOT NULL`, is a type of `Column Constraint`
defined as: 

```roomsql
	[ constraintNameDefinition ]
NOT NULL | PRIMARY KEY | UNIQUE | referencesSpecification | CHECK (condition)
```



`Primary Key` is another type of constraint we have seem defined as: 
```roomsql
	[ constraintNameDefinition ]
{ PRIMARY KEY [ HASH ] ( columnName [,...] ) }
    | UNIQUE ( { columnName [,...] | VALUE } )
    | referentialConstraint
    | CHECK (condition)
```

We hava also seen `FOREIGN KEY` that rooms defines as a `Referential Constraint`

```roomsql
FOREIGN KEY (columnName[...]) 	REFERENCES [ refTableName ] [ ( refColumnName [,...] ) ]
[ ON DELETE referentialAction ] [ ON UPDATE referentialAction ]
```
referential action.
```roomsql
	CASCADE | RESTRICT | NO ACTION | SET { DEFAULT | NULL }
```



#### references
[H2 Grammar definition](https://www.h2database.com/html/grammar.html#constraint_name_definition)


[back](outline.md)