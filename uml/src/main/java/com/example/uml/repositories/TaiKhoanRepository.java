package com.example.uml.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.uml.entities.TaiKhoan;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
    boolean existsByTenDangNhap(String tenDangNhap);
    boolean existsByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);
}
