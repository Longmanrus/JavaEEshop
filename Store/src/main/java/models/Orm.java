package models;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Orm {
	
	private Connection connection;
 
    private static Orm instance;

   
    private Orm(){

		try {
			Class.forName(ConfigDB.DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        String url = "jdbc:mysql://localhost/" + ConfigDB.DB + "?allowMultiQueries=true";
		try {
			connection = DriverManager.getConnection(url, ConfigDB.LOGIN, ConfigDB.PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

    }

    public static Orm getInstance(){
        if (instance==null){
        	instance = new Orm();
        }
        return instance;
    }
    
    public Connection getConnection(){
    	
        return connection;
    }

}
