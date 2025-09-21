-- 01. Select employee information
SELECT id, first_name, last_name, job_title FROM employees ORDER BY id; 

-- 02. Select employee with filter
SELECT id, CONCAT(first_name,' ',last_name) AS full_name, job_title, salary FROM employees  WHERE salary >= 1000 ORDER BY id;

-- 03. Update and select
UPDATE employees SET salary = salary + 100 WHERE job_title = 'Manager';
SELECT salary FROM employees;

-- 04. Top paid employee
SELECT * FROM employees ORDER BY salary DESC LIMIT 1;

-- 05. Select employees by multiple filters
SELECT * FROM employees WHERE department_id = 4 AND  salary >= 1000 ORDER BY id;

-- 06. Delete from table
DELETE FROM employees WHERE department_id <= 2;
SELECT * FROM employees ORDER BY id;