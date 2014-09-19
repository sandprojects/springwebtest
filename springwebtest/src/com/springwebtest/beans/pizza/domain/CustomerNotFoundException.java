package com.springwebtest.beans.pizza.domain;

import org.springframework.stereotype.Component;

@Component
public class CustomerNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(){
		super("CustomerNotFoundException");
	}

}
