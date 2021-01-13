package com.example.nhom6_6.Model;

public class Acount  {
    String tendangnhap ,ten , matkhau,xacnhanmatkhau,sdt , position ;

    public Acount(String tendangnhap, String ten, String matkhau, String xacnhanmatkhau,  String sdt,String position) {
        this.tendangnhap = tendangnhap;
        this.ten = ten;
        this.matkhau = matkhau;
        this.xacnhanmatkhau = xacnhanmatkhau;
        this.sdt = sdt;
        this.position = position;
    }

    public Acount() {
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getXacnhanmatkhau() {
        return xacnhanmatkhau;
    }

    public void setXacnhanmatkhau(String xacnhanmatkhau) {
        this.xacnhanmatkhau = xacnhanmatkhau;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
