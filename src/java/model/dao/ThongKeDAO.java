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
import model.bean.ThongKe;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {

    public ArrayList<ThongKe> getList() {
        ArrayList<ThongKe> result = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT khachhang.MaKH, khachhang.HoTenKH,SUM( vacxin.GiaVacxin* lichsutiemphong.SoTTMui) AS SoTien \n"
                + "FROM lichsutiemphong \n"
                + "LEFT JOIN khachhang ON khachhang.MaKH = lichsutiemphong.MaKH \n"
                + "LEFT JOIN vacxin ON lichsutiemphong.MaVacxin = vacxin.MaVacxin\n"
                + "GROUP BY khachhang.MaKH\n"
                + "ORDER BY SoTien ASC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe item = new ThongKe();
                item.setMaKH(rs.getInt("MaKH"));
                item.setTenKH(rs.getString("HoTenKH"));
                item.setTongTien(rs.getLong("SoTien"));
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
        ThongKeDAO _DAO = new ThongKeDAO();
        ArrayList<ThongKe> items = _DAO.getList();
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();
        int index = 0;
        for (ThongKe item : items) {
            JSONObject jObj = new JSONObject();
            jObj.put("makh", item.getMaKH());
            jObj.put("tenkh", item.getTenKH());
            jObj.put("sotien", item.getTongTien());
            data.put(index++, jObj);
        }
        json.put("data", data);
        System.out.println(json.toString());
    }
}
