--DDL data definition language, create drop alter truncate.

CREATE TABLE IF NOT EXISTS user_inf (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	password VARBINARY(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_inf(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    userid INTEGER NOT NULL,
    balance INTEGER NOT NULL,
    FOREIGN KEY (userid) REFERENCES user_inf(id)
);

CREATE TABLE IF NOT EXISTS transaction_inf(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    userid INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    transactiontime BIGINT NOT NULL,
    FOREIGN KEY (userid) REFERENCES user_inf(id)
);



