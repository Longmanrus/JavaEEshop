package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Orm;
import models.UserModel;
import models.validators.EmailValidator;
import models.validators.LoginValidator;
import models.validators.PasswordValidator;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	
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
		String login = request.getParameter("login");
		String password1 = request.getParameter("passwordFirst");
		String password2 = request.getParameter("passwordSecond");
		var checkEm = new EmailValidator();
		var checkLg = new LoginValidator();
		var checkPw = new PasswordValidator();
		
		if (checkEm.validate(email) &&
			checkLg.validate(login) &&
			checkPw.validate(password1) &&
			checkPw.validate(password2) &&
			password1.equals(password2)){
			
			try {
				userModel.addNewUser(email,login,password1);
				if ((session.getAttribute("user_id")==null) || 
						((session.getAttribute("user_id"))!=
						(Integer) userModel.getUserId(email))) {
						
						session.setAttribute("user_id", userModel.getUserId(email));
						response.sendRedirect("/Store/listing?page=0");
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errorReg", "Такой пользователь уже существует");
				request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			}
		}else {
			try {
				HomePage.headerUpdate(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("errorReg", "Ошибка заполнения формы...");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}
		
	
	}
	
	

}
