package models;

import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;


import models.validators.EmailValidator;
import models.validators.PasswordValidator;

public class test {
	public static void main(String[] args) throws SQLException {
		/*
		String password = "admin";
		String pwHash = BCrypt.hashpw(password,BCrypt.gensalt());
		
		System.out.println(pwHash);
		
		var validator = new PasswordValidator();
		System.out.println(validator.validate("Sacred!ыфвфыв1"));
		*/
		ProductModel productModel = new ProductModel();
		OrderModel orderModel = new OrderModel();
		CartModel cartModel = new CartModel();
		UserModel userModel = new UserModel();
		
		//System.out.println(orderModel.createOrder(1,userModel.getLoginById(1), cartModel.getCart(1)));
		//orderModel.createOrder(2,userModel.getLoginById(2), cartModel.getCart(2));
		

		
		//System.out.println(orderModel.getMaxOrderID());
		
		//System.out.println(productModel.getProductsWithPage(20,0));
		
		
	}
}
