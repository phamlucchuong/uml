package com.example.uml.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.uml.entities.TaiKhoan;
import com.example.uml.repositories.TaiKhoanRepository;


@Controller
public class TaiKhoanController {

    @Autowired
    private TaiKhoanRepository taiKhoanRepo;

    @PostMapping("/dangKy")
    public String xuLyDangKy(@RequestParam String tenDangNhap,
                             @RequestParam String matKhau,
                             @RequestParam String xacNhanMatKhau,
                             Model model) {

        // Kiểm tra rỗng
        if (tenDangNhap.isBlank() || matKhau.isBlank() || xacNhanMatKhau.isBlank()) {
            model.addAttribute("error", "Vui lòng điền đầy đủ thông tin.");
            return "dangKy";
        }

        // Kiểm tra tên đăng nhập tồn tại
        if (taiKhoanRepo.existsByTenDangNhap(tenDangNhap)) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại.");
            return "dangKy";
        }

        // Kiểm tra độ dài tên đăng nhập
        // if (tenDangNhap.length() < 6) {
        //     model.addAttribute("error", "Tên đăng nhập phải ít nhất 6 ký tự.");
        //     return "dangKy";
        // }

        // // Kiểm tra mật khẩu hợp lệ
        // if (!matKhau.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{7,}$")) {
        //     model.addAttribute("error", "Mật khẩu phải trên 6 ký tự và có cả chữ lẫn số.");
        //     return "dangKy";
        // }

        // Kiểm tra khớp mật khẩu
        if (!matKhau.equals(xacNhanMatKhau)) {
            model.addAttribute("error", "Mật khẩu xác nhận không khớp.");
            return "dangKy";
        }

        // ✅ Lưu vào DB
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(tenDangNhap);
        tk.setMatKhau(matKhau); // ❗Nên mã hóa trong thực tế
        taiKhoanRepo.save(tk);

        // Chuyển hướng hoặc thông báo thành công
        return "redirect:/dangNhap";
    }


    @PostMapping("/dangNhap")
    public ResponseEntity<String> dangNhap(@RequestParam String tenDangNhap, @RequestParam String matKhau) {
        System.out.println("Đăng nhập: " + tenDangNhap + " / " + matKhau);

        if (taiKhoanRepo.existsByTenDangNhapAndMatKhau(tenDangNhap, matKhau)) {
            return ResponseEntity.ok("Đăng nhập thành công!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai tên đăng nhập hoặc mật khẩu");
        }
    }

}
