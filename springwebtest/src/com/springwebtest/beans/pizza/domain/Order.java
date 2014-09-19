package com.springwebtest.beans.pizza.domain;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable{
	private static final long serialVersionUID=1L;
	private Customer customer;
	private List<Pizza> pizzas;
	private boolean payment;
	
	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public Order(){
		pizzas=new ArrayList<Pizza>();
		customer=new Customer();
	}
	
	public void addPizza(Pizza pizza){
		this.pizzas.add(pizza);
	}
	public Customer getCustomer(){
		return customer;
	}	
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public List<Pizza> getPizzas(){
		return pizzas;
	}
	
	public void setPizzas(List<Pizza> pizzas){
		this.pizzas=pizzas;
	}
	public float getTotal(){
		return 0.0f;
	}

}