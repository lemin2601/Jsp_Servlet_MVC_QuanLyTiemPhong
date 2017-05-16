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
import model.bean.LichSu;
import model.dao.LichSuDAO;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LichSuServlet", urlPatterns = {"/LichSuTiemPhong"})
public class LichSuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE_ERROR = "message";
    public static final String SESSION_USER = "user_session";

    private LichSuDAO _DAO;

    public LichSuServlet() {
        super();
        _DAO = new LichSuDAO();
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
            case "view"://
                
                View(request, response);       
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }

    }

    private void View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        long start = Long.parseLong(page);

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
        response.getWriter().write(json.toString());
        return;
    }

}
