package com.demo.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

//FoodItems class has inherited the Items class
public class FoodItems extends Items{

    private Date dOfManf;
    private Date dOfExp;
    //1 for vegeteraian, 0 for non-vegeterian
    private int vegType;


    //Default Constructor
    public FoodItems() {
        this.dOfManf = null;
        this.dOfExp = null;
        this.vegType = 0;
    }


    //Parameterized Constructor
    public FoodItems(int code, String name, float price, int qty, Date dOfManf, Date dOfExp, int vegType) {
        super(code, name, price, qty);
        this.dOfManf = dOfManf;
        this.dOfExp = dOfExp;
        this.vegType = vegType;
    }

    //Setter and Getter Methods
    public Date getdOfManf() {
        return dOfManf;
    }

    public void setdOfManf(Date dOfManf) {
        this.dOfManf = dOfManf;
    }

    public Date getdOfExp() {
        return dOfExp;
    }

    public void setdOfExp(Date dOfExp) {
        this.dOfExp = dOfExp;
    }

    public int getVegType() {
        return vegType;
    }

    public void setVegType(int vegType) {
        this.vegType = vegType;
    }

//    //ToString method overridden
    @Override
    public String toString() {
        return "FoodItems{" +
                "dOfManf=" + dOfManf +
                ", dOfExp=" + dOfExp +
                ", vegType=" + vegType +
                '}';
    }


}
