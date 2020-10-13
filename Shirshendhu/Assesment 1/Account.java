import java.util.Date;

public class Account{
	private int perId;
	private String perName;
	private Date oDate;
	private String typeOfAc;
	private Double bal;
	//private final String code="2308AB0";
	public static int count=0;

	//Default Constructor
	public Account(){
		count++;
		perId=count;
		perName=null;
		bal=0.0;
		oDate=null;
		typeOfAc=null;
	}

	//Parameterized Constructor
	public Account(String perName,Double bal,String typeOfAc,Date oDate){
		count++;
		perId=count;
		this.perName=perName;
		this.oDate=oDate;
		this.typeOfAc=typeOfAc;
		this.bal=bal;
	}

	//Overriding to display customized entries
	@Override
	public String toString(){

		return "Id : "+perId+"\nName : "+perName+"\nBalance : "+bal+"\nDate of opening"+oDate+"\nAccount Type: "+typeOfAc+"\n";
	}

	//Setter getter methods

	/*public void setPerId(int id){
		this.perId=id;
	}*/
	public int getPerId(){

		return this.perId;
	}
	public void setPerName(String pname){

		this.perName=pname;
	}
	public String getPerName(){

		return this.perName;
	}
	public void setTypeOfAc(String acType){
		this.typeOfAc=acType;
	}
	public String getTypeOfAc(){
		return this.typeOfAc;
	}
	public void setBalance(Double balance){

		this.bal=balance;
	}
	public Double getBalance(){

		return this.bal;
	}


	public void withdraw(Double bl){
			if(bal-10000>=bl)
			setBalance(bal-bl);
	}
	public void deposit(Double bl){
		setBalance(bl+bal);
	}
}