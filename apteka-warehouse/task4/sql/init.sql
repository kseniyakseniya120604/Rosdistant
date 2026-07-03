-- Создание базы данных для веб-приложения "Аптечный склад"
CREATE DATABASE IF NOT EXISTS apteka CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS 'apteka_user'@'localhost' IDENTIFIED BY 'apteka_pass';
GRANT ALL PRIVILEGES ON apteka.* TO 'apteka_user'@'localhost';
FLUSH PRIVILEGES;

USE apteka;

CREATE TABLE IF NOT EXISTS medicine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    manufacturer VARCHAR(150),
    quantity INT NOT NULL DEFAULT 0,
    price DOUBLE NOT NULL DEFAULT 0,
    expiry_date VARCHAR(20)
);

INSERT INTO medicine (name, manufacturer, quantity, price, expiry_date) VALUES
('Парацетамол 500мг №20', 'Фармстандарт', 150, 45.90, '2027-05-01'),
('Ибупрофен 400мг №30', 'Верофарм', 80, 89.50, '2026-11-15'),
('Аскорбиновая кислота №50', 'Фармаприм', 200, 25.00, '2027-01-20');
