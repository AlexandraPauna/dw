--Tabel TipZona
insert into Tip_Zona
values(1,'Rural');

insert into Tip_Zona
values(2,'Urban');

--Tabel TipInstitutieInvatamant
insert into Tip_Institutie_Invatamant
values(1,'Gimnaziu');

insert into Tip_Institutie_Invatamant
values(2,'Liceu');

--Tabel Profil
insert into Profil
values(1,'Umanist');

insert into Profil
values(2,'Real');

insert into Profil
values(3,'Militar');

insert into Profil
values(4,'Teologic');

insert into Profil
values(5,'Artistic');

insert into Profil
values(6,'Pedagogic');

insert into Profil
values(7,'Sportiv');

insert into Profil
values(8,'Tehnic');

insert into Profil
values(9,'Servicii');

insert into Profil
values(10,'Resurse naturale şi protecţia mediului');

--Tabel Specializare
insert into Specializare
values(1,'Filologie',1);

insert into Specializare
values(2,'Stiinte sociale',1);

insert into Specializare
values(3,'Matematica–informatica',2);

insert into Specializare
values(4,'Stiinte ale naturii',2);

insert into Specializare
values(5,'Aviatie',3);

insert into Specializare
values(6,'Tetrestru',3);

insert into Specializare
values(7,'Teologie: teologic ortodox',4);

insert into Specializare
values(8,'Teologie: patrimoniu cultural',4);

insert into Specializare
values(9,'Teologie: teologic catolic',4);

insert into Specializare
values(10,'Arhitectură',5);

insert into Specializare
values(11,'Arte ambientale şi design',5);

insert into Specializare
values(12,'Arte plastice şi decorative',5);

insert into Specializare
values(13,'Muzică',5);

insert into Specializare
values(14,'Coregrafie',5);

insert into Specializare
values(15,'Învăţător-educatoare',6);

insert into Specializare
values(16,'Bibliotecar-documentarist',6);

insert into Specializare
values(17,'Pedagog şcolar',6);

insert into Specializare
values(18,'Instructor pentru activităţi extraşcolare',6);

insert into Specializare
values(19,'Sportiv',7);

insert into Specializare
values(20,'Tehnic',8);

insert into Specializare
values(21,'Servicii',9);

insert into Specializare
values(22,'Resurse naturale şi protecţia mediului',10);

--- Tabela Specializare_Didactica
insert into Specializare_Didactica
values(1,'Matematica');

insert into Specializare_Didactica
values(2,'Informatica');

insert into Specializare_Didactica
values(3,'Fizica');

insert into Specializare_Didactica
values(4,'Chimie');

insert into Specializare_Didactica
values(5,'Biochimie tehnologica');

insert into Specializare_Didactica
values(6,'Biologie');

insert into Specializare_Didactica
values(7,'Biochimie');

insert into Specializare_Didactica
values(8,'Ecologie');

insert into Specializare_Didactica
values(9,'Geografie');

insert into Specializare_Didactica
values(10,'Geologie');

insert into Specializare_Didactica
values(11,'Istorie');

insert into Specializare_Didactica
values(12,'Filosofie');

insert into Specializare_Didactica
values(13,'Drept');

insert into Specializare_Didactica
values(14,'Administratie publica');

insert into Specializare_Didactica
values(15,'Psihologie');

insert into Specializare_Didactica
values(16,'Pedagogie');

insert into Specializare_Didactica
values(17,'Psihopedagogie specială');

insert into Specializare_Didactica
values (18, 'Sociologie');

insert into Specializare_Didactica
values(19,'Psihosociologie');

insert into Specializare_Didactica
values(20,'Teologie ortodoxa');

insert into Specializare_Didactica
values(21,'Teologie romano/greco-catolica');

insert into Specializare_Didactica
values(22,'Limba  şi  literatura  română');

insert into Specializare_Didactica
values(23,'Limbi şi literaturi străine: franceza');

insert into Specializare_Didactica
values(24,'Limbi şi literaturi străine: latina');

insert into Specializare_Didactica
values(25,'Limbi şi literaturi străine: italiana');

insert into Specializare_Didactica
values(26,'Limbi şi literaturi străine: engleza');

insert into Specializare_Didactica
values(27,'Limbi şi literaturi străine: germana');

insert into Specializare_Didactica
values(28,'Limbi şi literaturi străine: maghiara');

insert into Specializare_Didactica
values(29,'Limbi şi literaturi străine: spaniola');

--Tabel Regiune
insert into Regiune
values(1,'Sud');

insert into Regiune
values(2,'Nord');

insert into Regiune
values(3,'Vest');

insert into Regiune
values(4,'Est');

