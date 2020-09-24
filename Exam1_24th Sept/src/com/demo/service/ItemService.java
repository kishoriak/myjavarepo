package com.demo.service;

import com.demo.exception.ItemNotFoundException;
import com.demo.bean.Items;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Apparel;
import com.demo.dao.ItemDaoImpl;
import com.demo.dao.ItemDao;

import java.util.Scanner;


//Service Class to interact with dao and test layers
public class ItemService {

    static {
        sc=new Scanner(System.in);
    }
    static Scanner sc;
    private ItemDao itemDao;


    //Method to add items
    public void addItem(Items iarr) {

    }

    public void displayAll(Items iarr){

    }

}
