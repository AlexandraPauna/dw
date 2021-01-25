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
