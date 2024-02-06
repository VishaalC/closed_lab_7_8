package closedLab8;

import java.sql.Connection;
import java.sql.PreparedStatement;

//class for updating records
public class UpdateClass {
	Connection con;
	
	String empName;
	int selectId;
	String phoneNum;
	String City;
	
	UpdateClass(Connection con) {
		this.con=con;
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) throws Exception {
		if (!empName.matches(".*[a-zA-Z]+.*") ) {
			throw new Exception("Enter valid emp name");
		}
		this.empName = empName;
	}

	public int getEmpId() {
		return selectId;
	}

	public void setEmpId(int empId) {
		this.selectId = empId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) throws Exception {
		
		if (phoneNum.length() > 9) {
			throw new Exception("Phone number length cannot be greater than 9");
		}
		this.phoneNum = phoneNum;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) throws Exception {
		if (!city.matches(".*[a-zA-Z]+.*")) {
			throw new Exception("Enter valid city");
		};
		this.City = city;
	}
	
	String updateRecord = "UPDATE EMP_INFO SET EmpName=?, PhoneNum=?, City=? WHERE EmpId=?";
	
	public void updateRecord() throws Exception {
		PreparedStatement updateStatement = con.prepareStatement(updateRecord);
		
		updateStatement.setString(1, this.getEmpName());
		updateStatement.setString(2, this.getPhoneNum());
		updateStatement.setString(3, this.getCity());
		updateStatement.setInt(4, this.getEmpId());
		
		updateStatement.execute();
	}
}