### DDL, DML, DQL.

Here is a quick view of what it means:


#### DDL 

Data Definition Language. 

CREATE, ALTER, DROP.

Sample from yearUpJava: 
```roomsql
CREATE TABLE IF NOT EXISTS user_inf (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(200) NOT NULL UNIQUE,
	name VARCHAR(200) NOT NULL,
	password VARBINARY(32) NOT NULL
);
```

#### DML 

Data Manipulation Language.

INSERT, UPDATE, DELETE

Sample from yearUpJava:

```roomsql
insert into user_inf(id, name, username, password) 
values (0, 'Tom', 'Tom111', HASH('SHA-256',CONCAT('','some-password','salt')));
```

#### DQL

Data Query Language.

SELECT

```roomsql
SELECT * FROM ACCOUNT_INF 
```

------
There are of course more instructions related to each one of this "types"


