package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> productList = new ArrayList<>();
		int operation = 1;
		do {
			System.out.println("What's the operation you want to make it?");
			System.out.println("Type: 1-to register a new product, 2-to list all the products in stock, 3-to add or remove quantity to an existing product");
			System.out.println(" 4-change the information of a product, 5-to delete a product from stock, 6-calculate value in stock");
			System.out.println("0-to end operation");
			operation = sc.nextInt();
			switch (operation) {
				case 1:	
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

}
