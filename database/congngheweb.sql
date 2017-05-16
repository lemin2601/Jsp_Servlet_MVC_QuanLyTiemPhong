-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2017 lúc 08:19 CH
-- Phiên bản máy phục vụ: 10.1.21-MariaDB
-- Phiên bản PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `congngheweb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `benh`
--

CREATE TABLE `benh` (
  `MaBenh` int(11) NOT NULL,
  `TenBenh` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `benh`
--

INSERT INTO `benh` (`MaBenh`, `TenBenh`, `MoTa`) VALUES
(1, 'Bệnh 1', 'Đây là bệnh 1'),
(2, 'Bệnh 2', 'Đây là bệnh 2'),
(3, 'Bệnh 3', 'Đây là bệnh 3'),
(4, 'Bệnh 4', 'Đây là bệnh 4'),
(5, 'Bệnh 5', 'Đây là bệnh 5'),
(6, 'Bệnh 6', 'Đây là bệnh 6'),
(7, 'Bệnh 7', 'Đây là bệnh 7'),
(8, 'Bệnh 8', 'Đây là bệnh 8'),
(9, 'Bệnh 9', 'Đây là bệnh 9'),
(10, 'Bệnh 10', 'Đây là bệnh 10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `HoTenKH` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `SoDienThoai` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChiKH` text COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTenKH`, `SoDienThoai`, `DiaChiKH`, `NgaySinh`, `GioiTinh`) VALUES
(1, 'Nguyễn Văn 1', '123465789', 'Đà Nẵng 1', '0000-00-00', 1),
(2, 'Nguyễn Văn 2', '123456790', 'Đà Nẵng 2', '0000-00-00', 1),
(3, 'Nguyễn Văn 3', '123447791', 'Đà Nẵng 3', '0000-00-00', 1),
(4, 'Nguyễn Văn 4', '123438792', 'Đà Nẵng 4', '0000-00-00', 1),
(5, 'Nguyễn Văn 5', '123429793', 'Đà Nẵng 5', '0000-00-00', 1),
(6, 'Nguyễn Văn 6', '123420794', 'Đà Nẵng 6', '0000-00-00', 0),
(7, 'Nguyễn Văn 7', '123411795', 'Đà Nẵng 7', '0000-00-00', 0),
(8, 'Nguyễn Văn 8', '123402796', 'Đà Nẵng 8', '0000-00-00', 0),
(9, 'Nguyễn Văn 9', '123393797', 'Đà Nẵng 9', '0000-00-00', 0),
(10, 'Nguyễn Văn 10', '123384798', 'Đà Nẵng 10', '0000-00-00', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lichsutiemphong`
--

