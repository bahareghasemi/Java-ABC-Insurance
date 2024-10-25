package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ClaimChanges {

    private Connection conn;

    public ClaimChanges() {
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

    public void updateClaim(int claimId, String approvalDate, String rejectionReason, String status) 
    		throws SQLException {
        String query = "UPDATE Claims SET ApprovedDate = ?, RejectionReason = ?, Status = ? "
        		+ "WHERE ClaimID = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, approvalDate);
            stmt.setString(2, rejectionReason);
            stmt.setString(3, status);
            stmt.setInt(4, claimId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }
}
