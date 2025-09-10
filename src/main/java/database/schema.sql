CREATE DATABASE IF NOT EXISTS eventdb;
USE eventdb;

-- Events Table
CREATE TABLE events (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    location VARCHAR(255),
    start_time VARCHAR(50),
    end_time VARCHAR(50),
    organizer_contact VARCHAR(255),
    status VARCHAR(20) DEFAULT 'upcoming'
);

-- Users Table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);