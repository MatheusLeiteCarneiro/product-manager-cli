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
			System.out.println("1-to register a new product, 2-to list all the products in stock, 3-to add or remove quantity to an existing product");
			System.out.println("4-change the information of a product, 5-to delete a product from stock, 6-calculate value in stock");
			System.out.println("0-to end operation");
			operation = sc.nextInt();
			switch (operation) {
				case 1:	
					System.out.print("\nRegistering product:\n");
					System.out.print("Product id: ");
					int id = sc.nextInt();
					boolean verifyId = checkId(productList, id);
					while(verifyId) {
						System.out.println("This Id is already registered, try another one:");
						id = sc.nextInt();
						verifyId = checkId(productList, id);
					}
					sc.nextLine();
					System.out.print("Product name: ");
					String name = sc.nextLine();
					boolean verifyName = checkName(productList, name);
					while(verifyName) {
						System.out.println("This Name is already registered, try another one:");
						name = sc.nextLine();
						verifyName = checkName(productList, name);
					}
					
					System.out.print("Product price: ");					
					double price = sc.nextDouble();
					while(price < 0.0) {
						System.out.print("The price must be greater than 0, type another price: ");
						price = sc.nextDouble();
					}
					System.out.print("Product initial quantity in stock: ");
					int quantity = sc.nextInt();
					while(quantity < 0) {
						System.out.print("The quantity must be greater than 0, type another quantity: ");
						quantity = sc.nextInt();
					}
					
					productList.add(new Product(id,name,price,quantity));
					System.out.print("The product was successfully registered!\n\n");
					break;
				case 2:
					
					break;
				case 3:
					
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
			
			
			
			
			
			
			
			
			
			
			
		}
		while(operation != 0);
		
		
		
		
		
		
		sc.close();
	}

	public static boolean checkId (ArrayList<Product> productList, int id) {
		for(Product p : productList) {
			if(p.getId() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean checkName (ArrayList<Product> productList, String name) {
		for(Product p : productList) {
			if(p.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
}
