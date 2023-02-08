package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel {
	
	private Connection connection = Orm.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    
    
    public boolean createOrder(int user_id, String login, ArrayList<ProductCart> cart) throws SQLException {
    	double total=0;
		StringBuilder ordersInsert = new StringBuilder("BEGIN;INSERT INTO orders (user_id, login,total) VALUES (?,?,?);INSERT INTO order_products (order_id, product_id, title, count, price) VALUES ");
		for (ProductCart product:cart) {
			ordersInsert.append("(LAST_INSERT_ID(), '");
			ordersInsert.append(product.getProductId());
			ordersInsert.append("', '");
			ordersInsert.append(product.getTitle());
			ordersInsert.append("', '");
			ordersInsert.append(product.getCount());
			ordersInsert.append("', '");
			ordersInsert.append(product.getPrice());
			ordersInsert.append("'),");
			total = total + (product.getPrice()*product.getCount());
		}
		
		ordersInsert.deleteCharAt(ordersInsert.length()-1);
		ordersInsert.append(";COMMIT;");
		
		preparedStatement = connection.prepareStatement(ordersInsert.toString());
		preparedStatement.setInt(1, user_id);
		preparedStatement.setString(2, login);
		preparedStatement.setDouble(3, total);
		if(preparedStatement.executeUpdate() > 0) {

			return true;
		}
    	return true;
    }

    public boolean updateOrder(int order_id, int status) throws SQLException {
		var select = "SELECT order_id FROM orders WHERE order_id=?";
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setInt(1, order_id);
		var data = preparedStatement.executeQuery();
		if(data.next()) {
			var update = "UPDATE orders SET status=? WHERE order_id=?";
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, status);
			preparedStatement.setInt(2, order_id);
			if(preparedStatement.executeUpdate() > 0) {
				data.close();
				return true;
			}
		}
		data.close();
    	return false;
    }
    
    public ArrayList<Order> getOrders(int limit, int offset) throws SQLException{
    	
    	var sql = "SELECT * FROM orders ORDER BY order_id DESC LIMIT ? OFFSET ?";
    	preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, limit);
		preparedStatement.setInt(2, offset);
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet data = preparedStatement.executeQuery();
        while (data.next()){
            Order order = new Order(
            data.getInt("order_id"),
            data.getInt("user_id"),
            data.getString("login"),
            data.getDate("date"),
            data.getInt("status"),
            data.getDouble("total"));
            orders.add(order);

        }
        data.close();
        return orders;

    }
    
    public ArrayList<Order> getOrders(int user_id, int limit, int offset) throws SQLException{
    	
    	var sql = "SELECT * FROM orders WHERE user_id=? ORDER BY order_id DESC LIMIT ? OFFSET ?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, user_id);
		preparedStatement.setInt(2, limit);
		preparedStatement.setInt(3, offset);
        ArrayList<Order> orders = new ArrayList<>();
        ResultSet data = preparedStatement.executeQuery();
        while (data.next()){
            Order order = new Order(
            data.getInt("order_id"),
            data.getInt("user_id"),
            data.getString("login"),
            data.getDate("date"),
            data.getInt("status"),
            data.getDouble("total"));
            orders.add(order);

        }
        data.close();
        return orders;

    }
    
    public ArrayList<OrderProduct> getOrderProducts(int order_id) throws SQLException{
    	
    	var sql = "SELECT orders.order_id, status, product_id,title, email, users.login, count, price FROM orders "
    			+ "INNER JOIN order_products ON orders.order_id=order_products.order_id "
    			+ "INNER JOIN users ON orders.user_id=users.user_id "
    			+ "WHERE orders.order_id=?";
    	preparedStatement = connection.prepareStatement(sql);
    	preparedStatement.setInt(1, order_id);
        ArrayList<OrderProduct> products = new ArrayList<>();
        ResultSet data = preparedStatement.executeQuery();
        while (data.next()){
        	OrderProduct product = new OrderProduct(
            data.getInt("order_id"),
            data.getInt("status"),
            data.getInt("product_id"),
            data.getString("title"),
            data.getString("email"),
            data.getString("login"),
            data.getInt("count"),
            data.getDouble("price"));
        	products.add(product);

        }
        data.close();
        return products;
    }
	  
    public int getMaxOrderID() throws SQLException {
    	var sql = "SELECT MAX(order_id) FROM orders";
    	preparedStatement = connection.prepareStatement(sql);
        ResultSet data = preparedStatement.executeQuery();
        if (data.next()){
        	
        	return data.getInt("MAX(order_id)");
        }
        data.close();
        return -1;
    }
}
