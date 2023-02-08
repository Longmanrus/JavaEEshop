package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.mindrot.jbcrypt.BCrypt;

public class UserModel {
	
	private Connection connection = Orm.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    
	public boolean verifyUser(String email, String password) throws SQLException {
		var sql = "SELECT * FROM users WHERE email=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		var data = preparedStatement.executeQuery();
		if (data.next()) {
			if (BCrypt.checkpw(password, data.getString("password"))) {
				return true;
			}	
		}
		return false;	
	}
	
	public int getUserId(String email) throws SQLException {
		var sql = "SELECT user_id FROM users WHERE email=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		var data = preparedStatement.executeQuery();
		if (data.next()) {
			return Integer.parseInt(data.getString("user_id"));
		}
		return -1;	
	}
	
	public int getUserRights(int id) throws SQLException {
		var sql = "SELECT access_rights FROM users WHERE user_id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		var data = preparedStatement.executeQuery();
		if (data.next()) {
			return Integer.parseInt(data.getString("access_rights"));
		}
		return -1;	
	}
	
	public String getLoginById(int id) throws SQLException{
		var sql = "SELECT * FROM users WHERE user_id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		var data = preparedStatement.executeQuery();
		if (data.next()) {
			return data.getString("login");
		}
		return "null";
	}
	
	public boolean addNewUser(String email, String login, String password) throws SQLException {
		var sql = "insert into users(login,password,email) values(?,?,?)";	
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, BCrypt.hashpw(password,BCrypt.gensalt()));
		preparedStatement.setString(3, email);
		if(preparedStatement.executeUpdate() > 0) {
			return true;
		}
		return false;	
	}
	
}
