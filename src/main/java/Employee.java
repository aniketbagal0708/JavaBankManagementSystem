import java.util.*;
import java.sql.*;


public class Employee {
	
	static Scanner s = new Scanner(System.in);

	public void createEmployeeAcc()
	{
		System.out.println("Enter new employee id :- ");
		int eId = s.nextInt();
		
		System.out.println("Enter the employee name :- ");
		String eName = s.next();
		
		
		System.out.println("Create employee password :- ");
		String ePass = s.next();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			int no = stmt.executeUpdate("insert into employee values("+eId+",'"+eName+"','"+ePass+"')");
			if(no == 1)
			{
				System.out.println("Employee account created successfully....");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loginEmployee()
	{
		System.out.println("Enter employee id :- ");
		int eId = s.nextInt();
		
		System.out.println("Enter  employee password :- ");
		String ePass = s.next();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			ResultSet res = stmt.executeQuery("select * from employee where eId="+eId+" and ePass='"+ePass+"'");
			
			if(res.next())
			{
				System.out.println(res.getString("eName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyCustAcc()
	{
		System.out.println("Verifying the details of the customer ");
		System.out.println("Enter the customer id to verify the details ");
		int cId = s.nextInt();
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			
			stmt.executeUpdate("update customer set verify = "+1+" where cId = "+cId+"");
			System.out.println("Account verified ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewCustAcc()
	{
		System.out.println("View customer account details");
		System.out.println("Enter the customer id ");
		int cId = s.nextInt();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			ResultSet res = stmt.executeQuery("select * from customer where cId="+cId+"");
			
			if(res.next())
			{
				System.out.println("Customer Id :- "+res.getInt("cId"));
				System.out.println("first name :- "+res.getString("fname"));
				System.out.println("last name :- "+res.getString("lname"));
				System.out.println("Age :- "+res.getInt("age"));
				System.out.println("Aadhar no :- "+res.getString("aadhar_no"));
				System.out.println("Phone no  :- "+res.getString("phone_no"));
				System.out.println("Address :- "+res.getString("address"));
				System.out.println("Balance :- "+res.getFloat("bal"));
			}
			else
			{
				System.out.println("Customer doesn't exist....");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCustAcc()
	{
		System.out.println("Enter the customer id to delete account of customer :- ");
		int cId = s.nextInt();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			stmt.executeUpdate("delete from customer where cId="+cId+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{

		Employee e = new Employee();
		
		e.loginEmployee();
		
		
		char ch;
		
		do {
			
			System.out.println("1. View customer account details. ");
			System.out.println("2. Verify customer account.");
			System.out.println("3. Delete customer account.");
			System.out.println("4. Add new employee.");
			System.out.println("5. Exit.");
			
			System.out.println("Enter your choice :- ");
			int choice = s.nextInt();
			
			switch (choice) {
			case 1:
				e.viewCustAcc();
				break;
			case 2:
				e.verifyCustAcc();
				break;
			case 3:
				e.deleteCustAcc();
				break;
			case 4:
				e.createEmployeeAcc();
				break;

			default:
				break;
			}
			
			
			System.out.println("Do you want to continue ? --> Employee Page --> (Y/N)");
			ch = s.next().charAt(0);
		} while (ch=='Y' || ch=='y');

	}

}
