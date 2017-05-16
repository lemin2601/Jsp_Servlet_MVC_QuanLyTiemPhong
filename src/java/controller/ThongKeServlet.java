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
import model.bean.ThongKe;
import model.dao.ThongKeDAO;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ThongKeServlet", urlPatterns = {"/ThongKe"})
public class ThongKeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ThongKeDAO _DAO;

    public ThongKeServlet() {
        super();
        _DAO = new ThongKeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         View(request, response);
    }

    private void View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json.toString());
        return;
    }
}
