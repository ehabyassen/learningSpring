-- Create a new user and grant privileges to the database
DROP USER IF EXISTS 'user'@'localhost' ;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON employees.* TO 'user'@'localhost';

-- Flush the privileges to ensure they are applied
FLUSH PRIVILEGES;

-- Create a new database
DROP DATABASE IF EXISTS `employees`;
CREATE DATABASE `employees`;