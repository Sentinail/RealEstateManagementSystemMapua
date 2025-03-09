-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `mapua_real_estate`;

-- Use the database
USE `mapua_real_estate`;

-- Create the User table
CREATE TABLE IF NOT EXISTS `User` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(100) NOT NULL,
  `lname` VARCHAR(100) NOT NULL,
  `role` ENUM('ADMIN', 'CUSTOMER') NOT NULL
);

-- Create the Block table
CREATE TABLE IF NOT EXISTS `Block` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `number` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT
);

-- Create the Lot table
CREATE TABLE IF NOT EXISTS `Lot` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `blockId` INT,
  `customerId` INT,
  `location` VARCHAR(255) NOT NULL,
  `size` DECIMAL(10,2) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `status` ENUM('AVAILABLE', 'RESERVED', 'SOLD') NOT NULL,
  FOREIGN KEY (`blockId`) REFERENCES `Block`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`customerId`) REFERENCES `User`(`id`) ON DELETE SET NULL
);

-- Insert Users
INSERT INTO User (username, password, fname, lname, role) VALUES
('juanD', 'password123', 'Juan', 'Dela Cruz', 'CUSTOMER'),
('mariaS', 'password123', 'Maria', 'Santos', 'CUSTOMER'),
('pedroM', 'password123', 'Pedro', 'Morales', 'CUSTOMER'),
('anaG', 'password123', 'Ana', 'Garcia', 'CUSTOMER'),
('carlosT', 'password123', 'Carlos', 'Tan', 'CUSTOMER');

-- Insert Blocks
INSERT INTO Block (number, name, description) VALUES
(1, 'Block A', 'Residential area near Manila Bay'),
(2, 'Block B', 'Commercial zone in Makati'),
(3, 'Block C', 'Suburban development in Quezon City'),
(4, 'Block D', 'Exclusive village in Cebu City'),
(5, 'Block E', 'Newly developed area in Davao City');

-- Insert Lots (5 lots per block)
INSERT INTO Lot (blockId, customerId, location, size, price, status) VALUES
-- Block 1 (Manila)
(1, NULL, 'Ermita, Manila', 150.00, 2500000.00, 'AVAILABLE'),
(1, NULL, 'Malate, Manila', 200.00, 3000000.00, 'AVAILABLE'),
(1, NULL, 'Intramuros, Manila', 180.00, 2750000.00, 'AVAILABLE'),
(1, NULL, 'Paco, Manila', 160.00, 2600000.00, 'AVAILABLE'),
(1, NULL, 'San Andres, Manila', 170.00, 2700000.00, 'AVAILABLE'),

-- Block 2 (Makati)
(2, NULL, 'Ayala, Makati', 250.00, 6000000.00, 'AVAILABLE'),
(2, NULL, 'Legaspi Village, Makati', 220.00, 5500000.00, 'AVAILABLE'),
(2, NULL, 'Salcedo Village, Makati', 230.00, 5700000.00, 'AVAILABLE'),
(2, NULL, 'Poblacion, Makati', 240.00, 5800000.00, 'AVAILABLE'),
(2, NULL, 'San Antonio, Makati', 200.00, 5200000.00, 'AVAILABLE'),

-- Block 3 (Quezon City)
(3, NULL, 'Diliman, Quezon City', 300.00, 7000000.00, 'AVAILABLE'),
(3, NULL, 'Katipunan, Quezon City', 280.00, 6800000.00, 'AVAILABLE'),
(3, NULL, 'Tandang Sora, Quezon City', 260.00, 6500000.00, 'AVAILABLE'),
(3, NULL, 'Fairview, Quezon City', 270.00, 6600000.00, 'AVAILABLE'),
(3, NULL, 'Novaliches, Quezon City', 290.00, 6900000.00, 'AVAILABLE'),

-- Block 4 (Cebu)
(4, NULL, 'Banilad, Cebu City', 350.00, 7500000.00, 'AVAILABLE'),
(4, NULL, 'Lahug, Cebu City', 330.00, 7300000.00, 'AVAILABLE'),
(4, NULL, 'Mabolo, Cebu City', 320.00, 7200000.00, 'AVAILABLE'),
(4, NULL, 'Talamban, Cebu City', 310.00, 7100000.00, 'AVAILABLE'),
(4, NULL, 'Guadalupe, Cebu City', 340.00, 7400000.00, 'AVAILABLE'),

-- Block 5 (Davao)
(5, NULL, 'Bajada, Davao City', 400.00, 8000000.00, 'AVAILABLE'),
(5, NULL, 'Matina, Davao City', 380.00, 7800000.00, 'AVAILABLE'),
(5, NULL, 'Lanang, Davao City', 370.00, 7700000.00, 'AVAILABLE'),
(5, NULL, 'Toril, Davao City', 360.00, 7600000.00, 'AVAILABLE'),
(5, NULL, 'Agdao, Davao City', 390.00, 7900000.00, 'AVAILABLE');
