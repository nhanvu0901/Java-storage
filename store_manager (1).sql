-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 21, 2021 lúc 08:20 AM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `store_manager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `food_id` int(11) DEFAULT NULL,
  `food_name` varchar(50) NOT NULL,
  `food_kind` varchar(50) NOT NULL,
  `food_number` int(11) DEFAULT NULL,
  `food_price` double DEFAULT NULL,
  `food_dateInput` varchar(50) NOT NULL,
  `food_dayMade` varchar(50) NOT NULL,
  `food_expired` varchar(50) NOT NULL,
  `food_origin` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `store`
--

INSERT INTO `store` (`food_id`, `food_name`, `food_kind`, `food_number`, `food_price`, `food_dateInput`, `food_dayMade`, `food_expired`, `food_origin`) VALUES
(1230, 'thịt bò', 'Thịt', 300, 20000, '17/06/2021', '17/06/2021', '17/06/2021', 'Nhật Bản'),
(4444, 'mực', 'Hải sản', 200, 12000, '17/06/2021', '17/06/2021', '17/06/2021', 'Khánh Hòa'),
(1234, 'Cá hồi', 'Cá', 100, 12000, '13/06/2021', '13/06/2021', '13/06/2021', 'Nhật Bản'),
(1231, 'Thạch dừa', 'Tráng miệng', 200, 12000, '13/06/2021', '13/06/2021', '13/06/2021', 'Nha Trang'),
(1235, 'Thịt heo', 'Tráng miệng', 100, 12000, '13/06/2021', '13/06/2021', '13/06/2021', 'Nam Định'),
(1239, 'Bia', 'Tráng miệng', 100, 12000, '13/06/2021', '13/06/2021', '13/06/2021', 'Hà Nội'),
(1240, 'Bánh kem', 'Tráng miệng', 200, 12000, '13/06/2021', '13/06/2021', '13/06/2021', 'Hà Nội'),
(1902, 'sữa chua', 'Tráng miệng', 1000, 10000, '20/06/2021', '20/06/2021', '20/06/2021', 'Hàn Quốc'),
(1241, 'Dừa', 'Hoa Qủa', 200, 10000, '20/06/2021', '20/06/2021', '20/06/2021', 'Khánh Hòa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_employee`
--

DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `employee_id` int(11) DEFAULT NULL,
  `employee_name` varchar(150) NOT NULL,
  `employee_gender` varchar(150) NOT NULL,
  `employee_gmail` varchar(150) NOT NULL,
  `employee_password` varchar(150) NOT NULL,
  `employee_job` varchar(150) NOT NULL,
  `employee_shift` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_employee`
--

INSERT INTO `tbl_employee` (`employee_id`, `employee_name`, `employee_gender`, `employee_gmail`, `employee_password`, `employee_job`, `employee_shift`) VALUES
(30, 'Nguyễn Anh Tuấn', 'Nam', '@123', '12345', 'Quản lý', '07:00-11:00'),
(3, 'Nguyễn Huy Hoàng', 'Nam', '@123', '1234', 'Thu ngân', '08:00-17:00'),
(99999, 'Vũ Trọng Nhân', 'Nam', '@123', '1234', 'Giám đốc', '07:00-11:00'),
(88, 'Đỗ Hoàng Anh', 'Nam', '@123', '1234', 'Quản lý', '13:00-15:00'),
(12, 'Nguyễn Minh Châu', 'Nam', '@123', '1234', 'Bảo vệ', '15:00-21:00'),
(123, 'Nguyễn Long', 'Nam', '@123', '123', 'Bảo vệ', '15:00-21:00'),
(1, 'Minh', 'Nam', '1', '1', 'Nhân Viên part time', '07:00-11:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
