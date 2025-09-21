-- 00. Create DB
CREATE DATABASE minions;

-- 01. Create tables
CREATE TABLE minions(
	id INT PRIMARY KEY auto_increment,
    name varchar(50) NOT NULL,
    age INT
);

CREATE TABLE towns(
    town_id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- 02. Alter minions table
ALTER TABLE minions
ADD COLUMN town_id INT,
ADD FOREIGN KEY(town_id) REFERENCES towns(id);

-- 03. Insert records
INSERT INTO towns
VALUES(1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

INSERT INTO minions
VALUES (1, 'Kevin', 22, 1), (2, 'Bob', 15, 3), (3, 'Steward', NULL, 2);

-- 04. Truncate table
TRUNCATE minions;

-- 05. Drop all tables
DROP TABLE minions;
DROP TABLE towns;

-- 06. Create table people
CREATE TABLE people (
    id INT AUTO_INCREMENT NOT NULL UNIQUE PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DECIMAL(5 , 2 ),
    weight DECIMAL(5 , 2 ),
    gender ENUM('M', 'F') NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);
    
    INSERT INTO people
    VALUES(1, 'Sasho', NULL, 2.25, 85.7, 'M', '2000-8-20', NULL),
		(2, 'Petio', NULL, 1.756, 60.4, 'M', '1990-2-10', 'Test subject'),
		(3, 'Emi', 'blob',1.85, 55.67, 'F', '1997-12-13', 'Wife'),
		(4, 'Sasquatch', 'sasss', 0.55, 3.45, 'F', '2020-10-20', 'Animal'),
		(5, 'Kiki the cat', 'cute kitten', 0.10, 3, 'F', '2019-10-10', 'Home pet');
        
	-- 07. Create table users
    CREATE TABLE users(
		id BIGINT UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
        username VARCHAR(30) CHAR SET ascii UNIQUE NOT NULL,
        password VARCHAR(30) CHAR SET ascii NOT NULL,
        profile_pucture BLOB,
        last_login_time TIME,
        is_deleted BOOLEAN 
	);
    
    INSERT INTO users
    VALUES(1, 'admin', 'admin', 'blobPicture', NULL, false),
    (2, 'deleted', 'null', NULL, NULL, true),
    (3, 'activeUser', 'activePassword', 'HAPPY', '10:10:10', false),
    (4, 'sass', 'quatch', null, null, false),
    (5, 'josh', 'qwerty', 'mama', '12:20:24', false);
    
    -- 08. Change primary key
    ALTER TABLE users
    DROP PRIMARY KEY,
    ADD CONSTRAINT pk_users PRIMARY KEY(id, username);
    
    -- 09. Set default value
    ALTER TABLE users
    MODIFY COLUMN last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP();
    -- MODIFY last_login_time TIMESTAMP DEFAULT NOW();
    
    -- 10. Set unique field
    ALTER TABLE users
    DROP PRIMARY KEY,
    ADD CONSTRAINT pk_users PRIMARY KEY(id),
    ADD CONSTRAINT unique_username UNIQUE(username);
    
    -- 11. Movie database
    CREATE DATABASE movies;
    
    CREATE TABLE directors(
		id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
        director_name VARCHAR(60) NOT NULL,
        notes TEXT
        );
        
	CREATE TABLE genres(
		id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
        genre_name VARCHAR(60) NOT NULL,
        notes TEXT
        );
        
	CREATE TABLE categories(
		id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
        category_name VARCHAR(60) NOT NULL,
        notes TEXT
        );
        
	CREATE TABLE movies(
		id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
        title VARCHAR(60) NOT NULL,
        director_id INT,
        copuright_year YEAR,
        length DECIMAL(5, 2),
        genre_id INT,
        category_id INT,
        rating INT,
        notes TEXT
        );
        
	ALTER TABLE movies
    ADD FOREIGN KEY(director_id) REFERENCES directors(id),
    ADD FOREIGN KEY(genre_id) REFERENCES genres(id),
    ADD FOREIGN KEY(category_id) REFERENCES categories(id);
    
    INSERT INTO directors
    VALUES(1, 'first director', NULL),
		(2, 'second director', NULL),
		(3, 'third director', NULL),
		(4, 'four director', NULL),
		(5, 'five director', NULL);
        
	INSERT INTO genres
    VALUES(1, 'horor', NULL),
		(2, 'comedy', NULL),
		(3, 'cry', NULL),
        (4, 'action', NULL),
        (5, 'cars', NULL);
        
	INSERT INTO categories
    VALUES(1, 'fun', NULL),
		(2, 'cry', NULL),
        (3, 'fast', NULL),
        (4, 'slow', NULL),
        (5, 'rain', NULL);
        
	INSERT INTO movies
	VALUES(1, 'fast and furious', 1, '2020', 60.20, 2, 5, 10, NULL),
		(2, 'fast and cats', 2, '2020', 60.20, 3, 4, 10, NULL),
        (3, 'cats and furious', 3, '2020', 60.20, 4, 3, 10, NULL),
        (4, 'cats and mouses', 4, '2020', 60.20, 5, 2, 10, NULL),
        (5, 'mouses and cats', 5, '2020', 60.20, 1, 1, 10, NULL);
        
	-- 11. Car rentail database
    CREATE DATABASE car_rentail;
    
    USE car_rentail;
CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(50) NOT NULL,
    daily_rate DECIMAL(10, 2) NOT NULL,
    weekly_rate DECIMAL(10, 2) NOT NULL,
    monthly_rate DECIMAL(10, 2) NOT NULL,
    weekend_rate DECIMAL(10, 2) NOT NULL
);
      
CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(20) NOT NULL UNIQUE,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_year INT NOT NULL,
    category_id INT NOT NULL,
    doors TINYINT NOT NULL,
    picture BLOB,
    car_condition VARCHAR(255),
    available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
        
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(50),
    notes TEXT
);
        
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number VARCHAR(50) NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    zip_code VARCHAR(20),
    notes TEXT
);

