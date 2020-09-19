import java.util.Date;
import java.util.Scanner;
//import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AccountService{
	public static Scanner sc=new Scanner(System.in);
	//Create new account
	public static void acceptAcData(Account[] parr){

		for(int i=0;i<parr.length;i++){
			System.out.println("Enter name");
			String nm=sc.next();
			System.out.println("Enter Account Type(Savings/Current)");
			String acType=sc.next();
			System.out.println("Enter Balance");
			Double bal=sc.nextDouble();
			//try{
			parr[i]=new Account(nm,bal,acType,new Date());
			System.out.println("Id is: ");
			System.out.println(parr[i].getPerId());
			/*}catch(ParseException e){
				e.printStackTrace();
			}*/
		}
	}
	//Search by Id
	public static int searchById(Account[] parr,int id){
	for(int i=0;i<parr.length;i++){
		if(parr[i].getPerId()==id)
			return i;
		} 
			return -1;
	}
	//Withdraw method
	public static void withdrawAmt(Account[] arr,int id,double amt){
		int pos=searchById(arr,id);
		if(pos!=-1){
			arr[pos].withdraw(amt);
			displayAc(arr, id);
		}
		else
			System.out.println("Person Not found");
	}
	//Deposit method
	public static void depositAmt(Account[] arr,int id,double amt){
		int pos=searchById(arr,id);
		if(pos!=-1){
			arr[pos].deposit(amt);
			displayAc(arr, id);
		}
		else
		System.out.println("Person Not found");
	}

	//Display the account
	public static void displayAc(Account[] parr, int id){
		int pos=searchById(parr,id);
			System.out.println(parr[pos]);

	}
}
