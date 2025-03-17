-- Buat Tabel customers untuk Customer Service
CREATE TABLE IF NOT EXISTS customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

-- Menambahkan data contoh untuk tabel customers
INSERT INTO customers (username, first_name, last_name) VALUES
('john_doe', 'John', 'Doe'),
('jane_doe', 'Jane', 'Doe'),
('alice_smith', 'Alice', 'Smith'),
('bob_jones', 'Bob', 'Jones');
