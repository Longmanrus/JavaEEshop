package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartModel;
import models.OrderModel;
import models.ProductCart;
import models.UserModel;


@WebServlet("/checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final CartModel cartModel = new CartModel();
	private static final OrderModel orderModel = new OrderModel();
	private static final UserModel userModel = new UserModel();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		
		if (userId!=null) {
			try {
				ArrayList<ProductCart> cart = cartModel.getCart(userId);
				if (!cart.isEmpty()) {
					
					orderModel.createOrder(userId, userModel.getLoginById(userId), cart); 
					cartModel.cartClean(userId);
					response.sendRedirect("/Store/invoice?order_id="+orderModel.getMaxOrderID());
					
				}else {
					response.sendRedirect("/Store/cart");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
