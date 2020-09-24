package com.demo.service;

//name:adrija ghansiyal
//purpose: implementing  product service (Business layer)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.comparator.QtyComparator;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.exception.ItemNotFoundException;

public class ProductServiceImpl implements ProductService {
	static {
		productDao = new ProductDaoImpl();
	}
	static private ProductDao productDao;

	@Override
	public List<Product> generateReport(String category) throws ItemNotFoundException {
		Set<Product> targetSet= productDao.getSet(category);
		if(targetSet!=null) {
		List<Product> list = new ArrayList<>(targetSet);
		Collections.sort(list,new QtyComparator());
        return list;
		}
		else 
			throw new ItemNotFoundException("item not found");
		
	}
	

}
