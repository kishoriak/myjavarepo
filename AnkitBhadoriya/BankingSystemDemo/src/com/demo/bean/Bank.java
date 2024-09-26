package com.demo.bean;
import com.demo.test.TestBanking;
import java.util.Date;


	
	public class Bank {
		
		private int accountId;
		private String accountName;
		private Date bDate;
		private String type;
		private double balance;

	//Default constructor
		public Bank() {
			accountId=0;
			accountName=null;
			bDate=null ;
			type=null;
			balance=0;
		}
		//praameterized condtructor;
		public Bank(int id, String accountName, Date bDate, String type, double balance ) {
			this.accountId=id;
			this.accountName =accountName;
			this.bDate=bDate;
			this.type=type;
			this.balance=balance;
		}
		
		//setter and getter methods
			public void setAccountId(int id) {
			this.accountId=id;
			}
			public int getAccountId() {
				 return this.accountId;
			}
			public void SetAccountName(String pname) {
				this.accountName=pname;
			}
			public String getAccountName() {
				return this.accountName ;
			}
			public void setType(String actype) {
				this.type=actype;
			}
			public String getType() {
				return this.type;
			}
			public void setBDate(Date dt) {
				this.bDate=dt;

			}
			public  Date getDate() {
				return this.bDate;
			
			}
			public void setAccountBalance(double bal) {
				this.balance=bal;;

			}
			public  double getBalance() {
				return this.balance;
			
			}
			
		
		
		@Override
		public String toString() {	
				return  "Id:" +accountId+"\nNAME :"+accountName+"\nOpeningDate"+bDate+"\nBalance :"+balance;
		}
}