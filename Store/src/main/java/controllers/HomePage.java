package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ProductModel;
import models.UserModel;


@WebServlet("/index")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final UserModel userModel = new UserModel();
	private static final ProductModel productModel = new ProductModel();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			HomePage.headerUpdate(request,response);
			var products = productModel.getProductsWithPage(5,0);
			request.setAttribute("products", products);
			request.getRequestDispatcher("WEB-INF/views/content.jsp");
			request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected static void headerUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException {	
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		Boolean alreadyLogon;
		//System.out.println(userId);
		if (userId!=null) {
			var name = "Добро пожаловать, " + userModel.getLoginById(Integer.parseInt(session.getAttribute("user_id").toString()));
			alreadyLogon=true;
			request.setAttribute("name", name);
			Cart.cartHeaderUpdate(request,userId);
			
		}else {
			alreadyLogon=false;
		}
			
		request.setAttribute("alreadyLogon", alreadyLogon);
		request.getRequestDispatcher("WEB-INF/views/header.jsp");
		
	}
	
}
