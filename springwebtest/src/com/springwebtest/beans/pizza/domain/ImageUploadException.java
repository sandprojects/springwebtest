package com.springwebtest.beans.pizza.domain;

import java.io.IOException;

public class ImageUploadException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageUploadException(String str){
		super(str);
	}

	public ImageUploadException(String string, IOException e) {
		super(string, e);
	}
}
