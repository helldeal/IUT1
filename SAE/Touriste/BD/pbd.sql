
--erreurs

--code insee / commune
select distinct code_insee,count(commune)
from (select distinct code_insee,commune from degustation) 
HAVING COUNT(*) > 1 group by code_insee;

select distinct code_insee,commune from degustation where code_insee in ('72068',
'72042',
'49022',
'49331',
'44066',
'53130',
'53054',
'72208',
'49373') order by 1;



select distinct code_insee,count(commune_fête_ou_manif)
from (select distinct code_insee,commune_fête_ou_manif from manifestation) 
HAVING COUNT(*) > 1 group by code_insee;

select distinct code_insee,commune_fête_ou_manif from manifestation where code_insee in ('49183',
'49248',
'53107',
'72181',
'72180',
'72132',
'49050',
'53122',
'49017',
'49244',
'72200',
'49331',
'72010',
'53219',
'53271',
'49018') order by 1;

--code dÃ©partement hors pl
select * from degustation where substr(code_insee,0,2)='44' and departement!='Loire-Atlantique';
UPDATE degustation SET departement = 'Loire-Atlantique' WHERE code_insee='44141';
select * from degustation where substr(code_insee,0,2)='53' and departement!='Mayenne';
UPDATE degustation SET departement = 'Mayenne' WHERE code_insee='53133';
select * from degustation where substr(code_insee,0,2)='49' and departement!='Maine-et-Loire';
select * from degustation where substr(code_insee,0,2)='72' and departement!='Sarthe';
UPDATE degustation SET departement = 'Sarthe' WHERE code_insee='72262';

select * from manifestation where substr(code_insee,0,2)='44' and departement!='Loire-Atlantique';
select * from manifestation where substr(code_insee,0,2)='53' and departement!='Mayenne';
UPDATE manifestation SET departement = 'Mayenne' WHERE code_insee='53213';
select * from manifestation where substr(code_insee,0,2)='49' and departement!='Maine-et-Loire';
UPDATE manifestation SET departement = 'Maine-et-Loire' WHERE code_insee='49244';
select * from manifestation where substr(code_insee,0,2)='72' and departement!='Sarthe';



--CREATION TABLE
drop table commune;

create table commune as select distinct
* from 
(select substr(code_insee,0,2) code_dep,code_insee,manifestation.commune_fête_ou_manif from manifestation) 
union 
(select substr(code_insee,0,2) code_dep,code_insee,degustation.commune from degustation);

select * from commune;


drop table departement;

create table departement as select distinct
* from 
(select substr(code_insee,0,2) code_dep,departement from manifestation) 
union 
(select substr(code_insee,0,2) code_dep,departement from degustation);

select * from departement;


drop table event;

create table manif as select 
commune_fête_ou_manif,CATÉGORIE_FÊTE_OU_MANIF,ADRESSE1,ADRESSE_PARTIE_1_SUITE,ADRESSE_PARTIE_2,ADRESSE_PARTIE_3,CODE_POSTAL,
CEDEX_ADRESSE_POSTALE,LATITUDE,LONGITUDE,ACCèS_NOM_DISTANCE,MOBILE,FIXE,FAX
from manifestation 
;
create table degus as select 
nom_offre,TYPE_OFFRE,ADRESSE_P1,ADRESSE_P1_SUITE,ADRESSE_P2,ADRESSE_P3,CODE_POSTAL,
CEDEX,LATITUDE,LONGITUDE,ACCèS_NOM_DISTANCE,MOBILE,FIXE,FAX 
from degustation
;

select * from manif;
select * from degus;

select count(*) from degustation;
select count(*) from manifestation;
select count(*) from manif;
select count(*) from degus;


select * from degustation;
select * from manifestation;








--CLE





--REQUETE
