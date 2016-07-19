package com.niit.mycart;

public class Product {
	private String id;
	private String name;
	private double price;
	private String category;
	
	

	public Product(String id, String name, double price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			System.out.println("Please enter a valid number,Minimum value is Rs.10");
		} else {
			this.price = price;
		}
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
