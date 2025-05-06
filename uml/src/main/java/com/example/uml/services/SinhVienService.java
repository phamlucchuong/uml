package com.example.uml.services;

import com.example.uml.entities.SinhVien;
import com.example.uml.repositories.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public long getSinhVienCount() {
        return sinhVienRepository.count();
    }
}
