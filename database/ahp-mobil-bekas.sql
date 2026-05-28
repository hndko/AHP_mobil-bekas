-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 28, 2026 at 08:33 AM
-- Server version: 5.7.39
-- PHP Version: 8.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ahp-mobil-bekas`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` char(3) NOT NULL,
  `namalengkap` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `namalengkap`, `user`, `password`) VALUES
('001', 'Naufal Sholahuddin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `biodata_kandidat`
--

CREATE TABLE `biodata_kandidat` (
  `no_id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jeniskel` varchar(50) NOT NULL,
  `usia` int(5) NOT NULL,
  `pendidikan_terakhir` varchar(50) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `alamat` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `biodata_kandidat`
--

INSERT INTO `biodata_kandidat` (`no_id`, `nama`, `jeniskel`, `usia`, `pendidikan_terakhir`, `no_hp`, `alamat`) VALUES
(1, '1', 'Laki-Laki', 1, 'S1', '085XXXX', '1'),
(2, 'Nama2', 'Perempuan', 21, 'S1', '085XXX', 'Bogor'),
(3, 'Nama3', 'Laki-Laki', 12, 'SD', '085XX', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `bobot_kandidat`
--

CREATE TABLE `bobot_kandidat` (
  `no_id` int(5) NOT NULL,
  `nilai_wawancara` int(5) NOT NULL,
  `waktu_luang` varchar(100) NOT NULL,
  `sikap1` varchar(100) NOT NULL,
  `sikap2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bobot_kandidat`
--

INSERT INTO `bobot_kandidat` (`no_id`, `nilai_wawancara`, `waktu_luang`, `sikap1`, `sikap2`) VALUES
(1, 100, 'PAGI', 'GOOD', 'JUJUR'),
(2, 90, 'Item 2', 'Item 2', 'Item 2'),
(3, 100, 'Item 2', 'Item 2', 'Item 2');

-- --------------------------------------------------------

--
-- Table structure for table `calon_pelamar`
--

CREATE TABLE `calon_pelamar` (
  `no_id` varchar(5) NOT NULL,
  `nama_mobil` varchar(30) NOT NULL,
  `tahun_pembuatan` varchar(30) NOT NULL,
  `konsumsi_bahan_bakar` varchar(20) NOT NULL,
  `harga` varchar(18) NOT NULL,
  `kecepatan` varchar(100) NOT NULL,
  `golongan_harga` varchar(50) NOT NULL,
  `kelengkapan_dokumen` varchar(50) NOT NULL,
  `kondisi_mesin` varchar(30) NOT NULL,
  `jenis_transmisi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `calon_pelamar`
--

INSERT INTO `calon_pelamar` (`no_id`, `nama_mobil`, `tahun_pembuatan`, `konsumsi_bahan_bakar`, `harga`, `kecepatan`, `golongan_harga`, `kelengkapan_dokumen`, `kondisi_mesin`, `jenis_transmisi`) VALUES
('1', 'a', '2010 - 2012', 'Diesel', '1300000', '150', 'Di bawah 100 juta', 'Lengkap', 'Sangat Bagus', 'Otomatis'),
('2', 'b', '2013 - 2015', 'Diesel', '300000', '300', '100-150 juta', 'Kurang Lengkap', 'Kurang', 'Semi-Otomatis'),
('3', 'c', '2020 keatas', 'Hybrid', '1000000', '140', '100-150 juta', 'Kurang Lengkap', 'Sangat Bagus', 'Manual');

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`kd_kriteria`, `nama_kriteria`, `prioritas_kepentingan`) VALUES
('K1', 'Tahun Pembuatan', 'Sangat Penting ke-1'),
('K2', 'Tipe Bahan Bakar', 'Penting ke-2'),
('K3', 'Golongan Harga', 'Cukup Penting ke-3'),
('K4', 'Kelengkapan Dokumen', 'Biasa ke-4'),
('K5', 'Kondisi Mesin', 'Kurang Penting ke-5'),
('K6', 'Jenis Transmisi', 'Tidak Penting ke-6');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `email`, `user`, `password`) VALUES
(1, 'mail@gmail.com', 'admin', 'admin'),
(2, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `seleksi`
--

CREATE TABLE `seleksi` (
  `no_id` char(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `hasil_penilaian` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seleksi`
--

INSERT INTO `seleksi` (`no_id`, `nama`, `no_hp`, `hasil_penilaian`) VALUES
('1', 'a', '2010 - 2012', '0.53'),
('2', 'b', '300000', '0.29'),
('3', 'c', '1000000', '0.40');

-- --------------------------------------------------------

--
-- Table structure for table `sub_kriteria`
--

CREATE TABLE `sub_kriteria` (
  `no_sub` int(3) NOT NULL,
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `nama_sub_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_kriteria`
--

INSERT INTO `sub_kriteria` (`no_sub`, `kd_kriteria`, `nama_kriteria`, `nama_sub_kriteria`, `prioritas_kepentingan`) VALUES
(1, 'K1', 'Tahun Pembuatan', '2010 - 2012', 'Sangat Penting ke-1'),
(2, 'K1', 'Tahun Pembuatan', '2013 - 2015', 'Penting ke-2'),
(3, 'K1', 'Tahun Pembuatan', '2016 - 2019', 'Cukup Penting ke-3'),
(4, 'K1', 'Tahun Pembuatan', '2020 keatas', 'Biasa ke-4'),
(5, 'K2', 'Tipe Bahan Bakar', 'Bensin', 'Sangat Penting ke-1'),
(6, 'K2', 'Tipe Bahan Bakar', 'Diesel', 'Penting ke-2'),
(7, 'K2', 'Tipe Bahan Bakar', 'Hybrid', 'Cukup Penting ke-3'),
(8, 'K2', 'Tipe Bahan Bakar', 'Listrik', 'Biasa ke-4'),
(9, 'K3', 'Golongan Harga', 'Di bawah 100 juta', 'Sangat Penting ke-1'),
(10, 'K3', 'Golongan Harga', '100-150 juta', 'Penting ke-2'),
(11, 'K3', 'Golongan Harga', '150-200 juta', 'Cukup Penting ke-3'),
(12, 'K3', 'Golongan Harga', 'Di atas 200 juta', 'Biasa ke-4'),
(13, 'K4', 'Kelengkapan Dokumen', 'Lengkap', 'Sangat Penting ke-1'),
(14, 'K4', 'Kelengkapan Dokumen', 'Cukup Lengkap', 'Penting ke-2'),
(15, 'K4', 'Kelengkapan Dokumen', 'Kurang Lengkap', 'Cukup Penting ke-3'),
(16, 'K4', 'Kelengkapan Dokumen', 'Tidak Ada', 'Biasa ke-4'),
(17, 'K5', 'Kondisi Mesin', 'Sangat Bagus', 'Sangat Penting ke-1'),
(18, 'K5', 'Kondisi Mesin', 'Bagus', 'Penting ke-2'),
(19, 'K5', 'Kondisi Mesin', 'Cukup', 'Cukup Penting ke-3'),
(20, 'K5', 'Kondisi Mesin', 'Kurang', 'Biasa ke-4'),
(21, 'K6', 'Jenis Transmisi', 'Manual', 'Sangat Penting ke-1'),
(22, 'K6', 'Jenis Transmisi', 'Otomatis', 'Penting ke-2'),
(23, 'K6', 'Jenis Transmisi', 'Semi-Otomatis', 'Cukup Penting ke-3'),
(24, 'K6', 'Jenis Transmisi', 'CVT', 'Biasa ke-4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `biodata_kandidat`
--
ALTER TABLE `biodata_kandidat`
  ADD PRIMARY KEY (`no_id`);

--
-- Indexes for table `bobot_kandidat`
--
ALTER TABLE `bobot_kandidat`
  ADD UNIQUE KEY `no_id` (`no_id`);

--
-- Indexes for table `calon_pelamar`
--
ALTER TABLE `calon_pelamar`
  ADD PRIMARY KEY (`no_id`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`kd_kriteria`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seleksi`
--
ALTER TABLE `seleksi`
  ADD UNIQUE KEY `no_id` (`no_id`);

--
-- Indexes for table `sub_kriteria`
--
ALTER TABLE `sub_kriteria`
  ADD PRIMARY KEY (`no_sub`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `biodata_kandidat`
--
ALTER TABLE `biodata_kandidat`
  MODIFY `no_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
