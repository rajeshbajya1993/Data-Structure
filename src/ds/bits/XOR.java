package ds.bits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XOR {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int[] arr = new int[n];
//
//		for(int i=0;i<n;i++){
//			int t = scan.nextInt();
//			arr[i]=t;
//		}
//		XOR xor = new XOR();
//		xor.findTwoNonRepatingNumbers(arr);
//		scan.close();
		
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(1);
		list.add(1.2); 
		// 1.2 will be added something like this Number n = new Double(1.2)
		// we wont be able to access child class methods unless they are overridden
		
		
	}
	
	
	/**
	 * https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
	 * @param arr
	 */
   public void findTwoNonRepatingNumbers(int [] arr){
	   int n;
	   if(arr==null || (n=arr.length)<2){
		   return;
	   }
	   int xor=0;
	   for(int i=0;i<n;i++){
		   xor = xor^arr[i];
	   }
	   int first_set_bit = xor & ~(xor-1); //first set bit in xor
	   int x=0,y=0;
	   for(int i=0;i<n;i++){
		   if((arr[i]&first_set_bit) ==0){
			   x = x^arr[i];
		   }else{
			   y = y^arr[i]; // also xor-x = y
		   }
	   }
	   System.out.println(x+" "+y);
   }
	
  /**
   * 
   * @param a
   * @param b
   * @param c
   */
	
	public static void printBinary(int a, int b, int c){
		System.out.println(a+": "+Integer.toBinaryString(a));
		System.out.println(b+": "+Integer.toBinaryString(b));
		System.out.println(c+": "+Integer.toBinaryString(c));
	}

}
