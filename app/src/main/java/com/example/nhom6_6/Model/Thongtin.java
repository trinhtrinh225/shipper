package com.example.nhom6_6.Model;

import android.media.Image;

import java.util.HashMap;
import java.util.Map;

public class Thongtin {
   private String sMa;
   private String sTen;
   private double dGia;
   private String sMota;

    public Thongtin(String sMa, String sTen, double dGia, String sMota) {
        this.sMa = sMa;
        this.sTen = sTen;
        this.dGia = dGia;
        this.sMota = sMota;
    }

    public Map toMap(){
        Map thongtin = new HashMap();
        thongtin.put("productId",this.sMa);
        thongtin.put("productCategory",this.sTen);
        thongtin.put("productPrice",this.dGia);
        thongtin.put("productDescription",this.sMota);
        return thongtin;
    }
    public void setsMa(String sMa) {
        this.sMa = sMa;
    }

    public void setsTen(String sTen) {
        this.sTen = sTen;
    }

    public void setdGia(double dGia) {
        this.dGia = dGia;
    }

    public void setsMota(String sMota) {
        this.sMota = sMota;
    }

    public String getsMa() {
        return sMa;
    }

    public String getsTen() {
        return sTen;
    }

    public double getdGia() {
        return dGia;
    }

    public String getsMota() {
        return sMota;
    }
}
