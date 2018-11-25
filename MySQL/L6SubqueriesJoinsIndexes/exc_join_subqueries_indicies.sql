#1
SELECT e.employee_id, e.job_title, e.address_id, a.address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;


#2
SELECT e.first_name, e.last_name, t.name as `town`, a.address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
JOIN towns AS t
ON a.town_id = t.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;


#3
SELECT e.employee_id, e.first_name, e.last_name, d.name AS `department_name`
FROM employees AS e
JOIN departments as d
ON e.department_id = d.department_id AND d.name = 'Sales'
ORDER BY e.employee_id DESC;


#4
SELECT e.employee_id, e.first_name, e.salary, d.name AS `department_name`
FROM employees AS e
JOIN departments as d
ON d.department_id = e.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;


#5
SELECT e.employee_id, e.first_name
FROM employees AS e
LEFT JOIN employees_projects as ep
ON e.employee_id = ep.employee_id AND ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;


#6
SELECT 
    n.first_name,
    n.last_name,
    n.hire_date,
    de.name AS 'dept_name'
FROM
    (SELECT *
    FROM employees AS e
    WHERE DATE(e.hire_date) > '19990101') AS n
JOIN
    (SELECT *
    FROM departments AS d
    WHERE d.name = 'Sales' OR d.name = 'Finance') AS de
ON de.department_id = n.department_id
ORDER BY n.hire_date;


#7
SELECT 
	e.employee_id,
    e.first_name,
    p.name AS `project_name`
FROM employees AS e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13' 
	AND p.end_date IS NULL
ORDER BY e.first_name, project_name
LIMIT 5;


#8
SELECT e.employee_id,
	e.first_name,
    (CASE
		WHEN YEAR(p.start_date) > '2004' THEN NULL
        ELSE p.name
    END) AS `project_name`
FROM employees e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY project_name;


#9
SELECT em.employee_id, em.first_name, em.manager_id, emp.first_name AS `manager_name`
FROM (
	SELECT *
	FROM employees AS e
	WHERE e.manager_id IN (3,7)
	) AS em
JOIN employees AS emp
ON em.manager_id = emp.employee_id
ORDER BY em.first_name;


#10
SELECT e.employee_id, CONCAT(e.first_Name,' ', e.last_name) AS `employee_name`, CONCAT(em.first_name, ' ', em.last_name) AS `manager_name`, d.name AS `department_name`
FROM employees AS e
JOIN employees AS em
ON e.manager_id = em.employee_id
JOIN departments AS d
ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;


#11
SELECT MIN(em.average_salary) AS `min_average_salary`
FROM (
	SELECT e.department_id, AVG(e.salary) AS `average_salary`
	FROM employees AS e
	GROUP BY e.department_id
    ) AS em;


#12
SELECT mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM mountains_countries AS mc
JOIN mountains AS m
ON mc.mountain_id = m.id
JOIN peaks AS p
ON m.id = p.mountain_id
WHERE mc.country_code = 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;


#13
SELECT mc.country_code, COUNT(mc.mountain_id) AS `mountain_range`
FROM mountains_countries AS mc
GROUP BY mc.country_code
HAVING mc.country_code IN ('US', 'RU', 'BG')
ORDER BY mountain_range DESC;


#14
SELECT co.country_name, r.river_name
FROM (
	SELECT *
	FROM countries AS c
	WHERE c.continent_code = 'AF'
    ) AS co
LEFT JOIN countries_rivers AS cr
ON co.country_code = cr.country_code
LEFT JOIN rivers AS r
ON cr.river_id = r.id
ORDER BY co.country_name
LIMIT 5;


#15
SELECT n.continent_code, n.currency_code, MAX(n.count)
FROM (
	SELECT c.continent_code, c.currency_code, COUNT(c.currency_code) AS `count`
	FROM countries AS c
	GROUP BY c.currency_code
	) AS n
GROUP BY n.continent_code
ORDER BY n.continent_code, n.currency_code;



SELECT c.currency_code,COUNT(c.country_code) AS `currency_usage`
FROM countries AS c
GROUP BY c.currency_code
HAVING currency_usage > 1;




#16
SELECT COUNT(aaaa) AS `country_count`
FROM (
	SELECT c.country_code AS `aaaa`, mc.mountain_id AS `mountains`
	FROM countries c
	LEFT JOIN mountains_countries mc
	ON c.country_code = mc.country_code
	WHERE mc.mountain_id IS NULL
    ) AS n;


#17
SELECT c.country_name, 
	MAX(p.elevation) AS `highest_peak_elevation`,
    MAX(r.length) AS `longest_river_length`
FROM countries c
JOIN mountains_countries mc
ON c.country_code = mc.country_code
JOIN mountains m
ON mc.mountain_id = m.id
JOIN peaks p
ON m.id = p.mountain_id
JOIN countries_rivers cr
ON c.country_code = cr.country_code
JOIN rivers r
ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, 
		longest_river_length DESC,
        c.country_name
LIMIT 5;




























