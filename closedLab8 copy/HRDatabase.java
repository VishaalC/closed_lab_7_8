package closedLab8;
import java.sql.Connection;
import java.util.Scanner;

/**
 * Program to implement an employee database and allow HR to access and use it
 * @author vishaalc
 */

public class HRDatabase {

	public static void main(String[] args) throws Exception {
		
		Scanner scannerObject = new Scanner(System.in);
		Connection con = null;
		try {
			con = ConnectionCreator.getConnection();			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		// creating scanner object
		while(true) {
			AbstractUser DBUser = null;
			
			System.out.println("Select type of user: \n1.Employee\n2.HR User\n3.Exit");
			int choice = scannerObject.nextInt();
			
			if (choice == 1) {
				DBUser=new Employee();
				System.out.println("Enter name: ");
				DBUser.setName(scannerObject.next());
				System.out.println("Enter id:");
				DBUser.setEmpId(scannerObject.nextInt());
				// System.out.println(DBUser);
			}
			else if (choice == 2){
				DBUser=new HRUser();
				System.out.println("Enter name: ");
				DBUser.setName(scannerObject.next());
				System.out.println("Enter id:");
				DBUser.setEmpId(scannerObject.nextInt());
				// System.out.println(DBUser);			
			}
			else if (choice == 3) {
				System.out.println("Exiting...");
				break;
			}
			
			// System.out.println(DBUser);
			System.out.println("The current user is " +DBUser.getName()+":"+DBUser.getEmpId());
			
			// get Connection object
			
			System.out.println("Choose: \n1.Create\n2.Update\n3.Delete\n4.Select");
			
			int ch = scannerObject.nextInt();
			switch(ch) {
			
			case 1:
				// check if user can create and insert records
				if (DBUser.canCreate) {			
					System.out.println("FOR INSERTION: Enter the follwoing data:\n1.Name\n2.Employee id\n3.Phone Number\n4.City");
					InsertClass insertObj = new InsertClass(con);
					
					try {
						insertObj.setEmpName(scannerObject.next());
						insertObj.setEmpId(scannerObject.nextInt());
						insertObj.setPhoneNum(scannerObject.next());
						insertObj.setCity(scannerObject.next());
						insertObj.insertFullRecord();				
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("You do not have the required perms");		
				}
				break;
			case 2:
				// check if user can update and update records
				if (DBUser.canUpdate) {
					System.out.println("FOR UPDATION: Enter the follwoing data:\n1.Name\n2.Phone Number\n3.City\n4.Select ID");
					UpdateClass updateObj = new UpdateClass(con);
					
					try {
						updateObj.setEmpName(scannerObject.next());
						updateObj.setPhoneNum(scannerObject.next());
						updateObj.setCity(scannerObject.next());
						updateObj.setEmpId(scannerObject.nextInt());
						
						updateObj.updateRecord();				
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("You do not have the req perms");
				}
				break;
			case 3:
				// check if user can delete and delete records
				if (DBUser.canDelete) {
					System.out.println("FOR DELETION: Enter the data:\n1.Employee ID");
					DeleteClass deleteObj = new DeleteClass(con);
					
					try {
						deleteObj.setEmpId(scannerObject.nextInt());
						deleteObj.deleteRecord();				
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("You do not have the req perms");
				}
				break;
			case 4:
				// print all records
				if (DBUser.canSelect) {
					SelectClass selectObj = new SelectClass(con);
					selectObj.selectAllRecord();
				}
				else {
					System.out.println("You do not have the req perms");
				}
				
			}
		}
		scannerObject.close();
		ConnectionClose.closeConnection(con);
	}
}

