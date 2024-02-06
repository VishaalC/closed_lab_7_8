package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//class for selecing all records
public class SelectClass {
	Connection con;
	
	SelectClass(Connection con) {
		this.con=con;
	}
	String selectAll = "SELECT * FROM EMP_INFO";
	
	public void selectAllRecord() throws Exception{
		PreparedStatement selectStmt = con.prepareStatement(selectAll);
		
		ResultSet rs = selectStmt.executeQuery();
		while(rs.next()) {
			System.out.println("Name: " +rs.getString("EmpName")+ ", Employee id: " +rs.getString("EmpId")+ ", Phone Number: " +rs.getString("PhoneNum") + ", City: " +rs.getString("City"));
		}
	}
}