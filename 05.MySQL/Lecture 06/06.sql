-- 01. Find all information about departments
SELECT department_id, name, manager_id FROM departments ORDER BY department_id;

-- 02. Find all department names
SELECT name FROM departments ORDER BY department_id;

-- 03. Find salary of each empoloyee
SELECT first_name, last_name, salary FROM employees ORDER BY employee_id;

-- 04. Find full name of each employee
SELECT first_name, middle_name, last_name FROM employees ORDER BY employee_id;

-- 05. Find email adress of each employee
SELECT CONCAT(first_name, '.', last_name, '@softuni.bg') AS full_email_adress FROM employees;

-- 06. Find all different employees salaries
SELECT DISTINCT salary FROM employees;

-- 07. Find all information about employees
SELECT * FROM employees WHERE job_title = 'Sales Representative' ORDER BY employee_id;

-- 08. Find names of all employees by salary in range
SELECT first_name, last_name, job_title FROM employees WHERE salary >= 20000 AND salary <=30000 ORDER BY employee_id;

-- 09. Find names of all employees
SELECT CONCAT(first_name, ' ', middle_name, ' ', last_name) AS 'Full Name' FROM employees WHERE salary = 25000 OR salary = 14000 OR salary = 12500 OR salary = 23600;

-- 10. Find all employees whitout manager
SELECT first_name, last_name FROM employees WHERE manager_id IS NULL;

-- 11. Find all Employees with salary more than 50000
SELECT first_name, last_name, salary FROM employees WHERE salary > 50000 ORDER BY salary DESC;

-- 12. Find 5 best paid employees
SELECT first_name, last_name FROM employees ORDER BY salary DESC LIMIT 5;

-- 13. Find all employees except marketing
SELECT first_name, last_name FROM employees WHERE department_id != 4;

-- 14. Sort employees table
SELECT * FROM employees ORDER BY salary DESC, first_name, last_name DESC, middle_name, employee_id;

-- 15. Create view employees with salary
CREATE VIEW v_employees_salaries AS SELECT first_name, last_name, salary FROM employees;
SELECT * FROM v_employees_salaries;

-- 16. Create view employees with job tiles
CREATE VIEW v_employees_job_titles AS SELECT CONCAT(first_name, ' ', COALESCE(CONCAT(middle_name,' '), ''), last_name) AS full_name, job_title FROM employees;
SELECT * FROM v_employees_job_tiles;

-- 17. Distinct job tiles
SELECT DISTINCT job_title FROM employees WHERE job_title IS NOT NULL ORDER BY job_title;

-- 18. Find first 10 started projectsemployees
SELECT * FROM projects ORDER BY start_date, name, project_id LIMIT 10;

-- 19. Last 7 hired employees
SELECT first_name, last_name, hire_date FROM employees ORDER BY hire_date DESC LIMIT 7;

-- 20. Increase salaries ****
UPDATE employees SET salary = salary * 1.12 WHERE department_id IN (SELECT department_id FROM departments WHERE name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services'));
SELECT salary FROM employees;

-- 21. All mountains peaks
USE geography;
SELECT peak_name FROM peaks ORDER BY peak_name;

-- 22. Biggest countryes by population
SELECT country_name, population FROM countries WHERE continent_code = 'EU' ORDER BY population DESC LIMIT 30;

-- 23. Countries and currency
SELECT country_name, country_code,
	CASE
    WHEN currency_code = 'EUR' 	Then 'Euro'
    ELSE 'Not Euro'
    END AS 'currency'
 FROM countries ORDER BY country_name;

-- 24. All diablo characters


