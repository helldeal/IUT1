select * from basetd.commune;
select * from basetd.departement;
select * from BASETD.operateur order by 2,3;
select * from BASETD.distribution;
select * from basetd.commune co,basetd.departement de where co.nomdep=de.nomdep order by co.nom_commune;

select co.code_insee,co.nom_commune,op.nomfo,op.generation,op.technologie,co.nomdep,de.code_departement,di.adresse from
    basetd.commune co ,BASETD.distribution di,basetd.departement de, BASETD.operateur op
    where co.nom_commune='Saint-Sébastien-sur-Loire' 
    AND co.nomdep IN (select nomdep from basetd.departement)
    and di.code_insee in (select code_insee from BASETD.commune)
    and di.numfo in (select numfo from BASETD.operateur);
    
select co.code_insee,co.nom_commune,op.nomfo,op.generation,op.technologie,co.nomdep,de.code_departement,di.adresse from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where co.nom_commune='Nantes' 
    And op.generation='5G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    order by 8,3;
    
select op.nomfo,di.adresse from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where co.nom_commune='Nantes' 
    And op.generation='5G'
    and op.technologie='5G NR 3500'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo;
    
select DISTINCT co.nom_commune,op.nomfo,op.generation,op.technologie from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where op.generation='5G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    order by 1;
    
select co.nom_commune ,op.nomfo,count(op.generation) from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where op.generation='5G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    group by co.nom_commune,op.nomfo
    order by 1,3 desc;
    
select DISTINCT co.nom_commune,count(op.generation) from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where op.generation='5G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    group by co.nom_commune
    order by 2 desc
    FETCH NEXT 10 ROWS ONLY;
        
select co.nom_commune ,count(op.generation)cg from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where op.generation='5G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    group by co.nom_commune
    having count(op.generation)>50
    order by 2 desc;
    
select co.nomdep ,op.nomfo,count(op.generation)cg from
    basetd.commune co ,basetd.departement de,BASETD.distribution di, BASETD.operateur op
    where op.generation='4G'
    AND co.nomdep=de.nomdep 
    and di.code_insee=co.code_insee 
    and di.numfo=op.numfo
    group by co.nomdep,op.nomfo
    order by 1,3 desc;
    