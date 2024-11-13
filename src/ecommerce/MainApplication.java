package ecommerce;

import java.io.IOException;
import java.util.Scanner;

import product.productManagement;
import uesr.userManagement;

public class MainApplication {

	
	public static void main(String[] args) throws IOException {
		System.out.println("######## welcome to ECommerce System ########");
		boolean Continue = true;
		while(Continue) {
		System.out.println("what would you like to do Today");
		
		System.out.println("1 User Mangement System");
		System.out.println("2 Product Management System");
		System.out.println("3 Exit the Application");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
			switch (option) {
			case 1: 
				userManagement user = new userManagement();
				user.user_Management();
				break;
				
			case 2:
				productManagement pd = new productManagement();
				pd.product_Management();
				break;
				
			case 3:
				Continue = false;
				System.out.println("exiting the ecommerce system");
				break;
			default:
				System.out.println("Wrong Choice");
			}
			
		}
		
		
	}
}
