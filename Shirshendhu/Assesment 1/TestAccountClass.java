import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;

public class TestAccountClass{
	public static Scanner sc=new Scanner(System.in);

	public static void main(String args[]){
		Account[] parr=new Account[3];
		AccountService.acceptAcData(parr);
		do{
		System.out.println("Press 0 for Create accounts, 1 for Withdraw, 2 for Deposit, 3 for Display or 4 for Exit");
		int c=sc.nextInt();
		switch(c) {
			case 0:
				AccountService.acceptAcData(parr);
				break;
			case 1:
				System.out.println("Enter id to withdraw:");
				int id = sc.nextInt();
				System.out.println("Enter amount to withdraw:");
				double bal = sc.nextDouble();
				AccountService.withdrawAmt(parr, id,bal);
				
				break;
			case 2:
				System.out.println("Enter id to deposit:");
				id = sc.nextInt();
				System.out.println("Enter amount to deposit:");
				bal = sc.nextDouble();
				AccountService.depositAmt(parr, id,bal);
				break;
			case 3:
				System.out.println("Enter id to display:");
				id = sc.nextInt();
				AccountService.displayAc(parr, id);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct choice");
				break;
		}
		}while(1==1);
	}

}