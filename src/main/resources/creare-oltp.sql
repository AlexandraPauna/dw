--Creare tabele BD OLTP
-------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE Tip_Zona(
    tipZona_id NUMBER(4) CONSTRAINT pk_tipZona PRIMARY KEY,
    denumire VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Regiune(
    regiune_id NUMBER(4) CONSTRAINT pk_regiune PRIMARY KEY,
    nume VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Subregiune(
    subregiune_id NUMBER(4) CONSTRAINT pk_subregiune PRIMARY KEY,
    nume VARCHAR2(50) UNIQUE NOT NULL,
    regiune_id NUMBER(4),
    CONSTRAINT fk_subregiune_regiune FOREIGN KEY(regiune_id) REFERENCES Regiune(regiune_id)
);

CREATE TABLE Judet(
    judet_id NUMBER(4) CONSTRAINT pk_judet PRIMARY KEY,
    nume VARCHAR2(50) UNIQUE NOT NULL,
    subregiune_id NUMBER(4),
    CONSTRAINT fk_judet_subregiune FOREIGN KEY(subregiune_id) REFERENCES Subregiune(subregiune_id )
);

CREATE TABLE Localitate(
    localitate_id NUMBER(4) CONSTRAINT pk_localitate PRIMARY KEY,
    nume VARCHAR2(50) NOT NULL,
    tipZona_id NUMBER(4),
    judet_id NUMBER(4),
    CONSTRAINT fk_localitate_tipZona FOREIGN KEY(tipZona_id) REFERENCES Tip_Zona(tipZona_id),
    CONSTRAINT fk_localitate_judet FOREIGN KEY(judet_id) REFERENCES Judet(judet_id)
);

CREATE TABLE Adresa(
    adresa_id NUMBER(4) CONSTRAINT pk_adresa PRIMARY KEY,
    strada VARCHAR2(50) NOT NULL,
    numar NUMBER(4) NOT NULL,
    cod_postal VARCHAR2(10),
    localitate_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_adresa_localitate FOREIGN KEY(localitate_id) REFERENCES Localitate(localitate_id)
);

CREATE TABLE Tip_Institutie_Invatamant(
    tipInstitutie_id NUMBER(4) CONSTRAINT pk_tipInstitutieInvatamant PRIMARY KEY,
    denumire VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Institutie_Invatamant(
    institutie_id NUMBER(4) CONSTRAINT pk_institutieInvatamant PRIMARY KEY,
    nume VARCHAR2(50) NOT NULL,
    tipInstitutie_id NUMBER(4),
    adresa_id NUMBER(4),
    CONSTRAINT fk_institutieInvatamant_tipInstitutieInvatamant 
        FOREIGN KEY(tipInstitutie_id) REFERENCES Tip_Institutie_Invatamant(tipInstitutie_id),
    CONSTRAINT fk_institutieInvatamant_adresa 
        FOREIGN KEY(adresa_id) REFERENCES Adresa(adresa_id)
);

CREATE TABLE Profesor(
    profesor_id NUMBER(4) CONSTRAINT pk_profesor PRIMARY KEY,
    prenume VARCHAR2(50) NOT NULL,
    nume VARCHAR2(50) NOT NULL,
    data_nasterii DATE,
    grad_didactic NUMBER(2)
);

--CREATE TABLE Institutie_Profesor(
--    institutie_id NUMBER(4) NOT NULL,
--    profesor_id NUMBER(4) NOT NULL,
--    CONSTRAINT fk_institutieProfesor_institutieInvatamant 
--        FOREIGN KEY(institutie_id) REFERENCES Institutie_Invatamant(institutie_id),
--    CONSTRAINT fk_institutieProfesor_profesor 
--        FOREIGN KEY(profesor_id) REFERENCES Profesor(profesor_id)
--);

CREATE TABLE Specializare_Didactica(
    specializare_id NUMBER(4) CONSTRAINT pk_specializareDidactica PRIMARY KEY,
    nume VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Profesor_Specializare(
    specializare_id NUMBER(4) NOT NULL,
    profesor_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_profesorSpecializare_specializareDidactica
        FOREIGN KEY(specializare_id) REFERENCES Specializare_Didactica(specializare_id),
    CONSTRAINT fk_profesorSpecializare_profesor 
        FOREIGN KEY(profesor_id) REFERENCES Profesor(profesor_id)
);

CREATE TABLE Profil(
    profil_id NUMBER(4) CONSTRAINT pk_profil PRIMARY KEY,
    denumire VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Specializare(
    specializare_id NUMBER(4) CONSTRAINT pk_specializare PRIMARY KEY,
    denumire VARCHAR2(50) UNIQUE NOT NULL,
    profil_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_specializare_profil FOREIGN KEY(profil_id) REFERENCES Profil(profil_id)
);

CREATE TABLE Clasa(
    clasa_id NUMBER(4) CONSTRAINT pk_clasa PRIMARY KEY,
    nume VARCHAR2(50) NOT NULL,
    nivel NUMBER(1) NOT NULL,
    an NUMBER(4) NOT NULL,
    specializare_id NUMBER(4) NOT NULL,
    institutie_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_clasa_specializare FOREIGN KEY(specializare_id) REFERENCES Specializare(specializare_id),
    CONSTRAINT fk_clasa_institutie FOREIGN KEY(institutie_id) REFERENCES Institutie_Invatamant(institutie_id)

);

CREATE TABLE Curs(
    curs_id NUMBER(4) CONSTRAINT pk_curs PRIMARY KEY,
    nume VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE Clasa_Curs_Profesor(
    id NUMBER(4) CONSTRAINT pk_clasa_curs_profesor PRIMARY KEY,
    curs_id NUMBER(4) NOT NULL,
    clasa_id NUMBER(4) NOT NULL,
    profesor_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_clasaCurs_curs FOREIGN KEY(curs_id) REFERENCES Curs(curs_id),
    CONSTRAINT fk_clasaCurs_clasa FOREIGN KEY(clasa_id) REFERENCES Clasa(clasa_id),
    CONSTRAINT fk_clasaCurs_profesor FOREIGN KEY(profesor_id) REFERENCES Profesor(profesor_id)
);

CREATE TABLE Elev(
    elev_id NUMBER(4) CONSTRAINT pk_elev PRIMARY KEY,
    prenume VARCHAR2(50) NOT NULL,
    nume VARCHAR2(50) NOT NULL,
    data_nasterii DATE,
    gen VARCHAR2(10),
    clasa_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_elev_clasa FOREIGN KEY(clasa_id) REFERENCES Clasa(clasa_id)
);

CREATE TABLE Nota(
    nota_id NUMBER(4) CONSTRAINT pk_nota PRIMARY KEY,
    valoare NUMBER(2) NOT NULL,
    data DATE NOT NULL,
    elev_id NUMBER(4) NOT NULL,
    curs_id NUMBER(4) NOT NULL,
    CONSTRAINT fk_nota_curs FOREIGN KEY(curs_id) REFERENCES Curs(curs_id),
    CONSTRAINT fk_nota_elev FOREIGN KEY(elev_id) REFERENCES Elev(elev_id)
);

CREATE TABLE Istoric(
    istoric_id NUMBER(4) CONSTRAINT pk_istoric PRIMARY KEY,
    elev_id NUMBER(4) NOT NULL,
    nivel NUMBER(1) NOT NULL,
    medie NUMBER(4,2) NOT NULL,
    an NUMBER(4) NOT NULL,
    CONSTRAINT fk_istoric_elev FOREIGN KEY(elev_id) REFERENCES Elev(elev_id)
);

CREATE USER oltp_admin IDENTIFIED BY parola;
GRANT CREATE SESSION TO oltp_admin;
GRANT CREATE TABLE TO oltp_admin;

COMMIT;
--pt drop
-- drop table Institutie_Profesor;
drop table Clasa_Curs_Profesor;
drop table Profesor_Specializare;
drop table Specializare_Didactica;
drop table profesor;
drop table nota;
drop table elev;
drop table clasa;
drop table specializare;
drop table Profil;
drop table Institutie_Invatamant;
drop table Tip_Institutie_Invatamant;
drop table adresa;

drop table localitate;
drop table judet;
drop table subregiune;
drop table Regiune;
drop table Tip_Zona;


