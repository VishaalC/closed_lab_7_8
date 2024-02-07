package closedLab8;
import java.sql.Connection;
import java.util.Scanner;

/**
 * Program to implement an employee database and allow HR user to access and use it.
 * @author vishaalc
 */

public class HRDatabase {

	public static void main(String[] args) throws Exception {
		
		// Creating scanner object.
		Scanner scannerObject = new Scanner(System.in);
		
		// Creating instance of connection.
		Connection connectionObject = null;
		
		// Attemplting to initialize connection
		try {
			connectionObject = ConnectionCreator.getConnection();			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Looping till user exits.
		while(true) {
			
			// Creating an abstract user.
			AbstractUser DBUser = null;
			
			// Obtaining employee choice and information.
			System.out.println("Select type of user: \n1.Employee\n2.HR User\n3.Exit");
			int choice = scannerObject.nextInt();
			
			// Employee object creation.
			if (choice == 1) {
				DBUser=new Employee();
				System.out.println("Enter name: ");
				DBUser.setName(scannerObject.next());
				System.out.println("Enter id:");
				DBUser.setEmpId(scannerObject.nextInt());
			}
			
			// HR user creation.
			else if (choice == 2){
				DBUser=new HRUser();
				System.out.println("Enter name: ");
				DBUser.setName(scannerObject.next());
				System.out.println("Enter id:");
				DBUser.setEmpId(scannerObject.nextInt());
			}
			
			// exit option.
			else if (choice == 3) {
				System.out.println("Exiting...");
				break;
			}
			
			// checking for invalid input.
			else {
				System.out.println("Enter valid choice");
				break;
			}
			
			// printing user details.
			System.out.println("The current user is " +DBUser.getName()+":"+DBUser.getEmpId());
						
			// Obtaining user choice.
			System.out.println("Choose: \n1.Create\n2.Update\n3.Delete\n4.Select");
			int userChoice = scannerObject.nextInt();
			
			// using switch case to select choice
			try {
				switch(userChoice) {	
				
				case 1:
					// check if user can create and insert records
					if (DBUser.canCreate) {			
						System.out.println("FOR INSERTION: Enter the follwoing data:\n1.Name\n2.Employee id\n3.Phone Number\n4.City");
						
						// Creating insertClass object.
						InsertClass insertObj = new InsertClass(connectionObject);
						
						// initializing and inserting the record.
						insertObj.setEmpName(scannerObject.next());
						insertObj.setEmpId(scannerObject.nextInt());
						insertObj.setPhoneNum(scannerObject.next());
						insertObj.setCity(scannerObject.next());
						insertObj.insertFullRecord();				
					}
					else {
						System.out.println("You do not have the required perms");		
					}
					
					break;
				
				case 2:
					// check if user can update and update records
					if (DBUser.canUpdate) {
						System.out.println("FOR UPDATION: Enter the follwoing data:\n1.Name\n2.Phone Number\n3.City\n4.Select ID");
						
						// Creating updateClass object.
						UpdateClass updateObj = new UpdateClass(connectionObject);
						
						// initializing and updating the record.
						updateObj.setEmpName(scannerObject.next());
						updateObj.setPhoneNum(scannerObject.next());
						updateObj.setCity(scannerObject.next());
						updateObj.setEmpId(scannerObject.nextInt());
						updateObj.updateRecord();				
					}
					else {
						System.out.println("You do not have the req perms");
					}
					
					break;
				
				case 3:
					// check if user can delete and delete records
					if (DBUser.canDelete) {
						System.out.println("FOR DELETION: Enter the data:\n1.Employee ID");
						
						// Instantiating deleteClass object.
						DeleteClass deleteObj = new DeleteClass(connectionObject);
						
						// initialzing and deleting the selected record.
						deleteObj.setEmpId(scannerObject.nextInt());
						deleteObj.deleteRecord();				
					}
					else {
						System.out.println("You do not have the req perms");
					}
					
					break;
				
				case 4:
					// check if user has selection perms
					if (DBUser.canSelect) {
						
						// instatiating selectClass obj and getting records.
						SelectClass selectObj = new SelectClass(connectionObject);
						selectObj.selectAllRecord();
					}
					else {
						System.out.println("You do not have the req perms");
					}
					
					break;
				
				// default option to check for wrong input.
				default:
					System.out.println("Please enter a valid option");
					break;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		// close scanner
		scannerObject.close();
		
		// close connection
		ConnectionClose.closeConnection(connectionObject);
	}
}

