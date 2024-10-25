package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.ProductLists;

public class AddProduct {
	
	 Connection conn;
		ResultSet rs;
		Statement statement;
		PreparedStatement pStmt;

	public AddProduct() {
		// TODO Auto-generated constructor stub
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

	public int doAddProduct(ProductLists product) throws SQLException {
		
		String sql = "INSERT INTO productlists (ProductName, Model) "
				+ "VALUES (?, ?)";
		// Insert product details into the database
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getModel());
     
            int rowsAffected = pstmt.executeUpdate();           
            return rowsAffected;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return 0;
        }	
	}
}
