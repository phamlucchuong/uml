package com.example.uml.services;

import com.example.uml.entities.DoanhNghiep;
import com.example.uml.repositories.DoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoanhNghiepService {

    @Autowired
    private DoanhNghiepRepository doanhNghiepRepository;

    public List<DoanhNghiep> getAllDoanhNghiep() {
        return doanhNghiepRepository.findAll();
    }

    public long getDoanhNghiepCount() {
        return doanhNghiepRepository.count();
    }
}
