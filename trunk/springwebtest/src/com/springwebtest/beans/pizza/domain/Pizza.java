package com.springwebtest.beans.pizza.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Pizza implements Serializable{
	private static final long serialVersionUID=1L;
	
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
	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
}
