-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Jul 2020 pada 15.27
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `absensi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
`id_adm` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_adm`, `username`, `email`, `password`) VALUES
(1, 'reymonz', 'rey@g', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dosen`
--

CREATE TABLE IF NOT EXISTS `dosen` (
`id_dsn` int(11) NOT NULL,
  `nip` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dosen`
--

INSERT INTO `dosen` (`id_dsn`, `nip`, `nama`, `email`, `password`) VALUES
(2, '11111', 'dik', 'dik@', '123'),
(3, '1234', 'danu', 'danu@g', '123'),
(4, 'a1234', 'Dermawan', 'dermawan@g', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kehadiran`
--

CREATE TABLE IF NOT EXISTS `kehadiran` (
`id_kehadiran` int(11) NOT NULL,
  `id_mhs` varchar(20) NOT NULL,
  `id_dsn` varchar(20) NOT NULL,
  `waktu` datetime NOT NULL,
  `id_kelas` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kehadiran`
--

INSERT INTO `kehadiran` (`id_kehadiran`, `id_mhs`, `id_dsn`, `waktu`, `id_kelas`) VALUES
(4, 'A11.2017.10115', '1234', '2020-06-15 11:15:27', 0),
(5, 'A11.2017.10100', '1234', '2020-06-15 11:17:20', 0),
(6, 'A11.2017.10115', '1234', '2020-06-15 13:14:44', 0),
(7, 'A11.2017.10101', '1234', '2020-06-15 13:15:08', 0),
(8, 'A11.2017.10115', '1234', '2020-06-28 00:31:27', 0),
(9, 'A11.2017.10115', '1234', '2020-06-28 00:49:04', 0),
(10, 'A11.2017.10115', '1234', '2020-06-30 14:46:45', 0),
(11, 'A11.2017.10100', '1234', '2020-07-01 23:14:35', 0),
(12, 'A11.2017.10100', '1234', '2020-07-06 13:34:31', 0),
(13, 'A11.2017.10100', '1234', '2020-07-06 13:35:13', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelas`
--

CREATE TABLE IF NOT EXISTS `kelas` (
`id_kelas` int(11) NOT NULL,
  `nama_kelas` varchar(20) NOT NULL,
  `no_kelas` varchar(20) NOT NULL,
  `nip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE IF NOT EXISTS `mahasiswa` (
`id_mhs` int(11) NOT NULL,
  `nim` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mhs`, `nim`, `nama`, `email`, `password`) VALUES
(1, 'A11.2017.10115', 'Dicki Kurniawan', 'dik@g', '123'),
(2, 'A11.2017.10100', 'Doni', 'doni@g', '123'),
(3, 'A11.2017.10101', 'Donia', 'donia@g', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `session`
--

CREATE TABLE IF NOT EXISTS `session` (
`id_session` int(11) NOT NULL,
  `id_mhs` varchar(20) NOT NULL,
  `id_dsn` varchar(20) NOT NULL,
  `waktu` datetime NOT NULL,
  `id_kelas` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `session`
--

INSERT INTO `session` (`id_session`, `id_mhs`, `id_dsn`, `waktu`, `id_kelas`) VALUES
(1, 'A11.2017.10115', '1234', '2020-06-15 13:14:44', 0),
(2, 'A11.2017.10101', '1234', '2020-06-15 13:15:07', 0),
(3, 'A11.2017.10115', '1234', '2020-06-28 00:31:27', 0),
(4, 'A11.2017.10115', '1234', '2020-06-28 00:49:04', 0),
(5, 'A11.2017.10115', '1234', '2020-06-30 14:46:45', 0),
(6, 'A11.2017.10100', '1234', '2020-07-01 23:14:35', 0),
(7, 'A11.2017.10100', '1234', '2020-07-06 13:34:31', 0),
(8, 'A11.2017.10100', '1234', '2020-07-06 13:35:13', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id_adm`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
 ADD PRIMARY KEY (`id_dsn`);

--
-- Indexes for table `kehadiran`
--
ALTER TABLE `kehadiran`
 ADD PRIMARY KEY (`id_kehadiran`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
 ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
 ADD PRIMARY KEY (`id_mhs`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
 ADD PRIMARY KEY (`id_session`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id_adm` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `dosen`
--
ALTER TABLE `dosen`
MODIFY `id_dsn` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `kehadiran`
--
ALTER TABLE `kehadiran`
MODIFY `id_kehadiran` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
MODIFY `id_kelas` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
MODIFY `id_mhs` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
MODIFY `id_session` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
