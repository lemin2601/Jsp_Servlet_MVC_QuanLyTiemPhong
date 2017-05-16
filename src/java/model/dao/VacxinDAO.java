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
import model.bean.User;
import model.bean.Vacxin;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
public class VacxinDAO {

    private static final String TABLE_NAME = "vacxin";
    private static final String COL_MAVACXIN = "MaVacxin";
    private static final String COL_TENVACXIN = "TenVacxin";
    private static final String COL_SOMUI = "SoMui";
    private static final String COL_MOTA = "MoTa";
    private static final String COL_GIAVACXIN = "GiaVacxin";
    private static final String COL_TENHANG = "TenHang";

    public int addItem(Vacxin item) {
        int result = 0;
        String sql = "INSERT INTO " + TABLE_NAME + "(" + COL_GIAVACXIN + "," + COL_MOTA + "," + COL_SOMUI + ","
                + COL_TENHANG + "," + COL_TENVACXIN + ") VALUES ( ?, ?, ?, ?, ?)";
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             ps.setDouble(1,item.getGiaVacxin());
             ps.setString(2,item.getMoTa());
             ps.setInt(3,item.getSoMui());
             ps.setString(4,item.getTenHang());
             ps.setString(5,item.getTenVacxin());
            
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
//                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    public int editItem(Vacxin item) {
        int result = 0;
        String sql = "UPDATE " + TABLE_NAME + " SET " + 
                COL_GIAVACXIN + " = ?, " +
                COL_MOTA + " = ?, " + 
                COL_SOMUI + " = ?, " + 
                COL_TENHANG + " = ?, " + 
                COL_TENVACXIN + " = ? " + 
                "WHERE " + COL_MAVACXIN + " = ?";
        Connection connection = DBConnect.getConnection();
        System.out.println(sql);
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, item.getGiaVacxin());
            ps.setString(2, item.getMoTa());
            ps.setInt(3, item.getSoMui());
            ps.setString(4, item.getTenHang());
            ps.setString(5, item.getTenVacxin());
            ps.setInt(6, item.getMaVacxin());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int deleteItem(Vacxin item) {
        int result = 0;
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_MAVACXIN + " = ?";
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, item.getMaVacxin());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int deleteItem(long item) {
        int result = 0;
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_MAVACXIN + " = ?";
        Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, item);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<User> getList() {
        ArrayList<User> result = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User item = new User();
                item.setId(rs.getLong(COL_MAVACXIN));
                item.setUsername(rs.getString(COL_TENVACXIN));
                item.setPassword(rs.getString(COL_SOMUI));
                item.setFirstname(rs.getString(COL_MOTA));
                item.setLastname(rs.getString(COL_GIAVACXIN));
                item.setRoles(rs.getInt(COL_TENHANG));
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

    public ArrayList<User> getList(long start, long num) {
        ArrayList<User> result = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME + " LIMIT ?,?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, start);
            ps.setLong(2, num);

            rs = ps.executeQuery();
            while (rs.next()) {
                User item = new User();
                item.setId(rs.getLong(COL_MAVACXIN));
                item.setUsername(rs.getString(COL_TENVACXIN));
                item.setPassword(rs.getString(COL_SOMUI));
                item.setFirstname(rs.getString(COL_MOTA));
                item.setLastname(rs.getString(COL_GIAVACXIN));
                item.setRoles(rs.getInt(COL_TENHANG));
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

    public ArrayList<Vacxin> getList(long start, long num, String key) {
        ArrayList<Vacxin> result = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE "
                + COL_TENVACXIN + " like ? OR "
                + COL_MOTA + " like ? OR "
                + COL_GIAVACXIN + " like ? LIMIT ?,?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setLong(4, start);
            ps.setLong(5, num);

            rs = ps.executeQuery();
            while (rs.next()) {
                Vacxin item = new Vacxin();
                item.setGiaVacxin(rs.getLong(COL_GIAVACXIN));
                item.setMaVacxin(rs.getInt(COL_MAVACXIN));
                item.setMoTa(rs.getString(COL_MOTA));
                item.setSoMui(rs.getInt(COL_SOMUI));
                item.setTenHang(rs.getString(COL_TENHANG));
                item.setTenVacxin(rs.getString(COL_TENVACXIN));

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

    public Vacxin getItem(int id) {
        Vacxin item = null;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_MAVACXIN + " = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new Vacxin();
                item.setGiaVacxin(rs.getLong(COL_GIAVACXIN));
                item.setMaVacxin(rs.getInt(COL_MAVACXIN));
                item.setMoTa(rs.getString(COL_MOTA));
                item.setSoMui(rs.getInt(COL_SOMUI));
                item.setTenHang(rs.getString(COL_TENHANG));
                item.setTenVacxin(rs.getString(COL_TENVACXIN));
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
        return item;
    }

    public User getItem(String user, String pass) {
        User item = null;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TENVACXIN + "=? AND " + COL_SOMUI + "=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new User();
                item.setId(rs.getLong(COL_MAVACXIN));
                item.setUsername(rs.getString(COL_TENVACXIN));
                item.setPassword(rs.getString(COL_SOMUI));
                item.setFirstname(rs.getString(COL_MOTA));
                item.setLastname(rs.getString(COL_GIAVACXIN));
                item.setRoles(rs.getInt(COL_TENHANG));
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
        return item;
    }

    public Vacxin getItem(String user) {
        Vacxin item = null;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TENVACXIN + "= ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                item = new Vacxin();
                item.setGiaVacxin(rs.getLong(COL_GIAVACXIN));
                item.setMaVacxin(rs.getInt(COL_MAVACXIN));
                item.setMoTa(rs.getString(COL_MOTA));
                item.setSoMui(rs.getInt(COL_SOMUI));
                item.setTenHang(rs.getString(COL_TENHANG));
                item.setTenVacxin(rs.getString(COL_TENVACXIN));
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
        return item;
    }

    public long countItems() {
        long result = -1;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT count(*) FROM " + TABLE_NAME;
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

    public long countItems(String key) {
        long result = -1;
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT count(*) FROM " + TABLE_NAME + " WHERE "
                + COL_TENVACXIN + " like ? OR "
                + COL_MOTA + " like ? OR "
                + COL_GIAVACXIN + " like ?";;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");

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

    public static void main(String[] args) {
        ArrayList<Vacxin> Vacxins = new VacxinDAO().getList(0, 6, "");
        JSONObject json = new JSONObject();
        //json.put("total", total);		
        JSONObject data = new JSONObject();
        for (Vacxin u : Vacxins) {
            JSONObject jObj = new JSONObject();
            jObj.put("mavacxin", u.getMaVacxin());
            jObj.put("tenvacxin", u.getTenVacxin());
            jObj.put("mota", u.getMoTa());
            jObj.put("giavacxin", u.getGiaVacxin());
            jObj.put("somui", u.getSoMui());
            jObj.put("tenhang", u.getTenHang());
            data.put(u.getMaVacxin(), jObj);
        }
        json.put("data", data);
        System.out.println(json.toString());
        
        
        String tenvacxin = "ABC";
        String giavacxin = "100";
        String mota = "Môt rả";
        String tenhang = "sdfsdf";
        String somui ="2";
        String strid = "124";
        int id =Integer.parseInt(strid);
        Vacxin item = new Vacxin();
        item.setMaVacxin(id);
        item.setGiaVacxin(Integer.parseInt(giavacxin));
        item.setMoTa(mota);
        item.setSoMui(Integer.parseInt(somui));
        item.setTenHang(tenhang);
        item.setTenVacxin(tenvacxin);
        if (new VacxinDAO().editItem(item) > 0) {
            System.out.println("good");
        }else{
            System.out.println("!good");
            return;
        }
    }
}