insert into Regiune
values(5,'Centru');

--Tabel Subregiune
insert into Subregiune
values(1,'Oltenia',1);

insert into Subregiune
values(2,'Muntenia',1);

insert into Subregiune
values(3,'Dobrogea',3);

insert into Subregiune
values(4,'Moldova',3);

insert into Subregiune
values(5,'Transilvania',5);

insert into Subregiune
values(6,'Maramures',2);

insert into Subregiune
values(7,'Bucovina',2);

insert into Subregiune
values(8,'Crisana',4);

insert into Subregiune
values(9,'Banat',4);


---Tabel Judet
insert into Judet
values(1,'Gorj',1);

insert into Judet
values(2,'Dolj',1);

insert into Judet
values(3,'Valcea',1);

insert into Judet
values(4,'Olt',1);

insert into Judet
values(5,'Mehedinti',1);

insert into Judet
values(6,'Arges',2);

insert into Judet
values(7,'Dambovita',2);

insert into Judet
values(8,'Prahova',2);

insert into Judet
values(9,'Teleorman',2);

insert into Judet
values(10,'Giurgiu',2);

insert into Judet
values(11,'Ilfov',2);

insert into Judet
values(12,'Calarasi',2);

insert into Judet
values(13,'Ialomita',2);

insert into Judet
values(14,'Braila',2);

insert into Judet
values(15,'Buzau',2);

insert into Judet
values(16,'Tulcea',3);

insert into Judet
values(17,'Constanta',3);

insert into Judet
values(18,'Galati',4);

insert into Judet
values(19,'Vrancea',4);

insert into Judet
values(20,'Vaslui',4);

insert into Judet
values(21,'Neamt',4);

insert into Judet
values(22,'Bacau',4);

insert into Judet
values(23,'Iasi',4);

insert into Judet
values(24,'Botosani',4);

insert into Judet
values(25,'Hunedoara',5);

insert into Judet
values(26,'Alba',5);

insert into Judet
values(27,'Sibiu',5);

insert into Judet
values(28,'Brasov',5);

insert into Judet
values(29,'Covasna',5);

insert into Judet
values(30,'Harghita',5);

insert into Judet
values(31,'Mures',5);

insert into Judet
values(32,'Cluj',5);

insert into Judet
values(33,'Salaj',5);

insert into Judet
values(34,'Bistrita Nasaud',5);

insert into Judet
values(35,'Maramures',6);

insert into Judet
values(36,'Satu Mare',6);

insert into Judet
values(37,'Suceava',7);

insert into Judet
values(38,'Bihor',8);

insert into Judet
values(39,'Arad',8);

insert into Judet
values(40,'Timis',9);

insert into Judet
values(41,'Caras-Severin',9);

--inserare Localitate-- 2= urban/ 1= rural
insert into Localitate
values(1,'Mioveni',2,6);

insert into Localitate
values(2,'Pitesti',2,6);

insert into Localitate
values(3,'Darmanesti',1,6);

insert into Localitate
values(4,'Campulung Muscel',2,6);

insert into Localitate
values(5,'Bebe Veche',1,40);

insert into Localitate
values(6,'Buzias',2,40);

insert into Localitate
values(7,'Viseu de Jos',1,35);

insert into Localitate
values(8,'Viseu de Sus',2,35);

insert into Localitate
values(9,'Sebesu de Sus',1,27);

insert into Localitate
values(10,'Sibiu',2,27);

insert into Localitate
values(11,'Agnita',1,27);

insert into Localitate
values(12,'Bran',1,28);

insert into Localitate
values(13,'Brasov',2,28);

insert into Localitate
values(14,'Breaza',1,28);

insert into Localitate
values(15,'Codlea',2,28);

insert into Localitate
values(16,'Filias',2,2);

insert into Localitate
values(17,'Balta Verde',1,2);

insert into Localitate
values(18,'Gheorgheni',2,30);

insert into Localitate
values(19,'Hagota',1,30);

insert into Localitate
values(20,'Iasi',2,23);

insert into Localitate
values(21,'Medeleni',1,23);

insert into Localitate
values(22,'Recas',2,40);

insert into Localitate
values(23,'Pietroasa',1,40);

insert into Localitate
values(24,'Ungureni',1,40);

insert into Localitate
values(25,'Pucioasa',2,40);

insert into Localitate
values(26,'Titu',2,40);

insert into Localitate
values(27,'Bragadiru',2,11);

insert into Localitate
values(28,'Popesti-Leordeni',2,11);

insert into Localitate
values(29,'Chiajna',1,11);

insert into Localitate
values(30,'Tunari',1,11);

COMMIT;




