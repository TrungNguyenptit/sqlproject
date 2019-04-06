-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 06, 2019 lúc 06:38 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bank`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` varchar(15) NOT NULL,
  `provisionDate` date NOT NULL,
  `branch` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `surplus` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `provisionDate`, `branch`, `type`, `surplus`) VALUES
('acc01', '2018-02-22', 'Ha Noi', 'tin dung', 10000000),
('acc010', '2018-08-02', 'Ha Noi', 'tin dung', 70000000),
('acc011', '2018-09-04', 'Ha Noi', 'tin dung', 70000000),
('acc012', '2018-10-12', 'Ha Noi', 'tin dung', 80000000),
('acc013', '2018-11-11', 'Ha Noi', 'tin dung', 90000000),
('acc014', '2018-03-10', 'Ha Noi', 'tin dung', 10000000),
('acc015', '2018-01-09', 'Ha Noi', 'tin dung', 10000000),
('acc016', '2018-05-07', 'Ha Noi', 'tin dung', 10000000),
('acc017', '2018-06-22', 'Ha Noi', 'tin dung', 10000000),
('acc02', '2018-02-22', 'Ha Noi', 'tin dung', 10000000),
('acc03', '2018-02-13', 'Ha Noi', 'tin dung', 10000000),
('acc04', '2018-03-22', 'Ha Noi', 'tin dung', 100000000),
('acc05', '2018-04-21', 'Ha Noi', 'tin dung', 20000000),
('acc06', '2018-02-14', 'Ha Noi', 'tin dung', 30000000),
('acc07', '2018-04-18', 'Ha Noi', 'tin dung', 40000000),
('acc08', '2018-05-29', 'Ha Noi', 'tin dung', 50000000),
('acc09', '2018-07-23', 'Ha Noi', 'tin dung', 60000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` varchar(15) NOT NULL,
  `job` varchar(255) NOT NULL,
  `passportNo` varchar(255) NOT NULL,
  `idprofile` varchar(255) NOT NULL,
  `idaccount` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `job`, `passportNo`, `idprofile`, `idaccount`) VALUES
('cus01', 'bac sy', 'AK0123654564', 'pro01', 'acc01'),
('cus010', 'taxi', 'AK0123345564', 'pro010', 'acc010'),
('cus011', 'checker', 'AK0123254564', 'pro011', 'acc011'),
('cus012', 'lap trinh vien', 'AK02323654564', 'pro012', 'acc012'),
('cus013', 'ca sy', 'AK0123654532', 'pro013', 'acc013'),
('cus014', 'nguoi mau', 'AK01233244564', 'pro014', 'acc014'),
('cus015', 'giao vien', 'AK01236324564', 'pro015', 'acc015'),
('cus016', 'hoc sinh', 'AK01236523464', 'pro016', 'acc016'),
('cus017', 'sinh vien', 'AK0123651264', 'pro017', 'acc017'),
('cus02', 'y ta', 'AK312515564', 'pro02', 'acc02'),
('cus03', 'nha sy', 'AK012365154', 'pro03', 'acc03'),
('cus04', 'bac sy', 'AK0123654574', 'pro04', 'acc04'),
('cus05', 'bac sy', 'AK012365264', 'pro05', 'acc05'),
('cus06', 'bac sy', 'AK01236532464', 'pro06', 'acc06'),
('cus07', 'nha sy', 'AK01236674', 'pro07', 'acc07'),
('cus08', 'tho han', 'AK01235574564', 'pro08', 'acc08'),
('cus09', 'graber', 'AK012363464', 'pro09', 'acc09');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `id` varchar(15) NOT NULL,
  `idProfile` varchar(255) NOT NULL,
  `idemployeeAccount` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `idProfile`, `idemployeeAccount`, `role`) VALUES
('adm01', 'pro023', 'ada1', 'admin'),
('em01', 'pro018', 'ema01', 'nv'),
('em02', 'pro019', 'ema02', 'nv'),
('em03', 'pro020', 'ema03', 'nv'),
('em04', 'pro021', 'ema04', 'nv'),
('em05', 'pro022', 'ema05', 'nv');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employeeaccount`
--

CREATE TABLE `employeeaccount` (
  `id` varchar(15) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `provisionDate` date NOT NULL,
  `branch` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employeeaccount`
--

INSERT INTO `employeeaccount` (`id`, `username`, `password`, `provisionDate`, `branch`) VALUES
('ema01', 'employee1', '123456', '2017-07-19', 'Hà Nội'),
('ema02', 'employee2', '1234567', '2018-01-10', 'Hải Phòng'),
('ema03', 'employee3', '123987', '2017-12-05', 'TP Hồ Chí Minh'),
('ema04', 'employee4', '951753', '2017-11-11', 'Đà Nẵng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `husbandry`
--

CREATE TABLE `husbandry` (
  `id` varchar(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL,
  `minimumamountdespositcycle` float NOT NULL,
  `typeofmoney` varchar(255) NOT NULL,
  `despositCycle` varchar(255) NOT NULL,
  `interestPaymentCycle` varchar(255) NOT NULL,
  `sourcesofinterestPayment` varchar(255) NOT NULL,
  `note` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `husbandry`
--

INSERT INTO `husbandry` (`id`, `name`, `term`, `minimumamountdespositcycle`, `typeofmoney`, `despositCycle`, `interestPaymentCycle`, `sourcesofinterestPayment`, `note`) VALUES
('hus01', 'Tích lũy đầu tư', '12 thang', 200000000, 'vnd', '', 'hang thang, hang quy', 'chuyen khoan vao tai khoan dau tu', '01 hop dong bao hiem'),
('hus010', 'Tích lũy cho con', '12 thang', 3000000, 'vnd', '3 thang/lan', 'cuoi ky', '', ''),
('hus011', 'Tiền gửi cán bộ công nhân viên', '12 thang', 10000000, 'vnd', '1thang/lan', 'cuoi ky', '', ''),
('hus012', 'Tiền gửi trực tuyến', '14 ngay', 3000000, 'vnd', '', 'cuoi ky', '', 'thanh toan truoc han lai xuat 0%'),
('hus013', 'Tiền gửi trực tuyến', '1 thang', 3000000, 'aud', '', 'cuoi ky', '', 'thanh toan truoc han lai xuat khong ky han'),
('hus014', 'Tiền gửi trực tuyến', '3 thang', 3000000, 'aud', '', 'cuoi ky', '', 'thanh toan truoc han lai xuat khong ky han'),
('hus015', 'Tiền gửi trực tuyến', '6 thang', 3000000, 'aud', '', 'cuoi ky', '', 'thanh toan truoc han lai xuat khong ky han'),
('hus016', 'Tích lũy kiểu hối', '1 thang', 0, 'usd', '', 'cuoi ky', '', ''),
('hus017', 'Tiết kiệm tự động', 'dang ky', 3000000, 'vnd,usd', '', 'cuoi ky', '', ''),
('hus018', 'Lĩnh lãi định kỳ', '3,6,9,12,18,24,36,38,60 thang', 30000000, 'vnd,usd,eur', '', 'hang thang, hang quy', 'tien mat, chuyen khoan', 'thanh toan truoc han huong lai xuat khong ky hab'),
('hus019', 'Tiết kiệm lãi trả trước', '1,3,6,12,18,24 thang', 0, 'vnd,usd.eur', '', 'nhan ngay khi gui tien', 'tien mat, chuyen khoan', ''),
('hus02', 'Tích lũy đầu tư', '12 thang', 200000000, 'vnd', '', 'hang thang, hang quy', 'chuyen khoan vao tai khoan dau tu', '01 quy mo'),
('hus020', 'Tiết kiệm thường', 'dang ky', 500000, 'vnd,usd, ngoai te khac', '', 'cuoi ky, tra lai truoc', '', ''),
('hus03', 'Tích lũy đầu tư', '12 thang', 400000000, 'vnd', '', 'hang thang, hang quy', 'chuyen khoan vao tai khoan dau tu', '02 quy mo'),
('hus04', 'Tích lũy đầu tư', '12 thang', 400000000, 'vnd', '', 'hang thang, hang quy', 'chuyen khoan vao tai khoan dau tu', '01 hop dong bao hiem va 01 quy mo'),
('hus05', 'Tích lũy đầu tư', '12 thang', 600000000, 'vnd', '', 'hang thang, hang quy', 'chuyen khoan vao tai khoan dau tu', '01 hop dong bao hiem va 02 quy mo'),
('hus06', 'AUD ưu đãi', '1 thang', 3000, 'aud', '', 'cuoi ky', '', ''),
('hus07', 'AUD ưu đãi', '3 thang', 3000, 'aud', '', 'cuoi ky', '', ''),
('hus08', 'AUD ưu đãi', '6 thang', 3000, 'aud', '', 'cuoi ky', '', ''),
('hus09', 'AUD ưu đãi', '12 thang', 3000, 'aud', '', 'cuoi ky', '', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `interestrate`
--

CREATE TABLE `interestrate` (
  `id` varchar(15) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `term` varchar(255) NOT NULL,
  `vndinterestrate` float NOT NULL,
  `usdinterestrate` float NOT NULL,
  `eurinterestrate` float NOT NULL,
  `audinterestrate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `interestrate`
--

INSERT INTO `interestrate` (`id`, `name`, `type`, `term`, `vndinterestrate`, `usdinterestrate`, `eurinterestrate`, `audinterestrate`) VALUES
('inter01', 'Tich luy cho con', 'Tich luy cho con', 'thoi diem mo tai khoan', 0.3, 0, 0, 0),
('inter010', 'Tran lai xuat', 'tietkiem', 'khong ky han', 0.1, 0, 0, 0),
('inter011', 'Tran lai xuat', 'tietkiem', '7 ngay', 0.5, 0, 0, 0),
('inter012', 'Tran lai xuat', 'tietkiem', '14 ngay', 0.5, 0, 0, 0),
('inter013', 'Tran lai xuat', 'tietkiem', '1 thang', 4.5, 0, 0.15, 0),
('inter014', 'Tran lai xuat', 'tietkiem', '2 thang', 4.5, 0, 0.15, 0),
('inter015', 'Tran lai xuat', 'tietkiem', '3 thang', 5, 0, 0.15, 0),
('inter016', 'Tran lai xuat', 'tietkiem', '6 thang', 5, 0, 0.15, 0),
('inter017', 'Tran lai xuat', 'tietkiem', '9 thang', 5, 0, 0.15, 0),
('inter018', 'Tran lai xuat', 'tietkiem', '12 thang', 6.8, 0, 0.3, 0),
('inter019', 'Tran lai xuat', 'tietkiem', '24 thang', 6.8, 0, 0.3, 0),
('inter02', 'Tich luy cho con', 'Tich luy cho con', 'sau 3 thang', 5.5, 0, 0, 0),
('inter020', 'Tran lai xuat', 'tietkiem', '36 thang', 6.8, 0, 0.3, 0),
('inter021', 'Tran lai xuat', 'tietkiem', '48 thang', 6.8, 0, 0.3, 0),
('inter022', 'Tran lai xuat', 'tietkiem', '60 thang', 6.8, 0, 0.3, 0),
('inter023', 'Tran lai xuat', 'tienguicokyhan', '1 thang', 4.5, 0, 0.15, 0),
('inter024', 'Tran lai xuat', 'tienguicokyhan', '2 thang', 4.5, 0, 0.15, 0),
('inter025', 'Tran lai xuat', 'tienguicokyhan', '3 thang', 5, 0, 0.15, 0),
('inter026', 'Tran lai xuat', 'tienguicokyhan', '6 thang', 5.5, 0, 0.15, 0),
('inter027', 'Tran lai xuat', 'tienguicokyhan', '9 thang', 5.5, 0, 0.15, 0),
('inter028', 'Tran lai xuat', 'tienguicokyhan', '12 thang', 6.8, 0, 0.3, 0),
('inter029', 'Tran lai xuat', 'tienguicokyhan', '24 thang', 6.8, 0, 0.3, 0),
('inter03', 'Tich luy cho con', 'Tich luy cho con', 'sau 6 thang', 5.3, 0, 0, 0),
('inter030', 'Tran lai xuat', 'tienguicokyhan', '36 thang', 6.8, 0, 0.3, 0),
('inter031', 'Tran lai xuat', 'tienguicokyhan', '48 thang', 6.8, 0, 0.3, 0),
('inter032', 'Tran lai xuat', 'tienguicokyhan', '60 thang', 6.8, 0, 0.3, 0),
('inter04', 'Tich luy cho con', 'Tich luy cho con', 'sau 9 thang', 4.8, 0, 0, 0),
('inter05', 'Tich luy cho con', 'Tich luy cho con', 'rut truoc han', 0.1, 0, 0, 0),
('inter07', 'Tich luy kieu hoi', 'Tich luy kieu hoi', '1 thang', 0, 0, 0, 0),
('inter08', 'Linh lai dinh ky', '>200tr vnd', '>12 thang', 0.12, 0, 0, 0),
('inter09', 'Linh lai dinh ky', '>10000 eur', '>12 thang', 0, 0.12, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lend`
--

CREATE TABLE `lend` (
  `id` varchar(255) CHARACTER SET latin1 NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `term` varchar(255) CHARACTER SET latin1 NOT NULL,
  `interestRate` float NOT NULL,
  `lendingamountmaximum` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `lend`
--

INSERT INTO `lend` (`id`, `name`, `term`, `interestRate`, `lendingamountmaximum`) VALUES
('lo01', 'Cho vay sửa nhà', '10 nam', 0, 0),
('lo02', 'Ngôi nhà mơ ước', '15 nam', 0, 0),
('lo03', 'Gia đình thịnh vượng', '15 nam', 0, 0),
('lo04', 'Cho vay mua nhà dự án', '20 nam', 0, 0),
('lo05', 'Cho vay hỗ trợ mua nhà', '15 nam', 0.05, 0),
('lo06', 'Cho vay cá nhân', '', 0, 0),
('lo07', 'Cho vay cán bộ', '', 0, 300000000),
('lo08', 'Cho vay mua ô tô', '5 nam', 0, 0),
('lo09', 'Thấu chi tài khoản', '12 tháng', 0, 30000000),
('lo10', 'Kinh doanh tài lộc', '', 0, 0),
('lo11', 'Cho vay cầm cố CK', '', 0, 3000000000),
('lo12', 'Cho vay cầm cố giấy tờ', '5 nam', 0, 0),
('lo13', 'Thấu chi cầm cố giấy tờ', '12 tháng', 0, 0),
('lo14', 'Cho vay cán bộ NV', '', 0, 200000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loan`
--

CREATE TABLE `loan` (
  `id` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idlend` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `idcustomer` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idemployee` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `provisionDate` date NOT NULL,
  `expirationDate` date NOT NULL,
  `loanamount` float NOT NULL,
  `term` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `interestTotal` float NOT NULL,
  `InterestPaymentCycle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mo` char(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `loan`
--

INSERT INTO `loan` (`id`, `idlend`, `idcustomer`, `idemployee`, `provisionDate`, `expirationDate`, `loanamount`, `term`, `interestTotal`, `InterestPaymentCycle`, `note`, `mo`) VALUES
('le01', 'lo01', 'cus01', 'em01', '2019-01-02', '2021-01-02', 100000000, '12 thang', 0, '', '', ''),
('le02', 'lo02', 'cus02', 'em02', '2019-01-02', '2020-01-02', 500000000, '12 thang', 0, '', '', ''),
('le03', 'lo03', 'cus03', 'em03', '2019-01-04', '2021-01-04', 500000000, '1 nam', 0, '', '', ''),
('le04', 'lo04', 'cus04', 'em04', '2019-01-05', '2020-01-05', 100000000, '12 thang', 0, '', '', ''),
('le05', 'lo05', 'cus05', 'em05', '2016-01-12', '2019-01-12', 400000000, '3 nam', 0, '', '', NULL),
('le06', 'lo06', 'cus01', 'em01', '2019-01-22', '2020-01-22', 300000000, '12 thang', 0, '', '', ''),
('le07', 'lo07', 'cus07', 'em04', '2017-01-02', '2019-01-02', 100000000, '12 thang', 0, '', '', NULL),
('le08', 'lo08', 'cus08', 'em06', '2015-01-02', '2016-01-02', 200000000, '12 thang', 0, '', '', ''),
('le09', 'lo09', 'cus03', 'em01', '2019-01-02', '2020-01-02', 300000000, '12 thang', 0, '', '', ''),
('le10', 'lo10', 'cus04', 'em02', '2019-01-02', '2020-01-02', 400000000, '12 thang', 0, '', '', ''),
('le11', 'lo11', 'cus95', 'em03', '2019-01-02', '2020-01-02', 500000000, '12 thang', 0, '', '', ''),
('le12', 'lo12', 'cus07', 'em05', '2019-01-02', '2020-01-02', 600000000, '12 thang', 0, '', '', ''),
('le13', 'lo13', 'cus09', 'em02', '2019-01-02', '2020-01-02', 700000000, '12 thang', 0, '', '', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `profile`
--

CREATE TABLE `profile` (
  `id` varchar(15) NOT NULL,
  `dateofbirth` date NOT NULL,
  `address` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `profile`
--

INSERT INTO `profile` (`id`, `dateofbirth`, `address`, `tel`, `name`) VALUES
('pro01', '1987-01-12', '325 Bà Triệu, Hà Nội', '01584123514', 'Vũ Minh Giang'),
('pro010', '1954-03-07', '113 Văn Quán, Hà Nội', '09654455778', 'Đỗ Tuấn'),
('pro011', '1995-03-07', 'Chợ lớn, Hà Nội', '09654455778', 'Nguyễn Thị Thúy'),
('pro012', '1992-03-07', '20 Đại La, Hà Nội', '09654455778', 'Nguyễn Thị Lan'),
('pro013', '1991-03-07', '210 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thế Ba'),
('pro014', '1990-03-07', '120 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Bốn'),
('pro015', '1990-03-07', '360 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Năm'),
('pro016', '1994-03-07', '540 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Sáu'),
('pro017', '1996-03-07', '120 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Bảy'),
('pro018', '1996-03-07', '03 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Tám'),
('pro019', '1996-03-07', '14 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Chín'),
('pro02', '1967-05-23', '257 Minh Khai, Hà Nội', '0945817488', 'Đỗ Thị Liên'),
('pro020', '1996-03-07', '10 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Mười'),
('pro021', '1969-03-03', '172 Tây Sơn', '01511482417', 'Đỗ Thanh Bình'),
('pro022', '1972-05-11', '368 Hồ Đắc Di', '0344581747', 'Nguyễn Minh Thanh'),
('pro03', '1998-03-07', '210 Nguyễn Trãi, Hà Nội', '09654215778', 'Nguyễn Thị Thúy'),
('pro04', '1994-03-07', '210 Nguyễn Trãi, Hà Nội', '09654455778', 'Nguyễn Thị Thùy'),
('pro05', '1996-04-07', '210 Khâm Thiên, Hà Nội', '09654455774', 'Quyền Chinh'),
('pro06', '1944-03-07', '300 Khúc Thừa Dụ, Hà Nội', '09654455778', 'Khánh Phương'),
('pro07', '1984-03-07', '200 Đường lÁNG, Hà Nội', '09654455778', 'Bùi Anh Tuấn'),
('pro08', '1974-03-07', '60 lÊ la, Hà nội', '09654455778', 'Mỹ Tâm'),
('pro09', '1964-03-07', '40 Quán Thánh, Hà Nội', '09654455778', 'Lê lan');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `saving`
--

CREATE TABLE `saving` (
  `id` varchar(15) NOT NULL,
  `idcustomer` varchar(15) NOT NULL,
  `idhusbandry` varchar(15) NOT NULL,
  `idemployee` varchar(15) NOT NULL,
  `provisionDate` date NOT NULL,
  `expirationDate` date NOT NULL,
  `interestTotal` float NOT NULL,
  `depositTotal` float NOT NULL,
  `term` varchar(255) NOT NULL,
  `typeofmoney` varchar(255) NOT NULL,
  `mo` char(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `saving`
--

INSERT INTO `saving` (`id`, `idcustomer`, `idhusbandry`, `idemployee`, `provisionDate`, `expirationDate`, `interestTotal`, `depositTotal`, `term`, `typeofmoney`, `mo`) VALUES
('sav01', 'cus02', 'hus01', 'em01', '2018-01-06', '2019-01-06', 9066660, 200000000, '12 thang', 'vnd', ''),
('sav010', 'cus02', 'hus03', 'em03', '2018-01-01', '2019-01-01', 500000000, 28410000, '12 thang', 'vnd', NULL),
('sav011', 'cus011', 'hus019', 'em04', '2018-07-11', '2019-01-11', 50000000, 1250000, '6 thang', 'vnd', NULL),
('sav012', 'cus03', 'hus018', 'em05', '2018-10-18', '2019-01-18', 40000000, 500000, '3 thang', 'vnd', NULL),
('sav013', 'cus05', 'hus017', 'em05', '2018-01-18', '2019-01-18', 40000000, 2720000, '12 thang', 'vnd', NULL),
('sav02', 'cus02', 'hus06', 'em02', '2018-05-01', '2018-06-01', 0, 4000, '1 thang', 'aud', NULL),
('sav03', 'cus07', 'hus01', 'em03', '2018-01-21', '2019-01-21', 3315000, 60000000, '12 thang', 'vnd', NULL),
('sav04', 'cus04', 'hus01', 'em01', '2018-01-03', '2019-01-03', 2606000, 22000000, '12 thang', 'vnd', NULL),
('sav05', 'cus011', 'hus010', 'em02', '2018-01-21', '2019-01-21', 0, 12000000, '12 thang', 'vnd', NULL),
('sav06', 'cus012', 'hus011', 'em02', '2018-01-23', '2019-01-23', 8160000, 120000000, '12 thang', 'vnd', NULL),
('sav07', 'cus03', 'hus012', 'em05', '2019-01-11', '2019-01-25', 20000, 4000000, '14 ngay', 'vnd', NULL),
('sav08', 'cus04', 'hus013', 'em03', '2019-12-01', '2019-01-01', 5000000, 0, '1 thang', 'aud', NULL),
('sav09', 'cus09', 'hus016', 'em03', '2019-12-01', '2019-01-01', 5000, 0, '1 thang', 'usd', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trade`
--

CREATE TABLE `trade` (
  `id` varchar(255) NOT NULL,
  `idSaving` varchar(255) NOT NULL,
  `tradetype` varchar(255) NOT NULL,
  `dateofTrade` date NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `trade`
--

INSERT INTO `trade` (`id`, `idSaving`, `tradetype`, `dateofTrade`, `amount`) VALUES
('tra01', 'sav01', 'nop tien', '2018-01-06', 20000000),
('tra02', 'sav02', 'nop tien', '2018-05-01', 4000),
('tra03', 'sav03', 'nop tien', '2018-01-21', 15000000),
('tra04', 'sav03', 'nop tien', '2018-04-21', 15000000),
('tra05', 'sav03', 'nop tien', '2018-07-21', 15000000),
('tra06', 'sav03', 'nop tien', '2018-10-21', 15000000),
('tra07', 'sav03', 'tra lai', '2018-01-21', 3315000),
('tra08', 'sav03', 'tra von', '2018-01-21', 60000000),
('tra09', 'sav04', 'nop tien', '2018-01-03', 10000000),
('tra010', 'sav04', 'nop tien', '2018-01-03', 1000000),
('tra011', 'sav04', 'nop tien', '2018-02-03', 1000000),
('tra012', 'sav04', 'nop tien', '2018-03-03', 1000000),
('tra013', 'sav04', 'nop tien', '2018-04-03', 1000000),
('tra014', 'sav04', 'nop tien', '2018-05-03', 1000000),
('tra015', 'sav04', 'nop tien', '2018-06-03', 1000000),
('tra016', 'sav04', 'nop tien', '2018-07-03', 1000000),
('tra017', 'sav04', 'nop tien', '2018-08-03', 1000000),
('tra018', 'sav04', 'nop tien', '2018-09-03', 1000000),
('tra019', 'sav04', 'nop tien', '2018-10-03', 1000000),
('tra020', 'sav04', 'nop tien', '2018-11-03', 1000000),
('tra021', 'sav04', 'nop tien', '2019-12-03', 1000000),
('tra022', 'sav04', 'tra lai', '2018-01-03', 2606000),
('tra023', 'sav04', 'tra von', '2018-01-03', 22000000),
('tra024', 'sav05', 'noptien', '2018-01-21', 3000000),
('tra025', 'sav05', 'noptien', '2018-04-21', 3000000),
('tra026', 'sav05', 'noptien', '2018-07-21', 3000000),
('tra027', 'sav05', 'noptien', '2018-10-21', 3000000),
('tra028', 'sav05', 'tragoc', '2019-01-21', 12000000),
('tra029', 'sav05', 'tralai', '2019-01-21', 1596000),
('tra030', 'sav06', 'noptien', '2018-01-23', 10000000),
('tra031', 'sav06', 'noptien', '2018-02-23', 10000000),
('tra032', 'sav06', 'noptien', '2018-03-23', 10000000),
('tra033', 'sav06', 'noptien', '2018-04-23', 10000000),
('tra034', 'sav06', 'noptien', '2018-05-23', 10000000),
('tra035', 'sav06', 'noptien', '2018-06-23', 10000000),
('tra036', 'sav06', 'noptien', '2018-07-23', 10000000),
('tra037', 'sav06', 'noptien', '2018-08-23', 10000000),
('tra038', 'sav06', 'noptien', '2018-09-23', 10000000),
('tra039', 'sav06', 'noptien', '2018-10-23', 10000000),
('tra040', 'sav06', 'noptien', '2018-11-23', 10000000),
('tra041', 'sav06', 'noptien', '2018-12-23', 10000000),
('tra042', 'sav06', 'tragoc', '2019-01-23', 120000000),
('tra043', 'sav06', 'tralai', '2018-01-23', 8160000),
('tra044', 'sav07', 'noptien', '2019-01-11', 4000000),
('tra045', 'sav07', 'tragoc', '2019-01-25', 4000000),
('tra046', 'sav07', 'tralai', '2019-01-25', 20000),
('tra048', 'sav08', 'noptien', '2019-12-01', 5000000),
('tra047', 'sav08', 'tragoc', '2019-01-01', 5000000),
('tra049', 'sav08', 'tralai', '2019-01-01', 0),
('tra050', 'sav09', 'noptien', '2018-12-01', 5000),
('tra051', 'sav09', 'tralai', '2019-01-01', 0),
('tra052', 'sav09', 'travon', '2019-01-01', 5000),
('tra053', 'sav010', 'noptien', '2018-01-01', 500000000),
('tra054', 'sav010', 'tralai', '2018-04-01', 6250000),
('tra055', 'sav010', 'tralai', '2018-07-01', 6875000),
('tra056', 'sav010', 'tralai', '2018-10-01', 6875000),
('tra057', 'sav010', 'tralai', '2019-01-01', 8500000),
('tra058', 'sav010', 'tragoc', '2019-01-01', 500000000),
('tra059', 'sav011', 'noptien', '2018-07-11', 50000000),
('tra060', 'sav011', 'tralai', '2018-07-11', 1250000),
('tra061', 'sav011', 'tragoc', '2019-01-01', 50000000),
('tra062', 'sav012', 'noptien', '2018-10-18', 40000000),
('tra063', 'sav012', 'tragoc', '2019-01-18', 40000000),
('tra064', 'sav012', 'tralai', '2019-01-18', 5000000),
('tra065', 'sav013', 'noptien', '2018-01-18', 40000000),
('tra066', 'sav013', 'tralai', '2019-01-18', 2720000),
('tra067', 'sav013', 'tragoc', '2019-01-18', 40000000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `employeeaccount`
--
ALTER TABLE `employeeaccount`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `husbandry`
--
ALTER TABLE `husbandry`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `interestrate`
--
ALTER TABLE `interestrate`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lend`
--
ALTER TABLE `lend`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `saving`
--
ALTER TABLE `saving`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idhusbandry_husbandry` (`idhusbandry`),
  ADD KEY `idcustomer_customer` (`idcustomer`),
  ADD KEY `idemployee_employee` (`idemployee`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `saving`
--
ALTER TABLE `saving`
  ADD CONSTRAINT `idcustomer_customer` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `idemployee_employee` FOREIGN KEY (`idemployee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `idhusbandry_husbandry` FOREIGN KEY (`idhusbandry`) REFERENCES `husbandry` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
