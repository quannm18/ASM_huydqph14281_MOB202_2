package com.example.asm_huydqph14281_mob202_2.model;

import java.util.Date;

public class GiaoDich {
    private int maGd;
    private  String tieuDe;
    private Date ngay;
    private double tien;
    private String moTa;
    private int maLoai;

    public GiaoDich(int maGd, String tieuDe, Date ngay, double tien, String moTa, int maLoai) {
        this.maGd = maGd;
        this.tieuDe = tieuDe;
        this.ngay = ngay;
        this.tien = tien;
        this.moTa = moTa;
        this.maLoai = maLoai;
    }

    public int getMaGd() {
        return maGd;
    }

    public void setMaGd(int maGd) {
        this.maGd = maGd;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
}
