package com.example.uml.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.uml.services.DangKyService;

@RestController
@RequestMapping("/api/dangky")
public class DangKyRestController {

    @Autowired
    private DangKyService dangKySerVice;

    @PostMapping("/sinhvien")
    public ResponseEntity<String> dangKySinhVien(@RequestBody SinhVienDTO sinhVienDTO) {
        try {
            dangKySerVice.dangKySinhVien(sinhVienDTO);
            return ResponseEntity.ok("Đăng ký sinh viên thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi đăng ký: " + e.getMessage());
        }
    }

    @PostMapping("/doanhnghiep")
    public ResponseEntity<String> dangKyDoanhNghiep(@RequestBody DoanhNghiepDTO doanhNghiepDTO) {
        try {
            dangKySerVice.dangKyDoanhNghiep(doanhNghiepDTO);
            return ResponseEntity.ok("Đăng ký doanh nghiệp thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi đăng ký doanh nghiệp: " + e.getMessage());
        }
    }

    // DTO to capture form data
    public static class SinhVienDTO {
        private String hoTen;
        private String mssv;
        private String truong;
        private String email;
        private String tenDangNhap;
        private String matKhau;


        // Getters and Setters
        public String getHoTen() {
            return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public String getMssv() {
            return mssv;
        }

        public void setMssv(String mssv) {
            this.mssv = mssv;
        }

        public String getTruong() {
            return truong;
        }

        public void setTruong(String truong) {
            this.truong = truong;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTenDangNhap() {
            return tenDangNhap;
        }

        public void setTenDangNhap(String tenDangNhap) {
            this.tenDangNhap = tenDangNhap;
        }

        public String getMatKhau() {
            return matKhau;
        }

        public void setMatKhau(String matKhau) {
            this.matKhau = matKhau;
        }
    }



    public static class DoanhNghiepDTO {
        private String tenDoanhNghiep;
        private String email;
        private String tenDangNhap;
        private String matKhau;

        public String getTenDoanhNghiep() {
            return tenDoanhNghiep;
        }

        public void setTenDoanhNghiep(String tenDoanhNghiep) {
            this.tenDoanhNghiep = tenDoanhNghiep;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTenDangNhap() {
            return tenDangNhap;
        }

        public void setTenDangNhap(String tenDangNhap) {
            this.tenDangNhap = tenDangNhap;
        }

        public String getMatKhau() {
            return matKhau;
        }

        public void setMatKhau(String matKhau) {
            this.matKhau = matKhau;
        }
    }
}