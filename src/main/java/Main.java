import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("****WELCOME TO REVATURE BANK****");
		
		Scanner s = new Scanner(System.in);
		
		char ch;
		
		do {
			System.out.println("1. Login into your Account ");
			System.out.println("2. Create a new Account.");
			System.out.println("3. Employee Login ");
			System.out.println("4. Exit");
			
			System.out.println("Enter your choice :- ");
			int choice = s.nextInt();
			
			
			switch (choice) {
			case 1:
					CustomerAccount ca = new CustomerAccount();
					ca.main(args);
				break;
			case 2:
					CreateNewAccount cna = new CreateNewAccount();
					cna.main(args);
					
				break;
			case 3:
					Employee em = new Employee();
					em.main(args);
				break;
			default:
				break;
			}
			
			System.out.println("Do you want to continue? -->Home Page--> (Y/N)");
			ch = s.next().charAt(0);
			
		} while (ch == 'Y' || ch == 'y');

	}

}
