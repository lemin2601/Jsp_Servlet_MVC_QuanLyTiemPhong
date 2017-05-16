/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Admin
 */
public class ThongKe {
    int MaKH;
    String tenKH;
    double tongTien;

    public ThongKe(int MaKH, String tenKH, double tongTien) {
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.tongTien = tongTien;
    }

    public ThongKe() {
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "MaKH=" + MaKH + ", tenKH=" + tenKH + ", tongTien=" + tongTien + '}';
    }
    
}
