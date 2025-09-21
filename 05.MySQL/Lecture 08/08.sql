-- 01. Find names of all employee by first name
USE soft_uni;

SELECT first_name, last_name
	FROM employees
    WHERE first_name LIKE 'Sa%'
    ORDER BY employee_id;
    
-- 02. Find Names of All Employees by Last Name
SELECT first_name, last_name
	FROM employees
    WHERE last_name LIKE '%ei%'
    ORDER BY employee_id;
    
-- 03. Find First Names of All Employess
SELECT first_name
	FROM employees
    WHERE 
		department_id = 3
        AND YEAR(hire_date) >= 1995
        AND YEAR(hire_date) <= 2005
        OR
        department_id = 10
        AND YEAR(hire_date) >= 1995
        AND YEAR(hire_date) <= 2005
	ORDER BY employee_id;
    
-- 04. Find All Employees Except Engineers
SELECT first_name, last_name
	FROM employees
    WHERE job_title NOT LIKE '%engineer%'
    ORDER BY employee_id;
    
-- 05. Find Towns with Name Length
SELECT name
	FROM towns
    WHERE length(name) =  5 OR length(name) = 6
    ORDER BY name;

-- 06. Find Towns Starting With
SELECT *
	FROM towns
    WHERE name LIKE 'M%'
		OR name LIKE 'K%'
        OR name LIKE 'B%'
        OR name LIKE 'E%'
	ORDER BY name;
    
-- 07. Find Towns Not Starting With
SELECT *
	FROM towns
    WHERE name NOT LIKE 'R%'
		AND name NOT LIKE 'B%'
        AND name NOT LIKE 'D%'
	ORDER BY name;
    
-- 08. Create View Employees Hired After
CREATE VIEW v_employees_hired_after_2000
	AS SELECT first_name, last_name
    FROM employees
    WHERE YEAR(hire_date) > 2000;  
SELECT * FROM v_employees_hired_after_2000;

-- 09. Length of Last Name
SELECT first_name, last_name
	FROM employees
    WHERE LENGTH(last_name) = 5;
    
-- 10. Countries Holding 'A'
USE geography;
SELECT country_name, iso_code
	FROM countries
    WHERE country_name REGEXP '^(.*[aA]){3}.*$'
	ORDER BY iso_code;
    
-- 11. Mix of Peak and River Names
SELECT 
    p.peak_name AS peak_name,
    r.river_name AS river_name,
    LOWER(
        CASE 
            WHEN SUBSTRING(p.peak_name, -1, 1) = SUBSTRING(r.river_name, 1, 1) THEN
                CONCAT(
                    LEFT(p.peak_name, LENGTH(p.peak_name) - 1),
                    r.river_name
                )
            ELSE
                CONCAT(p.peak_name, r.river_name)
        END
    ) AS mix
FROM 
    peaks p
JOIN 
    rivers r ON LOWER(SUBSTRING(p.peak_name, -1, 1)) = LOWER(SUBSTRING(r.river_name, 1, 1))
ORDER BY 
    mix ASC;
    
-- 12.	Games from 2011 and 2012 Year
USE diablo;

SELECT name, DATE_FORMAT(start, '%Y-%m-%d')
	FROM games
    WHERE YEAR(start) = 2011 OR YEAR(start) = 2012    
    ORDER BY start, name 
    LIMIT 50;
    
-- 13. User Email Providers
SELECT user_name,
	SUBSTRING(email, LOCATE('@', email)+1 , LENGTH(email)) AS email_provider
    FROM users
    ORDER BY email_provider, user_name;
    
-- 14.Get Users with IP Address Like Pattern
SELECT user_name, ip_address
	FROM users
    WHERE ip_address LIKE '___.1%.%.___'
    ORDER BY user_name;
    
-- 15. Show All Games with Duration
    SELECT name as Game, 
	CASE WHEN hour(start) >= 0 and hour(start) < 12 THEN 'Morning'
		WHEN hour(start) >= 12 and hour(start) < 18 THEN 'Afternoon'
		WHEN hour(start) >= 18 and hour(start) < 24 THEN 'Evening'
        END AS "Part of the Day", 
	CASE WHEN duration <= 3 THEN 'Extra Short' 
		WHEN duration > 3 and duration <= 6 THEN 'Short'
        WHEN duration > 6 and duration <= 10 THEN 'Long' 
        ELSE 'Extra Long' 
        END AS duration
		FROM games;
        
-- 16. Orders Table
USE orders;

SELECT product_name, order_date,
	DATE_ADD(order_date, INTERVAL 3 DAY) AS pay_due,
    DATE_ADD(order_date, INTERVAL 1 MONTH) AS deliver_due
FROM orders;


