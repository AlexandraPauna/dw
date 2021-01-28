--in sqlplus
--deschizi cmd
sqlplus sys as sysdba
--bagi parola de sys
alter session set container=orclpdb;

CREATE USER oltp_admin IDENTIFIED BY parola;
GRANT CREATE SESSION TO oltp_admin;
GRANT CREATE TABLE TO oltp_admin;
GRANT SELECT ANY SEQUENCE TO oltp_admin;
GRANT CREATE ANY SEQUENCE TO oltp_admin;
ALTER USER oltp_admin quota 50M on USERS;

CREATE USER olap_admin IDENTIFIED BY parola;
GRANT CREATE SESSION TO olap_admin;
GRANT CREATE TABLE TO olap_admin;
GRANT SELECT ANY SEQUENCE TO olap_admin;
GRANT CREATE ANY SEQUENCE TO olap_admin;
ALTER USER olap_admin quota 50M on USERS;

grant create session to olap_admin;

grant create any directory to olap_admin;
grant create table to olap_admin;
grant create procedure to olap_admin;
grant select any sequence to olap_admin;
grant create any sequence to olap_admin;
alter USER olap_admin quota 50M on USERS;

