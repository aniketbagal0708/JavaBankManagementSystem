import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;


public class CustomerAccount
{
	static Scanner s = new Scanner(System.in);
	
	
	public Object login(String aadhar_no, String pass)
	{
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			//boolean res = stmt.execute("select fname,lname from customer where aadhar_no='"+aadhar_no+"' and pass='"+pass+"' ");
			ResultSet res = stmt.executeQuery("select cId,fname,lname,verify from customer where aadhar_no='"+aadhar_no+"' and pass='"+pass+"' ");
			
			if(res.next() && res.getInt("verify")==1)
			{
				System.out.println(res.getInt("cId"));
				System.out.println(res.getString("fname"));
				System.out.println(res.getString("lname"));
				return res.getInt("cID");
			}
			else
			{
				System.out.println("Customer Account details not found or not verified");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void deposit(int cId)
	{
		System.out.println("Enter the deposit amount :- ");
		float bal = s.nextFloat();
		
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			stmt.executeUpdate("update customer set bal = bal + "+bal+" where cId = "+cId+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void withdraw(int cId)
	{
		System.out.println("Enter the amount to withdraw :- ");
		float bal = s.nextFloat();
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			stmt.executeUpdate("update customer set bal = bal - "+bal+" where cId = "+cId+" and bal>="+bal+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void transefer(int cId)
	{
		System.out.println("Enter the receiver aadhar no :- ");
		String aadhar_no = s.next();
		
		System.out.println("Enter the amount to transfer");
		float bal = s.nextFloat();
		
		
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			stmt.executeUpdate("update customer set bal = bal - "+bal+" where cId = "+cId+" and bal>="+bal+"");
			stmt.executeUpdate("update customer set bal = bal + "+bal+" where aadhar_no = '"+aadhar_no+"' ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkAccountBal(int cId)
	{
		try {
			Statement stmt = (DBConnection.createDBConnection()).createStatement();
			ResultSet res = stmt.executeQuery("select cId,fname,lname,bal from customer where cId="+cId+"");
			
			if(res.next())
			{
				System.out.println("Customer ID "+res.getInt("cId")+" name "+res.getString("fname")+" "+res.getString("lname")+" account balance is "+res.getFloat("bal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		CustomerAccount ac = new CustomerAccount();
		
		char ch;
		
		System.out.println("Enter the aadhar no :-");
		String aadhar_no = s.next();
		
		System.out.println("Enter the password :-");
		String pass = s.next();
		
		int cId = (Integer) ac.login(aadhar_no,pass);
		
		if(cId != 0 )
		{
			System.out.println("Successfully Login into your account.....\n\n");
			
			do 
			{
				System.out.println("1.Check your account balance.");
				System.out.println("2.Deposit Money into your account.");
				System.out.println("3.Withdraw money from your account.");
				System.out.println("4.Transfer Money from your account");
				System.out.println("5.Exit \n\n");
				
				System.out.println("Enter your choice ");
				int choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					ac.checkAccountBal(cId);
					break;
				case 2:
					ac.deposit(cId);
					
					break;
				case 3:
					ac.withdraw(cId);
					
					break;
				case 4:
					ac.transefer(cId);
					
					break;
				default:
					break;
				}
				
				System.out.println("Do you want continue ? -->Customer Page --> (Y/N) ");
				ch = sc.next().charAt(0);
			} while (ch=='Y' || ch=='y');
			
			
			
		}
		
		
		

	}

}
