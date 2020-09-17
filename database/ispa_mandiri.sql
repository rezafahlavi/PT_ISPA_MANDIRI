-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 17, 2020 at 11:55 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ispa_mandiri`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `harga_beli` int(30) NOT NULL,
  `harga_jual` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`id_barang`, `nama_barang`, `jumlah`, `harga_beli`, `harga_jual`) VALUES
('B0001', 'UPS Trident 850', 85, 500000, 550000),
('B0002', 'MCB 6A', 150, 40000, 45000),
('B0003', 'Travo 5a', 80, 110000, 120000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang_keluar`
--

CREATE TABLE `tbl_barang_keluar` (
  `id_barang_keluar` varchar(30) NOT NULL,
  `id_barang` varchar(30) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `tanggal_keluar` date NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_barang_keluar`
--

INSERT INTO `tbl_barang_keluar` (`id_barang_keluar`, `id_barang`, `nama_barang`, `jumlah`, `tanggal_keluar`, `keterangan`) VALUES
('K0001', 'B0003', 'Travo 5a', 10, '2020-09-01', 'Kebutuhan Toko'),
('K0002', 'B0001', 'UPS Trident 850', 5, '2020-09-02', 'Sample Toko');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang_masuk`
--

CREATE TABLE `tbl_barang_masuk` (
  `id_barang_masuk` varchar(30) NOT NULL,
  `id_barang` varchar(30) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_barang_masuk`
--

INSERT INTO `tbl_barang_masuk` (`id_barang_masuk`, `id_barang`, `nama_barang`, `jumlah`, `tanggal_masuk`, `keterangan`) VALUES
('M0001', 'B0001', 'UPS Trident 850', 50, '2020-09-02', 'Restok'),
('M0002', 'B0002', 'MCB 6A', 50, '2020-09-03', 'Restok');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_telp` int(30) NOT NULL,
  `agama` varchar(30) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`, `jenis_kelamin`, `email`, `no_telp`, `agama`, `alamat`) VALUES
('Asbar', '123456', 'Laki-Laki', 'asbar@gmail.com', 12345, 'Islam', 'depok');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penjualan`
--

CREATE TABLE `tbl_penjualan` (
  `id_penjualan` varchar(20) NOT NULL,
  `id_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `harga` int(30) NOT NULL,
  `bayar` int(30) NOT NULL,
  `kembalian` int(30) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_penjualan`
--

INSERT INTO `tbl_penjualan` (`id_penjualan`, `id_barang`, `nama_barang`, `hsatuan`, `jumlah_beli`, `harga`, `bayar`, `kembalian`, `tanggal`) VALUES
('P0001', 'B0001', 'UPS Trident 850', 550000, 10, 5500000, 5500000, 0, '2020-09-05'),
('P0002', 'B0003', 'Travo 5a', 120000, 10, 1200000, 1200000, 0, '2020-09-07');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tbl_barang_keluar`
--
ALTER TABLE `tbl_barang_keluar`
  ADD PRIMARY KEY (`id_barang_keluar`);

--
-- Indexes for table `tbl_barang_masuk`
--
ALTER TABLE `tbl_barang_masuk`
  ADD PRIMARY KEY (`id_barang_masuk`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD PRIMARY KEY (`id_penjualan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
