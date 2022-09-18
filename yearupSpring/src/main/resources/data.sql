--DML data manipulation language. insert update delete


--note the password, is stored as a hash of the original password + some extra inf. 
insert into user_inf(id, name, password) values (1, 'Tom', HASH('SHA-256',CONCAT('','hello','SALT_random_string')));


insert into user_inf(id, name, password) values (2, 'SAM', HASH('SHA-256',CONCAT('','world','SALT_random_string')));

--DQL data query language: SELECT