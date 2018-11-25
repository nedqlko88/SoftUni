#1
CREATE TABLE passports(
	passport_id INT(11) PRIMARY KEY,
    passport_number VARCHAR(12)
);

CREATE TABLE persons(
	person_id INT(11) AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    salary DECIMAL(9,2),
    passport_id INT(11) UNIQUE,
	CONSTRAINT fk_persons_passports
    FOREIGN KEY(passport_id)
    REFERENCES passports(passport_id)
);


INSERT INTO `passports` (`person_id`, `passport_number`) VALUES
	('101', 'N34FG21B'),
	('102', 'K65LO4R7'),
    ('103','ZE657QP2');
    
INSERT INTO `persons` (`first_name`, `salary`, `passport_id`) VALUES
	('Roberto', '43300.00', '102'),
    ('Tom', '56100.00', '103'),
    ('Yana', '60200.00', '101');
	
#2
CREATE TABLE manufacturers(
	manufacturer_id INT(11) PRIMARY KEY,
    name VARCHAR(30),
    established_on DATE
);

CREATE TABLE models(
	model_id INT(11) PRIMARY KEY,
    name VARCHAR(40),
    manufacturer_id INT(11),
    CONSTRAINT fk_models_manufacturers
    FOREIGN KEY(manufacturer_id)
    REFERENCES manufacturers(manufacturer_id)
);

INSERT INTO manufacturers (`manufacturer_id`, `name`, `established_on`) VALUES
	('1', 'BMW', '1916/01/03'),
	('2', 'Tesla', '2003/01/01'),
	('3', 'Lada', '1966/01/05');
INSERT INTO models(`model_id`, `name`, `manufacturer_id`) VALUES
	('101', 'X1', '1'),
	('102', 'i6', '1'),
	('103', 'Model S', '2'),
	('104', 'Model X', '2'),
	('105', 'Model 3', '2'),
	('106', 'Nova', '3');






#5
CREATE TABLE cities(
	city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE customers(
	customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
    birthday DATE,
    city_id INT(11),
    CONSTRAINT fk_customers_cities
    FOREIGN KEY(city_id)
    REFERENCES cities(city_id)
);

CREATE TABLE orders(
	order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	customer_id INT(11),
    CONSTRAINT fk_orders_customers
    FOREIGN KEY(customer_id)
    REFERENCES customers(customer_id)
);

CREATE TABLE item_types(
	item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE items(
	item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
    item_type_id INT(11),
    CONSTRAINT fk_items_item_types
    FOREIGN KEY(item_type_id)
    REFERENCES item_types(item_type_id)
);

CREATE TABLE order_items(
	order_id INT(11),
	item_id INT(11),
    CONSTRAINT pk_order_items
    PRIMARY KEY(order_id, item_id),
    CONSTRAINT fk_order_items_orders
    FOREIGN KEY(order_id)
    REFERENCES orders(order_id),
    CONSTRAINT fk_order_items_items
    FOREIGN KEY(item_id)
    REFERENCES items(item_id)
);


#6
CREATE DATABASE university;
USE university;

CREATE TABLE majors(
	major_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE subjects(
	subject_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    subject_name VARCHAR(50)
);

CREATE TABLE students(
	student_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    student_number VARCHAR(12),
    student_name VARCHAR(50),
    major_id INT(11),
    CONSTRAINT fk_students_majors
    FOREIGN KEY(major_id)
    REFERENCES majors(major_id)
);

CREATE TABLE payments(
	payment_id INT(11) PRIMARY KEY AUTO_INCREMENT,
    payment_date DATE,
    payment_amount DECIMAL(8,2),
    student_id INT(11),
    CONSTRAINT fk_payments_students
    FOREIGN KEY(student_id)
    REFERENCES students(student_id)
);

CREATE TABLE agenda(
	student_id INT(11),
    subject_id INT(11),
    CONSTRAINT pk_student_subject
    PRIMARY KEY(student_id,subject_id),
    CONSTRAINT fk_agenda_students
    FOREIGN KEY(student_id)
    REFERENCES students(student_id),
    CONSTRAINT fk_agenda_subject
    FOREIGN KEY(subject_id)
    REFERENCES subjects(subject_id)
);

#9
SELECT m.mountain_range, p.peak_name, p.elevation
FROM peaks AS p
JOIN mountains as m 
ON m.id = p.mountain_id
WHERE m.mountain_range = 'Rila'
ORDER BY  p.elevation DESC;









      