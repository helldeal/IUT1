--Oracle id: i1b07a (meme mdp)

drop table passager_trajet;
drop table avis;
drop table trajet;
drop table vehicule;
drop table passager;
drop table conducteur;

create table vehicule (
    id_v number(4,0),
    marque varchar2(30),
    type_v varchar2(15),
    energie varchar2(15),
    nombre_de_place number(2,0),
    annee_de_mise_en_circulation number(4,0),
    constraint V1 primary key (id_v) 
    );



insert into vehicule values (1,'Renault Trafic','camionnette','diesel',9,2010);
insert into vehicule values (2,'Citroen Berlingo','voiture','diesel',5,2018);
insert into vehicule values (3,'Renault Clio 5','voiture','essence',5,2016);
insert into vehicule values (4,'BMW M5','voiture','essence',4,2019);
insert into vehicule values (5,'Citroen 2CV','voiture','essence',4,1970);
insert into vehicule values (6,'Renault 5 turbo','voiture','essence',2,1980);
insert into vehicule values (7,'Opel Combo','camionnette','diesel',8,2015);
insert into vehicule values (8,'Peugeot Partner','Camionnette','diesel',7,2008);
insert into vehicule values (9,'Tesla ModelX','voiture','electrique',5,2020);


create table passager (
    id_p number(4,0),
    nomp varchar2(25),
    adressep varchar2(50),
    constraint P1 primary key (id_p)
);
insert into passager values (1,'Géraldine','Brest');
insert into passager values (2,'Benjamin','Faverolles-sur-Cher');
insert into passager values (3,'Fernand','Nantes');
insert into passager values (4,'Maxim','Nantes');
insert into passager values (5,'Arnaud','Orléans');
insert into passager values (6,'Sunaj','Nantes');
insert into passager values (7,'Franck','Angers');
insert into passager values (8,'Gwendal','Plouguerneau');
insert into passager values (9,'Louis','Brest');
insert into passager values (10,'Jean','Blois');
insert into passager values (11,'Pierrick','Angers');
insert into passager values (12,'Thomas','Nantes');
insert into passager values (13,'Joël','Nantes');
insert into passager values (14,'Alexis','Angers');
insert into passager values (15,'Sébastien','Paris');
insert into passager values (16,'Martin Larsson','Nantes');



create table conducteur (
    id_c number(4,0),
    nomc varchar2(25),
    adressec varchar2(50),
    date_dagrement date,
    constraint C1 primary key (id_c)
);
insert into conducteur values (1,'Philipe','Nantes',TO_DATE('01/01/2012', 'DD/MM/YYYY'));
insert into conducteur values (2,'Michel','Nantes',TO_DATE('25/12/2019', 'DD/MM/YYYY'));
insert into conducteur values (3,'Sophie','Nantes',TO_DATE('01/03/2017', 'DD/MM/YYYY'));
insert into conducteur values (4,'Marie','Paris',TO_DATE('18/02/2019', 'DD/MM/YYYY'));
insert into conducteur values (5,'Alex','Nantes',TO_DATE('28/06/2006', 'DD/MM/YYYY'));
insert into conducteur values (6,'Ethan','Brest',TO_DATE('14/01/2003', 'DD/MM/YYYY'));
insert into conducteur values (7,'Bobby','Angers',TO_DATE('05/08/2018', 'DD/MM/YYYY'));
insert into conducteur values (8,'Cristophe','Nantes',TO_DATE('16/06/2014', 'DD/MM/YYYY'));
insert into conducteur values (9,'Edouard','Paris',TO_DATE('10/08/2020', 'DD/MM/YYYY'));
insert into conducteur values (10,'Benoit','Nantes',TO_DATE('01/08/2022', 'DD/MM/YYYY'));

create table trajet (
    id_t number(4,0),
    ville_de_depart varchar2(30),
    heure_de_depart date,
    ville_darrivee varchar2(30),
    heure_darrivee date,
    tarif number(5,2),
    id_v number(4,0),
    id_c number(4,0),
    constraint T1 primary key (id_t),
    constraint T3 foreign key (id_v) references vehicule(id_v),
    constraint T4 foreign key (id_c) references conducteur(id_c)
);

