package com.example.uml.repositories;

import com.example.uml.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
    boolean existsByMssv(String mssv); // Sửa từ existByMaSoSinhVien thành existsByMssv
    boolean existsByEmail(String email);
}