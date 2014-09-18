package com.springwebtest.beans.pizza.domain;

import java.util.Arrays;
import java.util.List;

public enum Topping {
	ONNION, CHEESE, TOMATO, CORN;
	
	public static List<Topping> asList(){
		Topping[] all=Topping.values();
		return Arrays.asList(all);
	}
}
