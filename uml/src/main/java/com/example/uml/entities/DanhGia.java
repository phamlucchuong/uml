// package com.example.uml.entities;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
// import java.time.LocalDate;

// @Entity
// @Table(name = "DanhGia")
// public class DanhGia {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @NotNull
//     @ManyToOne
//     @JoinColumn(name = "sinhVienId")
//     private SinhVien sinhVien;

//     @NotNull
//     @ManyToOne
//     @JoinColumn(name = "thucTapId")
//     private ThucTap thucTap;

//     @NotNull
//     @ManyToOne
//     @JoinColumn(name = "doanhNghiepId")
//     private DoanhNghiep doanhNghiep;

//     @Min(0)
//     @Max(10)
//     private Float diem;

//     @Column(columnDefinition = "NVARCHAR(MAX)")
//     private String nhanXet;

//     @NotNull
//     private LocalDate ngayDanhGia;

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

//     public ThucTap getThucTap() {
//         return thucTap;
//     }

//     public void setThucTap(ThucTap thucTap) {
//         this.thucTap = thucTap;
//     }

//     public DoanhNghiep getDoanhNghiep() {
//         return doanhNghiep;
//     }

//     public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
//         this.doanhNghiep = doanhNghiep;
//     }

//     public Float getDiem() {
//         return diem;
//     }

//     public void setDiem(Float diem) {
//         this.diem = diem;
//     }

//     public String getNhanXet() {
//         return nhanXet;
//     }

//     public void setNhanXet(String nhanXet) {
//         this.nhanXet = nhanXet;
//     }

//     public LocalDate getNgayDanhGia() {
//         return ngayDanhGia;
//     }

//     public void setNgayDanhGia(LocalDate ngayDanhGia) {
//         this.ngayDanhGia = ngayDanhGia;
//     }
// }