package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderModel;
import models.OrderProduct;


@WebServlet("/invoice")
public class Invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final OrderModel orderModel = new OrderModel();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		var orderId =  request.getParameter("order_id");
		double total=0;
		if (userId!=null) {
			try {
				if (orderId!=null) {
					
				var orderProducts = orderModel.getOrderProducts(Integer.parseInt(orderId));
				for (OrderProduct product:orderProducts) {
					total = total + (product.getPrice()*product.getCount());
				}
				HomePage.headerUpdate(request,response);
				request.setAttribute("total", total);
				request.setAttribute("orderProducts", orderProducts);
				request.getRequestDispatcher("WEB-INF/views/invoice.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("/Store/index");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		doGet(request, response);
	}

}
