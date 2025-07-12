CREATE DATABASE IF NOT EXISTS check-in-out-manager;
USE check-in-out-manager;

-- users table with document field validation
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document VARCHAR(11) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT chk_valid_document CHECK (document REGEXP '^[0-9]{8}$|^[0-9]{11}$')
);

-- attendances table
CREATE TABLE attendances (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    entry_date DATE NOT NULL,
    entry_time TIME NOT NULL,
    exit_date DATE DEFAULT NULL,
    exit_time TIME DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
