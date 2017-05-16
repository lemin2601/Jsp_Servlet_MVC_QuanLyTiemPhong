/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.DBConnect;
import model.bean.LichSu;
import model.bean.User;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
public class LichSuDAO {
    
    
    
    public ArrayList<LichSu> getList() {
        ArrayList<LichSu> result = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT khachhang.MaKH,khachhang.HoTenKH,benh.TenBenh,vacxin.MaVacxin,vacxin.TenVacxin,vacxin.SoMui FROM lichsutiemphong LEFT JOIN khachhang ON khachhang.MaKH = lichsutiemphong.MaKH LEFT JOIN vacxin ON vacxin.MaVacxin = lichsutiemphong.MaVacxin LEFT JOIN phongbenh ON vacxin.MaVacxin = phongbenh.MaVacxin LEFT JOIN benh ON benh.MaBenh = phongbenh.MaBenh";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LichSu item = new LichSu();
                item.setMaKH(rs.getInt("MaKH"));
                item.setMaVacxin(rs.getString("MaVacxin"));
                item.setTenBenh(rs.getString("TenBenh"));
                item.setTenKH(rs.getString("HoTenKH"));
                item.setTenVacxin(rs.getString("TenVacxin"));
                item.setTongSoMui(rs.getInt("SoMui"));
                result.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args) {
       LichSuDAO _DAO = new LichSuDAO();
        long total = _DAO.countItems();
        ArrayList<LichSu> items = _DAO.getList();
        JSONObject json = new JSONObject();
        json.put("total", total);
        JSONObject data = new JSONObject();
        int index = 0;
        for (LichSu item : items) {
            JSONObject jObj = new JSONObject();
            jObj.put("makh", item.getMaKH());
            jObj.put("mavacxin", item.getMaVacxin());
            jObj.put("tenbenh", item.getTenBenh());
            jObj.put("tenkh", item.getTenKH());
            jObj.put("tenvacxin", item.getTenVacxin());
            jObj.put("tongsomui", item.getTongSoMui());
            data.put(index ++, jObj);
        }
        json.put("data", data);
        System.out.println(json.toString());
    }

    public long countItems( ) {
        long result = -1;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT COUNT(*) FROM lichsutiemphong LEFT JOIN khachhang ON khachhang.MaKH = lichsutiemphong.MaKH LEFT JOIN vacxin ON vacxin.MaVacxin = lichsutiemphong.MaVacxin LEFT JOIN phongbenh ON vacxin.MaVacxin = phongbenh.MaVacxin LEFT JOIN benh ON benh.MaBenh = phongbenh.MaBenh";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
}
