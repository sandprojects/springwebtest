package com.springwebtest.beans.testbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CityService {
	
	private static Properties seloption;

	public static Properties getSeloption() {
		return CityService.seloption;
	}

	public static void setSeloption(Properties seloption) {
		CityService.seloption = seloption;
	}
	
	public List<City> cties;

	public List<City> getCties() {
		return cties;
	}

	public void setCties(List<City> cties) {
		this.cties = cties;
	}
}
