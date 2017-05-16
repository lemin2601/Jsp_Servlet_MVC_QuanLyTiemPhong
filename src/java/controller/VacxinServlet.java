/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.User;
import model.bean.Vacxin;
import model.bo.VacxinBO;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "VacxinServlet", urlPatterns = {"/Vacxin"})
public class VacxinServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE_ERROR = "message";
    public static final String SESSION_USER = "user_session";

    private VacxinBO _DAO;

    public VacxinServlet() {
        super();
        _DAO = new VacxinBO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        switch (command) {
            case "register"://
                Insert(request, response);
                break;
            case "view"://
                View(request, response);
                break;
            case "delete"://
                Delete(request, response);
                break;
            case "edit"://
                Update(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }

    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tenvacxin = request.getParameter("tenvacxin");
        String giavacxin = request.getParameter("giavacxin");
        String mota = request.getParameter("mota");
        String tenhang = request.getParameter("tenhang");
        String somui = request.getParameter("somui");
        String strid = request.getParameter("id");
        int id =Integer.parseInt(strid);
        Vacxin item = new Vacxin();
        item.setMaVacxin(id);
        item.setGiaVacxin(Integer.parseInt(giavacxin));
        item.setMoTa(mota);
        item.setSoMui(Integer.parseInt(somui));
        item.setTenHang(tenhang);
        item.setTenVacxin(tenvacxin);
//      kiểm tra        
//        response.getWriter().write(item.toString());
//        return;
//        if (!_DAO.getUser(id).getTenVacxin().equals(tenvacxin) && _DAO.CheckUser(tenvacxin) != null) {
//            response.getWriter().write("failed");
//            return;
//        }
        if (_DAO.editItem(item) > 0) {
            response.getWriter().write("success");
            return;
        }else{
            response.getWriter().write("failed");
            return;
        }
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strid = request.getParameter("id");
        int id = Integer.parseInt(strid);
        if (_DAO.deleteItem(id) > 0) {
            response.getWriter().write("success");
            return;
        } else {
            response.getWriter().write("failed");
            return;
        }
    }

    private void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenvacxin = request.getParameter("tenvacxin");
        String giavacxin = request.getParameter("giavacxin");
        String mota = request.getParameter("mota");
        String tenhang = request.getParameter("tenhang");
        String somui = request.getParameter("somui");

        Vacxin item = new Vacxin();
        item.setGiaVacxin(Integer.parseInt(giavacxin));
        item.setMaVacxin(0);
        item.setMoTa(mota);
        item.setSoMui(Integer.parseInt(somui));
        item.setTenHang(tenhang);
        item.setTenVacxin(tenvacxin);
        // kiểm tra        
//      response.getWriter().write(item.toString());
//      return;
        if (_DAO.CheckUser(tenvacxin) != null) {
            response.getWriter().write("falied");
            System.out.println("không công");
            return;
        }
        if (_DAO.addItem(item) > 0) {
            response.getWriter().write("success");
            System.out.println("thành công");
            return;
        }
    }

    private void View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        long start = Long.parseLong(page);

        String key = request.getParameter("key");
        long total = _DAO.countItems(key);
        ArrayList<Vacxin> users = _DAO.getList((start * 5) - 5, 5, key);

        JSONObject json = new JSONObject();
        json.put("total", total);
        JSONObject data = new JSONObject();
        for (Vacxin u : users) {
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
        response.getWriter().write(json.toString());
        return;
    }

}
