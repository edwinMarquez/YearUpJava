--DML data manipulation language. insert update delete


--note the password, is stored as a hash of the original password + some extra inf. 
insert into user_inf(id, name, username, password) values (0, 'Tom', 'Tom111', HASH('SHA-256',CONCAT('','hello','SALT_random_string')));


insert into account_inf(id, userid, balance) values (0, 0, 500000);



--DQL data query language: SELECT