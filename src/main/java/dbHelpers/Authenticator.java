package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Authenticator {
	
	Connection conn;
	ResultSet rs;
	Statement statement;
	PreparedStatement pStmt;
	
	
    public Authenticator() {
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
	
	
// method to Authenticate Admin Login
	public String authenticateAdmin(String username, String password) {
		if (("Bahare".equalsIgnoreCase(username))
				&& ("123".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	
// method to authenticate User	
	public String authenticateUser(String username, String password) {
		try {
			
			
			pStmt = conn.prepareStatement("select * from Users where username =? and password=?");
			
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				return"success";
			}else {
				return"failure";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}