insert into trajet values (1,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Brest',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),12,1,1);
insert into trajet values (2,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),9,2,2);
insert into trajet values (3,'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),29,3,3);
insert into trajet values (4,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),31,4,4);
insert into trajet values (5,'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),10,5,5);
insert into trajet values (6,'Brest',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),23,6,6);
insert into trajet values (7,'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Blois',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),14,7,7);
insert into trajet values (8,'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Cholet',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),12,8,8);
insert into trajet values (9,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Tour',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),13,9,9);
insert into trajet values (10,'Tour',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Blois',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),7,1,1);
insert into trajet values (11,'Brest',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),18,2,2);
insert into trajet values (12,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Cholet',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),17,3,3);
insert into trajet values (13,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Cholet',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),15,4,4);
insert into trajet values (14,'Blois',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),15,5,5);
insert into trajet values (15,'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Blois',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),16,6,6);
insert into trajet values (16,'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),13,7,7);
insert into trajet values (17,'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Brest',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),28,8,8);
insert into trajet values (18,'Blois',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Angers',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),20,9,9);
insert into trajet values (19,'Brest',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Paris',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),42,1,1);
insert into trajet values (20,'Cholet',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),'Nantes',TO_DATE('18/02/2014/00/00', 'DD/MM/YYYY/HH24/MI'),19,2,2);

create table passager_trajet (
    id_t number(4,0),
    id_p number(4,0),
    constraint PT1 foreign key (id_t) references trajet(id_t),
    constraint PT2 foreign key (id_p) references passager(id_p)
);

insert into passager_trajet values (1,1);
insert into passager_trajet values (1,2);
insert into passager_trajet values (1,3);
insert into passager_trajet values (2,4);
insert into passager_trajet values (2,5);
insert into passager_trajet values (3,6);
insert into passager_trajet values (4,7);
insert into passager_trajet values (4,8);
insert into passager_trajet values (5,9);
insert into passager_trajet values (5,10);
insert into passager_trajet values (5,11);
insert into passager_trajet values (6,12);
insert into passager_trajet values (7,13);
insert into passager_trajet values (7,14);
insert into passager_trajet values (8,15);
insert into passager_trajet values (8,16);
insert into passager_trajet values (8,1);
insert into passager_trajet values (9,2);
insert into passager_trajet values (10,3);
insert into passager_trajet values (10,4);
insert into passager_trajet values (11,5);
insert into passager_trajet values (11,6);
insert into passager_trajet values (11,7);
insert into passager_trajet values (12,8);
insert into passager_trajet values (13,9);
insert into passager_trajet values (14,10);
insert into passager_trajet values (14,11);
insert into passager_trajet values (15,12);
insert into passager_trajet values (16,13);
insert into passager_trajet values (16,14);
insert into passager_trajet values (16,15);
insert into passager_trajet values (17,16);
insert into passager_trajet values (17,1);
insert into passager_trajet values (17,2);
insert into passager_trajet values (18,3);
insert into passager_trajet values (19,4);
insert into passager_trajet values (20,5);
insert into passager_trajet values (20,6);



create table avis (
    id_a number(4,0),
    avis varchar2(1000),
    note number(2,1),
    id_p number(4,0),
    id_c number(4,0),
    id_t number(4,0),
    constraint A1 primary key (id_a),
    constraint A2 foreign key (id_p) references passager(id_p),
    constraint A3 foreign key (id_c) references conducteur(id_c),
    constraint A4 foreign key (id_t) references trajet(id_t),
    check (0<=note and note<=5)
);

insert into avis values (1,'',5,1,1,1);
insert into avis values (2,'',4,2,1,1);
insert into avis values (3,'',5,3,1,1);
insert into avis values (4,'',2,4,2,2);
insert into avis values (5,'',3,5,2,2);
insert into avis values (6,'',3,6,3,3);
insert into avis values (7,'',5,7,4,4);
insert into avis values (8,'',2,8,4,4);
insert into avis values (9,'',1,9,5,5);
insert into avis values (10,'',2,10,5,5);
insert into avis values (11,'',5,11,5,5);
insert into avis values (12,'',5,12,6,6);
insert into avis values (13,'',5,13,7,7);
insert into avis values (14,'',5,14,7,7);
insert into avis values (15,'',4,15,8,8);
insert into avis values (16,'',5,16,8,8);
insert into avis values (17,'',5,1,8,8);
insert into avis values (18,'',3,2,9,9);
insert into avis values (19,'',5,3,1,10);
insert into avis values (20,'',5,4,1,10);
insert into avis values (21,'',5,5,2,11);
insert into avis values (22,'',2.5,6,2,11);
insert into avis values (23,'',5,7,2,11);
insert into avis values (24,'',4,8,3,12);
insert into avis values (25,'',5,9,4,13);
insert into avis values (26,'',5,10,5,14);
insert into avis values (27,'',4,11,5,14);
insert into avis values (28,'',4,12,6,15);
insert into avis values (29,'',4,13,7,16);
insert into avis values (30,'',5,14,7,16);
insert into avis values (31,'',5,15,7,16);
insert into avis values (32,'',5,16,8,17);
insert into avis values (33,'',4,1,8,17);
insert into avis values (34,'',4,2,8,17);
insert into avis values (35,'',5,3,9,18);
insert into avis values (36,'',3,4,1,19);
insert into avis values (37,'',2,5,2,20);
insert into avis values (38,'',4,6,2,20);

--Liste des conducteurs qui effectuent des trajets entre Nantes et Cholet
select nomc  from trajet natural join conducteur where ville_de_depart='Nantes' and ville_darrivee='Cholet';
--Liste du type d’énergie utilisé par le véhicule de chaque conducteur habitant Nantes et conduisant un véhicule immatriculé avant 2000
select energie from vehicule join conducteur on conducteur.id_c=vehicule.id_v where vehicule.annee_de_mise_en_circulation<2000 and conducteur.adressec='Nantes';
--Les conducteurs Nantais qui n’ont reçu que des avis positifs.
select a.nomc from(select * from conducteur natural join avis where conducteur.adressec='Nantes')a left join (select * from conducteur natural join avis where avis.note<=2.5 and conducteur.adressec='Nantes') b on a.id_c=b.id_c where b.id_c is null group by a.nomc;
--les conducteurs qui ont parcouru le plus de trajet
select nomc,nbt from(select max(nbt)maxnbt from(select nomc,count(nomc)nbt from conducteur natural join trajet GROUP BY nomc))natural join(select nomc,count(nomc)nbt from conducteur natural join trajet GROUP BY nomc)where nbt=maxnbt;
--les trajets pour lesquels au moins un des passagers habite la ville d’arrivée
select id_t,trajet.ville_de_depart,ville_darrivee from trajet natural join (select * from passager natural join passager_trajet) where ville_darrivee=adressep;
--les conducteurs qui ont reçu leur agrément après l’année 2014
select nomc from conducteur where date_dagrement>TO_DATE('31/12/2014', 'DD/MM/YYYY');
--les conducteurs qui n’ont jamais transporté de passager
select nomc from(select nomc,count(id_p) nbp from conducteur a left join (select * from trajet natural join passager_trajet) b on a.id_c=b.id_c group by nomc)where nbp=0;
--Le conducteur qui a transporté le plus de passagers
select nomc,nbp from(select max(nbp) maxnbp from (select nomc,count(id_p) nbp from conducteur a left join (select * from trajet natural join passager_trajet) b on a.id_c=b.id_c group by nomc))natural join (select nomc,count(id_p) nbp from conducteur a left join (select * from trajet natural join passager_trajet) b on a.id_c=b.id_c group by nomc)where nbp=maxnbp;
--Somme total payée par chaque passager
select nomp,sum(tarif) Somme_tarif from passager a left join (select * from trajet natural join passager_trajet) b on a.id_p=b.id_p group by nomp;