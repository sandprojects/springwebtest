package com.springwebtest.beans.pizza.domain;

//import static org.apache.commons.lang.WordUtils.*;

import java.util.Arrays;
import java.util.List;

public enum PaymentType {
	
	CASH, CHECK, CREDIT_CARD;
	
	public static List<PaymentType> asList(){
		PaymentType[] all=PaymentType.values();
		return Arrays.asList(all);
	}
	
	/*@Override
	public String toString(){
		return capitalizeFully(name().replace('_',' '));
	}

	private String capitalizeFully(String replace) {
		// TODO Auto-generated method stub
		return replace.replace(arg0, arg1);
	}*/
}
