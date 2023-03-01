/*1-Liste des communes qui se trouvent dans le département 49(Vous le faites sous deux
formes : in et exists).*/
select co.nom_commune 
from BASETD.commune co 
where co.nomdep in (select nomdep from BASETD.departement where code_departement=49 );

select co.nom_commune 
from BASETD.commune co 
where exists (select * from BASETD.departement de where co.nomdep=de.nomdep and code_departement=49);

/*2-Liste des noms des communes avec le nom du département qui disposent de la 5G (Vous le
faites sous deux formes : in et exists).*/
select distinct co.nom_commune,co.nomdep 
from BASETD.commune co 
where co.code_insee in (select di.code_insee from BASETD.distribution di 
where di.numfo in (select op.numfo from BASETD.operateur op where op.generation='5G'));

select distinct co.nom_commune,co.nomdep 
from BASETD.commune co 
where exists (select * from BASETD.distribution di,BASETD.operateur op where di.numfo = op.numfo and generation='5G' and di.code_insee = co.code_insee );

/*3-Liste des communes avec le nom du departement qui ne possèdent pas la 5G (versions avec
not in et not exists) */
select distinct co.nom_commune,co.nomdep 
from BASETD.commune co 
where co.code_insee not in (select di.code_insee from BASETD.distribution di 
where di.numfo in (select op.numfo from BASETD.operateur op where op.generation='5G'));

select distinct co.nom_commune,co.nomdep 
from BASETD.commune co 
where not exists (select * from BASETD.distribution di,BASETD.operateur op where di.numfo = op.numfo and generation='5G' and di.code_insee = co.code_insee );

 /*4-Liste des communes qui ne possèdent pas la 5G et qui se trouvent dans le département
44(versions avec not in et not exists) */
select distinct co.nom_commune
from BASETD.commune co 
where co.nomdep in (select de.nomdep from BASETD.departement de where de.code_departement=44) 
and co.code_insee not in (select di.code_insee from BASETD.distribution di 
where di.numfo in (select op.numfo from BASETD.operateur op where op.generation='5G'));

select distinct co.nom_commune
from BASETD.commune co 
where  EXISTS (select * from BASETD.departement de where de.nomdep=co.nomdep and de.code_departement=44)
and not exists (select * from BASETD.distribution di,BASETD.operateur op where di.numfo = op.numfo and generation='5G' and di.code_insee = co.code_insee );

/*5-Afficher pour chaque département le nombre de communes(sous deux formes). Faites une
jointure de la table commune et celle du département.*/
select co.nomdep,count(co.nom_commune) 
from BASETD.commune co, BASETD.departement de
where  co.nomdep=de.nomdep
group by co.nomdep
order by 1;

select de.nomdep,(select count(*) from BASETD.commune co where co.nomdep=de.nomdep ) count
from BASETD.departement de
order by 1
;
/*6-Liste de toutes les communes de Loire-Atlantique avec le nombre di'antennes 5G. Le
résultat est trié par ordre croissant de la deuxième colonne(sous deux formes). Avez-vous le
même résultat avec les deux formes.*/
select co.nom_commune, (select count(*) from BASETD.operateur op,BASETD.distribution di where op.numfo=di.numfo and di.code_insee=co.code_insee and op.generation='5G') count
from BASETD.commune co
where co.nomdep in (select de.nomdep from BASETD.departement de where de.code_departement=44) 
order by 2 desc;

select distinct co.nom_commune,count(*)
from BASETD.commune co,BASETD.operateur op,BASETD.distribution di
where co.nomdep in (select de.nomdep from BASETD.departement de where de.code_departement=44) 
and op.numfo=di.numfo and di.code_insee=co.code_insee and op.generation='5G'
group by co.nom_commune
order by 2 desc;
/*7-Idem que la question précédente avec au moins 10 antennes.*/
select nom_commune,count from (
select co.nom_commune, (select count(*) from BASETD.operateur op,BASETD.distribution di where op.numfo=di.numfo and di.code_insee=co.code_insee and op.generation='5G') count
from BASETD.commune co
where co.nomdep in (select de.nomdep from BASETD.departement de where de.code_departement=44) 
order by 2 desc)
fetch first 10 rows only;

