--nuuust i2b07b
--nathan i2b06b

create Table communeLA as select * from basetd.commune 
where nomdep='Loire-Atlantique';

create Table operateurLA as select * from basetd.operateur 
where generation in('4G','5G');

create Table distributionLA as select * from basetd.distribution 
where code_insee in(select code_insee from communela)
and numfo in (select numfo from operateurla);

alter table communela add constraint pk_co primary key ( code_insee );
alter table distributionla add constraint pk_di primary key ( id );
alter table operateurla add constraint pk_op primary key ( numfo );

alter table distributionla
    add constraint ce_distribution_commune foreign key ( code_insee )
        references communela ( code_insee );

alter table distributionla
    add constraint ce_distribution_operateur foreign key ( numfo )
        references operateurla ( numfo );



select * from distributionla;
select * from i2b07b.distributionve;
select * from i2b06b.distributionsa;


--1.1
Grant select on communeLA to i2b07b,i2b06b;

Grant select on operateurLA to i2b07b,i2b06b;

Grant select on distributionLA to i2b07b,i2b06b;

--1.2
Grant Update(adresse) on distributionLA to i2b07b,i2b06b;

update i2b06b.distributionsa set adresse='jonnhy depp' where id=288054;
update i2b07b.distributionve set adresse='jonnhy depp' where id=481650;
commit;

--1.3
Grant insert on distributionLA to i2b07b,i2b06b;
insert into i2b06b.distributionsa values (0,null,null,null,null,null,null,null,null,null); 
insert into i2b07b.distributionve values (0,null,null,null,null,null,null,null,null,null); 
commit;
select * from i2b07b.distributionve where id=0;
select * from i2b06b.distributionsa where id=0;
select * from distributionla where id=0;

--1.4
revoke select on communeLA from i2b07b,i2b06b;
revoke select on distributionLA from i2b07b,i2b06b;
revoke select on operateurLA from i2b07b,i2b06b;
revoke update on distributionLA from i2b07b,i2b06b;
revoke insert on distributionLA from i2b07b,i2b06b;

--1.5
create or replace view distributionLAbis as
select id,numfo,code_insee,adresse,statut from distributionLa;

Grant select  on distributionLAbis to i2b07b,i2b06b;

select * from i2b07b.distributionVEbis;
select * from i2b06b.distributionSAbis;

--1.6
create or replace view LAville5g as
select distinct co.nom_commune,
(select count(*) from distributionla di, operateurla op
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='5G')count 
from communela co
order by 2 desc;

create or replace view LAville4g as
select distinct co.nom_commune,
(select count(*) from distributionla di, operateurla op
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='4G')count 
from communela co
order by 2 desc;

Grant select  on LAville5g to i2b07b,i2b06b;
Grant select  on LAville4g to i2b07b,i2b06b;

select * from i2b07b.VEville5g;
select * from i2b07b.VEville4g;
select * from i2b06b.SAville5g;
select * from i2b06b.SAville4g;

--1.7

create or replace view LAville5gOp as
select distinct co.nom_commune,op.nomfo,count(*)count5g
from communela co,operateurla op,distributionla di
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='5G'
group by co.nom_commune,op.nomfo
order by 3 desc;

create or replace view LAville4gOp as
select distinct co.nom_commune,op.nomfo,count(*)count4g
from communela co,operateurla op,distributionla di
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='4G'
group by co.nom_commune,op.nomfo
order by 3 desc;

Grant select  on LAville5gOp to i2b07b,i2b06b;
Grant select  on LAville4gOp to i2b07b,i2b06b;

select * from i2b07b.VEville5gOp;
select * from i2b07b.VEville4gOp;
select * from i2b06b.SAville5gOp;
select * from i2b06b.SAville4gOp;
--1.8

create or replace view LAville5gOpTech as
select distinct co.nom_commune,op.nomfo,op.technologie,count(*)count5g
from communela co,operateurla op,distributionla di
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='5G'
group by co.nom_commune,op.nomfo,op.technologie
order by 4 desc;

create or replace view LAville4gOpTech as
select distinct co.nom_commune,op.nomfo,op.technologie,count(*)count4g
from communela co,operateurla op,distributionla di
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='4G'
group by co.nom_commune,op.nomfo,op.technologie
order by 4 desc;

