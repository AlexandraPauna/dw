--adresa
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Vacarescu', 3, 123456, 9);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Lazar', 7, 123456, 9);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Haret', 13, 23455, 4);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Popa I', 3, 123456, 8);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Bd.Tineretului', 3, 123456, 10);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Aliorului', 3, 123456, 1);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Crisul Rece', 3, 123456, 3);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Principala', 3, 123456, 2);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('aleeea Ciceu', 3, 123456, 7);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Vacarescu', 3, 123456, 9);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Lazar', 7, 123456, 9);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Haret', 13, 23455, 4);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Popa I', 3, 123456, 8);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Bd.Tineretului', 3, 123456, 10);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Aliorului', 3, 123456, 1);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Crisul Rece', 3, 123456, 3);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Principala', 3, 123456, 2);
insert into Adresa(strada, numar, cod_postal, localitate_id) values('Aleea Trandafirilor', 3, 123567, 11);

--institutii
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Lazar', 1, 1);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul National Ienachita Vacarescu', 1, 2);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul National Constantin Carabella', 1, 3);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala Generala nr 5', 2, 4);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala Generala nr 1', 2, 5);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Liceul Cuza', 1, 6);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Liceul de arte', 1, 7);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul Tehnic', 1, 8);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala Normala', 2, 9);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('British College', 1, 10);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala Generela 6', 2, 11);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala Generela 10', 2, 12);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul Spiru Haret', 1, 13);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Liceul tehnologic nr 7', 1, 14);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul francez', 1, 15);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Colegiul Eliade', 1, 16);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('Scoala speciala', 2, 17);
insert into institutie_invatamant(nume, tipinstitutie_id, adresa_id) values ('CN Mihai Viteazu', 1, 18);

--clase
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('A', 10, 2000, 10, 5);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('B', 11, 2000, 11, 5);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('C', 12, 2000, 2, 5);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('D', 9, 2000, 9, 5);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('A', 1, 2000, 1, 3);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('B', 2, 2000, 2, 3);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('C', 3, 2000, 4, 3);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('D', 4, 2000, 6, 3);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('A', 5, 2006, 14, 8);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('E', 7, 2006, 11, 8);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('I', 9, 2011, 19, 8);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('C', 2, 2011, 18, 2);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('B', 4, 2010, 16, 2);
insert into clasa(nume, nivel, an, specializare_id, institutie_id) values ('F', 1, 2010, 9, 2);

--curs
insert into curs(nume) values ('Limba romana');
insert into curs(nume) values ('Limba franceza');
insert into curs(nume) values ('Limba engleza');
insert into curs(nume) values ('Limba italiana');
insert into curs(nume) values ('Fizica');
insert into curs(nume) values ('Chimie');
insert into curs(nume) values ('Sport');
insert into curs(nume) values ('Stiinte');
insert into curs(nume) values ('Desen');
insert into curs(nume) values ('Logica');
insert into curs(nume) values ('Geografie');
insert into curs(nume) values ('Istorie');

--elevi
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Ioana', 'Popescu', '11-JAN-1998', 'F', 2);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Maria', 'Pop', '14-JAN-1999', 'F', 2);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Larisa', 'Zamfir', '10-FEB-1997', 'F', 2);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Mircea', 'Ilie', '1-DEC-1998', 'M', 2);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Corina', 'Adam', '21-JUN-1998', 'F', 2);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Ana-Maria', 'Crisan', '11-JAN-2000', 'F', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Roberta', 'Cristescu', '10-MAY-2000', 'F', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Alexandra', 'Ivan', '8-DEC-2001', 'F', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Mihai', 'Popescu', '17-JAN-2000', 'M', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Cosmin', 'Lazar', '9-FEB-2000', 'M', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Marius', 'Cosma', '5-DEC-2000', 'M', 5);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Ioana', 'Ilie', '11-JAN-2003', 'F', 8);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Crina', 'Stefan', '11-DEC-2003', 'F', 8);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Alexandru', 'Iliescu', '11-MAY-2002', 'M', 8);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Crina', 'Vlad', '11-JUN-2003', 'F', 8);
insert into elev(prenume, nume, data_nasterii, gen, clasa_id) values ('Stefan', 'Moraru', '31-JAN-2002', 'M', 8);

commit;
