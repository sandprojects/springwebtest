package com.springwebtest.beans.pizza.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component
@WebService(serviceName="SpizzaService")
public class ServiceClass implements ServiceInterface{
	
	@Override
	@WebMethod
	public String getHotOffer(){
		return "Hot offer demo from pizza service..!";
	}
}
