-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jul 2018 pada 06.08
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
(1, 'iPhone X', 'GSM/HSDPA/LTE', 'Available. Released 2017, October', '142.5 x 70.9 x 7.7 mm', 'Super AMOLED capacitive touchscreen, 16M colors', '5.8 inches, 84.4 cm2 (~82.9% screen-to-body ratio)', 'IOS 11 (Upgradable IOS 12)', 'IOS 11 (Upgradable IOS 12)', '64/256 GB, 3 GB RAM', '12MP+12MP, 7MP', 'Li-ion 2716 mAh', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-x.jpg'),
(9, 'iPhone 8', 'GSM/HSDPA/LTE', 'Available. Released 2017, September', '138.4 x 67.3 x 7.3 mm', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '4.7 inches, 60.9 cm2 (~65.4% screen-to-body ratio) 326 ppi', 'iOS 11, upgradable to iOS 12', 'iOS 11, upgradable to iOS 12', '64/256 GB, 2 GB RAM', '12 MP ,7MP', 'Non-removable Li-Ion 1821 mAh battery (6.96 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-8-new.jpg'),
(15, 'iPhone 8 Plus', 'GSM / HSPA / LTE', 'Available. Released 2017, September', '158.4 x 78.1 x 7.5 mm (6.24 x 3.07 x 0.30 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.4% screen-to-body ratio)', 'Apple A11 Bionic ', 'IOS 11', '64/256 GB, 3 GB RAM', '12 MP + 12 MP, 7 MP', 'Non-removable Li-Ion 2691 mAh battery (10.28 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-8-plus-new.jpg'),
(16, 'iPad 9.7 (2018)', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2018, March', '240 x 169.5 x 7.5 mm (9.45 x 6.67 x 0.30 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '9.7 inches, 291.4 cm2 (~71.6% screen-to-body ratio)', 'Apple A10 Fusion', 'iOS 11.3, upgradable to iOS 11.4', '32/128 GB, 2 GB RAM', '8 MP,1.2  MP', 'Non-removable Li-Ion battery (32.4 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-97-2018.jpg'),
(17, 'iPhone 7 Plus', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2016, September', '158.2 x 77.9 x 7.3 mm (6.23 x 3.07 x 0.29 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.7% screen-to-body ratio)', 'iOS 10.0.1, upgradable to iOS 11.4', 'iOS 10.0.1, upgradable to iOS 11.4', '32/128/256 GB, 3 GB RAM', '12MP + 12MP , 7 MP', 'Non-removable Li-Ion 2900 mAh battery (11.1 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-7-plus-r2.jpg'),
(18, 'iPhone 7', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2016, September', '138.3 x 67.1 x 7.1 mm (5.44 x 2.64 x 0.28 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '4.7 inches, 60.9 cm2 (~65.6% screen-to-body ratio)', 'Apple A10 Fusion', 'iOS 10.0.1, upgradable to iOS 11.4', '32/128/256 GB, 2 GB RAM', '12MP, 7 MP', 'Non-removable Li-Ion 1960 mAh battery (7.45 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-7r4.jpg'),
(19, 'iPhone SE', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2016, March', '123.8 x 58.6 x 7.6 mm (4.87 x 2.31 x 0.30 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '4.0 inches, 44.1 cm2 (~60.8% screen-to-body ratio)', 'Apple A9 Dual-core 1.84 GHz Twister', 'iOS 9.3.2, upgradable to iOS 11.4', '16/32/64/128 GB, 2 GB RAM', '12MP,1.2MP', 'Non-removable Li-Po 1624 mAh battery (6.21 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-5se-ofic.jpg'),
(20, 'iPhone 6s Plus', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2015, September', '158.2 x 77.9 x 7.3 mm (6.23 x 3.07 x 0.29 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.7% screen-to-body ratio)', 'Apple A9 Dual-core 1.84 GHz Twister', 'iOS 9, upgradable to iOS 11.4', '16/32/64/128 GB, 2 GB RAM', '12MP, 5MP', 'Non-removable Li-Ion 2750 mAh battery (10.45 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-6s-plus.jpg'),
(21, 'iPhone 6s', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2015, September', '138.3 x 67.1 x 7.1 mm (5.44 x 2.64 x 0.28 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '4.7 inches, 60.9 cm2 (~65.6% screen-to-body ratio)', 'Apple A9 Dual-core 1.84 GHz Twister', 'iOS 9, upgradable to iOS 11.4', '16/32/64/128 GB, 2 GB RAM', '12MP, 5MP', 'Non-removable Li-Ion 1715 mAh battery (6.91 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-6s1.jpg'),
(22, 'iPhone 6 Plus', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2014, September', '158.1 x 77.8 x 7.1 mm (6.22 x 3.06 x 0.28 in)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.8% screen-to-body ratio)', 'Apple A8 Dual-core 1.4 GHz Typhoon (ARM v8-based)', 'iOS 8, upgradable to iOS 11.4', '16/64/128 GB, 1 GB RAM DDR3', '8MP, 1.2MP', 'Non-removable Li-Po 2915 mAh battery (11.1 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-6-plus2.jpg'),
(23, 'iPhone 5s', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2013, September', '123.8 x 58.6 x 7.6 mm (4.87 x 2.31 x 0.30 in)4.0 inches, 44.1 cm2 (~60.8% screen-to-body ratio)', 'LED-backlit IPS LCD, capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2 (~67.8% screen-to-body ratio)', 'Dual-core 1.3 GHz Cyclone (ARM v8-based)', 'iOS 7, upgradable to iOS 11.4', '16/32/64 GB, 1 GB RAM DDR3', '8MP, 1.2MP', 'Non-removable Li-Po 1560 mAh battery (5.92 Wh)', 'Apple', 'https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-5s-ofic.jpg'),
(26, 'Asus ROG Phone', 'GSM / HSPA / LTE', 'Coming soon. Exp. release 2018, Q3', '158.5 x 76.2 x 8.6 mm (6.24 x 3.00 x 0.34 in)', 'AMOLED capacitive touchscreen, 16M colors', '6.0 inches, 92.9 cm2 (~76.9% screen-to-body ratio)', 'Qualcomm SDM845 Snapdragon 845 Octa-core (4x2.96 GHz Kryo 385 Gold & 4x1.7 GHz Kryo 385 Silver)', 'Android 8.1 (Oreo)', '128/512 GB, 8 GB RAM', '12 MP,8 MP', 'Non-removable Li-Ion 4000 mAh battery', 'Asus', 'https://cdn2.gsmarena.com/vv/bigpic/asus-rog-phone-.jpg'),
(27, 'Asus ZenFone Live (L1) ZA550KL', 'GSM / HSPA / LTE', 'Available. Released 2018, May', '147.3 x 71.8 x 8.2 mm (5.80 x 2.83 x 0.32 in)', 'IPS LCD capacitive touchscreen, 16M colors', '5.5 inches, 78.1 cm2 (~73.8% screen-to-body ratio)', 'Qualcomm MSM8917 Snapdragon 425 Quad-core 1.4 GHz Cortex-A53', 'Android 8.0 Oreo (Go edition)', '32 GB, 2 RAM or 16 GB, 1 GB RAM', '13MP, 5MP', 'Non-removable Li-Ion 3000 mAh battery', 'Asus', 'https://cdn2.gsmarena.com/vv/bigpic/asus-zenfone-live-l1-za550kl-.jpg'),
(28, 'Asus Zenfone 5z ZS620KL', 'GSM / HSPA / LTE', 'Available. Released 2018, June', '153 x 75.7 x 7.9 mm (6.02 x 2.98 x 0.31 in)', 'IPS LCD capacitive touchscreen, 16M colors', '6.2 inches, 96.9 cm2 (~83.6% screen-to-body ratio)', 'Qualcomm SDM845 Snapdragon 845 Octa-core (4x2.7 GHz Kryo 385 Gold & 4x1.7 GHz Kryo 385 Silver)', 'Android 8.0 Oreo', '256 GB, 8 GB RAM or 128 GB, 6 GB RAM or 64 GB, 4 GB RAM', '12MP+8MP, 8MP', 'Non-removable Li-Ion 3300 mAh battery', 'Asus', 'https://cdn2.gsmarena.com/vv/bigpic/asus-zenfone-5-ze620kl-5z-zs620kl.jpg'),
(29, 'Asus Zenfone Max Pro (M1) ZB601KL', 'GSM / HSPA / LTE', 'Available. Released 2018, May', '159 x 76 x 8.5 mm (6.26 x 2.99 x 0.33 in)', 'IPS LCD capacitive touchscreen, 16M colors', '5.99 inches, 92.1 cm2 (~76.2% screen-to-body ratio)', 'Qualcomm SDM636 Snapdragon 636 Octa-core 1.8 GHz Kryo 260', 'Android 8.1 (Oreo)', '64 GB, 4/6 GB RAM or 32 GB, 3 GB RAM', '13MP+5MP, 8MP', 'Non-removable Li-Po 5000 mAh battery', 'Asus', 'https://cdn2.gsmarena.com/vv/bigpic/asus-zenfone-max-pro-m1-zb601kl-.jpg'),
(30, 'Xiaomi Mi 8 Explorer', 'GSM / CDMA / HSPA / LTE', 'Coming soon. Exp. release 2018, July', '154.9 x 74.8 x 7.6 mm (6.10 x 2.94 x 0.30 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '6.21 inches, 97.1 cm2 (~83.8% screen-to-body ratio)', 'Qualcomm SDM845 Snapdragon 845 Octa-core (4x2.8 GHz Kryo 385 Gold & 4x1.8 GHz Kryo 385 Silver)', 'Android 8.1 (Oreo)', '128 GB, 8 GB RAM', '12MP+12MP, 20MP', 'Non-removable Li-Po 3000 mAh battery', 'Xiaomi', 'https://cdn2.gsmarena.com/vv/bigpic/xiaomi-mi8-explore-.jpg'),
(31, 'Xiaomi Black Shark', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2018, April', '161.6 x 75.4 x 9.3 mm (6.36 x 2.97 x 0.37 in)', 'IPS LCD capacitive touchscreen, 16M colors', '5.99 inches, 92.6 cm2 (~76.0% screen-to-body ratio)', 'Octa-core (4x2.8 GHz Kryo 385 Gold & 4x1.8 GHz Kryo 385 Silver)', 'Android 8.0 (Oreo)', '128 GB, 8 GB RAM or 64 GB, 6 GB RAM', '12MP 20MP, 20MP', 'Non-removable Li-Ion 4000 mAh battery', 'Xiaomi', 'https://cdn2.gsmarena.com/vv/bigpic/xiaomi-black-shark.jpg'),
(32, 'Xiaomi Mi A1', 'GSM / HSPA / LTE', 'Available. Released 2017, September', '155.4 x 75.8 x 7.3 mm (6.12 x 2.98 x 0.29 in)', 'LTPS IPS LCD capacitive touchscreen, 16M colors', '5.5 inches, 82.6 cm2 (~70.1% screen-to-body ratio)', 'Octa-core 2.0 GHz Cortex-A53', 'Android 7.1.2 (Nougat), upgradable to Android 8.0 (Oreo); Android One', '64 GB, 4 GB RAM', '12MP 12MP, 5MP', 'Non-removable Li-Ion 3080 mAh battery', 'Xiaomi', 'https://cdn2.gsmarena.com/vv/bigpic/xiaomi-mi-a1.jpg'),
(33, 'LG V30', 'GSM / HSPA / LTE /EVDO', 'Available. Released 2017, September', '151.7 x 75.4 x 7.3 mm (5.97 x 2.97 x 0.29 in)', 'P-OLED capacitive touchscreen, 16M colors', '6.0 inches, 92.9 cm2 (~81.2% screen-to-body ratio)', 'Android 7.1.2 (Nougat), upgradable to Android 8.0 (Oreo)', 'Android 7.1.2 (Nougat), upgradable to Android 8.0 (Oreo)', '128 GB, 4 GB RAM (V30+) or 64 GB, 4 GB RAM (V30)', '16MP 13MP, 5MP', '128 GB, 4 GB RAM (V30+) or 64 GB, 4 GB RAM (V30)', 'LG', 'https://cdn2.gsmarena.com/vv/bigpic/lg-v30-.jpg'),
(34, 'LG V20', 'GSM / HSPA / LTE', 'GSM / HSPA / LTE', '159.7 x 78.1 x 7.6 mm (6.29 x 3.07 x 0.30 in)', 'IPS LCD capacitive touchscreen, 16M colors', '5.7 inches, 90.3 cm2 (~72.4% screen-to-body ratio)', 'Quad-core (2x2.15 GHz Kryo & 2x1.6 GHz Kryo)', 'Android 7.0 (Nougat)', '32/64 GB, 4 GB RAM', '16MP 8MP, 5MP', '32/64 GB, 4 GB RAM', 'LG', 'https://cdn2.gsmarena.com/vv/bigpic/lg-v20-ofic1.jpg'),
(37, 'Samsung Galaxy On6', 'GSM / HSPA / LTE', 'Coming soon. 2018, July', '149.3 x 70.2 x 8.2 mm (5.88 x 2.76 x 0.32 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '5.6 inches, 79.6 cm2 (~75.9% screen-to-body ratio)', 'Exynos 7870 Octa Octa-core 1.6 GHz Cortex-A53', 'Android 8.0 (Oreo)', '64 GB, 4 GB RAM or 32 GB, 3 GB RAM', '13MP,8MP', 'Non-removable Li-Ion 3000 mAh battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-on6-00.jpg'),
(38, 'Samsung Galaxy J7 (2018)', 'GSM / HSPA / LTE', 'Coming soon. Exp. release 2018, July', '-', 'Super AMOLED capacitive touchscreen, 16M colors', '5.5 inches, 83.4 cm2', 'Octa-core', 'Android', '-', '13MP, 13MP', 'Li-Ion battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-j7-2018-.jpg'),
(39, 'Samsung Galaxy A8 Star (A9 Star)', 'GSM / CDMA / HSPA / LTE', 'Available. Released 2018, June', '162.4 x 77 x 7.6 mm (6.39 x 3.03 x 0.30 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '6.3 inches, 100.7 cm2 (~80.6% screen-to-body ratio)', 'Qualcomm SDM660 Snapdragon 660 Octa-core (4x2.2 GHz Kryo 260 & 4x1.8 GHz Kryo 260)', 'Android 8.0 (Oreo)', '64 GB, 4 GB RAM', '24MP+16MP, 24MP', 'Non-removable Li-Ion 3700 mAh battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-a8-a9-star.jpg'),
(40, 'Samsung Galaxy A6+ (2018)', 'GSM / HSPA / LTE', 'Available. Released 2018, May', '160.2 x 75.7 x 7.9 mm (6.31 x 2.98 x 0.31 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '6.0 inches, 91.4 cm2 (~75.3% screen-to-body ratio)', 'Qualcomm SDM450 Snapdragon 450 Octa-core 1.8 GHz Cortex-A53', 'Android 8.0 (Oreo)', '64 GB, 4 GB RAM or 32 GB, 3 GB RAM', '16MP+5MP, 24MP', 'Non-removable Li-Ion 3500 mAh battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-a6-plus-2018-.jpg'),
(41, 'Samsung Galaxy A6 (2018)', 'GSM / HSPA / LTE', 'Available. Released 2018, May', '149.9 x 70.8 x 7.7 mm (5.90 x 2.79 x 0.30 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '5.6 inches, 79.6 cm2 (~75.0% screen-to-body ratio)', 'Exynos 7870 Octa Octa-core 1.6 GHz Cortex-A53', 'Android 8.0 (Oreo)', '64 GB, 4 GB RAM or 32 GB, 3 GB RAM', '16MP, 16MP', 'Non-removable Li-Ion 3000 mAh battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-a6-2018-.jpg'),
(42, 'Samsung Galaxy S9+', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2018, May', '158.1 x 73.8 x 8.5 mm (6.22 x 2.91 x 0.33 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '6.2 inches, 98.3 cm2 (~84.2% screen-to-body ratio)', '6.2 inches, 98.3 cm2 (~84.2% screen-to-body ratio)', 'Android 8.0 (Oreo)', '	64/128/256 GB, 6 GB RAM - China128 GB, 6 GB RAM - LATAM', '12MP+12MP,8MP', 'Non-removable Li-Ion 3500 mAh battery (13.48 Wh)', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-s9-plus-blue.jpg'),
(43, 'Samsung Galaxy Note8', 'GSM / CDMA / HSPA / EVDO / LTE', 'Available. Released 2017, September', '162.5 x 74.8 x 8.6 mm (6.40 x 2.94 x 0.34 in)', 'Super AMOLED capacitive touchscreen, 16M colors', '6.3 inches, 101.1 cm2 (~83.2% screen-to-body ratio)', '	Exynos 8895 Octa - EMEAQualcomm MSM8998 Snapdragon 835 - USA & China', 'Android 7.1.1 (Nougat), upgradable to Android 8.0 (Oreo)', '64/128/256 GB, 6 GB RAM', '12MP+12MP,8MP', 'Non-removable Li-Ion 3300 mAh battery', 'Samsung', 'https://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-note-8-sm-n950.jpg'),
(44, 'Oppo Find X', 'GSM / HSPA / LTE', 'Coming soon. Exp. release 2018, August', '156.7 x 74.2 x 9.4 mm (6.17 x 2.92 x 0.37 in)', 'AMOLED capacitive touchscreen, 16M colors', '6.42 inches, 101.2 cm2 (~87.0% screen-to-body ratio)', 'Android 8.1 (Oreo)', 'Android 8.1 (Oreo)', '128/256 GB, 8 GB RAM', '16MP+20MP, 25MP', 'Non-removable Li-Ion 3730 mAh battery', 'Oppo', 'https://cdn2.gsmarena.com/vv/bigpic/oppo-find-x.jpg');

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
