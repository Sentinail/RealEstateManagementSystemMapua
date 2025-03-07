/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Sentinail
 * Created: Mar 1, 2025
 */

CREATE TABLE `User` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(100) NOT NULL,
  `lname` VARCHAR(100) NOT NULL,
  `role` ENUM('ADMIN', 'CUSTOMER') NOT NULL
);

CREATE TABLE `Block` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `coordinates` VARCHAR(255) NOT NULL,
  `number` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT
);

CREATE TABLE `Lot` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `blockId` CHAR(36) NOT NULL,
  `customerId` INT, 
  `coordinates` VARCHAR(255) NOT NULL,
  `size` DECIMAL(10,2) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `status` ENUM('AVAILABLE', 'RESERVED', 'SOLD') NOT NULL,
  FOREIGN KEY (`blockId`) REFERENCES `Block`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`customerId`) REFERENCES `User`(`id`) ON DELETE SET NULL
);

