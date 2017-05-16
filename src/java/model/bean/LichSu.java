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
public class LichSu {
    int maKH;
    String tenKH;
    String tenBenh;
    String maVacxin;
    String tenVacxin;
    int tongSoMui;

    @Override
    public String toString() {
        return "LichSu{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", tenBenh=" + tenBenh + ", maVacxin=" + maVacxin + ", tenVacxin=" + tenVacxin + ", tongSoMui=" + tongSoMui + '}';
    }

    public LichSu() {
    }

    public LichSu(int maKH, String tenKH, String tenBenh, String maVacxin, String tenVacxin, int tongSoMui) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenBenh = tenBenh;
        this.maVacxin = maVacxin;
        this.tenVacxin = tenVacxin;
        this.tongSoMui = tongSoMui;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public String getMaVacxin() {
        return maVacxin;
    }

    public void setMaVacxin(String maVacxin) {
        this.maVacxin = maVacxin;
    }

    public String getTenVacxin() {
        return tenVacxin;
    }

    public void setTenVacxin(String tenVacxin) {
        this.tenVacxin = tenVacxin;
    }

    public int getTongSoMui() {
        return tongSoMui;
    }

    public void setTongSoMui(int tongSoMui) {
        this.tongSoMui = tongSoMui;
    }
    
    
}
