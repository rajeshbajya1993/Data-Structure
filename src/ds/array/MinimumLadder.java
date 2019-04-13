package ds.array;

import java.util.Arrays;

public class MinimumLadder {

	public static void main(String[] args) {
		MinimumLadder ml = new MinimumLadder();
		int [] arr = {2,0,0,1,4};
		System.out.println(Arrays.toString(ml.getMinimumNumberOfLadders(arr)));

	}
	
	public int [] getMinimumNumberOfLadders(int [] arr){
		int n = arr.length;
		int [] result = new int[n];
		int idx=0;
//		boolean found = false;
		for(int i=0;i<n;i++){
			
			int j = i+arr[i]-idx;
			System.out.println(j);
			while(j>0){
				idx++;
				if(idx==n){
					return result;
				}
				result[idx] = result[i]+1;
				j--;
			
		}
	}
		return result;

}
	
}
