package com.demo.dao;

import java.util.Set;
import java.util.TreeSet;

import com.demo.bean.Item;

public interface ItemDao {

	void addItems(Item item);
	Set<Item> displayAllItems();
	
}
