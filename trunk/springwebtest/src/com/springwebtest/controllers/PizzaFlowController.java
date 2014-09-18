package com.springwebtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
@RequestMapping("/pizza")
public class PizzaFlowController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String welcomeFlow(){
		return "flows/pizza/customer/welcome.jspx";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String pizzaPhoneTrack(){
		return "";
	}
}
