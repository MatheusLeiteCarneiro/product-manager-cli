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
			System.out.println("0-to finish the operations");
			operation = sc.nextInt();
			System.out.println();
			int findIdIndex;
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
				while (!verifyName) {
					System.out.print("This name is invalid or already register, try another one: ");
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
				if (!verifyIfHaveProduct(productList)) {
				} else {
					for (Product p : productList) {
						System.out.print(p);
					}
					System.out.println();
				}
				break;

			case 3:
				if (!verifyIfHaveProduct(productList)) {
				} else {

					System.out.print("Type the ID of the Product you want add or remove a quantity: ");
					int addOrRemoveId = sc.nextInt();
					int idIndex = findIdIndex(productList, addOrRemoveId);
					while (idIndex == -1) {
						System.out.print("This ID does not exist, type a valid id: ");
						addOrRemoveId = sc.nextInt();
						idIndex = findIdIndex(productList, addOrRemoveId);
					}

					System.out.println("The product is: " + productList.get(idIndex));
					System.out.print("Type 1-to add to stock or 2-to remove from stock: ");
					int addOrRemove = sc.nextInt();
					while (addOrRemove != 1 && addOrRemove != 2) {
						System.out.print("Invalid digit, type 1 to add or 2 to remove: ");
						addOrRemove = sc.nextInt();
					}
					if (addOrRemove == 1) {
						System.out.print("Type the quantity you want to add to the stock: ");
						int addOrRemoveQuantity = sc.nextInt();
						boolean verifyQuantity = productList.get(idIndex).addQuantity(addOrRemoveQuantity);
						while (!verifyQuantity) {
							System.out.println("Invalid quantity, type a valid number to add: ");
							addOrRemoveQuantity = sc.nextInt();
							verifyQuantity = productList.get(idIndex).addQuantity(addOrRemoveQuantity);
						}
						System.out.println("The amount was succesfully added to the stock!");
						System.out.println("Now there is " + productList.get(idIndex).getQuantity()
								+ " unit(s) of this product available in stock\n");

					}

					else {
						System.out.print("Type the quantity you want to remove from the stock: ");
						int addOrRemoveQuantity = sc.nextInt();
						boolean verifyQuantity = productList.get(idIndex).removeQuantity(addOrRemoveQuantity);
						while (!verifyQuantity) {
							System.out.println("Invalid quantity, or you don't have this amount on the stock.");
							System.out
									.println("Your current stock amount is :" + productList.get(idIndex).getQuantity());
							System.out.print("Type a valid number to remove from stock: ");
							addOrRemoveQuantity = sc.nextInt();
							verifyQuantity = productList.get(idIndex).removeQuantity(addOrRemoveQuantity);
						}
						System.out.println("\nThe amount was succesfully removed from the stock!");
						System.out.println("Now there is " + productList.get(idIndex).getQuantity()
								+ " unit(s) of this product available in stock\n");

					}
				}
				break;

			case 4:
				if (!verifyIfHaveProduct(productList)) {
				} else {
					System.out.print("Type the ID of the Product you want to change information: ");
					int idChangeProduct = sc.nextInt();
					findIdIndex = findIdIndex(productList, idChangeProduct);
					while (findIdIndex == -1) {
						System.out.print("This ID does not exist, type a valid id: ");
						int addOrRemoveId = sc.nextInt();
						findIdIndex = findIdIndex(productList, addOrRemoveId);
					}

					System.out.println("The product is: " + productList.get(findIdIndex));
					System.out.println("What information do you want to change?");
					System.out.print("Type 1-to change the name, 2-to change the price, 3-to change both: ");
					int informationToChange = sc.nextInt();
					System.out.println();
					while (informationToChange != 1 && informationToChange != 2 && informationToChange != 3) {
						System.out.print("Invalid digit, type 1, 2 or 3: ");
						informationToChange = sc.nextInt();
					}

					if (informationToChange == 1 || informationToChange == 3) {
						System.out.println(
								"The actual name of this product is: " + productList.get(findIdIndex).getName());
						System.out.print("Type the new name of the product: ");
						sc.nextLine();
						String newName = sc.nextLine();
						verifyName = checkName(productList, newName);
						while (!verifyName) {
							System.out.print("This name is invalid or already register, try another one: ");
							newName = sc.nextLine();
							verifyName = checkName(productList, newName);
						}
						productList.get(findIdIndex).setName(newName);

						if (informationToChange == 1) {
							System.out.println("The name was succesfully changed to "
									+ productList.get(findIdIndex).getName() + "!\n");
						}

					}

					if (informationToChange == 2 || informationToChange == 3) {
						System.out.println(
								"\nThe actual price of this product is: $" + productList.get(findIdIndex).getPrice());
						System.out.print("Type the new price of the product: ");
						double newPrice = sc.nextDouble();
						boolean changePrice = productList.get(findIdIndex).setPrice(newPrice);
						while (!changePrice) {
							System.out.print("The price must be greater than 0, type another price: ");
							newPrice = sc.nextDouble();
							changePrice = productList.get(findIdIndex).setPrice(newPrice);
						}
						if (informationToChange == 2) {
							System.out.println("The price was succesfully changed to $"
									+ productList.get(findIdIndex).getPrice() + "!\n");
						}
					}
					if (informationToChange == 3) {
						System.out.println(
								"\nThe name was succesfully changed to " + productList.get(findIdIndex).getName()
										+ ", and the price was succesfully changed to $"
										+ productList.get(findIdIndex).getPrice() + "\n");
					}

				}

				break;

			case 5:
				if (!verifyIfHaveProduct(productList)) {
				} else {
					System.out.print("Type the ID of the product you want to delete it: ");
					int idToDelete = sc.nextInt();
					findIdIndex = findIdIndex(productList, idToDelete);
					while (findIdIndex == -1) {
						System.out.print("This ID does not exist, type a valid id: ");
						int addOrRemoveId = sc.nextInt();
						findIdIndex = findIdIndex(productList, addOrRemoveId);
					}
					System.out.println("Confirm deletion of the following product?");
					System.out.println(productList.get(findIdIndex));
					System.out.print("Type 1-to confirm or 0-to cancel: ");
					int confirmDeletion = sc.nextInt();
					while (confirmDeletion != 0 && confirmDeletion != 1) {
						System.out.print("invalid value, type 1-to confirm or 0-to cancel");
						confirmDeletion = sc.nextInt();
					}
					if (confirmDeletion == 1) {
						productList.remove(findIdIndex);
						System.out.println("The product was succesfully deleted!\n");
					} else {
						System.out.println("Operation canceled\n");
					}

				}

				break;

			case 6:
				if (!verifyIfHaveProduct(productList)) {
				} else {
					totalValueInStock(productList);
				}

				break;

			case 0:
				if (!verifyIfHaveProduct(productList)) {
				} else {
					System.out.println("Final Data:");
					for (Product p : productList) {
						System.out.print(p);
					}
					totalValueInStock(productList);
				}
				System.out.println("Operations finished!");

				break;

			default:
				System.out.println("invalid value, type a number between 0 and 5.");
				break;
			}

		} while (operation != 0);

		sc.close();
	}

	public static boolean verifyIfHaveProduct(ArrayList<Product> productList) {
		if (productList.size() == 0) {
			System.out.println("There aren't products registered\n");
			return false;
		}
		return true;
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
		if (name == null || name.trim().isBlank()) {
			return false;
		}
		for (Product p : productList) {
			if (p.getName().equalsIgnoreCase(name)) {
				return false;
			}
		}

		return true;
	}

	public static double totalValueInStock(ArrayList<Product> productList) {
		double total = 0.0;
		for (Product p : productList) {
			System.out.println(p.totalValueString());
			total += p.getPrice() * p.getQuantity();
		}
		System.out.printf("The total value in stock is: $%.2f%n%n", total);
		return total;

	}

}
