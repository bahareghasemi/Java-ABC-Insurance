package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
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

public class ReadUser {

	Connection conn;
	ResultSet rs;
	Statement statement;
	PreparedStatement pStmt;

	public ReadUser() {
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
        String query = "SELECT userID, Username FROM users";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userID"));
                user.setUsername(rs.getString("Username"));
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

	public List<Product> doReadUserProducts(String username) throws SQLException {
	        List<Product> registeredProducts = new ArrayList<>();

	        String query = "SELECT * FROM products rp "
	                     + "INNER JOIN users u ON rp.UserID = u.UserID "
	                     + "WHERE u.Username = ?";
	        
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, username);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Product registeredProduct = new Product();
	                registeredProduct.setProductId(rs.getInt("ProductID"));
	                registeredProduct.setSerialNo(rs.getString("SerialNO"));
	                registeredProduct.setPurchaseDate(rs.getString("PurchaseDate"));
	                registeredProduct.setProductName(rs.getString("ProductName"));
	                registeredProduct.setCategory(rs.getString("Model"));
	                registeredProduct.setClaimsLeft(rs.getInt("ClaimLeft"));
	                registeredProducts.add(registeredProduct);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }

	        return registeredProducts;
	    }

	public List<Claim> doReadUserClaims(Integer userId) throws SQLException {
		List<Claim> claims = new ArrayList<>();
		
	       String query = "SELECT * FROM Products rp "
                   + "INNER JOIN Claims c ON rp.ProductID = c.ProductID "
                   + "WHERE c.UserID = ?";
		
	       try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Claim claim = new Claim();
	                claim.setProductId(rs.getInt("ProductID"));
	                System.out.println(rs.getInt("ProductID"));
	                claim.setDateOfClaim(rs.getDate("DateOfClaim").toLocalDate());
	                claim.setDescription(rs.getString("description"));
	               claim.setProductName(rs.getString("ProductName"));
	               claim.setStatus(rs.getString("status"));
	                claims.add(claim);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
		return claims;
	}

	

}
