/usr/local/mysql-5.5.17-osx10.6-x86_64/bin/mysql -u root

CREATE TABLE maroshibooks
(
entry_id INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(entry_id),
regnum varchar(255),
section varchar(255),
isbn varchar(255),
title varchar(255),
author varchar(255),
publisher varchar(255),
pubdate int,
remarks varchar(255)
);

CREATE TABLE maroshibrrowers
(
entry_id INT NOT NULL AUTO_INCREMENT, 
PRIMARY KEY(entry_id),
name varchar(255),
book_entry_id int,
return_date varchar(255)
);

INSERT INTO maroshibrrowers
VALUES (value1,value2,value3,...);

LOAD DATA INFILE '/Users/elena/maroshi/jf_page.csv'
INTO TABLE maroshibooks (regnum, section, isbn, title, author,publisher,pubdate,remarks)
;

LOAD DATA INFILE '/Users/elena/maroshi/f_page.csv'
INTO TABLE maroshibooks (regnum, section, isbn, title, author,publisher,pubdate,remarks)
;

delete from maroshibooks where title = 'TITLE';

mysql> select count(1) from maroshibooks;
+----------+
| count(1) |
+----------+
|     6132 |
+----------+
1 row in set (0.00 sec)

