package com.example.uml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uml.entities.DoanhNghiep;

@Repository
public interface DoanhNghiepRepository extends JpaRepository<DoanhNghiep, Integer> {
    boolean existsByEmail(String email);
}