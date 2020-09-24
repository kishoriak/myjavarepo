package com.demo.dao;
import java.util.List;
import com.demo.bean.product;


// product dao interface
public interface ProductDao {
	void addProduct(product p);
	
	List<product> top3food();
	List<product> top3apparel();
	List<product> top3electronics();
	

}
