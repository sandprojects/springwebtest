package com.springwebtest.beans.testbeans;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{message.customer.nameBlankValidation}")
	@Size(min=3, max=50, message="{message.genForm.nameBlankValidation}")
	String fullName;
	
	@Size(min=3, max=20, message="{message.genForm.useridSizeValidation}")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="{message.genForm.useridPattern}")
	@NotBlank(message = "{message.genForm.useridBlankValidation}")
	String username;
	@Size(min=6,max=20, message="{message.genForm.passwordSizeValidation}")
	@NotBlank(message = "{message.genForm.passwordBlankValidation}")
	String password;
	@NotBlank(message = "{message.genForm.emailBlankValidation}")
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="{message.genForm.emailPattern}")
	String email;
	
	boolean updateByEmail;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isUpdateByEmail() {
		return updateByEmail;
	}
	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
	
}
