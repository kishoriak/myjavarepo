import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestPersonClass {

	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
		//PersonService ps=new PersonService()
		//Person p1=new Person();
		Person[] p=new Person[3];
		/*Person[] p2= {new Person(12,"aaa",new Date(),"2222"),
				new Person(12,"xx",new Date(),"2222"),
				new Person(12,"yy",new Date(),"2222")};*/
		PersonService.acceptPersonData(p);
		PersonService.displayPerson(p);
		
				
	}

}
