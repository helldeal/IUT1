Create table departement as select * from
basetd.departement;
Create table commune as select * from
basetd.commune;
Create table operateur as select * from
BASETD.operateur;
Create table distribution as select * from
basetd.distribution;

/*Exercice 1 :*/
/*1-1-a. Créer une vue VueCarquefou qui correspond à cette requête : Une Vue est une table
temporaire créer à partir d’un select.*/
create or replace view VueCarquefou as
select co.nom_commune,co.code_insee, op.nomfo,
op.generation, op.technologie, de.nomdep,
de.code_departement, di.adresse
from commune co, departement de, operateur op,
distribution di
where op.numfo=di.numfo
and co.code_insee=di.code_insee
and co.nomdep=de.nomdep
and op.generation ='5G'
and co.nom_commune='Carquefou';

/*Afficher le nombre d’antennes 5G à partir de la Vue*/
select count(*)from VueCarquefou vc; 

/*Afficher pour chaque opérateur le nombre d’antennes 5G*/
select vc.nomfo,count(*)from VueCarquefou vc
group by vc.nomfo;  

/*Créer une vue et affichez les villes par ordre croissant*/
create or replace view Vue2 as
select co.nom_commune, count(op.generation) count
from commune co, departement de, operateur op,
distribution di
where op.numfo=di.numfo
and co.code_insee=di.code_insee
and co.nomdep=de.nomdep and generation='5G'
group by co.nom_commune order by 2 desc, 1 FETCH


NEXT 10 ROWS ONLY;

select v.nom_commune from Vue2 v;


create or replace view Vue31 as
select co.code_insee,co.nom_commune,
(select count(*) from distribution di, operateur op
where op.numfo=di.numfo and
co.code_insee=di.code_insee and op.generation='5G' )
nb5G
from commune co
where co.nomdep='Loire-Atlantique'
order by 2 desc;

create or replace view Vue32 as
select co.code_insee, co.nom_commune,
(select count(*) from distribution di, operateur op
where op.numfo=di.numfo and
co.code_insee=di.code_insee and op.generation='4G' )
nb4G
from commune co
where co.nomdep='Loire-Atlantique'
order by 3 desc;

/*A partir de ces deux vues, affichez les noms des 10 meilleurs communes (par rapport à la
5G) avec le nombres d’antennes 5G et 4G.*/
select nom_commune,NB5G,NB4G from Vue31 natural join Vue32 order by 2 desc fetch next 10 rows only;

/*Exercice 2*/
insert into AN5G values(44999,'fontome',200); 
/*AN5G correspond à la vue des antennes 5G.*/

/*Regardez maintenant si cette commune est visible dans la vue CommuneLA et dans la table
Commune*/
create or replace view CommuneLA as
select co.code_insee,co.nom_commune,co.nomdep
from commune co, departement dep where co.nomdep=dep.nomdep;
insert into CommuneLA values(44990, 'fontome2', 'Loire-Atlantique');

select * from CommuneLa