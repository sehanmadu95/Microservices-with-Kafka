CREATE DATABASE IF NOT EXISTS home_energy_tracker;
USE home_energy_tracker;

CREATE TABLE IF NOT EXISTS device (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(50),
    location VARCHAR(255),
    user_id BIGINT
);