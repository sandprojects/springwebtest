package com.springwebtest.beans.testbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CityService {
	
	private Properties seloption;

	public Properties getSeloption() {
		return this.seloption;
	}

	public void setSeloption(Properties seloption) {
		this.seloption = seloption;
	}
	
	public List<City> cties;

	public List<City> getCties() {
		return this.cties;
	}

	public void setCties(List<City> cties) {
		this.cties = cties;
	}
}
