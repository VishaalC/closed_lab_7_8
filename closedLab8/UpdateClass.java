package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Class responsible for updating records present in the database.
 */
public class UpdateClass {
	Connection connectionObject;
	
	String empName;
	int selectId;
	String phoneNum;
	String City;
		
	// Instatiating connection object.
	UpdateClass(Connection connectionObject) {
		this.connectionObject=connectionObject;
	}
	
	// getter for empName
	public String getEmpName() {
		return empName;
	}
	
	// setter for empName.
	public void setEmpName(String empName) throws Exception {
		if (!empName.matches(".*[a-zA-Z]+.*") ) {
			throw new Exception("Enter valid emp name");
		}
		this.empName = empName;
	}
	
	// getter for empId.
	public int getEmpId() {
		return selectId;
	}
	
	// setter for empId.
	public void setEmpId(int empId) {
		this.selectId = empId;
	}
	
	// getter for phone number.
	public String getPhoneNum() {
		return phoneNum;
	}
	
	// setter for phone number.
	// performs checking on length.
	public void setPhoneNum(String phoneNum) throws Exception {
		
		if (phoneNum.length() > 9) {
			throw new Exception("Phone number length cannot be greater than 9");
		}
		this.phoneNum = phoneNum;
	}
	
	// getter for city.
	public String getCity() {
		return City;
	}

	// setter for city.
	public void setCity(String city) throws Exception {
		if (!city.matches(".*[a-zA-Z]+.*")) {
			throw new Exception("Enter valid city");
		};
		this.City = city;
	}
	
	// prepared statement.
	String updateRecord = "UPDATE EMP_INFO SET EmpName=?, PhoneNum=?, City=? WHERE EmpId=?";
	
	// executes the update statement.
	public void updateRecord() throws Exception {
		PreparedStatement updateStatement = connectionObject.prepareStatement(updateRecord);
		
		updateStatement.setString(1, this.getEmpName());
		updateStatement.setString(2, this.getPhoneNum());
		updateStatement.setString(3, this.getCity());
		updateStatement.setInt(4, this.getEmpId());
		
		updateStatement.execute();
	}
}