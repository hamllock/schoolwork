CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL
);

CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_type VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    sale_date DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    payment_date DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE vehicle (
    car_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    variant VARCHAR(50) NOT NULL,
    bodyType VARCHAR(50) NOT NULL,
    transmission VARCHAR(50) NOT NULL,
    fuelType VARCHAR(50) NOT NULL,
    year INT DEFAULT 2021,
    color VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE parts_inventory (
    part_id INT PRIMARY KEY AUTO_INCREMENT,
    part_name VARCHAR(50) NOT NULL,
    part_description VARCHAR(100) NOT NULL,
    part_price DECIMAL(10,2) NOT NULL,
    part_quantity INT NOT NULL
);

CREATE TABLE service_history (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    car_id INT NOT NULL,
    service_type VARCHAR(50) NOT NULL,
    service_date DATE NOT NULL,
    service_cost DECIMAL(10,2) NOT NULL,
    service_description VARCHAR(100),
    FOREIGN KEY (car_id) REFERENCES vehicle(car_id)
);

CREATE TABLE car_inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    car_id INT NOT NULL,
    quantity INT NOT NULL,
    location VARCHAR(50) NOT NULL,
    FOREIGN KEY (car_id) REFERENCES vehicle(car_id)
);

CREATE TABLE customer_orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE sales_activity (
    activity_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    activity_type VARCHAR(50) NOT NULL,
    activity_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE service_appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_type VARCHAR(50) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (car_id) REFERENCES vehicle(car_id)
);

