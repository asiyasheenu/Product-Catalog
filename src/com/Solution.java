package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ShoppingCartProgram scp=new ShoppingCartImpl();
			
		while(true) {
			System.out.println("1->Add Product\n 2->Calculate Total\n 3->Exit");
			System.out.println("Enter Choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				scp.addProduct();
				break;
			
			case 2:
				scp.calculateTotal();
				break;
				
			case 3:
				System.out.println("Thank  You");
			
				
			}
		}
		
		

	}

}
