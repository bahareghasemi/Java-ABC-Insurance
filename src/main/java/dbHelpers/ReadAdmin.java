package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.User;
import model.Claim;
import model.Product;

public class ReadAdmin {

	Connection conn;
	ResultSet rs;
	Statement statement;
	PreparedStatement pStmt;

	public ReadAdmin() {
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

			conn = DB.getConnection(url, username, password);
			System.out.println("Connection Established");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> doReadAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users;";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userID"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNo(rs.getString("CellPhone"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return users;
    }
	
	public User doReadUserInfoById(int userId) throws SQLException {
        User user = null;
        String query = "SELECT * FROM users WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }
	
	public User doReadUserInfo(String username) throws SQLException {
		
		  User user = null;
		  String query = "SELECT * FROM users WHERE Username = ?";
	        try ( PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                user = new User();
	                user.setUserId(rs.getInt("UserID"));
	                user.setUsername(rs.getString("Username"));
	       
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	        return user;
		

	}

	public List<Product> doReadProducts() throws SQLException {
	        List<Product> products = new ArrayList<>();

	        String query = "SELECT * FROM productlists";
	        
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Product product = new Product();
	                product.setProductName(rs.getString("ProductName"));
	                product.setCategory(rs.getString("Model"));
	                products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }

	        return products;
	    }

	public List<Claim> doReadClaims() throws SQLException {
		List<Claim> claims = new ArrayList<>();
		
		String query = "SELECT * FROM Products rp "
                + "INNER JOIN Claims c ON rp.ProductID = c.ProductID ";
		
	       try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Claim claim = new Claim();
	                claim.setProductId(rs.getInt("ProductID"));
	                claim.setClaimId(rs.getInt("ClaimID"));
	                claim.setDateOfClaim(rs.getDate("DateOfClaim").toLocalDate());
	                claim.setDescription(rs.getString("description"));
	                claim.setProductName(rs.getString("ProductName"));
	                claim.setStatus(rs.getString("status"));

	                // Handle potential null value for ApprovedDate
	                Date approvedDate = rs.getDate("ApprovedDate");
	                if (approvedDate != null) {
	                    claim.setApprovalDate(approvedDate.toLocalDate());
	                } else {
	                    claim.setApprovalDate(null);  // or handle it according to your logic
	                }

	               claims.add(claim);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
		return claims;
	}

	

}
