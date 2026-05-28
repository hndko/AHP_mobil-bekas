# 🚗 Sistem Pendukung Keputusan (SPK) Pemilihan Mobil Bekas - Metode AHP

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)

Aplikasi Desktop berbasis **Sistem Pendukung Keputusan (SPK)** yang digunakan untuk merekomendasikan dan menyeleksi pemilihan mobil bekas terbaik menggunakan metode **Analytical Hierarchy Process (AHP)**.

Aplikasi ini sangat berguna bagi calon pembeli maupun _showroom_ mobil bekas untuk mendapatkan rekomendasi objektif berdasarkan perhitungan matematis terhadap berbagai kriteria penting (seperti Harga, Kondisi Mesin, Tahun Pembuatan, dsb).

---

## 🛠️ Teknologi & _Library_ yang Digunakan

Aplikasi ini dikembangkan menyeluruh menggunakan bahasa Java dan arsitektur _desktop application_ modern.

- **Bahasa Pemrograman:** Java (JDK 8/LTS)
- **GUI / Antarmuka:** Java Swing (menggunakan Look & Feel Nimbus)
- **Database:** MySQL
- **Driver:** MySQL Connector Java (JDBC)
- **Reporting:** JasperReports 📝 (Untuk mencetak dan menyimpan laporan PDF)
- **IDE / Build Tools:** Apache NetBeans (Ant Build)

---

## 👥 Role Pengguna

Aplikasi ini menggunakan pendekatan _Single-Role_ berpusat pada **Administrator/Penilai**.

- **Admin** memiliki akses penuh (Full CRUD) ke dalam sistem. Mulai dari manajemen data master, manajemen kriteria matematis, hingga proses perhitungan keputusan (AHP) dan pencetakan hasil laporan akhir.

---

## ✨ Fitur-Fitur Utama

1. 🔐 **Manajemen Autentikasi**
   - **Login & Register Admin:** Sistem keamanan _login_ untuk administrator sebelum dapat masuk ke Menu Utama (Dashboard).
2. 🗃️ **Manajemen Master Data (Alternatif)**
   - **Data Mobil Bekas:** Menambah, mengubah, mencari, dan menghapus kandidat mobil bekas (_CRUD_) beserta spesifikasinya (nama, harga, BBM, kondisi mesin, dsb).
3. ⚖️ **Manajemen Kriteria AHP**
   - **Pengaturan Kriteria:** Mendefinisikan kriteria utama penilaian beserta _bobot prioritas_ atau derajat kepentingannya terhadap kriteria lain.
   - **Pengaturan Sub-Kriteria:** Memberikan nilai intensitas/bobot pada masing-masing rincian dari tiap kriteria (misal rentang harga A memiliki bobot X, rentang harga B bobot Y).
4. 🧮 **Perhitungan Metode AHP (Seleksi)**
   - **Proses Evaluasi Matematis:** Memproses perbandingan kriteria & sub-kriteria serta mengalikan matriks bobotnya secara otomatis.
   - **Form Kustomisasi Penilaian:** Melihat visualisasi dan hasil _real-time_ perkalian nilai prioritas terhadap mobil yang dipilih.
5. 📊 **Pusat Laporan (_JasperReports_)**
   - Cetak Laporan Data Mobil / Kandidat
   - Cetak Laporan Bobot & Prioritas Kriteria
   - Cetak Laporan Bobot Sub-Kriteria
   - Cetak **Laporan Hasil Keputusan (Ranking Seleksi)**

---

## 🗄️ Struktur Database (`ahp-mobil-bekas.sql`)

Project ini menggunakan basis data relasional dengan entitas utama sebagai berikut:

- `admin` / `register`: Menyimpan data kredensial akses pengguna.
- `calon_pelamar`: Menyimpan master data mobil bekas (alternatif). _(Note: Penamaan tabel merupakan peninggalan dari sistem base rekrutmen yang diadaptasi menjadi data spesifikasi mobil)._
- `kriteria`: Menampung nama-nama kriteria beserta nilai _prioritas kepentingan_ (bobot utama).
- `sub_kriteria`: Menampung percabangan dan turunan bobot untuk skala nilai spesifik dari setiap kriteria utama.
- `seleksi`: Menyimpan hasil kalkulasi matriks sistem, rekapitulasi data, serta skor akhir (`hasil_penilaian`).

---

## 🚀 Cara Menjalankan Project (Lokal)

1. Pastikan **XAMPP/MAMP** (atau service MySQL lain) telah terinstall dan berjalan di sistem Anda.
2. Buat database baru di `phpMyAdmin` dengan nama `ahp-mobil-bekas`.
3. Import file `database/ahp-mobil-bekas.sql` ke dalam database yang baru dibuat.
4. Buka project _folder_ ini menggunakan **Apache NetBeans IDE**.
5. _(Opsional)_ Jika ada isu terkait koneksi, buka class `src/koneksi/Koneksi.java`, lalu sesuaikan kredensial (URL, _username: root_, _password: kosong_).
6. Jalankan (_Run_) project (F6). Aplikasi akan memulai halaman **Login**.

---

_Dibuat untuk kebutuhan portfolio presentasi teknis berbasis Java Desktop (SPK)._
