-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Jun 2018 pada 11.22
-- Versi server: 10.1.32-MariaDB
-- Versi PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetx`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_smartphone`
--

CREATE TABLE `tb_smartphone` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `NETWORK` varchar(100) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `DIMENSION` varchar(100) NOT NULL,
  `DISPLAY_TYPE` varchar(100) NOT NULL,
  `DISPLAY_SIZE` varchar(100) NOT NULL,
  `CPU` varchar(100) NOT NULL,
  `OS` varchar(100) NOT NULL,
  `MEMORY` varchar(100) NOT NULL,
  `CAMERA` varchar(100) NOT NULL,
  `BATTERY` varchar(100) NOT NULL,
  `BRAND` varchar(100) NOT NULL,
  `IMAGE` varchar(10000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_smartphone`
--

INSERT INTO `tb_smartphone` (`ID`, `NAME`, `NETWORK`, `STATUS`, `DIMENSION`, `DISPLAY_TYPE`, `DISPLAY_SIZE`, `CPU`, `OS`, `MEMORY`, `CAMERA`, `BATTERY`, `BRAND`, `IMAGE`) VALUES
(1, 'iPhone X', 'GSM/HSDPA/LTE', 'Available', '142.5 x 70.9 x 7.7 mm', 'Super Amoled', '5.8\" (458 ppi)', 'IOS 11 (Upgradable IOS 12)', 'IOS 11 (Upgradable IOS 12)', '3GB, 64/256 GB', '12mp+12mp, 7mp', 'Li-ion 2716 mAh', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-x.jpg'),
(9, 'iPhone 8', 'GSM/HSDPA/LTE', 'Available', '138.4 x 67.3 x 7.3 mm', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '4.7 inches, 60.9 cm2 (~65.4% screen-to-body ratio) 326 ppi', 'iOS 11, upgradable to iOS 12', 'iOS 11, upgradable to iOS 12', '64/256 GB, 2 GB RAM', '12 mp - 7mp', 'Non-removable Li-Ion 1821 mAh battery (6.96 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-8-new.jpg'),
(15, 'iPhone 8 Plus', 'GSM / HSPA / LTE', 'Available. Released 2017, September', '158.4 x 78.1 x 7.5 mm (6.24 x 3.07 x 0.30 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.4% screen-to-body ratio)', 'Apple A11 Bionic ', 'IOS 11', '64/256 GB, 3 GB RAM', '12 MP + 12 MP, 7 MP', 'Non-removable Li-Ion 2691 mAh battery (10.28 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-8-plus-new.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_smartphone`
--
ALTER TABLE `tb_smartphone`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_smartphone`
--
ALTER TABLE `tb_smartphone`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
