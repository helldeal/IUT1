--1
select OBJECT_NAME, OBJECT_TYPE, CREATED from USER_OBJECTS
where object_type='TABLE';

--2
select table_name,tablespace_name from USER_TABLES;

--3
select COLUMN_NAME, DATA_TYPE, DATA_PRECISION from USER_TAB_COLUMNS;

--4
select * from USER_CONSTRAINTS where table_name in (select table_name from USER_TABLES);

--5
select * from USER_CONS_COLUMNS where table_name in (select table_name from USER_TABLES) ;

--6
select * from USER_VIEWS ;

--7
select * from USER_USERS;
select * from ALL_USERS;

--8
select * from USER_ROLE_PRIVS;

--9
select * from ROLE_ROLE_PRIVS;

--10
select * from ROLE_TAB_PRIVS where owner in('I2B07B','I2B06B');
select * from ROLE_TAB_PRIVS where owner in('BASETD');

--11
select * from SESSION_ROLES ;

--12
select * from USER_SYS_PRIVS;
