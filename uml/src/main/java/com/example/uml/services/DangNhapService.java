package com.example.uml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uml.entities.TaiKhoan;
import com.example.uml.repositories.TaiKhoanRepository;
import com.example.uml.restcontrollers.DangNhapRestController.TaiKhoanDto;

import jakarta.transaction.Transactional;

@Service
public class DangNhapService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Transactional
    public TaiKhoan dangNhap(TaiKhoanDto taiKhoanDto) throws Exception {
        // Find account by username
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(taiKhoanDto.getTenDangNhap())
                .orElseThrow(() -> new Exception("Tên đăng nhập không tồn tại!"));

        // Verify password (plain text comparison)
        if (!taiKhoan.getMatKhau().equals(taiKhoanDto.getMatKhau())) {
            throw new Exception("Mật khẩu không đúng!");
        }

        return taiKhoan;
    }

}
