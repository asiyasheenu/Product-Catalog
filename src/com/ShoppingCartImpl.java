package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ShoppingCartImpl implements ShoppingCartProgram {
	
	Scanner sc=new Scanner(System.in);
	
	
	Map<String, Integer> products = new HashMap<>();
	Map<String, Integer> quantities = new HashMap<>();
	Map<String, Double> discountRules = new HashMap<>();
	Map<String, Boolean> giftWrap = new HashMap<>();
	
	

	@Override
	public void addProduct() {
		
		products.put("Product A", 20);
	    products.put("Product B", 40);
	    products.put("Product C", 50);
	    
	    
	    discountRules.put("flat_10_discount", 10.0);
        discountRules.put("bulk_5_discount", 0.05);
        discountRules.put("bulk_10_discount", 0.1);
        discountRules.put("tiered_50_discount", 0.5);
		
		    
		for (String product : products.keySet()) {
            System.out.print("Enter quantity for " + product + ": ");
            int quantity = sc.nextInt();
            quantities.put(product, quantity);

            System.out.print("Wrap " + product + " as a gift? (yes/no): ");
            String giftWrapInput = sc.next().toLowerCase();
            giftWrap.put(product, giftWrapInput.equals("yes"));
        }

		
	}

	@Override
	public void calculateTotal() {
		int subtotal = 0;
        for (Map.Entry<String, Integer> entry : quantities.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            int price = products.get(product);
            subtotal += quantity * price;
        }
	
		String discountName = "No discount";
        double discountAmount = 0.0;

        
		for (Entry<String, Double> entry : discountRules.entrySet()) {
            String rule = entry.getKey();
            double ruleDiscount = entry.getValue();

            if (subtotal > 200 && rule.equals("flat_10_discount")) {
                discountAmount = 10.0;
                discountName = rule;
            } else if (subtotal > 10 && rule.equals("bulk_5_discount")) {
                int maxQuantity = 0;
                for (int quantity : quantities.values()) {
                    maxQuantity = Math.max(maxQuantity, quantity);
                }
                if (maxQuantity > 10) {
                    discountAmount = subtotal * ruleDiscount;
                    discountName = rule;
                }
            } else if (subtotal > 20 && rule.equals("bulk_10_discount")) {
                int totalQuantity = 0;
                for (int quantity : quantities.values()) {
                    totalQuantity += quantity;
                }

                if (totalQuantity > 20) {
                    discountAmount = subtotal * ruleDiscount;
                    discountName = rule;
                }
            } else if (subtotal > 30 && rule.equals("tiered_50_discount")) {
                int maxQuantity = 0;
                for (int quantity : quantities.values()) {
                    maxQuantity = Math.max(maxQuantity, quantity);
                }

                if (maxQuantity > 15) {
                    int quantityAbove15 = maxQuantity - 15;
                    discountAmount = quantityAbove15 * products.get("Product C") * ruleDiscount;
                    discountName = rule;
                }
            }
      
		int giftWrapFee = 0;
        for (Map.Entry<String, Boolean> entry1 : giftWrap.entrySet()) {
            String product = entry1.getKey();
            boolean wrapAsGift = entry1.getValue();

            if (wrapAsGift) {
                int quantity = quantities.get(product);
                giftWrapFee += quantity;
            }
        }
        giftWrapFee *= 1;
        
        
        
        
        int totalUnits = 0;
        for (int quantity : quantities.values()) {
            totalUnits += quantity;
        }
        int shippingFee = (totalUnits / 10) * 5;
        
        
        double total = subtotal - discountAmount + shippingFee + giftWrapFee;
        
        
        System.out.println("Product Details:");
        for (Map.Entry<String, Integer> entry1 : quantities.entrySet()) {
            String product = entry1.getKey();
            int quantity = entry1.getValue();
            int totalAmount = quantity * products.get(product);
            System.out.println(product + ": Quantity - " + quantity + ", Total - $" + totalAmount);
        }

        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Discount Applied: " + discountName + ", Amount: $" + discountAmount);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Gift Wrap Fee: $" + giftWrapFee);
        System.out.println("Total: $" + total);

   

		
	}

        
		
	}
	
	
}
