-- 00. Tests
SELECT * FROM categories;
SELECT * FROM departments;
SELECT * FROM employees;
SELECT * FROM products;

SELECT department_id,
SUM(salary) AS salary
FROM employees
GROUP BY department_id
ORDER BY department_id;













-- 01. Departments Info
SELECT department_id, count(id) AS 'Number of employees'
FROM employees
GROUP BY department_id
ORDER BY department_id;

-- 02. Average Salary
SELECT department_id,
ROUND(AVG(salary), 2)
FROM employees
GROUP BY department_id
ORDER BY department_id;

-- 03. Minimum salary
SELECT department_id,
ROUND(MIN(salary), 2) AS 'Min Salary'
FROM employees
WHERE salary > 800
GROUP BY department_id
LIMIT 1;

-- 04. Appetizers Count
SELECT COUNT(id) AS count
FROM products
WHERE category_id = 2
AND price > 8;


-- 05. Menu Prices
SELECT category_id,
ROUND(AVG(price), 2) AS 'Average price',
MIN(price) AS 'Cheapest product',
MAX(price) AS 'Most expensive product'
FROM products
GROUP BY category_id;

