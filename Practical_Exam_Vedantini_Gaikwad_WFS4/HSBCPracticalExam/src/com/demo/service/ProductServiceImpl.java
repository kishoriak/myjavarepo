package com.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.FoodItems;
import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

//Vedantini gaikwad
//Business layer implementation

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	public ProductServiceImpl(){
		this.productDao=new ProductDaoImpl();
	}
	
	Product foodItem;
	Product apparel;
	Product electronic;
	SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	
	String dt1="22/10/2020";
	String dt2="24/10/2020";
	Date date1=null;
	Date date2=null;
	
	@Override
	public void addItems(){
	try {
		date1 = sdf.parse(dt1);
		date2=sdf.parse(dt2);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	foodItem= new FoodItems(101,"Milk",40,50.0,1,date1,date2,true);
	productDao.addData(foodItem);
	foodItem= new FoodItems(102,"Milk",20,50.0,1,date1,date2,true);
	productDao.addData(foodItem);
	foodItem= new FoodItems(111,"Milk",12,50.0,1,date1,date2,true);
	productDao.addData(foodItem);
	
	apparel=new Apparel(222,"T-shirt",50,1000,2,"large","woolen");
	productDao.addData(apparel);
	apparel=new Apparel(432,"T-shirt",32,1000,2,"large","woolen");
	productDao.addData(apparel);
	apparel=new Apparel(325,"T-shirt",20,1000,2,"large","woolen");
	productDao.addData(apparel);
	
	electronic=new Electronics(1012,"TV",100,10000.67,3,10);
	productDao.addData(electronic);
	electronic=new Electronics(1026,"TV",97,10000.67,3,10);
	productDao.addData(electronic);
	electronic=new Electronics(1114,"TV",54,10000.67,3,10);
	productDao.addData(electronic);
	}

	@Override
	public Map<Integer, Product> displayItems() {
		return productDao.displayAll();
	}

	@Override
	public Map<Integer, Product> displayFoodItems() {
		return productDao.displayAllFoodItems();
	}

	@Override
	public Map<Integer, Product> displayApparel() {
		return productDao.displayAllApparels();
	}

	@Override
	public Map<Integer, Product> displayElectronic() {
		return productDao.displayAllElectronics();
	}
}
