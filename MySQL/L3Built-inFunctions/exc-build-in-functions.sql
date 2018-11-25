#1
SELECT first_name, last_name
FROM employees
#WHERE SUBSTRING(first_name,1,2) = 'Sa';
#WHERE left(first_name,2) = 'Sa';
WHERE first_name LIKE 'sa%';

#2
SELECT first_name, last_name
FROM employees
WHERE last_name LIKE '%ei%';

#3
SELECT first_name
FROM employees 
WHERE department_id in (3,10) and year(hire_date) between 1995 and 2005;

#4
SELECT first_name, last_name
FROM employees 
WHERE job_title NOT LIKE '%engineer%';

#5
SELECT name
FROM towns
WHERE char_length(name) in (5,6)
ORDER BY name;

#6
SELECT town_id, name
FROM towns
WHERE substring(name,1,1) in ('M','K','B','E')
ORDER BY name;

#7
SELECT town_id, name
FROM towns
WHERE substring(name,1,1) not in ('R','B','D')
ORDER BY name;

#8
USE soft_uni;
CREATE VIEW v_employees_hired_after_2000 AS
	SELECT first_name,last_name
    FROM employees
   # WHERE extract(YEAR from hire_date) > 2000;
    WHERE YEAR(hire_date) > 2000;
SELECT *
FROM v_employees_hired_after_2000;

#9
SELECT first_name,last_name
FROM employees
WHERE char_length(last_name) = 5;
    


#10
SELECT country_name, iso_code
FROM countries
WHERE country_name LIKE '%a%a%a%'
ORDER BY iso_code;

#11
USE geography;
SELECT p.peak_name, r.river_name, lower(concat(p.peak_name, SUBSTRING(r.river_name,2))) AS `mix`
FROM peaks p,rivers r
WHERE RIGHT(p.peak_name, 1)= LEFT(r.river_name, 1)
ORDER BY mix;


#TEST
SELECT first_name
From employees
where first_name LIKE '[a-c]%';

#12
SELECT name, date_format(start,'%Y-%m-%d') as `start`
FROM games
WHERE YEAR(start) IN (2011,2012)
ORDER BY start, name
LIMIT 50;


#13
SELECT user_name, substr(u.email, position('@' IN u.email) + 1) AS `Email Provider`
FROM users u
ORDER BY `Email Provider`, `user_name`;

#14
SELECT user_name, ip_address
FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

SELECT 
c.country_name, 
c.country_code, 
(CASE
	WHEN c.currency_code = 'EUR' THEN 'Euro'
    ELSE 'Not Euro'
END) AS 'currency'
FROM countries AS c
ORDER BY c.country_name;
#15
SELECT g.name,
(CASE 
	WHEN HOUR(g.start) >= 0 and HOUR(g.start) < 12 THEN 'Morning'
    WHEN HOUR(g.start) >= 12 and HOUR(g.start) < 18 THEN 'Afternoon'
    ELSE 'Evening'
END) AS `Part of the Day`,
(CASE 
	WHEN g.duration <= 3 THEN 'Extra Short'
    WHEN g.duration BETWEEN 3 AND 6 THEN 'Short'
    WHEN g.duration BETWEEN 6 AND 10 THEN 'Long'
   ELSE 'Extra Long'
   # ELSE ''
END) AS `Part of the Day`
FROM games AS g
ORDER BY name,start;


#16
SELECT o.product_name, 
	o.order_date, 
	date_add(o.order_date, INTERVAL 3 DAY) AS `pay_due`, 
	date_add(o.order_date, INTERVAL 1 MONTH) AS `deliver_due`
FROM orders o;

