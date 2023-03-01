
select * from BASETD.rechargeelectrique ;

--Gironde
select * from BASETD.rechargeelectrique t1 where t1.département='Gironde';
--INSEE DOUBLE
select t1.commune,t1.insee from BASETD.rechargeelectrique t1,BASETD.rechargeelectrique t2 where t1.insee=t2.insee and t1.commune!=t2.commune;

drop table station;
create Table Station as select codestation,
nombrepointsdecharge,
aménageur,
enseigne,
opérateur,
libelléstation,
adresse,
longitude,
latitude,
insee,
source,
codepointdecharge
from basetd.rechargeelectrique;

update station
set nombrepointsdecharge=Replace(nombrepointsdecharge, '.', ',');

DELETE FROM station WHERE insee='85234.0';
DELETE FROM station WHERE insee='44143.0';
DELETE FROM station WHERE insee='85234.0';
insert into i2B05B.commune VALUES('85234.0','Saint-Jean-de-Monts','Vendée');
insert into i2B05B.commune VALUES('44143','Rezé','Loire-Atlantique');
update i2B05B.commune set insee = '44143.0' where insee ='44143' ;
update station set insee = '85234.0' where CODESTATION ='FR*S85*P85234*001' ;

ALTER TABLE station ADD CONSTRAINT pk_station PRIMARY KEY ( codestation );

grant select on station to i2b06b, i2b07b, i2b05b;
grant update on station to i2b06b, i2b07b, i2b05b;
grant insert on station to i2b06b, i2b07b, i2b05b;

--Clé étrangère
alter table station add constraint fk_insee_station 
foreign key(insee) references i2b05b.commune(insee);

--Clé étrangère
alter table station add constraint fk_codepointdecharge_station 
foreign key(codepointdecharge) references i2b06b.borne(codepointdecharge);

select * from station ;
select * from I2B05B.commune ;
select * from I2B07B.departement;
select * from I2B06B.borne;

--Q5
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Loire-Atlantique'
group by aménageur,commune
order by 1;
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Vendée'
group by aménageur,commune
order by 1;
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Sarthe'
group by aménageur,commune
order by 1;
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Mayenne'
group by aménageur,commune
order by 1;
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Maine-et-Loire'
group by aménageur,commune
order by 1;


select aménageur,puissancemaximum,sum(nombrepointsdecharge) nbrprise
from I2B06B.borne natural join station
group by aménageur,puissancemaximum
order by 1;


select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Loire-Atlantique'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Vendée'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Sarthe'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Mayenne'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Maine-et-Loire'
group by commune
order by 1;

select aménageur,sum(nombrepointsdecharge) nbrprise
from I2B06B.borne natural join station
group by aménageur
order by 1;

select distinct aménageur
from I2B06B.borne natural join station
where accèsrecharge in ('Gratuit','gratuit')
order by 1;


--7
create or replace view nbrpriseAménLA as
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Loire-Atlantique'
group by aménageur,commune
order by 1;

create or replace view nbrpriseAménVE as
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Vendée'
group by aménageur,commune
order by 1;

create or replace view nbrpriseAménSA as
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Sarthe'
group by aménageur,commune
order by 1;

create or replace view nbrpriseAménMA as
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Mayenne'
group by aménageur,commune
order by 1;

create or replace view nbrpriseAménML as
select aménageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where département='Maine-et-Loire'
group by aménageur,commune
order by 1;

create or replace view nbrpriseAménPDL as
select * from nbrpriseAménLA
union all
select * from nbrpriseAménVE
union all
select * from nbrpriseAménSA
union all
select * from nbrpriseAménMA
union all
select * from nbrpriseAménML;

select * from nbrpriseAménPDL;

select aménageur,sum(nbrprise) from nbrpriseAménPDL group by aménageur;
select aménageur,count(*) from nbrpriseAménPDL group by aménageur;