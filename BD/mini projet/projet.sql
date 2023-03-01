
select * from BASETD.rechargeelectrique ;

--Gironde
select * from BASETD.rechargeelectrique t1 where t1.d�partement='Gironde';
--INSEE DOUBLE
select t1.commune,t1.insee from BASETD.rechargeelectrique t1,BASETD.rechargeelectrique t2 where t1.insee=t2.insee and t1.commune!=t2.commune;

drop table station;
create Table Station as select codestation,
nombrepointsdecharge,
am�nageur,
enseigne,
op�rateur,
libell�station,
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
insert into i2B05B.commune VALUES('85234.0','Saint-Jean-de-Monts','Vend�e');
insert into i2B05B.commune VALUES('44143','Rez�','Loire-Atlantique');
update i2B05B.commune set insee = '44143.0' where insee ='44143' ;
update station set insee = '85234.0' where CODESTATION ='FR*S85*P85234*001' ;

ALTER TABLE station ADD CONSTRAINT pk_station PRIMARY KEY ( codestation );

grant select on station to i2b06b, i2b07b, i2b05b;
grant update on station to i2b06b, i2b07b, i2b05b;
grant insert on station to i2b06b, i2b07b, i2b05b;

--Cl� �trang�re
alter table station add constraint fk_insee_station 
foreign key(insee) references i2b05b.commune(insee);

--Cl� �trang�re
alter table station add constraint fk_codepointdecharge_station 
foreign key(codepointdecharge) references i2b06b.borne(codepointdecharge);

select * from station ;
select * from I2B05B.commune ;
select * from I2B07B.departement;
select * from I2B06B.borne;

--Q5
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Loire-Atlantique'
group by am�nageur,commune
order by 1;
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Vend�e'
group by am�nageur,commune
order by 1;
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Sarthe'
group by am�nageur,commune
order by 1;
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Mayenne'
group by am�nageur,commune
order by 1;
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Maine-et-Loire'
group by am�nageur,commune
order by 1;


select am�nageur,puissancemaximum,sum(nombrepointsdecharge) nbrprise
from I2B06B.borne natural join station
group by am�nageur,puissancemaximum
order by 1;


select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Loire-Atlantique'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Vend�e'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Sarthe'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Mayenne'
group by commune
order by 1;
select commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Maine-et-Loire'
group by commune
order by 1;

select am�nageur,sum(nombrepointsdecharge) nbrprise
from I2B06B.borne natural join station
group by am�nageur
order by 1;

select distinct am�nageur
from I2B06B.borne natural join station
where acc�srecharge in ('Gratuit','gratuit')
order by 1;


--7
create or replace view nbrpriseAm�nLA as
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Loire-Atlantique'
group by am�nageur,commune
order by 1;

create or replace view nbrpriseAm�nVE as
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Vend�e'
group by am�nageur,commune
order by 1;

create or replace view nbrpriseAm�nSA as
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Sarthe'
group by am�nageur,commune
order by 1;

create or replace view nbrpriseAm�nMA as
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Mayenne'
group by am�nageur,commune
order by 1;

create or replace view nbrpriseAm�nML as
select am�nageur,commune,sum(nombrepointsdecharge) nbrprise
from I2B05B.commune natural join I2B07B.departement natural join station
where d�partement='Maine-et-Loire'
group by am�nageur,commune
order by 1;

create or replace view nbrpriseAm�nPDL as
select * from nbrpriseAm�nLA
union all
select * from nbrpriseAm�nVE
union all
select * from nbrpriseAm�nSA
union all
select * from nbrpriseAm�nMA
union all
select * from nbrpriseAm�nML;

select * from nbrpriseAm�nPDL;

select am�nageur,sum(nbrprise) from nbrpriseAm�nPDL group by am�nageur;
select am�nageur,count(*) from nbrpriseAm�nPDL group by am�nageur;