CREATE TABLE rental_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(255),
    tank_level DECIMAL(5, 2) NOT NULL,
    kilometrage_start INT NOT NULL,
    kilometrage_end INT,
    total_kilometrage INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT NOT NULL,
    rate_applied DECIMAL(10, 2) NOT NULL,
    tax_rate DECIMAL(5, 2) NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    notes TEXT,
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);
	    
INSERT INTO categories (category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
	('Economy', 30.00, 150.00, 500.00, 50.00),
	('Standard', 50.00, 250.00, 800.00, 80.00),
	('Luxury', 100.00, 500.00, 1500.00, 150.00);

INSERT INTO cars (plate_number, make, model, car_year, category_id, doors, car_condition, available) VALUES
	('ABC123', 'Toyota', 'Corolla', 2020, 1, 4, 'Excellent', TRUE),
	('XYZ789', 'Honda', 'Accord', 2021, 2, 4, 'Good', TRUE),
	('DEF456', 'BMW', '5 Series', 2022, 3, 4, 'Like new', FALSE);

INSERT INTO employees (first_name, last_name, title, notes) VALUES
	('John', 'Smith', 'Manager', 'Senior employee'),
	('Jane', 'Doe', 'Sales Associate', 'Works weekends'),
	('Mike', 'Johnson', 'Customer Service', 'New hire');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) VALUES
	('DL123456', 'Alice Brown', '123 Main St', 'New York', '10001', 'Preferred customer'),
	('DL654321', 'Bob Wilson', '456 Oak Ave', 'Los Angeles', '90001', 'Corporate account'),
	('DL987654', 'Carol Davis', '789 Pine Rd', 'Chicago', '60601', NULL);

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) VALUES
	(1, 1, 1, 'Excellent', 80.00, 15000, 15200, 200, '2023-05-01', '2023-05-05', 4, 30.00, 8.50, 'Completed', 'Early return'),
	(2, 2, 2, 'Good', 75.00, 20000, NULL, NULL, '2023-05-10', '2023-05-17', 7, 50.00, 8.50, 'In Progress', 'Extended rental'),
	(3, 3, 3, 'Like new', 90.00, 5000, NULL, NULL, '2023-05-15', '2023-05-20', 5, 100.00, 8.50, 'Reserved', 'VIP customer');
    
-- 13. Bsic insert
CREATE DATABASE soft_uni;

USE soft_uni;
CREATE TABLE towns(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL);
    
CREATE TABLE addresses(
	id INT AUTO_INCREMENT PRIMARY KEY,
    address_text VARCHAR(60) NOT NULL,
    town_id INT NOT NULL,
    FOREIGN KEY (town_id) REFERENCES towns(id));
    
CREATE TABLE departments(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL);
    
CREATE TABLE employees(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    middle_name VARCHAR(60),
    last_name VARCHAR(60) NOT NULL,
    job_title VARCHAR(60) NOT NULL,
    department_id INT NOT NULL,
    hire_date DATE NOT NULL DEFAULT (CURRENT_DATE),
    salary DECIMAL(10, 2) NOT NULL,
    address_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id),
    FOREIGN KEY (address_id) REFERENCES addresses(id));
    
INSERT INTO towns(name)
VALUES('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO departments(name)
VALUES('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO addresses(address_text, town_id)
VALUES('Sveti Sofia 5', 1), ('Sveti Plovdiv 7', 2), ('Sveti Varna 6', 3), ('Sveti Burgas 3', 4);

INSERT INTO employees(first_name, middle_name, last_name, job_title, department_id, hire_date, salary, address_id)
VALUES('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00, 1),
	('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00, 2),
    ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25, 3),
    ('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00, 4),
    ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88, 1);
    
-- 14. Basic select all fields
SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

-- 15. Basic select all field and order them
SELECT * FROM towns ORDER BY name;
SELECT * FROM departments ORDER BY name;
SELECT * FROM employees ORDER BY salary DESC;

-- 16. Basic select some fields
SELECT name FROM towns ORDER BY name;
SELECT name FROM departments ORDER BY name;
SELECT first_name, last_name, job_title, salary FROM employees ORDER BY salary DESC;

-- 17. Increase employees salary
UPDATE employees SET salary = salary+salary*10/100 WHERE id;
SELECT salary FROM EMPLOYEES;


    
    
    
    
    
    
    
    
    
    
    
    
    