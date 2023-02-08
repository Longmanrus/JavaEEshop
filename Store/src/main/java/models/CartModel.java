package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartModel {
	
	private Connection connection = Orm.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    
	public ArrayList<ProductCart> getCart(int user_id) throws SQLException {
		
		var sql = "SELECT photo,title,price,user_id,count,products.product_id AS product_id " + 
		"FROM products INNER JOIN cart ON products.product_id=cart.product_id WHERE cart.user_id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,user_id);
		var data = preparedStatement.executeQuery();
		ArrayList<ProductCart> cart = new ArrayList<>();
		while(data.next()) {
			var product_id = data.getInt("product_id");
			var title = data.getString("title");
			var photo = data.getString("photo");
			var price = data.getDouble("price");
			var userId = data.getInt("user_id");
			var count = data.getInt("count");
			
			cart.add(new ProductCart(product_id,userId,count,title,photo,price));
		}
		return cart;
		
	}
	
	public boolean addToCart(int product_id, int user_id) throws SQLException{
		
		var sql = "select cart_id from cart where product_id=? and user_id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, product_id);
		preparedStatement.setInt(2, user_id);
		var data = preparedStatement.executeQuery();
		if(data.next()) {
			var update = "update cart set count=count+1 where product_id=? and user_id=?";
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, product_id);
			preparedStatement.setInt(2, user_id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		}else {
			var sqlInsert = "insert into cart(product_id,count, user_id) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sqlInsert);
			preparedStatement.setInt(1,product_id);
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, user_id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean cartUpdate(int user_id, int product_id, boolean IsToBeRemoved, int count) throws SQLException{
		if (IsToBeRemoved) {
			String deleteSQL = "DELETE FROM cart WHERE product_id=? AND user_id=?";
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, product_id);
			preparedStatement.setInt(2, user_id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		}
		if (!IsToBeRemoved) {
			String update = "update cart set count=? where product_id=? and user_id=?";
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, count);
			preparedStatement.setInt(2, product_id);
			preparedStatement.setInt(3, user_id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean cartClean(int user_id) throws SQLException{
		String deleteSQL = "DELETE FROM cart WHERE user_id=?";
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setInt(1, user_id);
		if(preparedStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
}
