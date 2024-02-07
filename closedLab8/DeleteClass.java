package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class used to perform delete operations.
 * Obtains employee id and then executes a prepared statement to delete the record.
 */
public class DeleteClass {
	Connection connectionObject;
	int empId;
	
	// instatiating connecting object
	DeleteClass(Connection con) {
		this.connectionObject=con;
	}
	
	// getter for empId.
	public int getEmpId() {
		return empId;
	}
	
	// setter for empId.
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// configurable string - prepared statement.
	String delRecord = "DELETE FROM EMP_INFO WHERE EmpId=?";
	
	// method to prepare the string and execute it
	public void deleteRecord() throws SQLException {
		PreparedStatement delStatement = connectionObject.prepareStatement(delRecord);
		delStatement.setInt(1, this.getEmpId());
		
		delStatement.execute();
	}
}
