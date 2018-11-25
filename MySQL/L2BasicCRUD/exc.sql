#1
SELECT *
FROM `departments`
ORDER BY department_id;

#2
SELECT name
FROM `departments`
ORDER BY department_id;

#3
SELECT `first_name`, `last_name`, `salary`
FROM `employees`
ORDER BY `employee_id`;

#4
SELECT `first_name`, `middle_name`, `last_name`
FROM `employees`
ORDER BY `employee_id`;

#5
SELECT CONCAT(`first_name`, '.', `last_name`, '@softuni.bg') AS 'full_email_address'
FROM `employees`;

#6
Select DISTINCT(`salary`)
FROM `employees`
ORDER BY `employee_id`;

#7
SELECT *
FROM employees
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;

#8
SELECT `first_name`, `last_name`, `job_title`
FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000
ORDER BY `employee_id`;

#9
SELECT CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) AS 'Full Name'
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);

#10
SELECT `first_name`, `last_name`
FROM `employees`
WHERE manager_id IS NULL;

#11
SELECT `first_name`, `last_name`, `salary`
FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;

#12
SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

#13
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` NOT IN (4);

#14
SELECT *
FROM `employees`
ORDER BY
	`salary` DESC, 
	`first_name`,
	`last_name` DESC,
	`middle_name`;
    
#15
CREATE VIEW `v_employee_salary` AS
	SELECT `first_name`, `last_name`, `salary`
	FROM `employees`;
    
SELECT *
FROM `v_employee_salary`;


#16
UPDATE `employees`
SET `middle_name`=''
WHERE `middle_name` IS NULL;

CREATE VIEW `v_employees_job_titles` AS
	SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`) AS 'full_name', `job_title`
    FROM `employees`;

SELECT *
FROM `v_employees_job_titles`;

#17
SELECT DISTINCT(`job_title`)
FROM `v_employees_job_titles`;

#18
SELECT *
FROM `projects`
ORDER BY `start_date`,
	`name`
LIMIT 10;

#19
SELECT `first_name`, `last_name`, `hire_date`
FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7;

#20
CREATE VIEW `v_salaries` AS
	SELECT `salary`
    FROM `employees`
    WHERE `department_id` IN ( 1,2,4,11);
    
UPDATE `v_salaries`
SET `salary` = 1.12 * `salary`;

SELECT `salary`
FROM `v_salaries`;

#21
SELECT `peak_name`
FROM `peaks`
ORDER BY `peak_name`;

#22
SELECT `country_name`, `population`
FROM `countries`
WHERE `continent_code`= 'EU'
ORDER BY `population` DESC, `country_name`
LIMIT 30;

#23
SELECT 
c.country_name, 
c.country_code, 
(CASE
	WHEN c.currency_code = 'EUR' THEN 'Euro'
    ELSE 'Not Euro'
END) AS 'currency'
FROM countries AS c
ORDER BY c.country_name;


#24
SELECT `name`
FROM `characters`
ORDER BY `name`;




