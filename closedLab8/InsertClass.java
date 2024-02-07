package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for inserting records 
 * Contains getters and setters and performs type checking
 */
public class InsertClass {
	Connection connectionObject;
	
	String empName;
	int empId;
	String phoneNum;
	String City;
	
	// instatiating connection object
	InsertClass(Connection connectionObject) {
		this.connectionObject=connectionObject;
	}
	
	// getter for empaName
	public String getEmpName() {
		return empName;
	}
	
	// setter for empName 
	public void setEmpName(String empName) throws Exception {
		if (!empName.matches(".*[a-zA-Z]+.*") ) {
			throw new Exception("Enter valid emp name");
		}
		this.empName = empName;
	}
	
	// getter for empId
	public int getEmpId() {
		return empId;
	}
	
	// setter for empId
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	// getter for phoneNum
	public String getPhoneNum() {
		return phoneNum;
	}
	
	// setter for phoneNum
	public void setPhoneNum(String phoneNum) throws Exception {	
		if (phoneNum.length() > 9) {
			throw new Exception("Phone number length cannot be greater than 9");
		}
		this.phoneNum = phoneNum;
	}
	
	// gettter for city
	public String getCity() {
		return City;
	}
	
	// setter for city
	public void setCity(String city) throws Exception {
		if (!city.matches(".*[a-zA-Z]+.*")) {
			throw new Exception("Enter valid city");
		};
		City = city;
	}

	// configurable string
	String insertRecord = "INSERT INTO EMP_INFO(EmpName, EmpId, PhoneNum, City) VALUES (?, ?, ?, ?)";
	
	// method to set the prepared statement and executre
	public void insertFullRecord() throws SQLException {
		PreparedStatement insertStatement = connectionObject.prepareStatement(insertRecord);
		insertStatement.setString(1, this.getEmpName());
		insertStatement.setInt(2, this.getEmpId());
		insertStatement.setString(3, this.getPhoneNum());
		insertStatement.setString(4, this.getCity());
		
		// executing the statement
		insertStatement.execute();	
	}
}