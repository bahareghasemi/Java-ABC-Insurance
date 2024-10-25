package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection conn;

	public static Connection getConnection(String url, String username, String password) throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	
	

}
