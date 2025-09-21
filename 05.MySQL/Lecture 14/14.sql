-- 00. Test's












-- 01. Employee Address
SELECT
	e.employee_id,
    e.job_title,
    e.address_id,
    a.address_text
FROM employees e
JOIN addresses a ON e.address_id = a.address_id
ORDER BY e.address_id ASC
LIMIT 5;





-- 02. Addresses with Towns
SELECT
	e.first_name,
    e.last_name,
    t.name AS town,
    a.address_text
FROM employees e
JOIN addresses a ON e.address_id = a.address_id
JOIN towns t ON a.town_id = t.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;





-- 03. Sales Employee
SELECT
	e.employee_id,
    e.first_name,
    e.last_name,
    d.name AS department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;








-- 04. Employee Departments
SELECT
	e.employee_id,
    e.first_name,
    e.salary,
    d.name AS department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;







-- 05. Employees Without Project
SELECT
	e.employee_id,
    e.first_name
FROM employees e
LEFT JOIN employees_projects ep ON e.employee_id = ep.employee_id 
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;





-- 06. Employees Hired After
SELECT 
	e.first_name,
    e.last_name,
    e.hire_date,
    d.name AS dept_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.hire_date > '1999-01-01' AND d.name = 'Sales' OR d.name = 'Finance'
ORDER BY e.hire_date ASC;





-- 07. Employees with Project












