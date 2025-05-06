CREATE TABLE SinhVien (
    id INT PRIMARY KEY IDENTITY(1,1),
    hoTen NVARCHAR(100),
    mssv NVARCHAR(20) UNIQUE,
    lop NVARCHAR(50),
    email NVARCHAR(100),
    nguyenVong NVARCHAR(255)
);

CREATE TABLE GiangVien (
    id INT PRIMARY KEY IDENTITY(1,1),
    hoTen NVARCHAR(100),
    email NVARCHAR(100),
    khoa NVARCHAR(100)
);

CREATE TABLE DoanhNghiep (
    id INT PRIMARY KEY IDENTITY(1,1),
    tenCTy NVARCHAR(100),
    diaChi NVARCHAR(255),
    linhVuc NVARCHAR(100)
);

CREATE TABLE ThucTap (
    id INT PRIMARY KEY IDENTITY(1,1),
    sinhVienId INT,
    giangVienId INT,
    doanhNghiepId INT,
    ngayBatDau DATE,
    ngayKetThuc DATE,
    trangThai NVARCHAR(50),
    FOREIGN KEY (sinhVienId) REFERENCES SinhVien(id),
    FOREIGN KEY (giangVienId) REFERENCES GiangVien(id),
    FOREIGN KEY (doanhNghiepId) REFERENCES DoanhNghiep(id)
);

CREATE TABLE BaoCao (
    id INT PRIMARY KEY IDENTITY(1,1),
    sinhVienId INT,
    tieuDe NVARCHAR(200),
    noiDung NVARCHAR(MAX),
    tepFile NVARCHAR(255),
    ngayNop DATE,
    FOREIGN KEY (sinhVienId) REFERENCES SinhVien(id)
);

CREATE TABLE DanhGia (
    id INT PRIMARY KEY IDENTITY(1,1),
    sinhVienId INT,
    nguoiDanhGia NVARCHAR(100),
    diem FLOAT,
    nhanXet NVARCHAR(MAX),
    FOREIGN KEY (sinhVienId) REFERENCES SinhVien(id)
);
