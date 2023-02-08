package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Orm;
import models.UserModel;


@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final UserModel userModel = new UserModel();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			HomePage.headerUpdate(request,response);
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			if (userModel.verifyUser(email, password)) {
				if ((session.getAttribute("user_id")==null) || 
					((session.getAttribute("user_id"))!=
					(Integer) userModel.getUserId(email))) {
					var userId = userModel.getUserId(email);
					session.setAttribute("user_id", userId);
					session.setAttribute("access_rights", userModel.getUserRights(userId));
					response.sendRedirect("/Store/listing?page=0");
				}
			}else {
				if (session.getAttribute("user_id")!=null) {
					session.removeAttribute("user_id");
					session.removeAttribute("access_rights");
				}
				var errorLogin = "Неправильный логин или пароль!";
				HomePage.headerUpdate(request,response);
				request.setAttribute("errorLogin", errorLogin);
				request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		

		
		
		
	}
	
	

}
