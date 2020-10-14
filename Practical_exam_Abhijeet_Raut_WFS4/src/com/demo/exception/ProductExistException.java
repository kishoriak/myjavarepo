package com.demo.exception;

//Exception when product exists already
public class ProductExistException extends Exception{
	public ProductExistException(String msg) {
		super(msg);
	}

}
