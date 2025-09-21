-- 00. Tests







-- 01. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
	BEGIN
		SELECT 
			first_name,
            last_name
        FROM employees
        WHERE salary > 35000
        ORDER BY first_name ASC, last_name ASC, employee_id ASC;
    END$$
DELIMITER ;

CALL usp_get_employees_salary_above_35000();





-- 02. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above (salary_above DECIMAL(19,4))
	BEGIN
		SELECT
			first_name,
            last_name
		FROM employees
        WHERE salary >= salary_above
        ORDER BY first_name ASC, last_name ASC, employee_id ASC;
	END$$    
DELIMITER ;

CALL usp_get_employees_salary_above(48100);








-- 03. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (searched VARCHAR(50))
	BEGIN
		SELECT
			name as town_name
		FROM towns
        WHERE name LIKE CONCAT (searched, '%')
        ORDER BY name ASC;
    END$$  
DELIMITER ;

CALL usp_get_towns_starting_with('b');





-- 04. Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(searched_town_name VARCHAR(50))
BEGIN
	SELECT
		first_name,
        last_name
	FROM employees e
    JOIN addresses a ON a.address_id = e.address_id
    JOIN towns t ON t.town_id = a.town_id
    WHERE t.name = searched_town_name
    ORDER BY e.first_name, e.last_name;
END$$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');






-- 05. Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(17,2))
RETURNS VARCHAR(50)
NOT DETERMINISTIC
NO SQL
	BEGIN
    DECLARE result VARCHAR(50);
    
		IF salary < 30000
			THEN SET result := 'Low';
		ELSEIF salary >= 30000 AND salary <= 50000
			THEN SET result := 'Average';
		ELSE SET result := 'High';
            END IF;    
            
    RETURN result;
    END$$
DELIMITER ;

SET @test := ufn_get_salary_level(20000);
SELECT @test;





-- 06. Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(50))
	BEGIN
		DECLARE start_point DECIMAL(17,4);
        DECLARE end_point DECIMAL(17,4);
        
        IF salary_level = 'low'
			THEN 
				SET start_point = 0.0001;
                SET end_point = 29999.9999;
		ELSEIF salary_level = 'average'
			THEN
				SET start_point = 30000;
                SET end_point = 50000;
		ELSE 
				SET start_point = 50001;
                SET end_point = 99999999999999999.9999;
			END IF;
    
		SELECT
			first_name,
            last_name
		FROM employees
        WHERE (salary >= start_point AND salary <= end_point)
        ORDER BY first_name DESC, last_name DESC;
	END$$
DELIMITER ;

CALL usp_get_employees_by_salary_level('high');

-- chatGBT
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(IN salary_level VARCHAR(50))
BEGIN
    SELECT 
        first_name,
        last_name
    FROM 
        employees
    WHERE 
        CASE 
            WHEN salary_level = 'low' THEN salary < 30000
            WHEN salary_level = 'average' THEN salary BETWEEN 30000 AND 50000
            WHEN salary_level = 'high' THEN salary > 50000
        END
    ORDER BY 
        first_name DESC, 
        last_name DESC;
END$$
DELIMITER ;



-- 07. Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50)) 
RETURNS INT
DETERMINISTIC
NO SQL
BEGIN
	DECLARE word_lenght_position INT DEFAULT 1;
    DECLARE current_symbol CHAR(1);
    
    WHILE word_lenght_position <= LENGTH(word) DO
		SET current_symbol = SUBSTRING(word, word_lenght_position, 1);
        
        IF LOCATE(current_symbol, set_of_letters) = 0
			THEN RETURN 0;
		END IF;
	END WHILE;    
    
    RETURN 1;
END$$
DELIMITER ;

DROP FUNCTION ufn_is_word_comprised;


SELECT ufn_is_word_comprised('oistmiahf','Sofia');
















