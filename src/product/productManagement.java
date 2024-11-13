package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

public class productManagement {
	List<String> productList = new ArrayList<>();

	public void product_Management() throws IOException {
		boolean productContinue = true;
		ProductCollection product = new ProductCollection();

		productLoadFromFile();
		while (productContinue) {

			System.out.println("########## Welcome to Product Management System ##########");
			System.out.println("1. Add Product");
			System.out.println("2. Update Product");
			System.out.println("3. Search Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Print Product");
			System.out.println("6. Exit Product Management");

			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("#### Add Product ####");

				System.out.println("enter the product name");
				product.product_Name = scanner.next();

				System.out.println("enter the product quantity");
				product.product_Quantity = scanner.nextInt();

				System.out.println("enter the product price");
				product.product_Price = scanner.nextInt();

				productList.add(product.product_Name + "," + product.product_Quantity + "," + product.product_Price);
				break;

			case 2:
				System.out.println("#### Update Product ####");

				System.out.println("enter the product name to update");
				String productaToUpdate = scanner.next();

				for (int i = 0; i < productList.size(); i++) {
					if (productList.get(i).contains(productaToUpdate)) {
						System.out.println("enter new product name");
						String newName = scanner.next();

						System.out.println("enter new quantity");
						int newQty = scanner.nextInt();

						System.out.println("enter new price");
						int newprice = scanner.nextInt();

						productList.set(i, newName + "," + newQty + "," + newprice);
					}
				}

				break;

			case 3:
				System.out.println("#### Search Product ####");

				System.out.println("enter the product name to search");
				String productToSearch = scanner.next();

				for (int i = 0; i < productList.size(); i++) {
					if (productList.get(i).contains(productToSearch)) {
						System.out.println(productList.get(i));
					} else {
						System.out.println("No product Available");
					}
				}

				break;

			case 4:
				System.out.println("#### Delete Product ####");
				System.out.println("enter the product name to Delete");
				String productToDelte = scanner.next();

				for (int i = 0; i < productList.size(); i++) {
					if (productList.get(i).contains(productToDelte)) {
						productList.remove((i));
					}
				}
				break;

			case 5:
				System.out.println("#### Print Product ####");

				for (String products : productList) {
					System.out.println(products);
				}
				break;

			case 6:
				productWriteToFile();
				productContinue = false;
				System.out.println("#### Exiting the Product ####");
				break;

			default:
				System.out.println("Wrong Choice");

			}

		}

	}

	public void productLoadFromFile() throws IOException {
		String path = "C:\\Users\\91853\\eclipse-workspace\\ECommerce_Collection\\src\\product\\product.txt";
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			productList.add(line);
		}
		bufferedReader.close();

	}

	public void productWriteToFile() throws IOException {
		String path = "C:\\Users\\91853\\eclipse-workspace\\ECommerce_Collection\\src\\product\\product.txt";
		File file = new File(path);
		FileWriter fWriter = new FileWriter(file, false);
		BufferedWriter bWriter = new BufferedWriter(fWriter);

		for (String product : productList) {
			bWriter.write(product+"\n");
		}
		bWriter.close();
	}

}
