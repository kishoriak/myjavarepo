package com.demo.bean;

public class Current extends Account {
	//static function
	static
	{
		nooftransaction=3;
	}
	static int nooftransaction;
	private Double Currentinterest=0.0;
	private final static Double interestrate=2.0;
	//Default constructor
	public Current()
	{
	
		Currentinterest=0.0;
		
	}
	//Parameterized constructor
    public Current(int id,Double Balance,String accHolderName,Double pin)
    {
    	super(id, Balance,accHolderName, pin);
    	Interest();
    	
    }
    //Formula to calculate interest
    public void Interest()
    {
    	this.Currentinterest=Balance*interestrate;
    }
    //Display function overriden from the object class
    public String toString()
    {
    	
    	return super.toString()+"\nno of transactions:"+nooftransaction+"\ninterest rate:"+Currentinterest;
    }

}
