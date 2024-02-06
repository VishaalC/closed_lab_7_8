package closedLab8;

import java.sql.Connection;
import java.sql.DriverManager;

//class for creating a connection object
public class ConnectionCreator {
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/closedLab8", "root", "Printer3!");
		
		if (con == null) {
			throw new Exception("Connection is null");
		}
		return con;
	}
}
