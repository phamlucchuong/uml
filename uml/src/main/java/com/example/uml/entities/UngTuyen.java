// package com.example.uml.entities;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
// import java.time.LocalDate;

// @Entity
// @Table(name = "UngTuyen")
// public class UngTuyen {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @Column(name = "cv_file", nullable = false)
//     private String cvFile;

//     @Column(name = "ngay_nop", nullable = false)
//     private LocalDate ngayNop;

//     @Column(name = "trang_thai", nullable = false)
//     @Enumerated(EnumType.STRING)
//     private TrangThai trangThai;

//     @ManyToOne
//     @JoinColumn(name = "doanh_nghiep_id", nullable = false)
//     private DoanhNghiep doanhNghiep;

//     @ManyToOne
//     @JoinColumn(name = "sinh_vien_id", nullable = false)
//     private SinhVien sinhVien;

//     // Enum TrangThai
//     public enum TrangThai {
//         Pending, Approved, Rejected
//     }

//     // Getters and Setters
//     public Integer getId() {
//         return id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public SinhVien getSinhVien() {
//         return sinhVien;
//     }

//     public void setSinhVien(SinhVien sinhVien) {
//         this.sinhVien = sinhVien;
//     }

//     public DoanhNghiep getDoanhNghiep() {
//         return doanhNghiep;
//     }

//     public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
//         this.doanhNghiep = doanhNghiep;
//     }

//     public String getCvFile() {
//         return cvFile;
//     }

//     public void setCvFile(String cvFile) {
//         this.cvFile = cvFile;
//     }

//     public TrangThai getTrangThai() {
//         return trangThai;
//     }

//     public void setTrangThai(TrangThai trangThai) {
//         this.trangThai = trangThai;
//     }

//     public LocalDate getNgayNop() {
//         return ngayNop;
//     }

//     public void setNgayNop(LocalDate ngayNop) {
//         this.ngayNop = ngayNop;
//     }
// }