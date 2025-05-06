package com.example.uml.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.uml.repositories.SinhVienRepository;


@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienRestController {
    @Autowired
    private SinhVienRepository sinhVienRepo;

    @PostMapping("/suaSinhVien")
    public String themSinhVien(@RequestParam String mssv) {
        
        return "themSinhVien";
    }
    
}
