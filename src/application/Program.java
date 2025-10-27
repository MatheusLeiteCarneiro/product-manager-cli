package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> productList = new ArrayList<>();
		int operation = 1;
		do {
			System.out.println("What's the operation you want to make it?");
			System.out.println("Type:");
			System.out.println(
					"1-to register a new product, 2-to list all the products in stock, 3-to add or remove quantity to an existing product");
			System.out.println(
					"4-change the information of a product, 5-to delete a product from stock, 6-calculate value in stock");
			System.out.println("0-to end operation");
			operation = sc.nextInt();
			System.out.println();
			switch (operation) {
			case 1:
				System.out.println("Registering product:");
				System.out.print("Product ID: ");
				int id = sc.nextInt();
				int verifyId = findIdIndex(productList, id);
				while (verifyId != -1) {
					System.out.print("This ID is already registered, try another one:");
					id = sc.nextInt();
					verifyId = findIdIndex(productList, id);
				}
				sc.nextLine();
				System.out.print("Product name: ");
				String name = sc.nextLine();
				boolean verifyName = checkName(productList, name);
				while (verifyName) {
					System.out.print("This Name is already registered, try another one:");
					name = sc.nextLine();
					verifyName = checkName(productList, name);
				}

				System.out.print("Product price: ");
				double price = sc.nextDouble();
				while (price < 0.0) {
					System.out.print("The price must be greater than 0, type another price: ");
					price = sc.nextDouble();
				}
				System.out.print("Product initial quantity in stock: ");
				int quantity = sc.nextInt();
				while (quantity < 0) {
					System.out.print("The quantity must be greater than 0, type another quantity: ");
					quantity = sc.nextInt();
				}

				productList.add(new Product(id, name, price, quantity));
				System.out.print("The product was successfully registered!\n\n");
				break;

			case 2:
				if (productList.size() == 0) {
					System.out.println("There isn't any product registered yet");
				} else {
					for (Product p : productList) {
						System.out.print(p);
					}
				}
				System.out.println();
				break;

			case 3:
				System.out.print("Type the ID of the Product you want add or remove a quantity");
				int addOrRemoveId = sc.nextInt();
				int findIdIndex = findIdIndex(productList, addOrRemoveId);
				while (findIdIndex == -1) {
					System.out.print("This ID does not exist, type a valid id: ");
					addOrRemoveId = sc.nextInt();
					findIdIndex = findIdIndex(productList, addOrRemoveId);
				}

				System.out.println("The product is: " + productList.get(findIdIndex));
				System.out.print("Type 1-to add to stock or 2-to remove from stock: ");
				int addOrRemove = sc.nextInt();
				while (addOrRemove != 1 && addOrRemove != 2) {
					System.out.print("Invalid digit, type 1 to add or 2 to remove: ");
					addOrRemove = sc.nextInt();
				}
				if (addOrRemove == 1) {
					System.out.print("Type the quantity you want to add to the stock: ");
					int addOrRemoveQuantity = sc.nextInt();
					boolean verifyQuantity = productList.get(findIdIndex).addQuantity(addOrRemoveQuantity);
					while (verifyQuantity) {
						System.out.println("Invalid quantity, type a valid number to add: ");
						addOrRemoveQuantity = sc.nextInt();
						verifyQuantity = productList.get(findIdIndex).addQuantity(addOrRemoveQuantity);
					}
					System.out.println("The amount was succesfully added to the stock!");
					System.out.println(
							"Now there is " + productList.get(findIdIndex).getQuantity() + " available in stock\n");

				}

				else {
					System.out.print("Type the quantity you want to remove from the stock: ");
					int addOrRemoveQuantity = sc.nextInt();
					boolean verifyQuantity = productList.get(findIdIndex).removeQuantity(addOrRemoveQuantity);
					while (verifyQuantity) {
						System.out.println("Invalid quantity, or you don't have this amount on the stock.");
						System.out
								.println("Your current stock amount is :" + productList.get(findIdIndex).getQuantity());
						System.out.println("Type a valid number to remove from stock: ");
						addOrRemoveQuantity = sc.nextInt();
						verifyQuantity = productList.get(findIdIndex).removeQuantity(addOrRemoveQuantity);
					}
					System.out.println("The amount was succesfully removed from the stock!");
					System.out.println("Now there is " + productList.get(findIdIndex).getQuantity()
							+ "of this product available in stock\n");

				}

				break;

			case 4:

				break;

			case 5:

				break;

			case 0:

				break;

			default:
				System.out.println("invalid value, type a number between 0 and 5.");
				break;
			}

		} while (operation != 0);

		sc.close();
	}

	public static int findIdIndex(ArrayList<Product> productList, int id) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getId() == id) {
				return i;
			}
		}
		return -1;

	}

	public static boolean checkName(ArrayList<Product> productList, String name) {
		for (Product p : productList) {
			if (p.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}

}
