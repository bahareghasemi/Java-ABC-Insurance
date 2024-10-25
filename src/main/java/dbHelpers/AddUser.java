package dbHelpers;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import model.User;

public class AddUser {
    Connection conn;
	ResultSet rs;
	Statement statement;
	PreparedStatement pStmt;

    public AddUser() {
	Properties properties = new Properties();
	InputStream in;
	
	try {
		in = getClass().getResourceAsStream("dbConfig.properties");
		properties.load(in);
		
		String driver = properties.getProperty("jdbc.driver");
		
		if (driver!=null) {
			Class.forName(driver);
		}
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		
		conn = DB.getConnection(url, username, password);
		System.out.println("Connection Established");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}



	public void doAddUser(User user) throws SQLException {
		
	String sql = "INSERT INTO Users (Username, Password, Email, Cellphone) VALUES (?, ?, ?, ?)";
    	
        try {
            
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, user.getUsername());
            pStmt.setString(2, user.getPassword());
            pStmt.setString(3, user.getEmail());
            pStmt.setString(4, user.getPhoneNo());
           
			
			pStmt.executeUpdate();
			System.out.println("user added successfully");
			
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL errors
        }
		
		
		
	}
    
   

}