CREATE TABLE part_sales (
    sale_id INT PRIMARY KEY AUTO_INCREMENT,
    part_id INT NOT NULL,
    customer_id INT NOT NULL,
    sale_date DATE NOT NULL,
    quantity_sold INT NOT NULL,
    sale_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (part_id) REFERENCES parts_inventory(part_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);


INSERT INTO vehicle (brand, model, variant, bodyType, transmission, fuelType, year, color, price)
VALUES 
  ('Toyota', 'Fortuner', 'V', 'SUV', 'Automatic', 'Diesel', 2023, 'Attitude Black Mica', 1856000.00),
  ('Toyota', 'Fortuner', 'Q', 'SUV', 'Automatic', 'Diesel', 2023, 'Attitude Black Mica', 2115000.00),
  ('Toyota', 'Fortuner', 'LTD', 'SUV', 'Automatic', 'Diesel', 2023, 'Silver Metallic / Attitude Black Mica', 2545000),
  ('Toyota', 'Vios', 'Base', 'Sedan', 'Manual', 'Gasoline', 2023, 'White', 696000.00),
  ('Toyota', 'Vios', 'J', 'Sedan', 'Manual', 'Gasoline', 2023, 'Red', 722000.00),
  ('Toyota', 'Vios', 'E', 'Sedan', 'Manual', 'Gasoline', 2023, 'Red', 886000.00),
  ('Toyota', 'Wigo', 'J', 'Hatchback', 'Manual', 'Gasoline', 2023, 'White', 609000.00),
  ('Toyota', 'Wigo', 'E', 'Hatchback', 'CVT', 'Gasoline', 2023, 'White', 648000.00),
  ('Toyota', 'Wigo', 'G', 'Hatchback', 'CVT', 'Gasoline', 2023, 'White', 729000.00),
  ('Toyota', 'Hilux', 'E', 'Pickup Truck', 'Manual', 'Diesel', 2023, 'White', 1306000.00),
  ('Toyota', 'Hilux', 'G', 'Pickup Truck', 'Manual', 'Diesel', 2023, 'Black', 1384000.00),
  ('Toyota', 'Hilux', 'GR Sport', 'Pickup Truck', 'Automatic', 'Diesel', 2023, 'Red', 2166000.00),
  ('Toyota', 'Innova', 'J', 'MPV', 'Manual', 'Diesel', 2023, 'White', 1236000.00),
  ('Toyota', 'Innova', 'E', 'MPV', 'Manual', 'Diesel', 2023, 'Black', 1340000.00),
  ('Toyota', 'Innova', 'G', 'MPV', 'Manual', 'Diesel', 2023, 'Red', 1572000.00);

INSERT INTO customer (first_name, last_name, email, phone, address, city, zip_code)
VALUES
  ('John', 'Doe', 'john.doe1@example.com', '+12345678901', '123 Main St', 'Davao City', '8000'),
  ('Jane', 'Smith', 'jane.smith2@example.com', '+23456789012', '456 Elm St', 'Davao City', '8000'),
  ('Alice', 'Johnson', 'alice.johnson3@example.com', '+34567890123', '789 Oak St', 'Davao City', '8000'),
  ('Bob', 'Williams', 'bob.williams4@example.com', '+45678901234', '101 Pine St', 'Davao City', '8000'),
  ('Sarah', 'Brown', 'sarah.brown5@example.com', '+56789012345', '202 Maple St', 'Davao City', '8000'),
  ('Michael', 'Lee', 'michael.lee6@example.com', '+67890123456', '303 Cedar St', 'Davao City', '8000'),
  ('Emily', 'Clark', 'emily.clark7@example.com', '+78901234567', '404 Birch St', 'Davao City', '8000'),
  ('David', 'Garcia', 'david.garcia8@example.com', '+89012345678', '505 Redwood St', 'Davao City', '8000'),
  ('Olivia', 'Rodriguez', 'olivia.rodriguez9@example.com', '+90123456789', '606 Walnut St', 'Davao City', '8000'),
  ('William', 'Hernandez', 'william.hernandez10@example.com', '+01234567890', '707 Chestnut St', 'Davao City', '8000');

  -- Salespersons
INSERT INTO employee (employee_type, first_name, last_name, email, phone, address, city, zip_code, salary)
VALUES
  ('Salesperson', 'John', 'Doe', 'john.doe1@example.com', '+12345678901', '123 Main St', 'Davao City', '8000', 40000),
  ('Salesperson', 'Jane', 'Smith', 'jane.smith2@example.com', '+23456789012', '456 Elm St', 'Davao City', '8000', 42000),
  ('Salesperson', 'Alice', 'Johnson', 'alice.johnson3@example.com', '+34567890123', '789 Oak St', 'Davao City', '8000', 38000);

-- Mechanics
INSERT INTO employee (employee_type, first_name, last_name, email, phone, address, city, zip_code, salary)
VALUES
  ('Mechanic', 'Bob', 'Williams', 'bob.williams4@example.com', '+45678901234', '101 Pine St', 'Davao City', '8000', 45000),
  ('Mechanic', 'Sarah', 'Brown', 'sarah.brown5@example.com', '+56789012345', '202 Maple St', 'Davao City', '8000', 48000),
  ('Mechanic', 'Michael', 'Lee', 'michael.lee6@example.com', '+67890123456', '303 Cedar St', 'Davao City', '8000', 42000);

-- Staff
INSERT INTO employee (employee_type, first_name, last_name, email, phone, address, city, zip_code, salary)
VALUES
  ('Cashier', 'Emily', 'Clark', 'emily.clark7@example.com', '+78901234567', '404 Birch St', 'Davao City', '8000', 55000),
  ('Admin', 'David', 'Garcia', 'david.garcia8@example.com', '+89012345678', '505 Redwood St', 'Davao City', '8000', 52000);

INSERT INTO parts_inventory (part_name, part_description, part_price, part_quantity)
VALUES
  ('Widget A', 'High-quality widget for various applications', 9.99, 100),
  ('Gizmo B', 'Advanced gizmo with innovative features', 19.99, 50),
  ('Doodad C', 'Durable doodad built to last', 14.99, 75),
  ('Thingamajig D', 'Versatile thingamajig for your needs', 29.99, 40),
  ('Sprocket E', 'Efficient sprocket for mechanical systems', 7.99, 120),
  ('Whatchamacallit F', 'Intriguing whatchamacallit for tech enthusiasts', 34.99, 30),
  ('Doohickey G', 'Compact doohickey for tight spaces', 12.99, 90),
  ('Widget H', 'Reliable widget designed for performance', 8.99, 110),
  ('Gadget I', 'Sleek gadget with a modern design', 24.99, 60),
  ('Contraption J', 'Ingenious contraption for various projects', 39.99, 20);

INSERT INTO transactions (customer_id, employee_id, transaction_type, sale_date, total, payment_method, payment_date)
VALUES
  (1, 1, 'Car Sale', '2023-11-01', 1856000.00, 'Credit Card', '2023-11-01'),
  (2, 2, 'Car Sale', '2023-11-02', 2115000.00, 'Cash', '2023-11-02'),
  (3, 4, 'Car Maintenance', '2023-11-03', 5000.00, 'Debit Card', '2023-11-03'),
  (4, 1, 'Car Sale', '2023-11-04', 696000.00, 'Credit Card', '2023-11-04'),
  (5, 4, 'Parts Installation', '2023-11-05', 4300.00, 'Cash', '2023-11-05'),
  (6, 5, 'Car Maintenance', '2023-11-06', 6300.00, 'Debit Card', '2023-11-06'),
  (7, 1, 'Car Sale', '2023-11-07', 650000.00, 'Cash', '2023-11-07'),
  (8, 6, 'Car Maintenance', '2023-11-08', 2000.00, 'Credit Card', '2023-11-08'),
  (9, 3, 'Car Sale', '2023-11-09', 245000.00, 'Cash', '2023-11-09'),
  (10, 1, 'Car Sale', '2023-11-10', 399000.00, 'Credit Card', '2023-11-10');

  INSERT INTO service_history (car_id, service_type, service_date, service_cost, service_description)
VALUES
  (1, 'Oil Change', '2023-10-15', 500.00, 'Regular oil change service.'),
  (2, 'Brake Inspection', '2023-10-20', 200.00, 'Check and replace brake pads.'),
  (2, 'Tire Rotation', '2023-10-25', 100.00, 'Rotate tires for even wear.'),
  (2, 'Oil Change', '2023-10-30', 500.00, 'Regular oil change service.'),
  (4, 'Brake Repair', '2023-11-05', 800.00, 'Replace worn-out brake components.'),
  (6, 'Engine Tune-Up', '2023-11-10', 600.00, 'Comprehensive engine maintenance.'),
  (7, 'Oil Change', '2023-11-15', 500.00, 'Regular oil change service.');

INSERT INTO car_inventory (car_id, quantity, location)
VALUES
  (1, 5, 'Main Showroom'),
  (2, 3, 'Main Showroom'),
  (3, 2, 'Main Showroom'),
  (4, 6, 'Secondary Showroom'),
  (5, 4, 'Secondary Showroom'),
  (6, 3, 'Service Center');

INSERT INTO customer_orders (customer_id, order_date, status)
VALUES
  (1, '2023-11-01', 'Pending'),
  (2, '2023-11-02', 'In Progress'),
  (3, '2023-11-03', 'Completed'),
  (4, '2023-11-04', 'In Progress'),
  (5, '2023-11-05', 'Pending');

INSERT INTO sales_activity (employee_id, customer_id, activity_type, activity_date)
VALUES
  (1, 1, 'Test Drive', '2023-11-01'),
  (2, 2, 'Sales Call', '2023-11-02'),
  (3, 3, 'Email Inquiry', '2023-11-03'),
  (1, 4, 'Test Drive', '2023-11-04'),
  (4, 5, 'Sales Call', '2023-11-05');

INSERT INTO service_appointments (customer_id, car_id, appointment_date, appointment_type)
VALUES
  (1, 1, '2023-11-10', 'Oil Change'),
  (2, 2, '2023-11-12', 'Brake Inspection'),
  (3, 3, '2023-11-14', 'Tire Rotation');

INSERT INTO part_sales (part_id, customer_id, sale_date, quantity_sold, sale_amount)
VALUES
  (1, 1, '2023-11-20', 3, 29.97);

