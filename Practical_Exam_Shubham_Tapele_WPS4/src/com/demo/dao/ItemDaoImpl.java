//Shubham Ramesh Tapele
//Dao Layer Implementaion of Dao Interface 

package com.demo.dao;

import java.util.Set;
import java.util.TreeSet;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;

public class ItemDaoImpl implements ItemDao{
	//Create Set of all Entities
	static Set<Electronics> eset;
	static Set<Apparel> aset;
	static Set<Food> fset;
	static {
		eset=new TreeSet<>();
		aset=new TreeSet<>();
		fset=new TreeSet<>();
	}
	//Function to get all Electronics
	@Override
	public Set<Electronics> getAllElec() {
		return eset;
	}
	//Function to get all Apparel
	@Override
	public Set<Apparel> getAllApp() {
		return aset;
	}
	//Function to get all Food
	@Override
	public Set<Food> getAllFood() {
		return fset;
	}

}
