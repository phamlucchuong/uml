package com.example.uml.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 25)
    @Column(unique = true)
    private String tenDangNhap;

    @NotNull
    @Size(max = 25)
    private String matKhau;

    @NotNull
    @Size(max = 20)
    @Column(columnDefinition = "NVARCHAR(20) CHECK (vaiTro IN ('SinhVien', 'DoanhNghiep', 'Admin'))")
    private String vaiTro;


    @Column(nullable = false)
    private Boolean trangThai;


    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean getTrangThai() {
        return trangThai;
    }
}