-- Create Database
CREATE DATABASE customerdb;

-- Use the Database
USE customerdb;

-- Create Table
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    salary INT NOT NULL
);

-- Insert 20 Sample Records
INSERT INTO customers (name, address, salary) VALUES
('John Doe', '123 Main St', 5000),
('Jane Smith', '456 Elm St', 6000),
('Michael Brown', '789 Oak St', 7000),
('Emily Davis', '321 Maple Ave', 5500),
('Chris Wilson', '654 Pine Dr', 6200),
('Sarah Taylor', '987 Cedar Ln', 5800),
('David Martinez', '159 Birch Ct', 7500),
('Sophia Garcia', '753 Willow Blvd', 6800),
('James Anderson', '852 Cherry Rd', 4900),
('Emma Thomas', '258 Poplar Ave', 5400),
('Liam Johnson', '147 Walnut Way', 6700),
('Olivia White', '369 Spruce St', 7100),
('William Harris', '741 Aspen Pl', 6300),
('Isabella Walker', '963 Fir Ln', 5200),
('Benjamin Hall', '357 Hickory Ct', 5900),
('Mia Robinson', '159 Dogwood Dr', 5600),
('Lucas Young', '951 Redwood Rd', 7200),
('Charlotte King', '753 Magnolia Ave', 6600),
('Ethan Scott', '246 Palm Blvd', 6100),
('Amelia Wright', '852 Cypress Ln', 5300);

-- Verify Data
SELECT * FROM customers;