CREATE TABLE `lichsutiemphong` (
  `MaKH` int(11) NOT NULL,
  `MaVacxin` int(11) NOT NULL,
  `SoTTMui` int(11) NOT NULL,
  `NgayTiemPhong` date NOT NULL,
  `NgayTiepTheo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lichsutiemphong`
--

INSERT INTO `lichsutiemphong` (`MaKH`, `MaVacxin`, `SoTTMui`, `NgayTiemPhong`, `NgayTiepTheo`) VALUES
(5, 9, 2, '0000-00-00', '0000-00-00'),
(6, 6, 2, '0000-00-00', '0000-00-00'),
(6, 7, 3, '0000-00-00', '0000-00-00'),
(8, 6, 3, '0000-00-00', '0000-00-00'),
(8, 7, 2, '0000-00-00', '0000-00-00'),
(8, 7, 3, '0000-00-00', '0000-00-00'),
(9, 4, 2, '0000-00-00', '0000-00-00'),
(10, 3, 2, '0000-00-00', '0000-00-00'),
(10, 7, 2, '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongbenh`
--

CREATE TABLE `phongbenh` (
  `MaVacxin` int(11) NOT NULL,
  `MaBenh` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phongbenh`
--

INSERT INTO `phongbenh` (`MaVacxin`, `MaBenh`, `GhiChu`) VALUES
(1, '1', 'Bênh 1'),
(2, '2', 'Bênh 2'),
(3, '3', 'Bênh 3'),
(4, '4', 'Bênh 4'),
(5, '5', 'Bênh 5'),
(6, '6', 'Bênh 6'),
(7, '7', 'Bênh 7'),
(8, '8', 'Bênh 8'),
(9, '9', 'Bênh 9'),
(10, '10', 'Bênh 10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `username` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `roles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `pass`, `firstname`, `lastname`, `roles`) VALUES
(1, 'user01', 'pass1', 'firstname1', 'lastname1', 1),
(2, 'user02', 'pass2', 'T�n 1', 'lastname2', 2),
(3, 'user03', 'pass3', 'firstname3', 'lastname3', 1),
(4, 'user04', 'pass4', 'firstname4', 'lastname4', 1),
(5, 'user05', 'pass5', 'firstname5', 'lastname5', 1),
(6, 'user06', 'pass6', 'firstname6', 'lastname6', 1),
(7, 'user07', 'pass7', 'firstname7', 'lastname7', 0),
(8, 'user08', 'pass8', 'firstname8', 'lastname8', 1),
(9, 'user09', 'pass9', 'firstname9', 'lastname9', 0),
(10, 'user10', 'pass10', 'firstname10', 'lastname10', 1),
(11, 'user11', 'pass11', 'firstname11', 'lastname11', 1),
(12, 'user12', 'pass12', 'firstname12', 'lastname12', 0),
(13, 'user13', 'pass13', 'firstname13', 'lastname13', 1),
(14, 'user14', 'pass14', 'firstname14', 'lastname14', 1),
(15, 'user15', 'pass15', 'firstname15', 'lastname15', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vacxin`
--

CREATE TABLE `vacxin` (
  `MaVacxin` int(11) NOT NULL,
  `TenVacxin` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `SoMui` int(11) NOT NULL,
  `MoTa` text COLLATE utf8_unicode_ci NOT NULL,
  `GiaVacxin` double NOT NULL,
  `TenHang` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `vacxin`
--

INSERT INTO `vacxin` (`MaVacxin`, `TenVacxin`, `SoMui`, `MoTa`, `GiaVacxin`, `TenHang`) VALUES
(1, 'Vacxin01', 5, 'Đây là vawcxin 01', 1000, 'Vx01'),
(2, 'Vacxin02', 6, 'Đây là vawcxin 02', 1000, 'Vx02'),
(3, 'Vacxin03', 6, 'Đây là vawcxin 03', 1000, 'Vx03'),
(4, 'Vacxin04', 4, 'Đây là vawcxin 04', 1000, 'Vx04'),
(5, 'Vacxin05', 5, 'Đây là vawcxin 05', 1000, 'Vx05'),
(6, 'Vacxin06', 7, 'Đây là vawcxin 06', 1000, 'Vx06'),
(7, 'Vacxin07', 5, 'Đây là vawcxin 07', 1000, 'Vx07'),
(8, 'Vacxin08', 6, 'Đây là vawcxin 08', 1000, 'Vx08'),
(9, 'Vacxin09', 7, 'Đây là vawcxin 09', 1000, 'Vx09'),
(10, 'Vacxin10', 8, 'Đây là vawcxin 10', 1000, 'Vx10'),
(11, '1212', 1, '1', 1, '1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `benh`
--
ALTER TABLE `benh`
  ADD PRIMARY KEY (`MaBenh`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `lichsutiemphong`
--
ALTER TABLE `lichsutiemphong`
  ADD PRIMARY KEY (`MaKH`,`MaVacxin`,`SoTTMui`),
  ADD KEY `MaVacxin` (`MaVacxin`);

--
-- Chỉ mục cho bảng `phongbenh`
--
ALTER TABLE `phongbenh`
  ADD PRIMARY KEY (`MaVacxin`,`MaBenh`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `vacxin`
--
ALTER TABLE `vacxin`
  ADD PRIMARY KEY (`MaVacxin`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `vacxin`
--
ALTER TABLE `vacxin`
  MODIFY `MaVacxin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
