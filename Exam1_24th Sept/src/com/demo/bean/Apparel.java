package com.demo.bean;

//Inherits Items Class
public class Apparel extends Items {
    private int size;
    private String material;


    //Default Constructor
    public Apparel() {
        this.size = 0;
        this.material = null;
    }

    //Parameterized Constructor
    public Apparel(int code, String name, float price, int qty, int size, String material) {
        super(code, name, price, qty);
        this.size = size;
        this.material = material;
    }



    //Getter and Setter Methods
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //ToString method overridden

    @Override
    public String toString() {
        return "Apparel{" +
                "size=" + size +
                ", material='" + material + '\'' +
                '}';
    }
}
