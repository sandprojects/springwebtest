package com.springwebtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pizza")
public class PizzaFlowController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String welcomeFlow(){
		return "pizza/customer/welcome";
	}
}
