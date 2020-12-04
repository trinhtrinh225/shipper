package com.example.nhom6_6.Model;

public class DHShip {
    private String maKH,tenKh;
    private int iSDT;

    public DHShip() {
    }

    public DHShip(String maKH, String tenKh, int iSDT) {
        this.maKH = maKH;
        this.tenKh = tenKh;
        this.iSDT = iSDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public int getiSDT() {
        return iSDT;
    }

    public void setiSDT(int iSDT) {
        this.iSDT = iSDT;
    }

    @Override
    public String toString() {
        return "DHShip{" +
                "maKH='" + maKH + '\'' +
                ", tenKh='" + tenKh + '\'' +
                ", iSDT=" + iSDT +
                '}';
    }
}
