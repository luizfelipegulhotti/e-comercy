select * from produto 
 where  UNIDADE = 'UN';
 

select * from produto
where CODIGO_CLASSIFICACAO = 020 and QUANTIDADE > 20;


select * from produto 
where  QUANTIDADE >6 and DESCRICAO  like '%bala%' and CODIGO_CLASSIFICACAO  =3;



select  * from  produto 
where DESCRICAO  like '%martelo%' and CODIGO_CLASSIFICACAO =17;



select * from produto 
where CODIGO_CLASSIFICACAO =2
and UNIDADE <> 'cx'
and QUANTIDADE  >=10 and QUANTIDADE <=50;


select * from produto 
where CODIGO_CLASSIFICACAO = 021
and DESCRICAO like '%camiseta%'
or CODIGO_CLASSIFICACAO = 08
and DESCRICAO like '%bola%';


select * from produto 
where UNIDADE = 'PCT'
and CODIGO_CLASSIFICACAO =3

select * from produto 
where CODIGO_CLASSIFICACAO =6
and UNIDADE = 'UN'?????????

select * from produto 
where QUANTIDADE >6 and QUANTIDADE <10


select * from produto 
where DESCRICAO like 'oleo%'
and UNIDADE = 'L'


select * ,(quantidade * valor = 20) as
valortotal from produto 
where CODIGO_CLASSIFICACAO  =015
and UNIDADE = 'CX'
