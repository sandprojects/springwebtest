package com.springwebtest.beans.testbeans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class UserLogin {
	//@Size(min=3, max=20, message="{message.genForm.useridSizeValidation}")
	//@Pattern(regexp="^[a-zA-Z0-9]+$", message="{message.genForm.useridPattern}")
	@NotBlank(message = "{message.genForm.useridBlankValidation}")
	String username;
	
	//@Size(min=6,max=20, message="{message.genForm.passwordSizeValidation}")
	@NotBlank(message = "{message.genForm.passwordBlankValidation}")
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
