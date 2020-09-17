package com.demo.test;

import java.util.Date;

import com.demo.bean.Employee;
import com.demo.bean.SalariedEmp;

public class TestEmployee {

	public static void main(String[] args) {
		SalariedEmp e=new SalariedEmp(12,"aaa",new Date(),"2222","hr","mgr",20000.00,1000.00f);
		System.out.println(e);
		System.out.println(e.getPerId());

	}

}
