package com.example.uml.restcontrollers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.uml.entities.TaiKhoan;
import com.example.uml.services.DangNhapService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/dangnhap")
public class DangNhapRestController {
    @Autowired
    private DangNhapService dangNhapService;

    @PostMapping
    public ResponseEntity<Map<String, String>> dangNhap(@RequestBody TaiKhoanDto taiKhoanDto, Model model) {
        try {
            TaiKhoan taiKhoan = dangNhapService.dangNhap(taiKhoanDto);
            if (!taiKhoan.getTrangThai()) {
                Map<String, String> response = new HashMap<>();
                model.addAttribute("error", "Tài khoản của bạn đã bị vô hiệu hóa");
                return ResponseEntity.badRequest().body(response);
            }
            Map<String, String> response = new HashMap<>();
            response.put("message", "Đăng nhập thành công!");
            response.put("vaiTro", taiKhoan.getVaiTro());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Lỗi đăng nhập: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    public static class TaiKhoanDto {
        private String tenDangNhap;
        private String matKhau;

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