Grant select  on LAville5gOpTech to i2b07b,i2b06b;
Grant select  on LAville4gOpTech to i2b07b,i2b06b;

select * from i2b07b.VEville5gOpTech;
select * from i2b07b.VEville4gOpTech;
select * from i2b06b.SAville5gOpTech;
select * from i2b06b.SAville4gOpTech;

--1.9

create or replace VIEW LAvilleOpOrange as 
select * from LAville5gOP NATURAL JOIN LAville4gOP
where nomfo = 'ORANGE'
order by 3 desc;

Grant select on LAvilleOpOrange to i2b07b,i2b06b;
select * from i2b07b.VEvilleOpOrange;
select * from i2b06b.SAvilleOpOrange;
--EX2
--2.1

create role Mon_Ami_Hell;
grant Mon_Ami_Hell to i2b07b,i2b06b;

--2.2

Grant select on communeLA to Mon_Ami_Hell;
Grant select on operateurLA to Mon_Ami_Hell;
Grant select on distributionLA to Mon_Ami_Hell;
Grant Update(adresse) on distributionLA to Mon_Ami_Hell;
Grant insert on distributionLA to Mon_Ami_Hell;

--2.3
update i2b06b.distributionsa set adresse='jonnhy depp2' where id=288054;
update i2b07b.distributionve set adresse='jonnhy depp2' where id=481650;
select * from i2b07b.distributionve;
select * from i2b06b.distributionsa;

--2.4

revoke select on communeLA from Mon_Ami_Hell;
revoke select on distributionLA from Mon_Ami_Hell;
revoke select on operateurLA from Mon_Ami_Hell;

--2.5

revoke Mon_Ami_HellVOIRTABLE from i2b07b,i2b06b;

--2.6

create role Mon_Ami_HellVOIRTABLE;
create role Mon_Ami_HellMAJ;

Grant select on communeLA to Mon_Ami_HellVOIRTABLE;
Grant select on operateurLA to Mon_Ami_HellVOIRTABLE;
Grant select on distributionLA to Mon_Ami_HellVOIRTABLE;
Grant Update(adresse) on distributionLA to Mon_Ami_HellMAJ;
Grant insert on distributionLA to Mon_Ami_HellMAJ;


--2.7
create role Mon_Ami_HellVOIRMAJ;

grant Mon_Ami_HellVOIRTABLE,Mon_Ami_HellMAJ to Mon_Ami_HellVOIRMAJ;

--2.8

grant Mon_Ami_HellVOIRMAJ to i2b07b,i2b06b;
select * from i2b07b.distributionve;
select * from i2b06b.distributionsa;

--2.9

revoke Mon_Ami_HellMAJ from Mon_Ami_HellVOIRMAJ;
select * from i2b07b.distributionve;
select * from i2b06b.distributionsa;
update i2b06b.distributionsa set adresse='jonnhy depp' where id=288054;
update i2b07b.distributionve set adresse='jonnhy depp' where id=481650;

--EX3

drop table distributionLA;
drop table operateurLA;
drop table communeLA;

--3.1

create Table communeLA as select * from basetd.commune 
where nomdep='Loire-Atlantique';

create Table operateurLA as select * from basetd.operateur 
where generation in('4G','5G');

create Table distributionLA as select * from basetd.distribution 
where code_insee in(select code_insee from communela)
and numfo in (select numfo from operateurla);

--3.2
grant select on operateurLA to i2b07b,i2b06b;

--3.3
--Clé Primaires
alter table communela add constraint pk_co primary key ( code_insee );
alter table distributionla add constraint pk_di primary key ( id );
alter table operateurla add constraint pk_op primary key ( numfo );

--Clé Étrangères
alter table distributionla
add constraint ce_distribution_commune foreign key ( code_insee )
references communela ( code_insee );

alter table distributionla
add constraint ce_distribution_operateur foreign key ( numfo )
references operateurla ( numfo );

--3.4
grant references on operateurLA to i2b07b,i2b06b;

--3.5
grant select on operateurLA to i2b07b,i2b06b with grant option;