/*8-Liste de toutes les communes de Loire-Atlantique avec le nombre di'antennes 5G et 4G.*/
select distinct co.nom_commune,
(select count(*) from BASETD.distribution di, BASETD.operateur op
where op.numfo=di.numfo  and di.code_insee = co.code_insee
and op.generation='5G') count5g,
(select count(*) from BASETD.distribution di, BASETD.operateur op
where op.numfo=di.numfo  and di.code_insee = co.code_insee 
and op.generation='4G') count4g
from basetd.commune co
where co.nomdep='Loire-Atlantique'
order by 1;

/*9-Liste de tous les fournisseurs avec le nombre di'antennes 5G de 3,5Ghz, 2,1 GHZ et
700MHZ(5G NR 3500, 2100 et 700)(sous deux formes).Vous générez aussi différents
graphiques(en batons, batons empilés, circulaire)*/
select op.nomfo,op.technologie, count(*) from BASETD.distribution di,BASETD.operateur op
where op.numfo=di.numfo and op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
group by op.nomfo,op.technologie
order by 1,2;

select op.nomfo,op.technologie,(select count(*) from BASETD.distribution di
where op.numfo=di.numfo ) count
from BASETD.operateur op
where op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
order by 1,2;

/*10-idem que la question précédente pour la ville de Nantes.*/
select op.nomfo,op.technologie, count(*) from BASETD.distribution di,BASETD.operateur op, BASETD.commune co
where op.numfo=di.numfo and di.code_insee = co.code_insee 
and co.nom_commune='Nantes' and op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
group by op.nomfo,op.technologie
order by 1,2;

select op.nomfo,op.technologie,(select count(*) from BASETD.distribution di, BASETD.commune co
where op.numfo=di.numfo  and di.code_insee = co.code_insee 
and co.nom_commune='Nantes') count
from BASETD.operateur op
where op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
order by 1,2;

/*11-Idem pour le département de Loire-Atlantique.*/
select op.nomfo,op.technologie, count(*) from BASETD.distribution di,BASETD.operateur op, BASETD.commune co
where op.numfo=di.numfo and di.code_insee = co.code_insee 
and co.nomdep='Loire-Atlantique' and op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
group by op.nomfo,op.technologie
order by 1,2;

select op.nomfo,op.technologie,(select count(*) from BASETD.distribution di, BASETD.commune co
where op.numfo=di.numfo  and di.code_insee = co.code_insee 
and co.nomdep='Loire-Atlantique') count
from BASETD.operateur op
where op.technologie in('5G NR 3500','5G NR 2100','5G NR 700')
order by 1,2;

/*12-Listes des communes qui possèdent le déploiement de toutes les technologies des différents
opérateurs. Vous utilisez la double négations et deux formes # not in et not exists*/
select distinct co.nom_commune from BASETD.commune co 
where co.code_insee not in(select distinct co.code_insee from BASETD.commune co cross join basetd.operateur op
where (co.code_insee,op.numfo) not in (select di.code_insee,di.numfo from basetd.distribution di))
;

select distinct co.nom_commune from BASETD.commune co 
where not exists (select * from basetd.operateur op 
where op.numfo NOT IN (select di.numfo from basetd.distribution di 
where di.code_insee = co.code_insee))
;
/*13-Listes des communes qui poss�dent le d�ploiement des technologies 5G des diff�rents
op�rateurs.*/
select distinct co.nom_commune from BASETD.commune co 
where co.code_insee not in(select distinct co.code_insee from BASETD.commune co cross join basetd.operateur op
where (co.code_insee,op.numfo) not in (select di.code_insee,di.numfo from basetd.distribution di) 
and op.generation='5G')
;

/*14-Listes des communes qui poss�dent le d�ploiement de toutes les technologies 4G de
l'op�rateur orange.*/
select distinct co.nom_commune from BASETD.commune co 
where co.code_insee not in(select distinct co.code_insee from BASETD.commune co cross join basetd.operateur op
where (co.code_insee,op.numfo) not in (select di.code_insee,di.numfo from basetd.distribution di) 
and op.generation='4G' and op.nomfo='ORANGE' )
;