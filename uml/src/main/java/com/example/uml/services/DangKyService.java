package com.example.uml.services;

import com.example.uml.entities.DoanhNghiep;
import com.example.uml.entities.SinhVien;
import com.example.uml.entities.TaiKhoan;
import com.example.uml.repositories.DoanhNghiepRepository;
import com.example.uml.repositories.SinhVienRepository;
import com.example.uml.repositories.TaiKhoanRepository;
import com.example.uml.restcontrollers.DangKyRestController.DoanhNghiepDTO;
import com.example.uml.restcontrollers.DangKyRestController.SinhVienDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DangKyService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private DoanhNghiepRepository doanhNghiepRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Transactional
    public void dangKySinhVien(SinhVienDTO dto) throws Exception {
        // Validate input

        // Check if username or email already exists
        if (taiKhoanRepository.existsByTenDangNhap(dto.getTenDangNhap())) {
            throw new Exception("Tên đăng nhập đã tồn tại!");
        }
        if (sinhVienRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("Email đã được sử dụng!");
        }
        if (sinhVienRepository.existsByMssv(dto.getMssv())) {
            throw new Exception("Mã số sinh viên đã tồn tại!");
        }

        // Create TaiKhoan entity
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(dto.getTenDangNhap());
        taiKhoan.setMatKhau(dto.getMatKhau()); // In production, hash the password
        taiKhoan.setVaiTro("SinhVien");
        taiKhoan.setTrangThai(true);
        

        // Save TaiKhoan
        taiKhoan = taiKhoanRepository.save(taiKhoan);

        // Create SinhVien entity
        SinhVien sinhVien = new SinhVien();
        sinhVien.setTaiKhoan(taiKhoan);
        sinhVien.setHoTen(dto.getHoTen());
        sinhVien.setMssv(dto.getMssv());
        sinhVien.setTruong(dto.getTruong());
        sinhVien.setEmail(dto.getEmail());

        // Save SinhVien
        sinhVienRepository.save(sinhVien);
    }




    @Transactional
    public void dangKyDoanhNghiep(DoanhNghiepDTO dto) throws Exception {
        // Validate input

        // Check if username or email already exists
        if (taiKhoanRepository.existsByTenDangNhap(dto.getTenDangNhap())) {
            throw new Exception("Tên đăng nhập đã tồn tại!");
        }

        if (doanhNghiepRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("Email đã được sử dụng!");
        }

        // Create TaiKhoan entity
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenDangNhap(dto.getTenDangNhap());
        taiKhoan.setMatKhau(dto.getMatKhau()); // In production, hash the password
        taiKhoan.setVaiTro("DoanhNghiep");
        taiKhoan.setTrangThai(true);

        // Save TaiKhoan
        taiKhoan = taiKhoanRepository.save(taiKhoan);

        // Create DoanhNghiep entity
        DoanhNghiep doanhNghiep = new DoanhNghiep();
        doanhNghiep.setTaiKhoan(taiKhoan);
        doanhNghiep.setTenDN(dto.getTenDoanhNghiep());
        doanhNghiep.setEmail(dto.getEmail());

        // Save DoanhNghiep
        doanhNghiepRepository.save(doanhNghiep);
    }
}