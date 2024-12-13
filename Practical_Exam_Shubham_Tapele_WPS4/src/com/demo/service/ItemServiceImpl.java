//Shubham Ramesh Tapele
//Implementaion of Service Interface

package com.demo.service;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;
import com.demo.dao.ItemDaoImpl;

public class ItemServiceImpl implements ItemService{

	private ItemDaoImpl itemDao;
    static Scanner sc;
    static SimpleDateFormat sdf;
    static {
  	  sc=new Scanner(System.in);
  	  sdf=new SimpleDateFormat("dd/MM/yyyy");
	
    }
    
   
    //Funtion to call Dao layer
	public Set<Food> getAllFood() {
		return itemDao.getAllFood();
	}
    //Funtion to call Dao layer
	@Override
	public Set<Electronics> getAllElec() {
		return itemDao.getAllElec();
	}
    //Funtion to call Dao layer
	@Override
	public Set<Apparel> getAllApp() {
		return itemDao.getAllApp();
	}

}
