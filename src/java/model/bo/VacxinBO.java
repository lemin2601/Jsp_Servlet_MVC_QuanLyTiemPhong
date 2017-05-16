/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.util.ArrayList;
import model.bean.User;
import model.bean.Vacxin;
import model.dao.VacxinDAO;

/**
 *
 * @author Admin
 */
public class VacxinBO {

    private VacxinDAO _DAO;

    public VacxinBO() {
        _DAO = new VacxinDAO();
    }

    public int addItem(Vacxin item) {
        return _DAO.addItem(item);
    }

    public int editItem(Vacxin item) {
        return _DAO.editItem(item);
    }

    public int deleteItem(int item) {
        return _DAO.deleteItem(item);
    }

    public Vacxin CheckUser(String user) {
        return _DAO.getItem(user);
    }

    public User CheckLogin(User item) {
        return _DAO.getItem(item.getUsername(), item.getPassword());
    }

    public User CheckLogin(String user, String pass) {
        return _DAO.getItem(user, pass);
    }

    public ArrayList<User> getList() {
        return _DAO.getList();
    }

    public ArrayList<User> getList(long start, long num) {
        return _DAO.getList(start, num);
    }

    public ArrayList<Vacxin> getList(long start, long num, String key) {
        return _DAO.getList(start, num, key);
    }

    public long countItems() {
        return _DAO.countItems();
    }

    public long countItems(String key) {
        return _DAO.countItems(key);
    } 
    public Vacxin getUser(int id) {
        return _DAO.getItem(id);
    }

}
