package com.springwebtest.beans.pizza.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PaymentDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	PaymentType paymentType;
	
	float amount;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
