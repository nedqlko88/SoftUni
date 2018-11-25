
SET GLOBAL log_bin_trust_function_creators = 1;


DELIMITER $$


#1
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT e.first_name, e.last_name
	FROM employees AS e
	WHERE e.salary > 35000
	ORDER BY e.first_name, e.last_name;
END $$


#2
CREATE PROCEDURE usp_get_employees_salary_above(salary_min DOUBLE)
BEGIN
	SELECT e.first_name, e.last_name
	FROM employees AS e
	WHERE e.salary >= salary_min
	ORDER BY e.first_name, e.last_name, e.employee_id;
END $$


#3
CREATE PROCEDURE usp_get_towns_starting_with (town_starts_with VARCHAR(10))
BEGIN
	DECLARE town_wildcard VARCHAR(50);
    SET town_wildcard := CONCAT(town_starts_with, '%');
    SELECT t.name AS `town_name`
	FROM towns AS t
	WHERE lower(town_name) LIKE lower(town_wildcard)
	ORDER BY town_name;
#	SELECT t.name AS `town_name`
#	FROM towns AS t
#	WHERE LEFT(t.name, LENGTH(town_starts_with)) = town_starts_with
#	ORDER BY town_name;
END $$


#4
CREATE PROCEDURE usp_get_employees_from_town (town VARCHAR(20))
BEGIN
	SELECT e.first_name, e.last_name
    FROM employees AS e
    JOIN addresses AS a
    ON e.address_id = a.address_id
    JOIN towns AS t
    ON a.town_id = t.town_id
    WHERE t.name = town
    ORDER BY e.first_name, e.last_name, e.employee_id;
END $$


#5
CREATE FUNCTION ufn_get_salary_level(salary_size DOUBLE)
RETURNS varchar(20)
BEGIN
	RETURN 
        CASE 
			WHEN salary_size < 30000 THEN 'Low'
            WHEN salary_size BETWEEN 30000 AND 50000 THEN 'Average'
            ELSE 'High'
		END;
END $$


#6
CREATE PROCEDURE usp_get_employees_by_salary_level(IN level_salary VARCHAR(10))
BEGIN
	DECLARE result INT(11);
    SET result := 1;
	CASE
		WHEN level_salary IN ('low') THEN
			SELECT e.first_name, e.last_name 
			FROM employees AS e 
			WHERE e.salary < 30000 AND e.salary > 20
			ORDER BY e.first_name DESC, e.last_name DESC;
		WHEN level_salary = 'average' THEN 
			SELECT e.first_name, e.last_name 
			FROM employees AS e 
			WHERE e.salary BETWEEN 30000 AND 50000
			ORDER BY e.first_name DESC, e.last_name DESC;
		WHEN level_salary = 'high' THEN  
			SELECT e.first_name, e.last_name 
			FROM employees AS e 
			WHERE e.salary > 50000 AND e.salary < 500000
			ORDER BY e.first_name DESC, e.last_name DESC;
		ELSE 
			SELECT e.first_name, e.last_name 
			FROM employees AS e 
            WHERE e.salary > 500000
			ORDER BY e.first_name DESC, e.last_name DESC;
			
	END CASE;
END $$


#7
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))  
RETURNS BIT
BEGIN
	DECLARE result BIT;
	DECLARE word_length INT(11);
    DECLARE current_index INT(11);
    
    SET result := 1;
    SET word_length := char_length(word);
    SET current_index := 1;
    
    WHILE (current_index <= word_length) DO 
		IF (set_of_letters NOT LIKE (CONCAT('%', substr(word, current_index, 1), '%'))) THEN
			SET result := 0;
		END IF;
        
        SET current_index := current_index + 1;
    END WHILE;
    RETURN result;
END $$

#8
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT(ah.first_name, ' ', ah.last_name) AS `full_name`
    FROM account_holders AS ah
    ORDER BY full_name, ah.id;
END $$


#9
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(mount DOUBLE)
BEGIN
SELECT nn.first_name ,nn.last_name
FROM(
	SELECT n.first_name, n.last_name, SUM(n.balance) AS `all_balances`
	FROM (
		SELECT ah.first_name,ah.last_name, a.balance
		FROM account_holders AS ah
		JOIN accounts AS a
		ON ah.id = a.account_holder_id
		) AS n
	GROUP BY n.first_name
    ) AS nn
WHERE all_balances > mount
ORDER BY nn.first_name, nn.last_name, a.account_holder_id;
END $$ 
 

#10
CREATE FUNCTION ufn_calculate_future_value(sum DOUBLE, yearly_interest_rate DOUBLE, years INT(11))
RETURNS DOUBLE
BEGIN
	DECLARE result DOUBLE;
    SET result := sum * POWER((1 + yearly_interest_rate),years);
    RETURN result;
END $$


#11
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT(11), interest_rate DOUBLE)
BEGIN

	SELECT a.id, ah.first_name, ah.last_name, a.balance AS `current_balance`, ROUND(ufn_calculate_future_value(account_id, interest_rate, 5),4) AS `balance_in_5_years`
	FROM account_holders AS ah
	JOIN accounts AS a
	ON a.account_holder_id = ah.id
    HAVING a.id = account_id;
END $$




#15
DELIMITER ;
CREATE TABLE logs(
	log_id INT(11) AUTO_INCREMENT PRIMARY KEY, 
    account_id INT(11),
    old_sum DECIMAL(19,4), 
    new_sum DECIMAL(19,4)
	);
DELIMITER $$
CREATE TRIGGER tr_logs
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs(account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END $$

DELIMITER ;
UPDATE accounts
SET balance = balance + 10
WHERE id = 1;
	















