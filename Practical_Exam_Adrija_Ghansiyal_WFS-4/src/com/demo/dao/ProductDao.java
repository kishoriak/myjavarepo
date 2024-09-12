package com.demo.dao;
//name:adrija ghansiyal
//purpose:interface of product dao (data layer)
import java.util.Set;

import com.demo.bean.Product;
import com.demo.exception.ItemNotFoundException;

public interface ProductDao {

	Set<Product> getSet(String category) throws ItemNotFoundException;

}
