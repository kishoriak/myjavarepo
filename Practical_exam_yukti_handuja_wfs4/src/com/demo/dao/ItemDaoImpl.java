package com.demo.dao;

//Interface of ItemDaoImpl class
import java.util.Set;
import java.util.TreeSet;

import com.demo.bean.Item;


public class ItemDaoImpl implements ItemDao {
	
	//the static block is for the tree collection class object assignment
	static{
		tset=new TreeSet<>();
	}
	
	//Object creation class tree
	static Set<Item> tset;
	@Override
	public void addItems(Item item)  {
		try {
			tset.add(item);
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
		
		
	}



@Override
	//Displaying the data
	public Set<Item> displayAllItems() {
	try {
		return tset;
	}
	catch(NullPointerException e)
	{
		System.out.println(e);
	}
	return null;
}





}
