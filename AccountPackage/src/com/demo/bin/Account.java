package com.demo.bin;
import java.util.Date;

public class Account {
	public static int cnt;
	static {
		     cnt=0;
	       }    
	private int accId;
	private String accName;
	private Date accDate;
	private String accType;
	
	private double amt;
	
	
	
	//Default Constructor
	public Account()
	{
		accId=++cnt;
		accName=null;
		accDate=null;
		accType=null;
		
		amt=0;
		
	}
	
	
	//Parametrised Constructor
	public Account(String accName,Date accDate,String accType,int amt)
	{
		this.accId=++cnt;
		this.accName=accName;
		this.accDate=accDate;
		this.accType=accType;
		
		this.amt=amt;
		
		
	}
	
	//Setter Getter
	/*public void setAccId(int id)
	{
		this.accId=id;
	}
	*/
	public int getAccId()
	{
		return this.accId;
	}
	
	public void setAccName(String aname)
	{
		this.accName=aname;
	}
	public String getAccName()
	{
		return this.accName;
	}
	
	public void setAccType(String atype)
	{
		this.accType=atype;
	}
	public String getAccType()
	{
		return this.accType;
	}
	
	public void setAccDate(Date dt)
	{
		this.accDate=dt;
	}
	public Date getAccDate()
	{
		return this.accDate;
	}
	
	public void setAmt(double amt)
	{
		this.amt=amt;
	}
	public double getAmt()
	{   
		return this.amt;
	}
	
	
	public void withdraw(double bal)
	{
		if(amt-10000>=bal)
			amt=amt-bal;
	}
	
	public void deposite(double bal)
	{
		amt=amt+bal;
	}
	
	@Override
	public String toString()
	{
		return "Id : "+accId+"\nName : "+accName+"\nAccountType: "+accType+"\nAcc Opening Date :"+accDate+"\nBalance :"+amt;
	}
}
