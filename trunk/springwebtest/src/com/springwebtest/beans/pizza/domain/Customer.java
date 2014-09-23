package com.springwebtest.beans.pizza.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;


@Component
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	MessageSource msg;
	
	String address, city, state, zipCode;
	
	@NotNull(message = "{message.customer.phonenoNullValidation}")
	@NotBlank(message = "{message.customer.phonenoBlankValidation}")
	String phoneNumber;
	
	@Size(min=3, max=50, message="{message.customer.nameSizeValidation}")
	@NotNull(message = "{message.customer.nameNullValidation}")
	@NotBlank(message = "{message.customer.nameBlankValidation}")
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
