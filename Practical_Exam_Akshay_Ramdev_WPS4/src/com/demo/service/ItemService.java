//Shubham Ramesh Tapele
//Interface to have all ServiceLAyer Functions Initialiser

package com.demo.service;

import java.util.Set;

import com.demo.bean.Apparel;
import com.demo.bean.Electronics;
import com.demo.bean.Food;

public interface ItemService {
	
	static Set<Food> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}
	Set<Electronics> getAllElec();
	Set<Apparel> getAllApp();
	static Set<Apparel> getAllApparel() {
		// TODO Auto-generated method stub
		return null;
	}
	static Set<Electronics> getAllElectronics() {
		// TODO Auto-generated method stub
		return null;
	}

}
