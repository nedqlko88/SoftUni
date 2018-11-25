#FROM LECTURE
SELECT department_id, SUM(salary), ROUND(AVG(salary)) AS `Average Salary`
FROM employees
GROUP BY department_id
ORDER BY department_id; 


#1
SELECT COUNT(id) as 'count'
FROM wizzard_deposits;


#2
SELECT MAX(magic_wand_size) as 'longest_magic_wand'
FROM wizzard_deposits;


#3
SELECT deposit_group, MAX(magic_wand_size) as 'longest_magic_wand'
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY longest_magic_wand, deposit_group;


#4
SELECT deposit_group
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY AVG(magic_wand_size)
LIMIT 1;


#5
SELECT deposit_group, SUM(deposit_amount) as `total_sum`
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;


#6
SELECT deposit_group, SUM(deposit_amount) as `total_sum`																				
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
HAVING magic_wand_creator = 'Ollivander family'
ORDER BY deposit_group;


#7
SELECT deposit_group, SUM(deposit_amount) as `total_sum`																				
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
HAVING magic_wand_creator = 'Ollivander family' AND total_sum < 150000
ORDER BY total_sum DESC;


#8
SELECT deposit_group, magic_wand_creator, MIN(deposit_charge) as `min_deposit_charge`																				
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator, deposit_group;


#9
SELECT 
	CASE 
    WHEN wd.age BETWEEN 0 AND 10 THEN '[0-10]'
    WHEN wd.age BETWEEN 11 AND 20 THEN '[11-20]'
    WHEN wd.age BETWEEN 21 AND 30 THEN '[21-30]'
    WHEN wd.age BETWEEN 31 AND 40 THEN '[31-40]'
    WHEN wd.age BETWEEN 41 AND 50 THEN '[41-50]'
    WHEN wd.age BETWEEN 51 AND 60 THEN '[51-60]'
    ELSE '[61+]'
    END AS `age_group`,
    COUNT(wd.id) AS `wizard_count`
FROM wizzard_deposits AS wd
GROUP BY age_group
ORDER BY wizard_count;


#10
SELECT LEFT(wd.first_name, 1) AS `first_letter`
FROM (
		SELECT *
		FROM wizzard_deposits
		WHERE deposit_group = 'Troll Chest'
	) AS wd
GROUP BY first_letter
ORDER BY first_letter;


#11
SELECT 
dt.deposit_group, 
dt.is_deposit_expired, 
AVG(deposit_interest) AS `average_interest`
FROM (
		SELECT *
		FROM wizzard_deposits
		WHERE YEAR(deposit_start_date) >= 1985 AND deposit_start_date != '1985-01-01'
	) as dt
GROUP BY dt.deposit_group, dt.is_deposit_expired
ORDER BY dt.deposit_group DESC, is_deposit_expired;


#12
SELECT SUM(difference) AS `sum_difference`
FROM 
(
		SELECT host.deposit_amount - 
			(	
				SELECT  guest.deposit_amount
				FROM wizzard_deposits AS guest
				WHERE guest.id = host.id + 1
			) 
		AS `difference`
		FROM wizzard_deposits AS host
) AS new_table;


#13
SELECT e.department_id, MIN(salary) AS `minimum_salary`
FROM (
		SELECT *
		FROM employees 
		WHERE YEAR(hire_date) >= 2000 AND DATE(hire_date) != '2000-01-01' and department_id IN (2,5,7)
	) as e
GROUP BY e.department_id
ORDER BY e.department_id;


#14
CREATE TABLE `employees_with_highest_salaries` AS
SELECT *
FROM employees
WHERE salary > 30000;

DELETE FROM employees_with_highest_salaries
WHERE manager_id = 42;

UPDATE employees_with_highest_salaries
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) AS `avg_salary`
FROM employees_with_highest_salaries
GROUP BY department_id
ORDER BY department_id;


#15
SELECT e.department_id, e.max_salary
FROM 
	(
		SELECT department_id, MAX(salary) AS `max_salary`
		FROM employees
		GROUP BY department_id
	) AS e
WHERE max_salary NOT BETWEEN 30000 and 70000
ORDER BY e.department_id;


#16
SELECT COUNT(e.salary)
FROM 
	(
		SELECT * 
		FROM employees
		WHERE manager_id IS NULL
	) AS e;


#17
SELECT e.department_id, MAX(e.salary)
FROM employees e
JOIN (
	SELECT e.department_id, max(e.salary) AS `second_salary`
	FROM employees e
	JOIN (
		SELECT department_id, MAX(e.salary) AS `first_salary`
		FROM employees e
		GROUP BY e.department_id
	) AS `first_max_salary`
	ON e.department_id = first_max_salary.department_id
	WHERE e.salary < first_max_salary.first_salary
	GROUP BY e.department_id
) AS `second_max_salary`
ON e.department_id = second_max_salary.department_id
WHERE e.salary < second_max_salary.second_salary
GROUP BY e.department_id
ORDER BY e.department_id;

#18




#19
SELECT department_id, SUM(salary) AS `total_salary`
FROM employees
GROUP BY department_id
ORDER BY department_id;






















