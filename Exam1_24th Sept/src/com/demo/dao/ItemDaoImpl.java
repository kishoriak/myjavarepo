package com.demo.dao;

import com.demo.bean.Items;
import com.demo.bean.FoodItems;
import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemDaoImpl implements ItemDao{

    public List<Items> ilist;

        //Compares 2 products based on quantity

    public int compare(Items i1,Items i2) throws ItemNotFoundException{

        return 0;

    }

    /*//To compare

    public List<Items> getItems(List list){
        ArrayList<Items> ls=new ArrayList<>();
        //Collections.sort(list, new );

    }*/


    //Adds 2 products
    public void addItem(Items iarr) {
        ilist.add(iarr);
    }

    //Display items
    public List<Items> getProducts(List list) {
        // TODO Auto-generated method stub
        ArrayList<Items> newList= new ArrayList<>();
        //Collections.sort(list, new ());
        for(int i=0;i<3;i++)
        {
            newList.add((Items) list.get(i));
        }
        return newList;
    }
//To display all the items
        public List<Items> getAllItemss() {
            // TODO Auto-generated method stub
            return this.ilist;
        }

}
