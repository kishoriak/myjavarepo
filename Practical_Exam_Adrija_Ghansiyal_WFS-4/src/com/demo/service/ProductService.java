package com.demo.service;
//name:adrija ghansiyal
//purpose:interface of product service
import java.util.List;
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ItemNotFoundException;

public interface ProductService {

	List<Product> generateReport(String category) throws ItemNotFoundException;

}
