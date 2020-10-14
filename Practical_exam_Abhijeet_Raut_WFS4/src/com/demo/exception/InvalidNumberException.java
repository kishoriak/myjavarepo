package com.demo.exception;

//Exception if number is not valid
public class InvalidNumberException extends Exception{
	public InvalidNumberException(String msg) {
		super(msg);
	}
}
