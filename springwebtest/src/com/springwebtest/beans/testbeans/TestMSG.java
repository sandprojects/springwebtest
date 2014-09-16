package com.springwebtest.beans.testbeans;

import org.springframework.stereotype.Component;

@Component
public class TestMSG {
	String MSG;
	public String getMSG() {
		return MSG;
	}
	public void setMSG(String MSG) {
		this.MSG = MSG;
	}
	public TestMSG(){
		this.MSG="Default Dummy Data Message...!";
	}
}
