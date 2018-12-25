package ds.maths;

import java.util.Arrays;
import java.util.Scanner;

public class CatlanNumber {



	long [] arr ;
	/**
	 * Method to generate first n catlan number
	 * T(n) = T(0)*T(n-1)+T(1)*T(n-2)......T(n-1)*T(0)
	 * @param n
	 */
	public void generateCatlanNumber(int n){
		arr = new long[n];
		arr[0]=1;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<n;i++){
			for(int j=0;j<i;j++){
				arr[i]=arr[i]+arr[j]*arr[i-j-1];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
//		elemType[] arr = new elemType[n];

		CatlanNumber cn = new CatlanNumber();
		cn.generateCatlanNumber(n);
		scan.close();

	}

}
