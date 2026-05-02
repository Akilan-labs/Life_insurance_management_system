-- ============================================================
--  Life Insurance Management System — Database Schema
--  Database : MySQL
--  Run      : mysql -u root -p < sql/schema.sql
-- ============================================================

CREATE DATABASE IF NOT EXISTS insurance_management;
USE insurance_management;

-- ---- Customers Table ----
CREATE TABLE IF NOT EXISTS customers (
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100)  NOT NULL,
    email      VARCHAR(100)  UNIQUE NOT NULL,
    phone      VARCHAR(15),
    address    VARCHAR(255),
    created_at TIMESTAMP     DEFAULT CURRENT_TIMESTAMP
);

-- ---- Policies Table ----
CREATE TABLE IF NOT EXISTS policies (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    customer_id     INT           NOT NULL,
    policy_number   VARCHAR(50)   UNIQUE NOT NULL,
    type            VARCHAR(50),
    premium_amount  DECIMAL(12,2) NOT NULL,
    coverage_amount DECIMAL(12,2),
    start_date      DATE,
    end_date        DATE,
    created_at      TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

-- ---- Claims Table ----
CREATE TABLE IF NOT EXISTS claims (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    customer_id   INT           NOT NULL,
    policy_number VARCHAR(50)   NOT NULL,
    claim_amount  DECIMAL(12,2) NOT NULL,
    status        ENUM('PENDING','APPROVED','REJECTED','SETTLED') DEFAULT 'PENDING',
    claim_date    DATE,
    created_at    TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

-- ---- Users Table (for Role-Based Access Control) ----
CREATE TABLE IF NOT EXISTS users (
    id         INT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50)  UNIQUE NOT NULL,
    password   VARCHAR(255) NOT NULL,  -- store hashed passwords only
    role       ENUM('ADMIN','AGENT','CUSTOMER') DEFAULT 'CUSTOMER',
    created_at TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- ---- Sample Data ----
INSERT INTO customers (name, email, phone, address) VALUES
('Akilan R',     'akilan@gmail.com',  '9942667445', 'Chennai, TN'),
('Raj Kumar',    'raj@example.com',   '9876543210', 'Coimbatore, TN'),
('Priya S',      'priya@example.com', '9001234567', 'Madurai, TN');

INSERT INTO policies (customer_id, policy_number, type, premium_amount, coverage_amount, start_date, end_date) VALUES
(1, 'POL-001', 'Term Life',  1234.00, 7000000.00, '2024-01-01', '2034-01-01'),
(2, 'POL-002', 'Whole Life', 2500.00, 5000000.00, '2023-06-01', '2053-06-01'),
(3, 'POL-003', 'Endowment',  1800.00, 3000000.00, '2024-03-01', '2044-03-01');

INSERT INTO claims (customer_id, policy_number, claim_amount, status, claim_date) VALUES
(1, 'POL-001', 700000.00, 'PENDING',  '2024-10-26'),
(2, 'POL-002', 100000.00, 'APPROVED', '2024-09-15');
