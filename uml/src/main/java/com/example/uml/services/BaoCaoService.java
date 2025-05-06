package com.example.uml.services;

import com.example.uml.entities.DoanhNghiep;
import com.example.uml.repositories.BaoCaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoCaoService {

    @Autowired
    private BaoCaoRepository baoCaoRepository;

    public List<DoanhNghiep> getAllBaoCao() {
        return baoCaoRepository.findAll();
    }

    public long getBaoCaoCount() {
        return baoCaoRepository.count();
    }
}
