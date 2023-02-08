package controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ProductModel;



@WebServlet("/listing")
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ProductModel productModel = new ProductModel();
	
	          

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		var page =  request.getParameter("page");
		var limit = 4; 
		
		try {
			if (page!=null) {
			var offset = Integer.parseInt(page)*limit;
			var products = productModel.getProductsWithPage(limit,offset);
			HomePage.headerUpdate(request,response);
			
			request.setAttribute("page", page);
			request.setAttribute("products", products);
			request.getRequestDispatcher("WEB-INF/views/catalog.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
