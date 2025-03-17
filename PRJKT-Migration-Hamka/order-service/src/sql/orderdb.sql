-- Buat Tabel orders untuk Order Service
CREATE TABLE IF NOT EXISTS orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uuid VARCHAR(255) UNIQUE NOT NULL,
    username VARCHAR(255) NOT NULL,
    items TEXT NOT NULL,  -- menyimpan UUID item yang dipesan, dipisahkan dengan koma
    FOREIGN KEY (username) REFERENCES customers(username)
);

-- Menambahkan data contoh untuk tabel orders
INSERT INTO orders (uuid, username, items) VALUES
('order-001', 'john_doe', '123e4567-e89b-12d3-a456-426614174000,123e4567-e89b-12d3-a456-426614174001'),
('order-002', 'jane_doe', '123e4567-e89b-12d3-a456-426614174002'),
('order-003', 'alice_smith', '123e4567-e89b-12d3-a456-426614174003,123e4567-e89b-12d3-a456-426614174001'),
('order-004', 'bob_jones', '123e4567-e89b-12d3-a456-426614174000');
