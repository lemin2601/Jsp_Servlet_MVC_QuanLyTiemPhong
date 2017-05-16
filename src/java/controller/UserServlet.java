package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/User" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE_ERROR = "message";
	public static final String SESSION_USER = "user_session";

	private UserBO _DAO;

	public UserServlet() {
		super();
		_DAO = new UserBO();
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
		case "login"://xong
			Login(request, response);
			break;
		case "register"://xong
			Insert(request, response);
			break;
		case "view"://xong
			View(request, response);
			break;
		case "delete"://xong
			Delete(request, response);
			break;
		case "edit"://xong
			Update(request,response);
			break;
		case "logout":
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String check = request.getParameter("remember");

		User item = _DAO.CheckLogin(user, pass);
		if (_DAO.CheckUser(user) == null) {
			response.getWriter().write("user");
			return;
		} else if (item == null) {
			response.getWriter().write("pass");
			return;
		} else {
			// set cookie login
			// Create cookies for first and last names.
			Cookie cuser = new Cookie("username", user);
			Cookie cpass = new Cookie("password", pass);
			if (check != null) {
				// Set expiry date after 24 Hrs for both the cookies.
				cuser.setMaxAge(60 * 60 * 24);
				cpass.setMaxAge(60 * 60 * 24);
			} else {
				cuser.setMaxAge(0);
				cpass.setMaxAge(0);
			}
			response.addCookie(cuser);
			response.addCookie(cpass);
			// set Session Login
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_USER, item);
			// request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request,
			// response);
			response.getWriter().write("success");
			return;
		}
	}

	private void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("username");
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
//		String pass = request.getParameter("password");		
//		String pass2 = request.getParameter("password2");
		String strroles = request.getParameter("roles");
		int roles = Integer.parseInt(strroles);
		String strid = request.getParameter("idedit");
		System.out.println(roles);
		long id = Integer.parseInt(strid);
//		if (!pass.equals(pass2) || pass.equals("")) {
//			response.getWriter().write("pass");
//			return;
//		}
		if((roles)<0||(roles)>3){
			response.getWriter().write("roles");
			return;
		}
		if (!_DAO.getUser(id).getUsername().equals(user) && _DAO.CheckUser(user)!=null){
			response.getWriter().write("user");
			return;
		}
		User item = new User(id, user, "", first, last,roles );
		if (_DAO.editItem(item)> 0) {
			response.getWriter().write("success");
			System.out.println("thành công");
			return;
		}
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid = request.getParameter("id");
		long id = Integer.parseInt(strid);
		if (_DAO.deleteItem(id) > 0) {
			response.getWriter().write("success");
			return;
		} else {
			response.getWriter().write("failed");
			return;
		}
	}

	private void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String pass2 = request.getParameter("password2");
		System.out.println("vào đây"+user+"|"+pass+"|"+first);
		if (!pass.equals(pass2) || pass.equals("")) {
			response.getWriter().write("pass");
			return;
		}
		if (_DAO.CheckUser(user) != null) {
			response.getWriter().write("user");
			System.out.println("không công");
			return;
		}
		User item = new User(System.currentTimeMillis(), user, pass, first, last, 0);
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
		ArrayList<User> users = _DAO.getList((start*5)-5, 5,key);

		JSONObject json =new JSONObject();	
		json.put("total", total);		
		JSONObject data=new JSONObject();		
		for(User u:users){		
			JSONObject jObj = new JSONObject();
			jObj.put("id", u.getId());
			jObj.put("username", u.getUsername());
			jObj.put("firstname", u.getFirstname());
			jObj.put("lastname", u.getLastname());	
			jObj.put("roles", u.getRoles());			
			data.put(u.getId(),jObj);		
		}
		json.put("data", data);
		response.getWriter().write(json.toString());
		return;
	}

}
