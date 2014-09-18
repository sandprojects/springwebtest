package com.springwebtest.beans.pizza.domain;

public class PizzaFlowActions {
	
	public String saveOrder(Order order){
		return "Your order is saved..!";
	}
	
	public boolean checkDeliveryArea(String customerZipCode){
		return true;
	}
	
}
