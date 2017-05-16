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
public class Vacxin {
    private int maVacxin;
    private String tenVacxin;
    private String tenHang;
    private String moTa;
    private int soMui;
    private double giaVacxin;

    public Vacxin() {
    }

    @Override
    public String toString() {
        return "Vacxin{" + "maVacxin=" + maVacxin + ", tenVacxin=" + tenVacxin + ", tenHang=" + tenHang + ", moTa=" + moTa + ", soMui=" + soMui + ", giaVacxin=" + giaVacxin + '}';
    }

    public int getMaVacxin() {
        return maVacxin;
    }

    public void setMaVacxin(int maVacxin) {
        this.maVacxin = maVacxin;
    }

    public String getTenVacxin() {
        return tenVacxin;
    }

    public void setTenVacxin(String tenVacxin) {
        this.tenVacxin = tenVacxin;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoMui() {
        return soMui;
    }

    public void setSoMui(int soMui) {
        this.soMui = soMui;
    }

    public double getGiaVacxin() {
        return giaVacxin;
    }

    public void setGiaVacxin(double giaVacxin) {
        this.giaVacxin = giaVacxin;
    }

    public Vacxin(int maVacxin, String tenVacxin, String tenHang, String moTa, int soMui, double giaVacxin) {
        this.maVacxin = maVacxin;
        this.tenVacxin = tenVacxin;
        this.tenHang = tenHang;
        this.moTa = moTa;
        this.soMui = soMui;
        this.giaVacxin = giaVacxin;
    }

}
