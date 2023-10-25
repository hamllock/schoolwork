CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL
);

CREATE TABLE salesperson (
    salesperson_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    hire_date DATE NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

CREATE TABLE invoice (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    salesperson_id INT NOT NULL,
    sale_date DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    payment_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (salesperson_id) REFERENCES salesperson(salesperson_id)
);

CREATE TABLE vehicle (
    car_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    carType VARCHAR(50) NOT NULL,
    transmission VARCHAR(50) NOT NULL,
    fuelType VARCHAR(50) NOT NULL,
    year INT DEFAULT 2021,
    color VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE parts (
    part_id INT PRIMARY KEY AUTO_INCREMENT,
    part_name VARCHAR(50) NOT NULL,
    part_description VARCHAR(100) NOT NULL,
    part_price DECIMAL(10,2) NOT NULL,
    part_quantity INT NOT NULL
);