package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel {
	
	private Connection connection = Orm.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    
    public ArrayList<Product> getProducts() throws SQLException {
    	String sql = "SELECT * FROM products";
    	preparedStatement = connection.prepareStatement(sql);
        ArrayList<Product> products = new ArrayList<>();
        ResultSet data = preparedStatement.executeQuery(sql);
        while (data.next()){
            Product product = new Product(
            data.getInt("product_id"),
            data.getString("title"),
            data.getString("info"),
            data.getString("photo"),
            data.getDouble("price"));
            products.add(product);

        }
        data.close();
        return products;
    }
    
    public ArrayList<Product> getProductsWithPage(int limit, int offset) throws SQLException {
    	String sql = "SELECT * FROM products LIMIT ? OFFSET ?";
    	preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, limit);
		preparedStatement.setInt(2, offset);
        ArrayList<Product> products = new ArrayList<>();
        ResultSet data = preparedStatement.executeQuery();
        while (data.next()){
            Product product = new Product(
            data.getInt("product_id"),
            data.getString("title"),
            data.getString("info"),
            data.getString("photo"),
            data.getDouble("price"));
            products.add(product);

        }
        data.close();
        return products;
    }
    
    public Product getProductById(String id) throws SQLException {
    	return new ProductModel().
	    			getProducts().
	    			stream().
	    			filter(item -> item.getId() == Integer.parseInt(id)).
	    			findFirst().
	    			get();
    }

}
