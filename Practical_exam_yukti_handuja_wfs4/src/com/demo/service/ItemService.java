package com.demo.service;

import java.util.Set;

import com.demo.bean.Item;

public interface ItemService {

	void addNewItemInfo(int ch);
	Set<Item> displayAllItems();
}
