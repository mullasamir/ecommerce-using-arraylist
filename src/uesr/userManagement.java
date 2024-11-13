package uesr;

import java.io.*;

import java.util.*;

public class userManagement {
	
		List<String> userList = new ArrayList<>();

		public void user_Management() throws IOException {
			boolean productContinue = true;
			User user = new User();

			userLoadFromFile();
			while (productContinue) {

				System.out.println("########## Welcome to Product Management System ##########");
				System.out.println("1. Add User");
				System.out.println("2. Update User");
				System.out.println("3. Search User");
				System.out.println("4. Delete User");
				System.out.println("5. Print User");
				System.out.println("6. Exit User Management");

				Scanner scanner = new Scanner(System.in);
				int option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.println("#### Add User ####");

					System.out.println("enter the first name");
					user.firstName = scanner.next();

					System.out.println("enter the last name");
					user.lastName = scanner.next();

					System.out.println("enter the age");
					user.age = scanner.nextInt();
					
					System.out.println("enter the gender");
					user.gender = scanner.next();
					
					System.out.println("enter the email");
					user.email = scanner.next();
					
					System.out.println("enter the password");
					user.password = scanner.next();

					userList.add(user.firstName + "," + user.lastName + "," + user.age+ "," + user.gender + "," + user.email+ "," + user.password);
					break;

				case 2:
					System.out.println("#### Update Product ####");

					System.out.println("enter the product name to update");
					String userToUpdate = scanner.next();

					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).contains(userToUpdate)) {
							System.out.println("enter the first name");
							String fnm = scanner.next();

							System.out.println("enter the last name");
							String lnm = scanner.next();

							System.out.println("enter the age");
							int age = scanner.nextInt();
							
							System.out.println("enter the gender");
							String gender = scanner.next();
							
							System.out.println("enter the email");
							String email = scanner.next();
							
							System.out.println("enter the password");
							String pass = scanner.next();

							userList.set(i, fnm + "," + lnm + "," + age+ "," + gender + "," + email +"," + pass);
						}
					}

					break;

				case 3:
					System.out.println("#### Search Product ####");

					System.out.println("enter the product name to search");
					String userToSearch = scanner.next();

					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).contains(userToSearch)) {
							System.out.println(userList.get(i));
						} else {
							System.out.println("No product Available");
						}
					}

					break;

				case 4:
					System.out.println("#### Delete Product ####");
					System.out.println("enter the product name to Delete");
					String userToDelte = scanner.next();

					for (int i = 0; i < userList.size(); i++) {
						if (userList.get(i).contains(userToDelte)) {
							userList.remove((i));
						}
					}
					break;

				case 5:
					System.out.println("#### Print Product ####");

					for (String products : userList) {
						System.out.println(products);
					}
					break;

				case 6:
					userWriteToFile();
					productContinue = false;
					System.out.println("#### Exiting the Product ####");
					break;

				default:
					System.out.println("Wrong Choice");

				}

			}

		}

		public void userLoadFromFile() throws IOException {
			String path = "C:\\Users\\91853\\eclipse-workspace\\ECommerce_Collection\\src\\uesr\\user.txt";
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				userList.add(line);
			}
			bufferedReader.close();

		}

		public void userWriteToFile() throws IOException {
			String path = "C:\\Users\\91853\\eclipse-workspace\\ECommerce_Collection\\src\\uesr\\user.txt";
			File file = new File(path);
			FileWriter fWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			for (String user : userList) {
				bWriter.write(user+"\n");
			}
			bWriter.close();
		}

	}


