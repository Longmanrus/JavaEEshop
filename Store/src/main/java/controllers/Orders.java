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
import models.UserModel;


@WebServlet("/orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final OrderModel orderModel = new OrderModel();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		Integer rights = (Integer) session.getAttribute("access_rights");

		if (userId!=null) {
			var page =  request.getParameter("page");
			var limit = 6; 
			try {
			
			if (rights==3) {
				if (page!=null) {
				var offset = Integer.parseInt(page)*limit;
				var orders = orderModel.getOrders(limit,offset);
				HomePage.headerUpdate(request,response);
				
				request.setAttribute("rights", rights);
				request.setAttribute("page", page);
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request, response);
				}
				
			}else {

				if (page!=null) {
				var offset = Integer.parseInt(page)*limit;
				var orders = orderModel.getOrders(userId,limit,offset);
				HomePage.headerUpdate(request,response);
				
				request.setAttribute("page", page);
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("WEB-INF/views/orders.jsp").forward(request, response);
				}
			}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}else {
			response.sendRedirect("/Store/index");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("user_id");
		Integer rights = (Integer) session.getAttribute("access_rights");
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		if (null !=userId || rights==3) {
			if (null != id || null != state) {
				try {
					orderModel.updateOrder(Integer.parseInt(id),Integer.parseInt(state));
					response.getWriter().print("Изменения сохранены");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.getWriter().print("Ошибка изменения статуса заказа");
			}
		}else {
			response.sendRedirect("/Store/index");
		}
		
		
	}

}
