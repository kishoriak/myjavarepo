package com.demo.exception;

//If the item asked by the user is not found
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
