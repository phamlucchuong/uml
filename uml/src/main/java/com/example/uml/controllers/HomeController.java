package com.example.uml.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/dangKy")
    public String dangKy() {
        return "taiKhoan/dangKy";
    }

    @GetMapping("/dangNhap")
    public String dangNhap() {
        return "taiKhoan/dangNhap";
    }

    @GetMapping("/sinhVien")
    public String sinhVienTrangChu() {
        return "sinhVien/trangChu";
    }

    @GetMapping("/doanhNghiep")
    public String doanhNhiepTrangChu() {
        return "doanhNghiep/trangChu";
    }
}
