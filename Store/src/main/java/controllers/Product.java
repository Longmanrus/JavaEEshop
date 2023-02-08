package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartModel;
import models.Orm;
import models.ProductModel;


@WebServlet("/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ProductModel productModel = new ProductModel();
	private static final CartModel cartModel = new CartModel();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {
			var product_id = request.getParameter("product_id");
			if (product_id != null) {
				var product = productModel.getProductById(product_id);
				HomePage.headerUpdate(request,response);
				request.setAttribute("product", product);
				request.getRequestDispatcher("WEB-INF/views/productInfo.jsp").forward(request, response);
			}else {
				response.sendRedirect("/Store/listing?page=0");
			}		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("user_id");
	    
	    if (userId != null) {
			var productId = request.getParameter("id");
	    	if(productId != null) {
	    		try {
					if(cartModel.addToCart(Integer.parseInt(productId),userId)){
						response.getWriter().print("Товар добавлен в корзину");
					}else {
						response.getWriter().print("Ошибка при добавлении товара в корзину");
					}
				} catch (NumberFormatException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }else {
	    	response.getWriter().print("Войдите для добавления товара к корзину");;
	    }
	}
	

}

