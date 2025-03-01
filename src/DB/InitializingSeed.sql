/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Sentinail
 * Created: Mar 1, 2025
 */

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `realestatesalesmanagementsystemmapua`;

-- Use the database
USE `realestatesalesmanagementsystemmapua`;

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
  `coordinates` VARCHAR(255) NOT NULL,
  `number` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT
);

-- Create the Lot table
CREATE TABLE IF NOT EXISTS `Lot` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `blockId` CHAR(36) NOT NULL,
  `customerId` INT, -- Matches User.id
  `coordinates` VARCHAR(255) NOT NULL,
  `size` DECIMAL(10,2) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL,
  `status` ENUM('AVAILABLE', 'RESERVED', 'SOLD') NOT NULL,
  FOREIGN KEY (`blockId`) REFERENCES `Block`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`customerId`) REFERENCES `User`(`id`) ON DELETE SET NULL
);


