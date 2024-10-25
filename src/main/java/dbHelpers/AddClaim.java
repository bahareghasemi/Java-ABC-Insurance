package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.Claim;

public class AddClaim {
	
	 private Connection conn;
	    private PreparedStatement pStmt;


	public AddClaim() {
		Properties properties = new Properties();
        InputStream in;

        try {
            in = getClass().getResourceAsStream("dbConfig.properties");
            properties.load(in);

            String driver = properties.getProperty("jdbc.driver");

            if (driver != null) {
                Class.forName(driver);
            }
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	 public void addClaim(Claim claim) throws SQLException { 
	        
	        String sql = "INSERT INTO Claims (UserID, ProductID, DateOfClaim, Description,Status"
	        		+ ") VALUES (?, ?, ?, ?, ?)";

	        try {
	            pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1, claim.getUser());
	            pStmt.setInt(2, claim.getProductId());
	            pStmt.setDate(3, java.sql.Date.valueOf(claim.getDateOfClaim()));
	            pStmt.setString(4, claim.getDescription());
	            pStmt.setString(5, "Pending");
	      
	            int rowsAffected = pStmt.executeUpdate();
	            System.out.println(rowsAffected + " row(s) affected");
	            

	            // Update ClaimsLeft for the registered product
	            updateClaimsLeft(claim.getProductId());

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (pStmt != null) {
	                pStmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
	 
	 public void updateClaimsLeft(int regId) throws SQLException {
		  String sql = "UPDATE Registered_Products SET claims_left = claims_left - 1 WHERE registration_id = ?";

	        try {
	            pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1, regId);

	            int rowsAffected = pStmt.executeUpdate();
	            System.out.println(rowsAffected + " row(s) updated");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (pStmt != null) {
	                pStmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        }
	    }
		 
	 

}
