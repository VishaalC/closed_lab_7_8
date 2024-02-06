package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//class for deleting records
public class DeleteClass {
	Connection con;
	int empId;
	
	// instatiating connecting object
	DeleteClass(Connection con) {
		this.con=con;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// configurable string
	String delRecord = "DELETE FROM EMP_INFO WHERE EmpId=?";
	
	// method to prepare the string and execute it
	public void deleteRecord() throws SQLException {
		PreparedStatement delStatement = con.prepareStatement(delRecord);
		delStatement.setInt(1, this.getEmpId());
		
		delStatement.execute();
	}
}
