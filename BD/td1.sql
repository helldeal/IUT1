drop table Serv;
create table Serv (
nuserv number(4,0) primary key,
nomserv VARCHAR2(10) not null, 
chef VARCHAR2(10) not null
);

drop table Concerne;
create table Concerne (
nuserv number(4,0) not null,
nuproj number(4,0) not null,
CONSTRAINT Cle_Concerne primary key(nuserv,nuproj)
);

drop table employe;
create table employe (
nuempl number(4,0) not null primary key,
nomempl VARCHAR2(10) not null,
hebdo number(2,0) check(hebdo<=25),
affect number(2,0),
CONSTRAINT FK_serv FOREIGN KEY(affect) references serv(nuserv)
);

drop table projet;
create table projet (
nuproj number(4,0) not null primary key,
nomproj VARCHAR2(10) not null,
chef number(4,0) not null,
CONSTRAINT FK_empl FOREIGN KEY(chef) references employe(nuempl)
);

drop table Travail;
create table Travail (
nuempl number(4,0) not null,
nuproj number(4,0) not null,
duree number(4,0),
CONSTRAINT Cle_Travail primary key(nuempl,nuproj),
CONSTRAINT FK_emp FOREIGN KEY(nuempl) references employe(nuempl)
);

set hebdo=hebdo-2 where nuempl=20;
insert into employe values(120,'Martin',15,2);
delete from employe where nuempl=20;
alter table employe add salaire number(5);


select * from basetd.projet ;
select * from basetd.employe ;
select * from basetd.travail ;
select * from basetd.service ;

select nomempl from basetd.employe,basetd.travail where employe.nuempl=travail.nuempl ;
select nomempl from basetd.employe where nuempl in (20,30,42) ;
select nuproj from basetd.projet where nomproj Like 'C%' ;
select nuempl from basetd.employe where hebdo is NULL ;
select * from basetd.employe, basetd.travail where travail.nuempl(+) = employe.nuempl ;
select * from basetd.employe e NATURAL JOIN basetd.travail t ;
select nuempl,nomempl from basetd.employe union select nuempl, nuproj from basetd.travail ;
select nuproj from basetd.projet intersect select nuproj from basetd.travail ;
select nuempl from basetd.employe minus select nuempl from basetd.travail ;

SELECT nuempl,nomempl FROM basetd.employe ;
SELECT count(*) FROM basetd.employe ;
select avg(hebdo) from basetd.employe;
select sum(duree) from basetd.travail;
select nomempl from basetd.employe order by nomempl;
select nuempl, duree from basetd.travail order by nuempl desc;
select nomserv from basetd.service where nuserv=1;
select nomserv from basetd.service where nuserv!=1;
select nomempl from basetd.employe where hebdo=0;
select nomempl from basetd.employe where hebdo<30 AND hebdo>20;

select nomserv,nomempl from basetd.employe e NATURAL JOIN basetd.service t where chef=nuempl;
select nomempl,nuproj from basetd.employe e NATURAL JOIN basetd.travail t where nuempl=nuempl;
select nomempl,nuproj from basetd.travail e NATURAL JOIN (select * from basetd.employe e NATURAL JOIN basetd.service t where chef=nuempl and nomserv='achat')t where nuempl=nuempl;
select nomproj,nomempl from basetd.employe e NATURAL JOIN basetd.projet t where resp=nuempl;
select nuproj,nomproj,nomempl from basetd.employe, basetd.projet where resp=nuempl and nomproj='zorro';
select nuempl,nuproj,nomproj,nomempl from basetd.travail e NATURAL JOIN (select nuproj,nomproj,nomempl from basetd.employe, basetd.projet where resp=nuempl and nomproj='zorro')t where nuproj=nuproj;
select e.nomempl,t.nomempl from basetd.employe e inner JOIN (select nuempl,nuproj,nomproj,nomempl from basetd.travail e NATURAL JOIN (select nuproj,nomproj,nomempl from basetd.employe, basetd.projet where resp=nuempl and nomproj='zorro') where nuproj=nuproj)t on e.nuempl=t.nuempl where e.nomempl!='edith';

