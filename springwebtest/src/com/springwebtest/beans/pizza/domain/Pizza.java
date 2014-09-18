package com.springwebtest.beans.pizza.domain;

import java.util.List;

public class Pizza {
	
	String size;
	List<Topping>  toppings;

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<Topping> getToppings() {
		return toppings;
	}
	public void setToppings() {
		this.toppings = Topping.asList();
	}
}
