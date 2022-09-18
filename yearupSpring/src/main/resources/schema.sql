--DDL data definition language, create drop alter truncate.

CREATE TABLE IF NOT EXISTS user_inf (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	password VARBINARY(32) NOT NULL
);

