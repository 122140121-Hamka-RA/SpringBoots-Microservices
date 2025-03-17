-- Buat Tabel items untuk Item Service
CREATE TABLE IF NOT EXISTS items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(255) UNIQUE NOT NULL,
    type VARCHAR(100),
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT
);

-- Menambahkan data contoh untuk tabel items
INSERT INTO items (uuid, type, name, price, description) VALUES
('123e4567-e89b-12d3-a456-426614174000', 'Electronics', 'Smartphone', 199.99, 'A modern smartphone with great features.'),
('123e4567-e89b-12d3-a456-426614174001', 'Clothing', 'T-shirt', 9.99, 'A comfortable cotton T-shirt for casual wear.'),
('123e4567-e89b-12d3-a456-426614174002', 'Electronics', 'Headphones', 49.99, 'Noise-cancelling over-ear headphones.'),
('123e4567-e89b-12d3-a456-426614174003', 'Furniture', 'Chair', 59.99, 'Ergonomic office chair with adjustable height.');
