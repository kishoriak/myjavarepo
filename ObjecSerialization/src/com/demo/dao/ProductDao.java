package com.demo.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.demo.bean.Product;

public class ProductDao implements ProductDaoInterface {
	private static HashMap<Integer, Product> map;
	private static boolean isFileNull = true;
	static {
		map = new HashMap<Integer, Product>();
	}

	@Override
	public void readDatafromFile(String fileName) {
		ObjectInputStream ois = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(fileName);
			ois = new ObjectInputStream(fin);
			while (true) {
				try {
					Product p = (Product) ois.readObject();
					map.put(p.getPid(), p);
					isFileNull = false;
				} catch (EOFException e) {
					System.out.println("end of file");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void writeDataToFile(String fileName) {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fout);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void appendDataToFile(String fileName, Product p) {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(fileName, true);
			if (isFileNull) {
				oos = new ObjectOutputStream(fout);
			} else {
				oos = new AppendableObjectOutputStream(fout);
			}
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean addProduct(Product p, String fileName) {
		map.put(p.getPid(), p);
		appendDataToFile(fileName, p);
		System.out.println("product appended");
		return true;
	}

	@Override
	public String deleteProduct(int id, String fileName) {
		if (map.remove(id) != null) {
			writeDataToFile(fileName);
		} else {
			return "Product Not Found";
		}
		return "Product deleted successfully";
	}

	@Override
	public HashMap<Integer, Product> getAllProduct() {
		return map;
	}

	@Override
	public Product updateProduct(int id, int qty, String fileName) {
		Product p = map.get(id);
		if (p == null) {
			return null;
		}
		p.setQty(qty);
		writeDataToFile(fileName);
		return p;
	}

	@Override
	public Product getProductById(int id) {
		return map.get(id);
	}

}
