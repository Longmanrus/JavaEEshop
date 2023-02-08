package controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartModel;
import models.ProductCart;


@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final CartModel cartModel = new CartModel();
	          

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("user_id");

		try {
			if (userId!=null) {
				var cart = cartModel.getCart(userId);		
				request.setAttribute("cart", cart);
			}
			HomePage.headerUpdate(request,response);
			request.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		if (userId!=null) {
			ArrayList<String[]> arr = new ArrayList<>();
			for (Enumeration<String> product1 = request.getParameterNames(); product1.hasMoreElements();)
				arr.add(request.getParameterValues(product1.nextElement()));
				
			for (String[] strings : arr) {
				try {
					cartModel.cartUpdate(userId, Integer.parseInt(strings[0]), Boolean.parseBoolean(strings[1]), Integer.parseInt(strings[2]));
					
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}			
			}
		}
		doGet(request,response);
	}
	
	protected static void cartHeaderUpdate (HttpServletRequest request, int user_id) throws SQLException {
		var cart = cartModel.getCart(user_id);
		if (!cart.isEmpty()) {
			double totalCart=0;
			for (ProductCart product : cart) {
				totalCart = totalCart + (product.getPrice()*product.getCount());
			}
			request.setAttribute("cart", cart);
			request.setAttribute("totalCart", totalCart);
			request.getRequestDispatcher("WEB-INF/views/header.jsp");
		}
	}

}
