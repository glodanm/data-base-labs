
SELECT maker, type FROM labor_sql.product
WHERE product.type = 'PC'
ORDER BY maker ASC;

SELECT date FROM labor_sql.pass_in_trip
WHERE place like '%c';

SELECT date FROM labor_sql.pass_in_trip
INNER JOIN passenger ON pass_in_trip.ID_psg = passenger.ID_psg;

SELECT country, class FROM classes
WHERE country = 'Ukraine' AND EXISTS (
	SELECT country, class
	FROM classes
	WHERE country = 'Ukraine'
)
UNION ALL
SELECT country, class FROM classes
WHERE NOT EXISTS (
	SELECT country, class
	FROM classes
	WHERE country = 'Ukraine' 
)

SELECT maker FROM labor_sql.product
WHERE maker = ANY(SELECT maker FROM product WHERE type = 'Laptop')
	  AND
	  maker != ALL(SELECT maker FROM product WHERE type = 'Printer');

SELECT CONCAT('Code: ', code) AS code,
	   CONCAT('Model: ', model) AS model,
       CONCAT('Color: ', color) AS color,
       CONCAT('Type: ', type) AS type,
       CONCAT('Price: ', price) AS price
FROM labor_sql.printer

SELECT country, MAX(x), MIN(launched) 
FROM (SELECT country, COUNT(*) x , launched 
 FROM Ships b, Classes a
 WHERE a.class = b.class 
 GROUP BY country, launched
 ) s
WHERE launched = ANY(SELECT MIN(launched) 
 FROM Ships bb, Classes aa 
 WHERE bb.class = aa.class 
 GROUP BY country, launched
 ) 
GROUP BY country;


SELECT distinct (SELECT COUNT(laptop.code) FROM labor_sql.laptop) as laptop,
				(SELECT COUNT(printer.code) FROM labor_sql.printer) as printer,
                (SELECT COUNT(pc.code) FROM labor_sql.pc) as pc
FROM labor_sql.product


select distinct
    p.maker,
    case
      when c.count is not null then concat('yes(', c.count, ')')
      else 'no'
    end as laptop
  from Product as p
  left outer join
    (select maker, count(*) as count
      from Laptop as l
      join Product as pd on l.model = pd.model
      group by maker) as c on p.maker = c.maker
order by 1;


select case 
	when count(distinct classes.class) = count(classes.class)
	then  classes.class  end as unique_ship
from classes
union 
select 
case 
when count(distinct ships.class) = count(ships.class)
then ships.class  end 
from ships
union 
select case 
when count(distinct  outcomes.ship) = count( outcomes.ship)
then outcomes.ship end  from outcomes;