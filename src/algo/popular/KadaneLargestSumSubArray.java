package algo.popular;

import java.util.Arrays;
import java.util.Random;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array 
 * of numbers which has the largest sum
 * @author rbajya
 *
 */
public class KadaneLargestSumSubArray {

	
	public static void main(String[] args) {
		KadaneLargestSumSubArray ks = new KadaneLargestSumSubArray();
		int k =ks.getLargestSumSubArray(ks.generateArray());
		System.out.println(k);
		
	}
	
	/**
	 * This method assumes that array contains at least one positive interger
	 * @param arr
	 * @return
	 */
	public int getLargestSumSubArray(int [] arr){
		int max=0;
		int start=0;
		int end=0;
		int s=0;
		int max_ending_here=0;
		int n = arr.length;
		for(int i=0;i<n;i++){
			max_ending_here = max_ending_here+arr[i];
			if(max_ending_here <0){
				s = i+1;
				max_ending_here=0;
			}
			if(max<max_ending_here){
				end = i;
				start = s;
				max = max_ending_here;
			}
		}
		System.out.println(start+" "+end);
		return max;
	}
	
	/**
	 * Also handle case where all array elements are negative
	 * @param arr
	 * @return
	 */
	public int getLarestContagiousSubarray(int [] arr){
		int max=arr[0];
		int max_end_here=arr[0];
		int n = arr.length;
		for(int i=1;i<n;i++){
			max_end_here = Math.max(max_end_here+arr[i], arr[i]);
			max = Math.max(max, max_end_here);
		}
		return max;
		
	}
	
	
	public int [] generateArray(){
		int [] arr;
		int n =10;
		arr = new int[n];
		Random rn = new Random();
		for(int i=0;i<n;i++){
			int k = rn.nextInt(10);
			if(k%2==0){
				arr[i]=k*-1;
			}else{
				arr[i]=k*-1;
			}
		}
		System.out.print(Arrays.toString(arr)+"\n");
		return arr;
		
		
	}
	
	
}
