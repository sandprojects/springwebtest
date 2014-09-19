package com.springwebtest.beans.pizza.domain;

import org.springframework.stereotype.Component;

@Component
public class PizzaFlowActions {
	
	public String saveOrder(Order order){
		return "Your order is saved..!";
	}
	
	public boolean checkDeliveryArea(String customerZipCode){
		return true;
	}
	
	public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException{
		
		throw new CustomerNotFoundException();
		//return null;
	}
	
	public void addCustomer(Customer customer){
		return;
	}
}
