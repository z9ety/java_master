package com.serv;

public class BookVO {

	String name;
	String publsher;
	String price;
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getPublsher() {
		return publsher;
	}
	void setPublsher(String publsher) {
		this.publsher = publsher;
	}
	String getPrice() {
		return price;
	}
	void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookVO [name=" + name + ", publsher=" + publsher + ", price=" + price + "]";
	}
	
	
}
