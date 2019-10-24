package ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class DutchNationalFlag {

	public void sort012(int [] arr){
		int n;
		if(arr==null || (n=arr.length)<2){
			return;
		}
		System.out.println(Arrays.toString(arr));
		int low = 0;
		int high = n-1;
		int mid=0;
		while(mid<=high){
			switch(arr[mid]){
			case 0:
//				int temp = arr[mid];
				int temp1 = arr[low];
				if(0!=temp1){
					arr[low]=arr[mid];
					arr[mid]=temp1;
				}
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
//				int t1 = arr[mid];
				int t2 = arr[high];
				if(2!=t2){
					arr[high]=arr[mid];
					arr[mid]=t2;
				}
				high--;
				break;
			default :
				return;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str = "Rajesh";
		
		int [] arr = new int[n];
		for(int i=0;i<n;i++){
			int t = scan.nextInt();
			arr[i]=t;
		}
		DutchNationalFlag dn = new DutchNationalFlag();
		dn.sort012(arr);
       scan.close();
	}

}
