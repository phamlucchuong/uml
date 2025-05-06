// package com.example.uml.entities;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
// import java.time.LocalDate;

// @Entity
// @Table(name = "BaoCao")
// public class BaoCao {
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
//     @Size(max = 200)
//     private String tieuDe;

//     @Column(columnDefinition = "NVARCHAR(MAX)")
//     private String noiDung;

//     @Size(max = 255)
//     private String tepFile;

//     @NotNull
//     private LocalDate ngayNop;

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

//     public String getTieuDe() {
//         return tieuDe;
//     }

//     public void setTieuDe(String tieuDe) {
//         this.tieuDe = tieuDe;
//     }

//     public String getNoiDung() {
//         return noiDung;
//     }

//     public void setNoiDung(String noiDung) {
//         this.noiDung = noiDung;
//     }

//     public String getTepFile() {
//         return tepFile;
//     }

//     public void setTepFile(String tepFile) {
//         this.tepFile = tepFile;
//     }

//     public LocalDate getNgayNop() {
//         return ngayNop;
//     }

//     public void setNgayNop(LocalDate ngayNop) {
//         this.ngayNop = ngayNop;
//     }
// }