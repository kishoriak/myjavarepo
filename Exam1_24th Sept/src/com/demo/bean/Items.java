package com.demo.bean;

//POJO class for all the 3 items
public class Items {
    protected int code;
    protected String name;
    protected float price;
    protected int qty;


//static int count=0;

    //Default Constructor
    public Items() {
    code=1110;
    name=null;
    price=0.0f;
    qty=0;
    }

    //Parameterized Constructor
    public Items(int code, String name, float price,int qty) {
        //count++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.qty=qty;
    }



    //Setter and Getter Methods
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }



    //ToString method overridden to be shown in System.out.println()
    @Override
    public String toString() {
        return "Items{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
