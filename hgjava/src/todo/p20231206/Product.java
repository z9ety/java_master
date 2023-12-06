package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	private String code;
	private String name;
	private int price;
	
	Product(String code, String name, int price){
		this.code = code;
		this.name = name;
		this.price = price;
	}
}
