public class MyComparator {

public class MyComparator implements Comparator<Products>{

	@Override
	public int compare(Product ob1, Product ob2) {
		
		
		if(((Products)ob1).getQuantity()<((Products)ob2).getQuantity()){
			return -1;
		}
		else if(((Products)ob1).getQuantity()==((Products)ob2).getQuantity()) {
		    return 0;	
		}
		else {
			return 1;
		}
		
	}



}
