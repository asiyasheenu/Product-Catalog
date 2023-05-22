package com;

public class Product {
	
	private String productname;
	private int quantity;
	private double cost;
	
	
	
	public Product( String productname,int quantity, double cost) {
		this.productname=productname;
		this.quantity = quantity;
		this.cost = cost;
		
		
		
	}

	

	public String getProductname() {
		return productname;
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}



	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}



	@Override
	public String toString() {
		return "Product name: " + productname + ", quantity: " + quantity + ", cost: " + cost;
	}
	
	

	
}
