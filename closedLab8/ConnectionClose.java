package closedLab8;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class responsible for closing the connection.
 */
public class ConnectionClose {
	public static void closeConnection(Connection con) throws SQLException {
		con.close();
	}
}
