//Shubham Ramesh Tapele
//Dao Layer Interface

package com.demo.dao;

import java.util.Set;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;

public interface ItemDao {


	Set<Electronics> getAllElec();

	Set<Apparel> getAllApp();

	Set<Food> getAllFood();

}
