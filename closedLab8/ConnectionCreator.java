package closedLab8;

import java.sql.Connection;
import java.sql.DriverManager;

//class for creating a connection object
public class ConnectionCreator {
	public static Connection getConnection() throws Exception {
		
		// loading jdbc drivers.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// getting connection.
		Connection connectionObject = DriverManager.getConnection("jdbc:mysql://localhost/closedLab8", "root", "Printer3!");
		
		// checking if connection object is created.
		if (connectionObject == null) {
			throw new Exception("Connection is null");
		}
		return connectionObject;
	}
}
