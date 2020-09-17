package com.demo.bean;
import java.util.Date;


 

public class Person {
	static {
		cnt=0;
	}
	public static int cnt;
	private int perId;
	private String perName;
	private Date bDate;
	private String mobile;
	private String email;
	
	//Default Constructor
	public Person() {
		perId=++cnt;
		perName=null;
		bDate=null;
		mobile=null;
		email=null;
	}
	
	//parametrised constructor
	public Person(String perName,Date bDate,String mob,String email) {
		this.perId=++cnt;
		this.perName=perName;
		this.bDate=bDate;
		this.mobile=mob;
		this.email=email;
		
	}
	///setter and getter methods
	/*public void setPerId(int id) {
		this.perId=id;
	}*/
	public String getEmail() { 
		return this.email;
	}
	public void setEmail(String em) {
		this.email=em;
	}
	public int getPerId() { 
		return this.perId;
	}
	public void setPerName(String pname) {
		this.perName=pname;
	}
	public String getPerName() {
		return this.perName;
	}
	
	public void setMobile(String mob) {
		this.mobile=mob;
		
	}
	public String getMobile() {
		return this.mobile;
	}
	public void setBDate(Date dt) {
		this.bDate=dt;
	}
	public Date getDate() {
		return this.bDate;
	}
  
	@Override
	public String toString() {
		return "Id : "+perId+"\nName : "+perName+"\nMobile: "+mobile+"\nB date:"+bDate+"\nEmail : "+email;
		
	}
	/*public void display() {
		System.out.println("Id : "+this.perId);
		System.out.println("Name : "+this.perName);
		System.out.println("bDate : ");
		System.out.println("Mobile :"+mobile);
		
	}*/
	
	/*  this is destructor
	 * public void finalize(){
		
	}*/
	
	
	

}
