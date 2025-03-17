# Migrasi ke Microservices

Proyek ini mendemonstrasikan migrasi dari **Arsitektur Monolitik** ke **Arsitektur Microservices**. File ini menjelaskan perbedaan antara kedua pendekatan tersebut dan perubahan yang dilakukan pada struktur proyek, kode, dan deployment.

## Daftar Isi
- [Tinjauan Arsitektur Monolitik](#tinjauan-arsitektur-monolitik)
- [Tinjauan Arsitektur Microservices](#tinjauan-arsitektur-microservices)
- [Proses Migrasi](#proses-migrasi)
- [Struktur Proyek](#struktur-proyek)
- [Menjalankan Aplikasi](#menjalankan-aplikasi)
- [Kesimpulan](#kesimpulan)

## Tinjauan Arsitektur Monolitik

Pada **Arsitektur Monolitik** yang sebelumnya digunakan, seluruh aplikasi dibangun sebagai satu unit yang besar dan saling terhubung, di mana semua fitur (seperti manajemen pelanggan, manajemen item, dan manajemen pesanan) digabungkan dalam satu basis kode. Komponen-komponen dalam monolit ini saling terintegrasi dengan erat, berbagi satu database, dan berkomunikasi secara internal.

### Fitur Utama:
- **Basis Kode Tunggal**: Semua komponen (Customer, Item, Order) adalah bagian dari satu proyek yang sama.
- **Database Bersama**: Satu database digunakan untuk semua layanan.
- **Deploy Tunggal**: Seluruh aplikasi di-deploy sebagai satu unit.
- **Tergantung Satu Sama Lain**: Semua komponen saling bergantung, membuatnya lebih sulit untuk melakukan skala, uji coba, dan pemeliharaan setiap layanan secara terpisah.

## Tinjauan Arsitektur Microservices

Pada **Arsitektur Microservices** yang baru, aplikasi dipecah menjadi beberapa layanan independen, masing-masing bertanggung jawab untuk domain bisnis tertentu:

- **Customer Service**: Mengelola data dan operasi terkait pelanggan.
- **Item Service**: Menangani operasi terkait item (penlistingan, pembuatan).
- **Order Service**: Mengelola operasi terkait pesanan (pembuatan, pengambilan pesanan).

Setiap layanan berdiri sendiri, memiliki database sendiri, dan dapat di-deploy, di-skala, dan dipelihara secara terpisah.

### Fitur Utama:
- **Layanan Independen**: Setiap microservice (Customer, Item, Order) adalah aplikasi terpisah dengan basis kode masing-masing.
- **Data Terdesentralisasi**: Setiap layanan memiliki database sendiri, memastikan isolasi data.
- **Keterkaitan Longgar**: Layanan-layanan berkomunikasi satu sama lain melalui API REST atau sistem pesan, sehingga lebih mudah untuk melakukan skala dan pemeliharaan secara terpisah.
- **Deploy Independen**: Setiap microservice dapat di-deploy secara independen, memungkinkan fleksibilitas lebih dalam skala dan pembaruan.

## Proses Migrasi

Proses migrasi melibatkan beberapa langkah:

1. **Memecah Monolit**: Aplikasi monolit yang besar dipecah menjadi layanan-layanan yang lebih kecil dan lebih spesifik.
2. **Pengisolasi Database**: Setiap microservice diberi database sendiri untuk menghindari keterkaitan data antar layanan.
3. **Komunikasi Antar Layanan**: API REST diperkenalkan untuk komunikasi antar layanan, memungkinkan mereka berinteraksi secara terpisah.
4. **Deployment Independen**: Docker dan Docker Compose digunakan untuk containerization dan orkestrasi layanan, memungkinkan deploy dan skala setiap layanan secara terpisah.
5. **Discovery Layanan dan API Gateway**: Alat seperti **Spring Cloud** dapat digunakan untuk discovery layanan dan API Gateway untuk routing.

## Struktur Proyek

Struktur proyek telah diubah untuk mendukung arsitektur microservices. Berikut adalah gambaran umum struktur baru:

```bash
microservices-project
├── customer-service                  # Direktori untuk layanan Customer
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── customer
│   │   │   │               ├── CustomerController.java
│   │   │   │               ├── CustomerService.java
│   │   │   │               ├── CustomerRepo.java
│   │   │   │               └── CustomerEntity.java
│   │   │   ├── resources
│   │   │   │   ├── application.properties
│   │   │   │   └── application.yml
│   ├── Dockerfile                    # Dockerfile untuk layanan Customer
│   └── pom.xml                       # pom.xml untuk layanan Customer
│
├── item-service                      # Direktori untuk layanan Item
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── item
│   │   │   │               ├── ItemController.java
│   │   │   │               ├── ItemService.java
│   │   │   │               ├── ItemRepo.java
│   │   │   │               └── ItemEntity.java
│   │   │   ├── resources
│   │   │   │   ├── application.properties
│   │   │   │   └── application.yml
│   ├── Dockerfile                    # Dockerfile untuk layanan Item
│   └── pom.xml                       # pom.xml untuk layanan Item
│
├── order-service                     # Direktori untuk layanan Order
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── order
│   │   │   │               ├── OrderController.java
│   │   │   │               ├── OrderService.java
│   │   │   │               ├── OrderRepo.java
│   │   │   │               └── OrderEntity.java
│   │   │   ├── resources
│   │   │   │   ├── application.properties
│   │   │   │   └── application.yml
│   ├── Dockerfile                    # Dockerfile untuk layanan Order
│   └── pom.xml                       # pom.xml untuk layanan Order
│
├── docker-compose.yml                # Konfigurasi Docker Compose untuk menjalankan semua layanan
└── README.md                         # Dokumentasi proyek
