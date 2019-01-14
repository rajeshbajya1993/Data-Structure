package ds.sort;

import java.util.Scanner;

public interface Sortable {

//	int [] arr;
	void sort(int [] arr); 
	
	public static int [] prepareArray() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Number of elements in the Array: ");
		int n = scan.nextInt();
		System.out.println("Space separated array elements: ");
		int [] arr = new int[n];
		for(int i=0;i<n;i++){
			int k = scan.nextInt();
			arr[i]=k;
		}
		scan.close();
		return arr;
	}
}
