drop database bank if EXISTS;
CREATE database bank;
use bank;
create table accounts(
    `id` int PRIMARY KEY auto_increment,
    `name` VARCHAR(40) UNIQUE NOT NULL,
    `account` DECIMAL(12,4)
);

INSERT INTO accounts VALUES(null,'Tom',2000);
INSERT INTO accounts VALUES(null,'Jerry',2000);