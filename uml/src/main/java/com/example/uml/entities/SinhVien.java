package com.example.uml.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "SinhVien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "taiKhoanId", unique = true)
    private TaiKhoan taiKhoan;

    @NotNull
    @Size(max = 100)
    private String hoTen;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String mssv;

    @NotNull
    @Size(max = 50)
    private String truong;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @Size(max = 255)
    private String nguyenVong;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTruong() {
        return truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getTrangThai() {
        return this.taiKhoan.getTrangThai();
    }

    public void setTrangThai(boolean trangThai) {
        this.taiKhoan.setTrangThai(trangThai);
    }

    public String getNguyenVong() {
        return nguyenVong;
    }

    public void setNguyenVong(String nguyenVong) {
        this.nguyenVong = nguyenVong;
    }
}