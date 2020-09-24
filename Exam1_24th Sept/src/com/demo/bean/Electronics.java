package com.demo.bean;


//Inherited Items class
public class Electronics extends Items{
    private int wrntyMnths;


    //Default Constructor
    public Electronics() {
        wrntyMnths=0;
    }


    //Parameterized Constructor
    public Electronics(int code, String name, float price,int qty) {
        super(code, name, price, qty);
        wrntyMnths=0;
    }


    //Setter & Getter Methods
    public int getWrntyMnths() {
        return wrntyMnths;
    }

    public void setWrntyMnths(int wrntyMnths) {
        this.wrntyMnths = wrntyMnths;
    }


    //ToString method to override
    @Override
    public String toString() {
        return "Electronics{" +
                "wrntyMnths=" + wrntyMnths +
                '}';
    }
}
