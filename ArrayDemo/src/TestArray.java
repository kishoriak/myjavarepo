import java.util.Scanner;

public class TestArray {
	public static void main(String[] args) {
		int[][] n=new int[3][3];
		Scanner sc=new Scanner(System.in);
		//int[][] n1= {{12,13},{10,10},{13,14}};  //3X2
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n[0].length;j++) {
				System.out.println("enter num");
				n[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n[0].length;j++) {
				System.out.println(n[i][j]);
				
			}
		}
	}
}
