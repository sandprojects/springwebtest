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

	@Size(min=3, max=50, message="{message.customer.nameSizeValidation}")
	String fullName;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	@NotBlank(message = "{message.customer.nameBlankValidation}")
	String username;
	@Size(min=6,max=20, message="The password must be atleast 6 characters long.")
	String password;
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Invalid email address.")
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
