package com.springwebtest.beans.pizza.domain;

import org.springframework.stereotype.Component;

@Component
public class PaymentDetails {
	PaymentType paymentType;

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
}
