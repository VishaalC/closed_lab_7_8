package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Class used to perform selection operation.
 * 
 */
public class SelectClass {
	Connection connectionObject;
	
	// instatiate connection object.
	SelectClass(Connection connectionObject) {
		this.connectionObject=connectionObject;
	}
	
	// prepared statment
	String selectAll = "SELECT * FROM EMP_INFO";
	
	// execute select statement.
	public void selectAllRecord() throws Exception{
		PreparedStatement selectStmt = connectionObject.prepareStatement(selectAll);
		
		ResultSet rs = selectStmt.executeQuery();
		while(rs.next()) {
			System.out.println("Name: " +rs.getString("EmpName")+ ", Employee id: " +rs.getString("EmpId")+ ", Phone Number: " +rs.getString("PhoneNum") + ", City: " +rs.getString("City"));
		}
	}
}