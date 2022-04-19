import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateNewAccount 
{

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the customer ID ");
		int cId = sc.nextInt();
		
		System.out.println("Enter the First Name :- ");
		String fname = sc.next();
		
		System.out.println("Enter the Last Name :- ");
		String lname = sc.next();
		
		System.out.println("Enter the Age :- ");
		int age = sc.nextInt();
		
		System.out.println("Enter the Aadhar Number :- ");
		String aadhar_no = sc.next();
		
		System.out.println("Enter the Phone Number :- ");
		String phone_no = sc.next();
		
		System.out.println("Enter the Address :- ");
		String address = sc.next();
		
		System.out.println("Enter the initial account balance ");
		float bal = sc.nextInt();
		
		System.out.println("Create a Password :- ");
		String pass = sc.next();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			int no = stmt.executeUpdate("insert into customer values("+cId+",'"+fname+"','"+lname+"',"+age+",'"+aadhar_no+"','"+phone_no+"', '"+address+"',"+bal+",'"+pass+"')");
			
			if(no == 1)
			{
				System.out.println("Account data inserted successfully...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
