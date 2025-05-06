package com.example.uml.restcontrollers;

import com.example.uml.entities.DoanhNghiep;
import com.example.uml.entities.SinhVien;
import com.example.uml.repositories.BaoCaoRepository;
import com.example.uml.services.BaoCaoService;
import com.example.uml.services.DoanhNghiepService;
import com.example.uml.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private DoanhNghiepService doanhNghiepService;

    @Autowired
    private BaoCaoService baoCaoService;

    @GetMapping("/sinhVienList")
    public ResponseEntity<List<SinhVien>> getAllSinhVien() {
        List<SinhVien> sinhViens = sinhVienService.getAllSinhVien();
        return ResponseEntity.ok(sinhViens);
    }

    @GetMapping("/congTyList")
    public ResponseEntity<List<DoanhNghiep>> getAllCongTy() {
        List<DoanhNghiep> doanhNghieps = doanhNghiepService.getAllDoanhNghiep();
        return ResponseEntity.ok(doanhNghieps);
    }

    @GetMapping("/thongKe")
    public ResponseEntity<Map<String, Long>> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("sinhVienCount", sinhVienService.getSinhVienCount());
        stats.put("doanhNghiepCount", doanhNghiepService.getDoanhNghiepCount());
        stats.put("baoCaoCount", baoCaoService.getBaoCaoCount());
        return ResponseEntity.ok(stats);
    }
}